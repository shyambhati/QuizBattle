package com.info.sky.quizbattle.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.info.sky.quizbattle.entity.PaymentEntity;
import com.info.sky.quizbattle.entity.UserEntity;
import com.info.sky.quizbattle.service.PaymentService;
import com.info.sky.quizbattle.service.UserService;
import com.info.sky.quizbattle.service.common.Config;
import com.info.sky.quizbattle.service.common.Uqid;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@ResponseBody
@RequestMapping({"/API/v1/{token}/Payment/"}) 
@Tag(name = "Payment", description = "All Payment Related API")
public class PaymentGatewayApi 
{
	
	@Autowired 
	private PaymentService paymentService;
	

	@Autowired
	private UserService userService;
	
	@GetMapping("Create/{payment_amount}/{userid}/")
	public String test2(
			@PathVariable String token,
			@PathVariable String payment_amount,
			@PathVariable String userid) throws RazorpayException           
	{
		RazorpayClient razorpayClient = new RazorpayClient(Config.rozorKeyId,Config.rozorSecretKey);
		
		int amt=Integer.parseInt(payment_amount);
		
		JSONObject options = new JSONObject();
		options.put("amount", amt*100);
		options.put("currency", Config.currency);
		options.put("receipt", Uqid.genratePaymentRecipt());
		
		Order order = razorpayClient.Orders.create(options);
		
		UserEntity user=userService.getUserByUqid(userid);
		
		PaymentEntity model=new PaymentEntity();
		model.setAmount(amt+"");
		model.setReceipt(order.get("receipt")+"");
		model.setPaymetId(order.get("id")+"");
		model.setStatus(order.get("status")+"");
		model.setUser_model(user);
		model.setUqid(Uqid.getuqid());
		
		model.setUserId(userid);
		paymentService.save(model);
		
		return order.toString();
	}
	
	
	@GetMapping("Update/{order_id}/")
	@ResponseBody 
	public String update_payment(
			@PathVariable String token,
			@PathVariable String order_id)         
	{
		
		PaymentEntity model=paymentService.getByPaymentId(order_id);
		
		UserEntity user=userService.getUserByUqid(model.getUserId());
		
		
		user.setDeposit_amt(user.getDeposit_amt()+Integer.parseInt(model.getAmount()));
		
		userService.save(user);
		
		model.setStatus("success");
		paymentService.save(model);
		
		
		
		return "payment successful";
	}
	
	
	
	@GetMapping("GetAllPayment/{userid}/")
	@ResponseBody 
	public List<PaymentEntity> all_payment(
			@PathVariable String token,
			@PathVariable String userid)         
	{
		
	
		List<PaymentEntity> list=paymentService.getByUserId(userid);
	
		return list;
	}
	
	@GetMapping("GetPendingPayment/{userid}/")
	@ResponseBody 
	public List<PaymentEntity> pending_payment(
			@PathVariable String token,
			@PathVariable String userid)         
	{
		
	
		List<PaymentEntity> list=paymentService.getByUserId(userid);
		list = list.stream().filter(c -> c.getStatus().equalsIgnoreCase("created")).collect(Collectors.toList());

	
		return list;
	}
	
	@GetMapping("GetSuccesPayment/{userid}/")
	@ResponseBody 
	public List<PaymentEntity> success_payment(
			@PathVariable String token,
			@PathVariable String userid)         
	{
		
	
		List<PaymentEntity> list=paymentService.getByUserId(userid);
		list = list.stream().filter(c -> c.getStatus().equalsIgnoreCase("success")).collect(Collectors.toList());

	
		return list;
	}
	
	
	
	
	
	
	
}

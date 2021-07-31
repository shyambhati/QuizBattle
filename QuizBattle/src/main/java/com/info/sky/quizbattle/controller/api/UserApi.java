package com.info.sky.quizbattle.controller.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.info.sky.quizbattle.entity.UserEntity;
import com.info.sky.quizbattle.service.UserService;
import com.info.sky.quizbattle.service.common.Config;

import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@ResponseBody
@RequestMapping("/API/v1/{token}/User/")
@Tag(name = "User", description = "All User Related API")
public class UserApi {
	
	@Autowired
	private UserService userService;

	@PostMapping("/Register")
	public String register(@RequestBody UserEntity model, @PathVariable String token) {
		if (Config.tokenKey.equals(token))
			return userService.save(model);
		else
			return "Wrong token key!";
	}

	@GetMapping("/Login/{email}/{password}/")
	public UserEntity login(@PathVariable String token, @PathVariable String email, @PathVariable String password) {
		UserEntity model = new UserEntity();
		model.setToken("no");
		if (Config.tokenKey.equals(token))
			return userService.login(email, password);
		else
			return model;
	}

	@GetMapping(value = "/sendOtp/{email}/")
	public String sendOtpAddress(@PathVariable String token, @PathVariable String email) {
		if (Config.tokenKey.equals(token))
			return userService.sendOtp(email);
		else
			return "Wrong token key!";
	}

	@GetMapping(value = "/validateOtp/{email}/{otp}/")
	public String validateOtp(@PathVariable String token, @PathVariable String email, @PathVariable String otp) {
		if (Config.tokenKey.equals(token)) {
			if (userService.existsByEmailAndOtp(email, otp))
				return "Validation Successfully!";
			else
				return "Enter a valid OTP!";
		} else
			return "Wrong token key!";
	}

	@GetMapping(value = "/updatePassword/{email}/{password}/")
	public String updatePassword(@PathVariable String token, @PathVariable String email,
			@PathVariable String password) {
		if (Config.tokenKey.equals(token)) {
			return userService.updatePassword(email, password);
		} else
			return "Wrong token key!";
	}
	
	
	@GetMapping(value = "/validateToken/{userToken}/")
	public String validateTeken(@PathVariable String token, @PathVariable String userToken) {
		if (Config.tokenKey.equals(token)) {
			if (userService.existsByToken(userToken))
				return "1";
			else
				return "0";
		} else
			return "Wrong token key!";
	}
	
	
	
	
	@GetMapping("/GetByUqid/{uqid}/")
	public UserEntity getUser(@PathVariable String token, @PathVariable String uqid) {
			return userService.getUserByUqid(uqid);
	}
	
	
	@GetMapping("/GetWallet/{uqid}/")
	public String getWallet(@PathVariable String token, @PathVariable String uqid) {
		
		UserEntity model=userService.getUserByUqid(uqid);
		System.out.println(model);
		
		JSONObject obj=new JSONObject();    
		  obj.put("Wallet",model.getDeposit_amt());    
		  obj.put("Winning",model.getWinning_amt());    
		  obj.put("cash",model.getCash_amt());    
		   System.out.print(obj);    
		
		return obj.toString();
		
		//return userService.getUserByUqid(uqid);
	}
}

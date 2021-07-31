package com.info.sky.quizbattle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.entity.AdminEntity;
import com.info.sky.quizbattle.entity.PraticeQuizEntity;
import com.info.sky.quizbattle.service.AdminService;
import com.info.sky.quizbattle.service.PraticeQiuizService;
import com.info.sky.quizbattle.service.common.UrlBase;
import io.swagger.v3.oas.annotations.Hidden;


@Hidden
@Controller
@RequestMapping("/Admin/PraticeQuiz/")
public class PraticeQuizController 
{

	@Autowired
	private SessionRecord sr;
	
	@Autowired
	private AdminService adminService;	
	
	@Autowired
	private PraticeQiuizService praticeQiuizService;	
	
	@RequestMapping("/New")
	public String newContest(Model model)
	{
		if(sr.isLogin())
		{		
			 model.addAttribute("praticeQiuizBean", new PraticeQuizEntity()); 	
			return UrlBase.pratice_quiz_new;
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	
	@RequestMapping("/Manage")
	public String manage(Model model)
	{
		System.out.println("is work");

		if(sr.isLogin())
		{		
			List<PraticeQuizEntity> list=praticeQiuizService.getlist();

			model.addAttribute("list_obj",list);
			return UrlBase.pratice_quiz_list;
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	@PostMapping({"/Save"})
	public String save(@ModelAttribute PraticeQuizEntity praticeQuizBean)
	{
		if(sr.isLogin())
		{
			AdminEntity admin=adminService.getAdminByUqid(sr.getAdminUnq());
			praticeQuizBean.setAdd_by_model(admin);
			
			praticeQiuizService.save(praticeQuizBean);
			return "redirect:/Admin/PraticeQuiz/New";
		}
		else
			return UrlBase.redirect_login;		
	}
	

	@RequestMapping("/Delete")
	public String delete(@RequestParam("thisid") String id)
	{
		if(sr.isLogin())
		{		
			praticeQiuizService.delet(Integer.parseInt(id));			
			return "redirect:/Admin/PraticeQuiz/Manage";
		}
		else
			return UrlBase.redirect_login;
	}


}

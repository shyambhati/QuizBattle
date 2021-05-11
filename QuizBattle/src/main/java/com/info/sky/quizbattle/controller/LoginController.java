package com.info.sky.quizbattle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.entity.AdminEntity;
import com.info.sky.quizbattle.entity.LoginBean;
import com.info.sky.quizbattle.service.AdminService;

@Controller
public class LoginController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SessionRecord sessionRecord;

	@RequestMapping({"/",""})
	public ModelAndView baseUrl()
	{
		return new ModelAndView("redirect:/Login");
	}
	
	@RequestMapping({"/Login"})
	public String loginForm(@ModelAttribute LoginBean loginBean)
	{
		loginBean.setUsername("");
		loginBean.setPassword("");
		
		return "login";
	}
	
	
	@PostMapping({"/GetLogin"})
	public String getLogin(@ModelAttribute LoginBean loginBean)
	{
		
		AdminEntity model=adminService.getAdminByUsernameAndPassword(
											loginBean.getUsername(),
											loginBean.getPassword());
		
		if(model!=null)
		{
			sessionRecord.setAllValue(model);
			sessionRecord.getActiveSessions();
			 return "redirect:Admin/Dash/";
		}
		else
			return "login";
		
	}
	
	
	
	@GetMapping({"/Logout"})
	public String logout()
	{
		sessionRecord.removeAll();
		return "redirect:Login";
	}
}

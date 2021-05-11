package com.info.sky.quizbattle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.info.sky.quizbattle.SessionRecord;

@Controller
@RequestMapping("/Admin")
public class AdminController 
{
	
	@Autowired
	private SessionRecord sessionRecord;
	
	@RequestMapping("Dash/")
	public String dash(Model model)
	{
		
		if(sessionRecord.getLoginStatus()!=null&&sessionRecord.getLoginStatus().equalsIgnoreCase("true"))
		{
			
			model.addAttribute("admin_name","Hello, "+sessionRecord.getAdminName());
			return "dash";
		}
		else
			return "redirect:Login";
	}
}

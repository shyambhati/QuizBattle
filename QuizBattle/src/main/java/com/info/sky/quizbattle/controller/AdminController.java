package com.info.sky.quizbattle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.service.CategoryService;

@Controller
@RequestMapping("/Admin")
public class AdminController 
{
	
	@Autowired
	private SessionRecord sr;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("Dash/")
	public String dash(Model model)
	{
		
		if(sr.isLogin())
		{		
			
			System.out.println("Size : "+categoryService.getlist().size());
			 model.addAttribute("category_size",categoryService.getlist().size()); 
			return "dash";
		}
		else
			return "redirect:Login";
	}
}

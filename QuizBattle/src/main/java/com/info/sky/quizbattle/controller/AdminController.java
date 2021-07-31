package com.info.sky.quizbattle.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.Dao.ContestPoolDao;
import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.ContestEntity;
import com.info.sky.quizbattle.entity.ContestPoolEntity;
import com.info.sky.quizbattle.entity.UserEntity;
import com.info.sky.quizbattle.service.CategoryService;
import com.info.sky.quizbattle.service.ContestService;
import com.info.sky.quizbattle.service.UserService;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@Controller
@RequestMapping("/Admin")
public class AdminController 
{
	
	@Autowired
	private SessionRecord sr;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ContestPoolDao contestPoolDao;
	
	@Autowired
	private ContestService contestService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("Dash/")
	public String dash(Model model)
	{
		
		if(sr.isLogin())
		{	
			List<CategoryEntity> list = categoryService.getlist();

			list = list.stream().filter(c -> c.getIsdelete().equalsIgnoreCase("No")).collect(Collectors.toList());

			model.addAttribute("category_size",list.size()); 
			
		
		
			
			model.addAttribute("pool_size",contestPoolDao.findAll().size());
			model.addAttribute("quiz_size",contestService.getlist().size());
			model.addAttribute("user_size",contestPoolDao.findAll().size());
			
			
			
			List<UserEntity> userList = userService.getList();
			
			model.addAttribute("userList",userList);
			
			return "dash";
		}
		else
			return "redirect:Login";
	}
}

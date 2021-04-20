package com.info.sky.quizbattle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.sky.quizbattle.entity.CategoryEntity;

@Controller
public class MainController 
{
	
	@ResponseBody
	@RequestMapping(value = {"/",""})
	public String startup()
	{
		return "This is a Quiz battle application!";
	}
	
	public static List<CategoryEntity> getCategoryData()
	{
		List<CategoryEntity> list=new ArrayList<>();
		
		CategoryEntity model;
		
		for(int i=1;i<=10000;i++)
		{
			model=new CategoryEntity(i, "Hindi "+i);		
			list.add(model);
		}
		
		return list;
	}
	
	@ResponseBody
	@GetMapping("/Demo")
	public String Demo()
	{
		System.out.println("work");
		return "Hello Ram, This is Spring Boot Application";
	}
}

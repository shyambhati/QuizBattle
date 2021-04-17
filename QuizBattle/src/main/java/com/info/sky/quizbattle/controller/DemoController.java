package com.info.sky.quizbattle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController 
{
	
	@ResponseBody
	@GetMapping("/Demo")
	public String Demo()
	{
		System.out.println("work");
		return "Hello Ram, This is Spring Boot Application";
	}
}

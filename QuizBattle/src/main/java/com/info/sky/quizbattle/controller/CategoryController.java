package com.info.sky.quizbattle.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.service.CategoryService;

@Controller
public class CategoryController 
{
	@ResponseBody
	@GetMapping("/Category")
	public List<CategoryEntity> getCategory()
	{
		return CategoryService.getCategoryData();
	}
}

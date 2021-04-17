package com.info.sky.quizbattle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.service.CategoryService;

@Controller
public class CategoryController 
{
	
	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@GetMapping("/Category")
	public List<CategoryEntity> getCategory()
	{
		return null;
	//	return CategoryService.getCategoryData();
	}
	
	
	
	@ResponseBody
	@PostMapping("/Category")
	public String saveCategory(@RequestBody CategoryEntity model)
	{	
		categoryService.save(model);	
		return "Saved";
	}
}

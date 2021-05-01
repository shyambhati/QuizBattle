package com.info.sky.quizbattle.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.service.CategoryService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.ParameterBinding.Unique;

@Controller
public class CategoryController 
{
	
	@Autowired
	private CategoryService categoryService;
	

	@ResponseBody
	@PostMapping("/Category")
	public String saveCategory(@RequestBody CategoryEntity model)
	{	
		
		model.setIsactive(false);
		model.setIsdelete(false);
		model.setUqid(UUID.randomUUID()+"");
		categoryService.save(model);	
		return "Saved";
	}
	
	
	@ResponseBody
	@GetMapping("/Category")
	public List<CategoryEntity> getCategory()
	{
		return categoryService.getlist();
	}
	
	
	
	@ResponseBody
	@GetMapping("/Category/{id}")
	public CategoryEntity getCategoryById(@PathVariable int id)
	{

		if(categoryService.findByid(id).isPresent())
		{
			return categoryService.getById(id);
		}
		
		return new CategoryEntity(0, "Empty");
	
		
		
	}
}

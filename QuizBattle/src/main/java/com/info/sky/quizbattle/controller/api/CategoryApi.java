package com.info.sky.quizbattle.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.service.CategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@ResponseBody
@Controller
@RequestMapping("/API/v1/{token}/Category/")
@Tag(name = "Category", description = "All Category Related API")
public class CategoryApi {

	@Autowired
	private CategoryService service;

	@GetMapping("/getList/")
	public List<CategoryEntity> login(@PathVariable String token) {
		return service.getlist();
	}
}

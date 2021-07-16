package com.info.sky.quizbattle.controller.api;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.ContestEntity;
import com.info.sky.quizbattle.service.ContestService;

import io.swagger.v3.oas.annotations.tags.Tag;

@ResponseBody
@Controller
@RequestMapping("/API/v1/{token}/Contest/")
@Tag(name = "Contest", description = "All Contest Related API")
public class ContestApi {

	@Autowired
	private ContestService service;

	@GetMapping("/GetList/")
	public List<ContestEntity> list(@PathVariable String token) {
		return service.getApilist();
	}
	
	@GetMapping("/GetList/{categoryId}/")
	public List<ContestEntity> byCategory(@PathVariable String token,@PathVariable String categoryId) {
		
		int id =Integer.parseInt(categoryId);
		
		List<ContestEntity> list =  service.getApilist();

		list = list.stream().filter(c -> c.getCategory_model().getId()==id).collect(Collectors.toList());

		
		return list;
	}

	

}

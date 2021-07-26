package com.info.sky.quizbattle.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.info.sky.quizbattle.entity.PraticeQuizEntity;

import io.swagger.v3.oas.annotations.tags.Tag;

@ResponseBody
@Controller
@RequestMapping("/API/v1/{token}/PraticeQuiz/")
@Tag(name = "Pratice Contest", description = "All Pratice Quiz Related API")
public class PraticeQuizApi {

	
	@GetMapping("/GetList/")
	public List<PraticeQuizEntity> getList(@PathVariable String token) {
		List<PraticeQuizEntity> list =  new ArrayList<>();
		PraticeQuizEntity model;
		
		for(int i=1;i<=15;i++)
		{
			/*
			 * model=new PraticeQuizEntity(
			 * 
			 * "This is Question "+i,"Option 1"
			 * ,"Option 2","Option 3","Option 4","Option 1"); list.add(model);
			 */
			
		}
		
		return list;
	}
}

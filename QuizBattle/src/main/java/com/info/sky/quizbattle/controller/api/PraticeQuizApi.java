package com.info.sky.quizbattle.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.info.sky.quizbattle.entity.PraticeQuizEntity;
import com.info.sky.quizbattle.service.PraticeQiuizService;

import io.swagger.v3.oas.annotations.tags.Tag;

@ResponseBody
@Controller
@RequestMapping("/API/v1/{token}/PraticeQuiz/")
@Tag(name = "Pratice Contest", description = "All Pratice Quiz Related API")
public class PraticeQuizApi {

	
	@Autowired
	private PraticeQiuizService praticeQiuizService;	
	
	
	@GetMapping("/GetList/")
	public List<PraticeQuizEntity> getList(@PathVariable String token) {
		
		return praticeQiuizService.getlist();
	}
}

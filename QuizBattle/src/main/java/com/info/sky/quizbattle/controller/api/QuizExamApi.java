package com.info.sky.quizbattle.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.sky.quizbattle.entity.QuizExamDetailsEntity;
import com.info.sky.quizbattle.entity.UserEntity;
import com.info.sky.quizbattle.service.QuizExamDetailsService;
import com.info.sky.quizbattle.service.common.Config;

import io.swagger.v3.oas.annotations.tags.Tag;

@ResponseBody
@RequestMapping("API/v1/{token}/QuizExam/")
@Controller
@Tag(name = "Quiz Exam", description = "All Quiz Exam Realated API")
public class QuizExamApi {
	
	
	@Autowired
	private QuizExamDetailsService quizExamService;
	
	@PostMapping("/Save/")
	public String register(@RequestBody QuizExamDetailsEntity model, @PathVariable String token) {
		if (Config.tokenKey.equals(token))
		{
			 quizExamService.save(model);
			 return "Success";
		}
		else
			return "Wrong token key!";
	}

}

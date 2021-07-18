package com.info.sky.quizbattle.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.info.sky.quizbattle.entity.MyContestEntity;
import com.info.sky.quizbattle.service.MyContestService;
import com.info.sky.quizbattle.service.common.Config;

import io.swagger.v3.oas.annotations.tags.Tag;

@ResponseBody
@Controller
@RequestMapping("/API/v1/{token}/MyContest/")
@Tag(name = "My Contest", description = "All User Contest Related API")
public class MyContestApi {

	
	@Autowired
	private MyContestService myContestService ;
	
	@PostMapping("/Save/")
	public String register(@RequestBody MyContestEntity model, @PathVariable String token) {
		if (Config.tokenKey.equals(token))
		{
			myContestService.save(model);
			 return "Success";
		}
		else
			return "Wrong token key!";
	}
	
	@GetMapping("/GetList/{userId}/")
	public List<MyContestEntity> byUserId(@PathVariable String token,@PathVariable String userId) {
		List<MyContestEntity> list =  myContestService.getByUserId(userId);
		return list;
	}
	
	@GetMapping("/GetList/{contestId}/")
	public List<MyContestEntity> byContestId(@PathVariable String token,@PathVariable String contestId) {
		List<MyContestEntity> list =  myContestService.getByContestId(contestId);
		return list;
	}
	
	@GetMapping("/GetList/{contestId}/{userId}/")
	public MyContestEntity byContestId(@PathVariable String token,@PathVariable String contestId,String userId) {
		MyContestEntity list =  myContestService.getByUserId(userId, contestId);
		return list;
	}

}

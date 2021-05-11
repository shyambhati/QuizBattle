package com.info.sky.quizbattle.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.info.sky.quizbattle.entity.AdminEntity;
import com.info.sky.quizbattle.service.DeveloperService;
import com.info.sky.quizbattle.service.common.Uqid;

@Controller
@RequestMapping("Developer/")
public class DeveloperController 
{
	@Autowired 
	private DeveloperService developerService;
	
	@GetMapping("Create/{name}/{phone}/{email}/{username}/{password}/{role}")
	@ResponseBody
	public String createDemoAdmin(
			@PathVariable String name,
			@PathVariable String phone,
			@PathVariable String email,
			@PathVariable String username,
			@PathVariable String password,
			@PathVariable String role)
		{
		
		
		String token=Uqid.genrateToken(username, password);
		
		AdminEntity entity=developerService.findByToken(token);
		
		if(entity!=null)
		{
			return "Record Already exits!";
		}
		else
		{
		
			entity=new AdminEntity();
			
			entity.setEmail(email);
			entity.setIsactive(true);
			entity.setIsdeveloper(true);
			entity.setName(name);
			entity.setOtp("000000");
			entity.setUsername(username);
			entity.setPassword(password);
			entity.setPhone(phone);
			entity.setRole(role);
			entity.setToken(token);
			entity.setUqid(Uqid.getuqid());
			
			if(role.equalsIgnoreCase("admin"))
			{
				entity.setIsdeveloper(false);
			}
		
			developerService.save(entity);
			return "Record Saved!";
		}
		
	}
	
}

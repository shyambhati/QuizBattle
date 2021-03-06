package com.info.sky.quizbattle.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.UserEntity;
import com.info.sky.quizbattle.service.AdminService;
import com.info.sky.quizbattle.service.CategoryService;
import com.info.sky.quizbattle.service.UserService;
import com.info.sky.quizbattle.service.common.Config;
import com.info.sky.quizbattle.service.common.UrlBase;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@Controller
@RequestMapping("/Admin/User/")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SessionRecord sr;

	@Autowired
	private AdminService adminService;

	@RequestMapping(path = "/List",method = RequestMethod.GET)
	public String dash(Model model) {

		if (sr.isLogin()) {
			List<UserEntity> list = userService.getList();

			model.addAttribute("userList", list);
			return UrlBase.user_list;
		} else
			return UrlBase.redirect_login;
	}
}

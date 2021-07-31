package com.info.sky.quizbattle.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.entity.AdminEntity;
import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.NotificationEntity;
import com.info.sky.quizbattle.service.AdminService;
import com.info.sky.quizbattle.service.CategoryService;
import com.info.sky.quizbattle.service.NotificationService;
import com.info.sky.quizbattle.service.common.Uqid;
import com.info.sky.quizbattle.service.common.UrlBase;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@Controller
@RequestMapping("/Admin/Notification/")
public class NotificationController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SessionRecord sr;

	@Autowired
	private AdminService adminService;
	

	@Autowired
	private NotificationService service;

	@RequestMapping(path = "/Manage",method = RequestMethod.GET)
	public String dash(@ModelAttribute NotificationEntity notificationEntity, Model model) {

		if (sr.isLogin()) {
			List<NotificationEntity> list = service.getlist();

			model.addAttribute("list_obj", list);
			return UrlBase.notification_manage;
		} else
			return UrlBase.redirect_login;
	}
	
	
	@PostMapping({ "/Save" })
	public String save(@ModelAttribute NotificationEntity model) {
		if (sr.isLogin()) {
			model.setIsdelete("No");
			model.setUqid(Uqid.getuqid() + "");

			AdminEntity admin = adminService.getAdminByUqid(sr.getAdminUnq());
			model.setAdd_by_model(admin);

			service.save(model);
			return UrlBase.notificationManageRedirect;
		} else
			return UrlBase.redirect_login;

	}
}

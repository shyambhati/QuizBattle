package com.info.sky.quizbattle.controller.api;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.NotificationEntity;
import com.info.sky.quizbattle.entity.SlideImageEntity;
import com.info.sky.quizbattle.service.NotificationService;
import com.info.sky.quizbattle.service.OtherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@ResponseBody
@RequestMapping("API/v1/{token}/Common/")
@Controller
@Tag(name = "Common", description = "All Commons Information Realated API")
public class CommonApi {

	@Autowired
	private OtherService otherService;

	public String getToken() {
		return "1998";
	}
	

	@Autowired
	private NotificationService service;

	@GetMapping("/getSlideImage/")
	@Operation(description = "Returns All Images Id's", summary = "You can Get All image id list ")
	public List<SlideImageEntity> login(@PathVariable String token) {
		return otherService.getlist().stream().filter(s -> s.getIsactive().equalsIgnoreCase("Yes"))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	@Operation(description = "Returns A Image", summary = "You can Get image by using image id ")
	public void getSlideImage(@RequestParam("id") int id, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		SlideImageEntity data = otherService.getimage(id);
		byte[] image = data.getImage();
		if (image != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(data.getImage());
			response.getOutputStream().close();
		} else {

		}
	}
	
	
	@GetMapping("/getNotification/")
	public List<NotificationEntity> message(@PathVariable String token) {
		return service.getlist();
	}
}

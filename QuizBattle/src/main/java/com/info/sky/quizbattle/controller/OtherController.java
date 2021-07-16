package com.info.sky.quizbattle.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.entity.AdminEntity;
import com.info.sky.quizbattle.entity.SlideImageEntity;
import com.info.sky.quizbattle.service.AdminService;
import com.info.sky.quizbattle.service.OtherService;
import com.info.sky.quizbattle.service.common.Uqid;
import com.info.sky.quizbattle.service.common.UrlBase;

import io.swagger.v3.oas.annotations.Hidden;


@Hidden
@Controller
@RequestMapping({ "/Admin/Slide/", "/Admin/Slide" })
@EnableAsync
public class OtherController {
	@Autowired
	private SessionRecord sr;

	@Autowired
	private OtherService otherService;

	@Autowired
	private AdminService adminService;

	@RequestMapping("/Manage")
	public String newImage(Model model) {
		if (sr.isLogin()) {
			model.addAttribute("slideImage", new SlideImageEntity());
			List<SlideImageEntity> list = otherService.getlist().stream()
					.filter(c -> c.getIsdelete().equalsIgnoreCase("No")).collect(Collectors.toList());

			model.addAttribute("list_obj", list);
			return UrlBase.slide_image;
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
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

	@PostMapping({ "/Save" })
	public String save(@RequestParam("image") MultipartFile image) throws IOException {
		if (sr.isLogin()) {

			SlideImageEntity slideImage = new SlideImageEntity();

			slideImage.setIsactive("YES");

			slideImage.setIsdelete("No");
			slideImage.setUqid(Uqid.getuqid() + "");
			slideImage.setImage(image.getBytes());
			AdminEntity admin = adminService.getAdminByUqid(sr.getAdminUnq());
			slideImage.setAdd_by_model(admin);

			otherService.save(slideImage);
			return "redirect:/Admin/Slide/Manage";
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping({ "/Remove" })
	public String remove(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {

			otherService.delete(id);
			return "redirect:/Admin/Slide/Manage";
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping({ "/Active" })
	public String active(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {

			SlideImageEntity entity = otherService.getimage(Integer.parseInt(id));

			entity.setIsactive("Yes");
			otherService.save(entity);
			return "redirect:/Admin/Slide/Manage";
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping({ "/DeActive" })
	public String deActive(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {

			SlideImageEntity entity = otherService.getimage(Integer.parseInt(id));

			entity.setIsactive("No");
			otherService.save(entity);
			return "redirect:/Admin/Slide/Manage";
		} else
			return UrlBase.redirect_login;

	}

}

package com.info.sky.quizbattle.controller;

import java.util.List;
import java.util.UUID;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.entity.AdminEntity;
import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.LoginBean;
import com.info.sky.quizbattle.service.AdminService;
import com.info.sky.quizbattle.service.CategoryService;
import com.info.sky.quizbattle.service.common.Uqid;
import com.info.sky.quizbattle.service.common.UrlBase;

import io.swagger.v3.oas.annotations.Hidden;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.ParameterBinding.Unique;


@Hidden
@Controller
@RequestMapping("/Admin/Category/")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SessionRecord sr;

	@Autowired
	private AdminService adminService;

	@RequestMapping(path = "/Manage",method = RequestMethod.GET)
	public String dash(@ModelAttribute CategoryEntity categoryBean, Model model) {

		if (sr.isLogin()) {
			List<CategoryEntity> list = categoryService.getlist();

			list = list.stream().filter(c -> c.getIsdelete().equalsIgnoreCase("No")).collect(Collectors.toList());

			model.addAttribute("list_obj", list);
			return UrlBase.category_manage;
		} else
			return UrlBase.redirect_login;
	}

	@PostMapping({ "/Save" })
	public String save(@ModelAttribute CategoryEntity categoryEntity) {
		if (sr.isLogin()) {
			categoryEntity.setIsdelete("No");
			categoryEntity.setUqid(Uqid.getuqid() + "");

			AdminEntity admin = adminService.getAdminByUqid(sr.getAdminUnq());
			categoryEntity.setAdd_by_model(admin);

			categoryService.save(categoryEntity);
			return UrlBase.categoryManageRedirect;
		} else
			return UrlBase.redirect_login;

	}

	@PostMapping({ "/Update" })
	public String update(@ModelAttribute CategoryEntity model) {
		if (sr.isLogin()) {
			CategoryEntity entity = categoryService.getById(model.getId());

			entity.setName(model.getName());
			entity.setIsactive(model.getIsactive());

			categoryService.save(entity);
			return UrlBase.categoryManageRedirect;
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping({ "/Remove" })
	public String remove(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {
			CategoryEntity entity = categoryService.getById(Integer.parseInt(id));
			entity.setIsdelete("Yes");

			categoryService.save(entity);
			return UrlBase.categoryManageRedirect;
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping({ "/Active" })
	public String active(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {
			CategoryEntity entity = categoryService.getById(Integer.parseInt(id));

			entity.setIsactive("Yes");
			categoryService.save(entity);
			return "redirect:/Admin/Category/Manage";
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping({ "/DeActive" })
	public String deActive(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {
			CategoryEntity entity = categoryService.getById(Integer.parseInt(id));

			entity.setIsactive("No");

			categoryService.save(entity);

			return UrlBase.categoryManageRedirect;
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping("/ActiveList")
	public String activeList(Model model) {

		if (sr.isLogin()) {
			List<CategoryEntity> list = categoryService.getlist();

			list = list.stream()
					.filter(c -> c.getIsactive().equalsIgnoreCase("Yes") && c.getIsdelete().equalsIgnoreCase("No"))
					.collect(Collectors.toList());

			model.addAttribute("list_obj", list);
			return UrlBase.category_isactive;
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping("/DeActiveList")
	public String deactiveList(Model model) {

		if (sr.isLogin()) {
			List<CategoryEntity> list = categoryService.getlist();

			list = list.stream()
					.filter(c -> c.getIsactive().equalsIgnoreCase("No") && c.getIsdelete().equalsIgnoreCase("No"))
					.collect(Collectors.toList());

			model.addAttribute("list_obj", list);
			return UrlBase.category_isdeactive;
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping("/isDeleteList")
	public String deletedlist(Model model) {

		if (sr.isLogin()) {
			List<CategoryEntity> list = categoryService.getlist();

			list = list.stream().filter(c -> c.getIsdelete().equalsIgnoreCase("Yes")).collect(Collectors.toList());

			model.addAttribute("list_obj", list);
			return UrlBase.category_isdelete;
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping("/Restore")
	public String restore(@RequestParam("thisid") String id) {

		if (sr.isLogin()) {
			CategoryEntity entity = categoryService.getById(Integer.parseInt(id));
			entity.setIsdelete("No");

			categoryService.save(entity);
			return "redirect:/Admin/Category/isDeleteList";
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping("/Delete")
	public String delete(@RequestParam("thisid") String id) {

		if (sr.isLogin()) {
			categoryService.delet(Integer.parseInt(id));
			return "redirect:/Admin/Category/isDeleteList";
		} else
			return UrlBase.redirect_login;
	}

	/**
	 * @PostMapping("/") public String saveCategory(@RequestBody CategoryEntity
	 * model) {
	 * 
	 * 
	 * model.setIsactive(false); model.setIsdelete(false);
	 * model.setUqid(UUID.randomUUID()+""); categoryService.save(model); return
	 * "Saved"; }
	 * 
	 * 
	 * @ResponseBody @GetMapping("/") public List<CategoryEntity> getCategory() {
	 *               return categoryService.getlist(); }
	 * 
	 * 
	 * 
	 * @ResponseBody @GetMapping("{id}") public CategoryEntity
	 *               getCategoryById(@PathVariable int id) {
	 * 
	 *               if(categoryService.findByid(id).isPresent()) { return
	 *               categoryService.getById(id); }
	 * 
	 *               return new CategoryEntity(0, "Empty");
	 * 
	 *               }
	 */
}

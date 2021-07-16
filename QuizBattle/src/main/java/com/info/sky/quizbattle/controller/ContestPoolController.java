package com.info.sky.quizbattle.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.entity.AdminEntity;
import com.info.sky.quizbattle.entity.ContestEntity;
import com.info.sky.quizbattle.entity.ContestPoolEntity;
import com.info.sky.quizbattle.entity.dto.PoolMemberPriceEntity;
import com.info.sky.quizbattle.service.AdminService;
import com.info.sky.quizbattle.service.CategoryService;
import com.info.sky.quizbattle.service.ContestPoolService;
import com.info.sky.quizbattle.service.ContestService;
import com.info.sky.quizbattle.service.common.Uqid;
import com.info.sky.quizbattle.service.common.UrlBase;

import io.swagger.v3.oas.annotations.Hidden;


@Hidden
@Controller
@RequestMapping("/Admin/Contest/Pool/")
public class ContestPoolController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SessionRecord sr;

	@Autowired
	private AdminService adminService;

	@Autowired
	private ContestService contestService;

	@Autowired
	private ContestPoolService contestPlanService;

	@RequestMapping("/New")
	public String newPool(Model model) {
		if (sr.isLogin()) {
			model.addAttribute("contestPoolBean", new ContestPoolEntity());

			return UrlBase.contest_plan_new;
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping("/Manage")
	public String manage(Model model) {

		if (sr.isLogin()) {

			List<ContestPoolEntity> list = contestPlanService.getlist().stream()
					.filter(c -> c.getIsdelete().equalsIgnoreCase("No")).collect(Collectors.toList());

			model.addAttribute("list_obj", list);

			return UrlBase.contest_plan_manage;
		} else
			return UrlBase.redirect_login;
	}

	@PostMapping({ "/Save" })
	public String save(@ModelAttribute ContestPoolEntity contestPoolBean) {
		if (sr.isLogin()) {

			contestPoolBean.setIsdelete("No");
			contestPoolBean.setUqid(Uqid.getuqid() + "");

			AdminEntity admin = adminService.getAdminByUqid(sr.getAdminUnq());
			contestPoolBean.setAdd_by_model(admin);

			System.out.println(" Extra : " + contestPoolBean.getExtra());

			ArrayList<PoolMemberPriceEntity> member = new ArrayList<PoolMemberPriceEntity>();

			String str = contestPoolBean.getExtra();
			String[] splited = str.split("#");

			PoolMemberPriceEntity model;
			for (int i = 0; i < splited.length; i++) {
				String str1 = splited[i];
				String[] spl = str1.split("/");

				model = new PoolMemberPriceEntity(Integer.parseInt(spl[1]), spl[0]);
				member.add(model);
			}

//			for (PoolMemberPriceEntity show : member) {
//				System.out.println("Rank : " + show.getMemberRank() + " " + "price : " + show.getPrice());
//			}

			contestPoolBean.setMember(member);

			contestPlanService.save(contestPoolBean);
			return "redirect:/Admin/Contest/Pool/Manage";
		} else
			return UrlBase.redirect_login;
	}

	@PostMapping({ "/Update" })
	public String update(@ModelAttribute ContestEntity model) {
		if (sr.isLogin()) {
			ContestEntity entity = contestService.getById(model.getId());

			entity.setName(model.getName());
			entity.setIsactive(model.getIsactive());
			entity.setStartDateTime(model.getStartDateTime());

			contestService.save(entity);
			return "redirect:/Admin/Contest/Manage";
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping({ "/Remove" })
	public String remove(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {
			ContestPoolEntity entity = contestPlanService.getById(Integer.parseInt(id));
			entity.setIsdelete("Yes");

			contestPlanService.save(entity);

			return "redirect:/Admin/Contest/Pool/Manage";
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping({ "/Active" })
	public String active(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {

			ContestPoolEntity entity = contestPlanService.getById(Integer.parseInt(id));
			entity.setIsactive("Yes");

			contestPlanService.save(entity);

			return "redirect:/Admin/Contest/Pool/Manage";
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping({ "/DeActive" })
	public String deActive(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {

			ContestPoolEntity entity = contestPlanService.getById(Integer.parseInt(id));
			entity.setIsactive("No");

			contestPlanService.save(entity);

			return "redirect:/Admin/Contest/Pool/DeActiveList";
		} else
			return UrlBase.redirect_login;

	}
	
	
	@RequestMapping({ "/Active1" })
	public String active1(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {

			ContestPoolEntity entity = contestPlanService.getById(Integer.parseInt(id));
			entity.setIsactive("Yes");

			contestPlanService.save(entity);

			return "redirect:/Admin/Contest/Pool/ActiveList";
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping({ "/DeActive1" })
	public String deActive1(@RequestParam("thisid") String id) {
		if (sr.isLogin()) {

			ContestPoolEntity entity = contestPlanService.getById(Integer.parseInt(id));
			entity.setIsactive("No");

			contestPlanService.save(entity);

			return "redirect:/Admin/Contest/Pool/Manage";
		} else
			return UrlBase.redirect_login;

	}

	@RequestMapping("/ActiveList")
	public String activeList(Model model) {

		if (sr.isLogin()) {
			List<ContestPoolEntity> list = contestPlanService.getlist();

			list = list.stream()
					.filter(c -> c.getIsactive().equalsIgnoreCase("Yes") && c.getIsdelete().equalsIgnoreCase("No"))
					.collect(Collectors.toList());

			model.addAttribute("list_obj", list);
			return UrlBase.contest_plan_isactive;
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping("/DeActiveList")
	public String deactiveList(Model model) {

		if (sr.isLogin()) {
			List<ContestPoolEntity> list = contestPlanService.getlist();

			list = list.stream()
					.filter(c -> c.getIsactive().equalsIgnoreCase("No") && c.getIsdelete().equalsIgnoreCase("No"))
					.collect(Collectors.toList());

			model.addAttribute("list_obj", list);
			return UrlBase.contest_plan_isdeactive;
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping("/isDeleteList")
	public String deletedlist(Model model) {

		if (sr.isLogin()) {
			List<ContestPoolEntity> list = contestPlanService.getlist();

			list = list.stream().filter(c -> c.getIsdelete().equalsIgnoreCase("Yes")).collect(Collectors.toList());

			model.addAttribute("list_obj", list);
			return UrlBase.contest_plan_isdelete;
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping("/Restore")
	public String restore(@RequestParam("thisid") String id) {

		if (sr.isLogin()) {

			ContestPoolEntity entity = contestPlanService.getById(Integer.parseInt(id));
			entity.setIsdelete("No");

			contestPlanService.save(entity);

			return "redirect:/Admin/Contest/Pool/isDeleteList";
		} else
			return UrlBase.redirect_login;
	}

	@RequestMapping("/Delete")
	public String delete(@RequestParam("thisid") String id) {

		if (sr.isLogin()) {
			contestPlanService.delet(Integer.parseInt(id));
			return "redirect:/Admin/Contest/Pool/isDeleteList";
		} else
			return UrlBase.redirect_login;
	}
}

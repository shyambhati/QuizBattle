package com.info.sky.quizbattle.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.sky.quizbattle.SessionRecord;
import com.info.sky.quizbattle.Dao.ContestPoolDao;
import com.info.sky.quizbattle.Dao.ContestRulesDao;
import com.info.sky.quizbattle.entity.AdminEntity;
import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.ContestEntity;
import com.info.sky.quizbattle.entity.ContestPoolEntity;
import com.info.sky.quizbattle.entity.ContestRulesTextEntity;
import com.info.sky.quizbattle.entity.PoolMemberPriceEntity;
import com.info.sky.quizbattle.service.AdminService;
import com.info.sky.quizbattle.service.CategoryService;
import com.info.sky.quizbattle.service.ContestService;
import com.info.sky.quizbattle.service.common.Uqid;
import com.info.sky.quizbattle.service.common.UrlBase;

@Controller
@RequestMapping("/Admin/Contest/")
public class ContestController 
{
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SessionRecord sr;
	
	@Autowired
	private AdminService adminService;
	
	
	@Autowired
	private ContestService contestService;
	
	@Autowired
	private ContestPoolDao contestPoolDao;
	
	@Autowired
	private ContestRulesDao contestRulesDao;
	
	 
	
	
	
	@RequestMapping("/New")
	public String newContest(Model model)
	{
		System.out.println("is work");

		if(sr.isLogin())
		{		
			 model.addAttribute("contestBean", new ContestEntity()); 
		
			
			
			
			
			List<CategoryEntity> categorylist=categoryService.getlist()
					.stream().filter(c -> c.getIsdelete().equalsIgnoreCase("No")&&c.getIsactive().equalsIgnoreCase("Yes"))
					.collect(Collectors.toList());
			
			
			List<ContestRulesTextEntity> rule_list=contestRulesDao.findAll();
	
			
		
			
			
			List<ContestPoolEntity> planlist=contestPoolDao.findAll();
		
			model.addAttribute("category_list_obj",categorylist);
			model.addAttribute("rule_list",rule_list);
			
			
			model.addAttribute("planlist",planlist);
			return UrlBase.contest_new;
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	
	@RequestMapping("/Manage")
	public String manage(Model model)
	{
		System.out.println("is work");

		if(sr.isLogin())
		{		
			List<ContestEntity> list=contestService.getlist()
					.stream().filter(c -> c.getIsdelete().equalsIgnoreCase("No"))
					.collect(Collectors.toList());
			

			
			model.addAttribute("list_obj",list);
			return UrlBase.contest_manage;
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	@PostMapping({"/Save"})
	public String save(@ModelAttribute ContestEntity contestBean)
	{
		if(sr.isLogin())
		{
			contestBean.setIsdelete("No");
			contestBean.setUqid(Uqid.getuqid()+"");
			contestBean.setContestStatus("Upcoming");
			
			contestBean.setIsactive("Yes");
			
			System.out.println("contestBean : "+contestBean.getStartDateTime());
			
			if (contestBean.getStartDateTime() == null) {
				contestBean.setStartDateTime(LocalDateTime.now());
		    }
			
			System.out.println(contestBean.getContestQuestion());
			
			
			AdminEntity admin=adminService.getAdminByUqid(sr.getAdminUnq());
			contestBean.setAdd_by_model(admin);
			
			contestService.save(contestBean);
			return "redirect:/Admin/Contest/New";
		}
		else
			return UrlBase.redirect_login;		
	}
	
	
	
	
	
	
	@PostMapping({"/Update"})
	public String update(@ModelAttribute ContestEntity model)
	{
		if(sr.isLogin())
		{
			ContestEntity entity=contestService.getById(model.getId());
			
			entity.setName(model.getName());
			entity.setIsactive(model.getIsactive());
			entity.setStartDateTime(model.getStartDateTime());
			
			contestService.save(entity);
			return "redirect:/Admin/Contest/Manage";
		}
		else
			return UrlBase.redirect_login;
		
	}
	
	
	@RequestMapping({"/Remove"})
	public String remove(@RequestParam("thisid") String id)
	{
		if(sr.isLogin())
		{
			ContestEntity entity=contestService.getById(Integer.parseInt(id));
			entity.setIsdelete("Yes");
			
			contestService.save(entity);
			
			return "redirect:/Admin/Contest/Manage";
		}
		else
			return UrlBase.redirect_login;
		
	}
	
	

	@RequestMapping({"/Active"})
	public String active(@RequestParam("thisid") String id)
	{
		if(sr.isLogin())
		{
			ContestEntity entity=contestService.getById(Integer.parseInt(id));
			
			entity.setIsactive("Yes");
			contestService.save(entity);
			return "redirect:/Admin/Contest/Manage";
		}
		else
			return UrlBase.redirect_login;
		
	}
	
	@RequestMapping({"/DeActive"})
	public String deActive(@RequestParam("thisid") String id)
	{
		if(sr.isLogin())
		{
			ContestEntity entity=contestService.getById(Integer.parseInt(id));
			
			entity.setIsactive("No");
			
			contestService.save(entity);
			
			return "redirect:/Admin/Contest/Manage";
		}
		else
			return UrlBase.redirect_login;
		
	}
	
	
	@RequestMapping({"/Active1"})
	public String active1(@RequestParam("thisid") String id)
	{
		if(sr.isLogin())
		{
			ContestEntity entity=contestService.getById(Integer.parseInt(id));
			
			entity.setIsactive("Yes");
			contestService.save(entity);
			return "redirect:/Admin/Contest/DeActiveList";
		}
		else
			return UrlBase.redirect_login;
		
	}
	
	@RequestMapping({"/DeActive1"})
	public String deActive1(@RequestParam("thisid") String id)
	{
		if(sr.isLogin())
		{
			ContestEntity entity=contestService.getById(Integer.parseInt(id));
			
			entity.setIsactive("No");
			
			contestService.save(entity);
			
			return "redirect:/Admin/Contest/ActiveList";
		}
		else
			return UrlBase.redirect_login;
		
	}
	
	
	
	
	
	@RequestMapping("/ActiveList")
	public String activeList(Model model)
	{

		if(sr.isLogin())
		{		
			List<ContestEntity> list=contestService.getlist();

			list=list.stream().filter(c -> c.getIsactive().equalsIgnoreCase("Yes")&&c.getIsdelete().equalsIgnoreCase("No")).collect(Collectors.toList());
			
			model.addAttribute("list_obj",list);
			return UrlBase.contest_isactive;
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	
	@RequestMapping("/DeActiveList")
	public String deactiveList(Model model)
	{

		if(sr.isLogin())
		{		
			List<ContestEntity> list=contestService.getlist();

			list=list.stream().filter(c -> c.getIsactive().equalsIgnoreCase("No")&&c.getIsdelete().equalsIgnoreCase("No")).collect(Collectors.toList());
			
			model.addAttribute("list_obj",list);
			return UrlBase.contest_isdeactive;
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	@RequestMapping("/isDeleteList")
	public String deletedlist(Model model)
	{

		if(sr.isLogin())
		{		
			List<ContestEntity> list=contestService.getlist();

			list=list.stream().filter(c -> c.getIsdelete().equalsIgnoreCase("Yes")).collect(Collectors.toList());
			
			model.addAttribute("list_obj",list);
			return UrlBase.contest_isdelete;
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	@RequestMapping("/Restore")
	public String restore(@RequestParam("thisid") String id)
	{

		if(sr.isLogin())
		{	
			ContestEntity entity=contestService.getById(Integer.parseInt(id));
			entity.setIsdelete("No");
			
			contestService.save(entity);
			return "redirect:/Admin/Contest/isDeleteList";
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	
	@RequestMapping("/Delete")
	public String delete(@RequestParam("thisid") String id)
	{

		if(sr.isLogin())
		{		
			contestService.delet(Integer.parseInt(id));			
			return "redirect:/Admin/Contest/isDeleteList";
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	
	
	
	@GetMapping({"/SavePlan"})
	@ResponseBody
	public String saveplan()
	{
		ContestPoolEntity model=new ContestPoolEntity();
		
		model.setName("Hello");
		
		PoolMemberPriceEntity en=new PoolMemberPriceEntity();
		PoolMemberPriceEntity en2=new PoolMemberPriceEntity();
		
		en.setMemberRank("1");
		en.setPrice(200);
		
		en2.setMemberRank("2-4");
		en2.setPrice(250);
		
		ArrayList<PoolMemberPriceEntity>list=new ArrayList<PoolMemberPriceEntity>();
		
		list.add(en);
		list.add(en2);
		
		model.setMember(list);
		
		contestPoolDao.save(model);
		
		return "saved";
	}
	
	
	@GetMapping({"/GetPlan"})
	@ResponseBody
	public List<ContestPoolEntity> getplan()
	{
		
		List<ContestPoolEntity> list=contestPoolDao.findAll();
		
		list.forEach(System.out :: println);
		
		System.out.println("List size : "+list.size());
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/Rules", produces={"text/html; charset=UTF-8"})
	public String rules(Model model)
	{
		if(sr.isLogin())
		{		
			 model.addAttribute("contestRulesBean", new ContestRulesTextEntity()); 
			 
			List<ContestRulesTextEntity> list=contestRulesDao.findAll();
	
			
			
			model.addAttribute("list_obj",list);
			return UrlBase.contest_rules;
		}
		else
			return UrlBase.redirect_login;
	}
	
	
	@PostMapping({"/SaveRule"})
	public String savea(@ModelAttribute ContestRulesTextEntity contestRulesBean)
	{
		if(sr.isLogin())
		{
			contestRulesBean.setIsdelete("No");
			contestRulesBean.setUqid(Uqid.getuqid()+"");
			
		
			
			AdminEntity admin=adminService.getAdminByUqid(sr.getAdminUnq());
			contestRulesBean.setAdd_by_model(admin);
			
			System.out.print("Messsage : "+contestRulesBean.getContestRules());
			
			contestRulesDao.save(contestRulesBean); 
			return "redirect:/Admin/Contest/Rules";
		}
		else
			return UrlBase.redirect_login;		
	}
	
	
	@PostMapping({"/UpdateRule"})
	public String update(@ModelAttribute ContestRulesTextEntity contestRulesBean)
	{
		if(sr.isLogin())
		{
			ContestRulesTextEntity entity=contestRulesDao.getOne(contestRulesBean.getId());
		
			entity.setName(contestRulesBean.getName());
			entity.setContestRules(contestRulesBean.getContestRules());

			contestRulesDao.save(entity); 
			return "redirect:/Admin/Contest/Rules";
		}
		else
			return UrlBase.redirect_login;		
	}
	
	
	@RequestMapping({"/RemoveRule"})
	public String removeRules(@RequestParam("thisid") String id)
	{
		if(sr.isLogin())
		{
			contestRulesDao.deleteById(Integer.parseInt(id)); 
			return "redirect:/Admin/Contest/Rules";
		}
		else
			return UrlBase.redirect_login;		
	}
	
	
	

}

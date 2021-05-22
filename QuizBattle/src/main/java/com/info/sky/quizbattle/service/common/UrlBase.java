package com.info.sky.quizbattle.service.common;

public class UrlBase 
{
	public static String login_page="login";
	
	public static String dash_page="dash";
	
	public static String redirect_login="redirect:Login";
	
	/* Category pages */
	public static String category_manage="category_page/category";
	public static String category_isactive="category_page/category_is_active";
	public static String category_isdeactive="category_page/category_is_deactive";
	public static String category_isdelete="category_page/category_is_delete";
	
	public static String categoryManageRedirect="redirect:/Admin/Category/Manage";
	
	/* Contest Pages */
	public static String contest_new="contest_page/contest";
	public static String contest_manage="contest_page/manage";
	public static String contest_isactive="contest_page/contest_is_active";
	public static String contest_isdeactive="contest_page/contes_is_deactive";
	public static String contest_isdelete="contest_page/contest_is_delete";
	
	public static String contest_rules="contest_page/rules";
	
	
	public static String contest_plan_manage="contest_pool/manage";
	public static String contest_plan_new="contest_pool/pool";
	public static String contest_plan_isactive="contest_pool/active";
	public static String contest_plan_isdeactive="contest_pool/deactive";
	public static String contest_plan_isdelete="contest_pool/isdeleted";
	
}

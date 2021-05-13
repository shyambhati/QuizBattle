package com.info.sky.quizbattle.service;

import com.info.sky.quizbattle.entity.AdminEntity;

public interface AdminService 
{
	public AdminEntity getAdminByUsernameAndPassword(String username,String password);
	
	public AdminEntity getAdminByUqid(String uqid);
}

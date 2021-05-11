package com.info.sky.quizbattle.service;

import com.info.sky.quizbattle.entity.AdminEntity;

public interface DeveloperService 
{
	public void save(AdminEntity entity);
	
	public AdminEntity findByToken(String id);
}

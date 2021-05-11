package com.info.sky.quizbattle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.AdminDao;
import com.info.sky.quizbattle.entity.AdminEntity;


@Service
public class AdminServiceImp  implements AdminService
{

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public AdminEntity getAdminByUsernameAndPassword(String username, String password) 
	{
		return adminDao.getAdminByUsernameAndPassword(username, password);
	}
	
}

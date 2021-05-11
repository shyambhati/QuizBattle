package com.info.sky.quizbattle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.DeveloperDao;
import com.info.sky.quizbattle.entity.AdminEntity;

@Service
public class DeveloperServiceImp implements DeveloperService {

	@Autowired
	private DeveloperDao developerDao;
	
	@Override
	public void save(AdminEntity entity) {
		developerDao.save(entity);
	}

	@Override
	public AdminEntity findByToken(String id) {
		// TODO Auto-generated method stub
		return developerDao.findByToken(id);
	}

}

package com.info.sky.quizbattle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.info.sky.quizbattle.Dao.UserDao;
import com.info.sky.quizbattle.entity.UserEntity;

public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void save(UserEntity entity) {
		userDao.save(entity);
	}

	@Override
	public UserEntity get(int id) {
		// TODO Auto-generated method stub
		return userDao.getOne(id);
	}

	@Override
	public List<UserEntity> getList() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

}

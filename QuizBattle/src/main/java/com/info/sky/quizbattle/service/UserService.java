package com.info.sky.quizbattle.service;

import java.util.List;

import com.info.sky.quizbattle.entity.UserEntity;



public interface UserService 
{
	public void save(UserEntity entity);
	UserEntity get(int id);
	
	List<UserEntity> getList();
}

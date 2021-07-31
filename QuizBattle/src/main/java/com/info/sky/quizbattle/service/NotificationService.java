package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Optional;

import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.NotificationEntity;

public interface NotificationService 
{
	public void save(NotificationEntity model); 
	public List<NotificationEntity> getlist();
	public void delet(int id);
	
}

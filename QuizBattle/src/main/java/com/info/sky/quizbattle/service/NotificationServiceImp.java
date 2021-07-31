package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.CategoryDao;
import com.info.sky.quizbattle.Dao.NotificationDao;
import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.NotificationEntity;


@Service
public class NotificationServiceImp implements NotificationService {

	
	@Autowired
	private NotificationDao dao;
	
	@Override
	public void save(NotificationEntity model) {
		dao.save(model);
	}


	@Override
	public List<NotificationEntity> getlist() {
		return dao.findAll();
	}


	@Override
	public void delet(int id) {
		dao.deleteById(id);
	}

}

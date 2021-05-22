package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.CategoryDao;
import com.info.sky.quizbattle.Dao.ContestDao;
import com.info.sky.quizbattle.Dao.ContestPoolDao;
import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.ContestEntity;
import com.info.sky.quizbattle.entity.ContestPoolEntity;

@Service
public class ContestPoolServiceImp implements ContestPoolService {

	@Autowired
	private ContestPoolDao dao;
	
	@Override
	public void save(ContestPoolEntity model) {
		dao.save(model);
	}

	@Override
	public ContestPoolEntity getById(int id) {
		return dao.getOne(id);
	}

	@Override
	public List<ContestPoolEntity> getlist() {
		return dao.findAll();
	}

	@Override
	public void update(ContestPoolEntity model) {
		
	}

	@Override
	public void delet(int id) {
		dao.deleteById(id);
	}

	@Override
	public void active(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<ContestPoolEntity>  findByid(int id) {
		// TODO Auto-generated method stub
		
		Optional<ContestPoolEntity> obj=dao.findById(id);
		return obj;
	}
}

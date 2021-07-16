package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.CategoryDao;
import com.info.sky.quizbattle.Dao.ContestDao;
import com.info.sky.quizbattle.entity.CategoryEntity;
import com.info.sky.quizbattle.entity.ContestEntity;

@Service
public class ContestServiceImp implements ContestService {

	@Autowired
	private ContestDao dao;
	
	@Override
	public void save(ContestEntity model) {
		dao.save(model);
	}

	@Override
	public ContestEntity getById(int id) {
		return dao.getOne(id);
	}

	@Override
	public List<ContestEntity> getlist() {
		return dao.findAll();
	}

	@Override
	public void update(ContestEntity model) {
		
	}

	@Override
	public void delet(int id) {
		dao.deleteById(id);
	}

	@Override
	public void active(int id) {
	
	}

	@Override
	public Optional<ContestEntity>  findByid(int id) {
		return dao.findById(id);
	}

	@Override
	public List<ContestEntity> getApilist() {
		/*
		 * Pageable limit = PageRequest.of(0,1); return dao.findAll(limit).toList();
		 */
		return dao.findAll();
	}
	
	
	@Override
	public List<ContestEntity> getApilist(String categoryId) {
		
		return dao.findAll();
	}
}

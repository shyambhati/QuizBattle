package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.CategoryDao;
import com.info.sky.quizbattle.entity.CategoryEntity;


@Service
public class CategoryServiceImp implements CategoryService {

	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void save(CategoryEntity model) {
		categoryDao.save(model);
	}

	@Override
	public CategoryEntity getById(int id) {
		return categoryDao.getOne(id);
	}

	@Override
	public List<CategoryEntity> getlist() {
		return categoryDao.findAll();
	}

	@Override
	public void update(CategoryEntity model) {
		
	}

	@Override
	public void delet(int id) {
		categoryDao.deleteById(id);
	}

	@Override
	public void active(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<CategoryEntity>  findByid(int id) {
		// TODO Auto-generated method stub
		
		Optional<CategoryEntity> obj=categoryDao.findById(id);
		return obj;
	}

}

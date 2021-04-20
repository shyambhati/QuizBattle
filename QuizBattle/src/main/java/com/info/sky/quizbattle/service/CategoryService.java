package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Optional;

import com.info.sky.quizbattle.entity.CategoryEntity;

public interface CategoryService 
{
	public void save(CategoryEntity model); 
	public CategoryEntity getById(int id);
	public List<CategoryEntity> getlist();
	public void update(CategoryEntity model);
	public void delet(int id);
	public void active(int id);
	
	
	public Optional<CategoryEntity>  findByid(int id);
}

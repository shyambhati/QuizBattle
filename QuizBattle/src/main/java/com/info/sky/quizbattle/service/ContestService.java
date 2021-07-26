package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.info.sky.quizbattle.entity.ContestEntity;

public interface ContestService 
{
	public void save(ContestEntity model); 
	
	public ContestEntity getById(int id);
	
	public ContestEntity getByUnqId(String id);
	
	public List<ContestEntity> getlist();
	public void update(ContestEntity model);
	public void delet(int id);
	public void active(int id);
	
	
	
	public Optional<ContestEntity>  findByid(int id);
	
	public List<ContestEntity> getApilist();
	
	public List<ContestEntity> getApilist(String categoryId);
}

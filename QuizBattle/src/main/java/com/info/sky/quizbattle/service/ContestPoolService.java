package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Optional;

import com.info.sky.quizbattle.entity.ContestEntity;
import com.info.sky.quizbattle.entity.ContestPoolEntity;

public interface ContestPoolService 
{
	public void save(ContestPoolEntity model); 
	public ContestPoolEntity getById(int id);
	public List<ContestPoolEntity> getlist();
	public void update(ContestPoolEntity model);
	public void delet(int id);
	public void active(int id);
	
	public Optional<ContestPoolEntity>  findByid(int id);
	
}

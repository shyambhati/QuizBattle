package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.info.sky.quizbattle.entity.ContestEntity;
import com.info.sky.quizbattle.entity.PraticeQuizEntity;

public interface PraticeQiuizService 
{
	public void save(PraticeQuizEntity model); 
	public List<PraticeQuizEntity> getlist();
	public void delet(int id);
}

package com.info.sky.quizbattle.service;

import java.util.List;
import com.info.sky.quizbattle.entity.QuizExamDetailsEntity;


public interface QuizExamDetailsService 
{
	public void save(QuizExamDetailsEntity model); 
	public List<QuizExamDetailsEntity> getlist();
	
	public List<QuizExamDetailsEntity> getByContestId(String contestId);
	
	public QuizExamDetailsEntity getByUserId(String contestId);
	
	

}

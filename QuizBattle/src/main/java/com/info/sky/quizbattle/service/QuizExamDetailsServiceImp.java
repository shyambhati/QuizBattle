package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.QuizExamDetailsDao;
import com.info.sky.quizbattle.entity.MyContestEntity;
import com.info.sky.quizbattle.entity.QuizExamDetailsEntity;

@Service
public class QuizExamDetailsServiceImp implements QuizExamDetailsService {

	@Autowired
	private QuizExamDetailsDao dao;
	
	@Autowired
	private MyContestService myContestService ;
	
	@Override
	public void save(QuizExamDetailsEntity model) {
		model.setUqid(UUID.randomUUID() + "");
		
		MyContestEntity contestModel=myContestService.getByUserId(model.getUserId(), model.getContestId());
		
		contestModel.setStatus("SUBMIT");
		
		myContestService.save(contestModel);
		
		dao.save(model);
	}

	@Override
	public List<QuizExamDetailsEntity> getlist() {
		return dao.findAll();
	}

	@Override
	public List<QuizExamDetailsEntity> getByContestId(String contestId) {
		// TODO Auto-generated method stub
		return dao.getByContestId(contestId);
	}

	@Override
	public QuizExamDetailsEntity getByUserId(String contestId) {
		// TODO Auto-generated method stub
		return dao.getByUserId(contestId);
	}

}

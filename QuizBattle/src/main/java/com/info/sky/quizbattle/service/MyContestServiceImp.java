package com.info.sky.quizbattle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.MyContestDao;
import com.info.sky.quizbattle.entity.MyContestEntity;

@Service
public class MyContestServiceImp implements MyContestService {

	@Autowired
	private MyContestDao dao;
	
	@Override
	public void save(MyContestEntity entity) {
		dao.save(entity);
	}

	@Override
	public List<MyContestEntity> getlist() {
		return dao.findAll();
	}

	@Override
	public List<MyContestEntity> getByContestId(String contestId) {
		return dao.getByContestId(contestId);
	}

	@Override
	public List<MyContestEntity> getByUserId(String userId) {
		return dao.getByUserId(userId);
	}

	@Override
	public MyContestEntity getByUserId(String userId, String contestId) {
		return dao.getByUserIdAndContestId(userId, contestId);
	}

}

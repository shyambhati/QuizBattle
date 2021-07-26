package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.MyContestDao;
import com.info.sky.quizbattle.entity.ContestEntity;
import com.info.sky.quizbattle.entity.MyContestEntity;
import com.info.sky.quizbattle.entity.UserEntity;

@Service
public class MyContestServiceImp implements MyContestService {

	@Autowired
	private MyContestDao dao;
	
	@Autowired
	private ContestService contestService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void save(MyContestEntity entity) {
		entity.setUqid(UUID.randomUUID() + "");
		
		ContestEntity model=contestService.getByUnqId(entity.getContestId());
		UserEntity user=userService.getUserByUqid(entity.getUserId());

		int amount=(user.getDeposit_amt())-(model.getPlan_model().getEntryFee());
		
		user.setDeposit_amt(amount);
	
		userService.save(user);
		
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

package com.info.sky.quizbattle.service;

import java.util.List;
import com.info.sky.quizbattle.entity.MyContestEntity;

public interface MyContestService {
	public void save(MyContestEntity entity);
	
	public List<MyContestEntity> getlist();	
	public List<MyContestEntity> getByContestId(String contestId);	
	public List<MyContestEntity> getByUserId(String userId);
	public MyContestEntity getByUserId(String userId,String contestId);
	
}

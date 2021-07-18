package com.info.sky.quizbattle.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.sky.quizbattle.entity.MyContestEntity;

@Repository
@Transactional
public interface MyContestDao extends JpaRepository<MyContestEntity, Integer>{

	List<MyContestEntity> getByContestId(String contestId);
	
	List<MyContestEntity> getByUserId(String userId);
	
	MyContestEntity getByUserIdAndContestId(String userId,String contestId);
}

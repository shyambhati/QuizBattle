package com.info.sky.quizbattle.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.sky.quizbattle.entity.QuizExamDetailsEntity;

@Repository
@Transactional
public interface QuizExamDetailsDao extends JpaRepository<QuizExamDetailsEntity, Integer>{

	List<QuizExamDetailsEntity> getByContestId(String contestId);
	QuizExamDetailsEntity getByUserId(String contestId);

}

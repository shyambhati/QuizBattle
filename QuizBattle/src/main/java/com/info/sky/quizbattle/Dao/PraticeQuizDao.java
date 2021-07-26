package com.info.sky.quizbattle.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.sky.quizbattle.entity.ContestEntity;
import com.info.sky.quizbattle.entity.PraticeQuizEntity;

@Repository
public interface PraticeQuizDao extends JpaRepository<PraticeQuizEntity, Integer>{

}

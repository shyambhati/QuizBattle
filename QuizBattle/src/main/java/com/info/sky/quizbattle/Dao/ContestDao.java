package com.info.sky.quizbattle.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.sky.quizbattle.entity.ContestEntity;

@Repository
public interface ContestDao extends JpaRepository<ContestEntity, Integer>{

}

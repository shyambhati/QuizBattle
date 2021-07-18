package com.info.sky.quizbattle.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.sky.quizbattle.entity.ContestPoolEntity;
import com.info.sky.quizbattle.entity.PoolMemberPriceEntity;

public interface ContestPoolDao extends JpaRepository<ContestPoolEntity, Integer>
{

}

package com.info.sky.quizbattle.Dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.sky.quizbattle.entity.AdminEntity;

@Repository
@Transactional
public interface DeveloperDao extends JpaRepository<AdminEntity, Integer>{

	AdminEntity findByToken(String id);
}

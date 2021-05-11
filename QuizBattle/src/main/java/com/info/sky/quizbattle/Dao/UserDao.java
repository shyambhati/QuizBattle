package com.info.sky.quizbattle.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.sky.quizbattle.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer>
{
	UserEntity getByPhone(String phone);
	UserEntity getByEmail(String email);
}

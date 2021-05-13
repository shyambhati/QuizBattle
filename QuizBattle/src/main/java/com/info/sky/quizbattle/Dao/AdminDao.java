package com.info.sky.quizbattle.Dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.info.sky.quizbattle.entity.AdminEntity;

@Repository
@Transactional
public interface AdminDao extends JpaRepository<AdminEntity, Integer>
{
	
	public AdminEntity getAdminByUsernameAndPassword(String username,String password);

	public AdminEntity getAdminByUqid(String uqid);
}

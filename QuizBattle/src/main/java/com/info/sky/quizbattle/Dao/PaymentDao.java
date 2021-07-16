package com.info.sky.quizbattle.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.sky.quizbattle.entity.PaymentEntity;

@Repository
@Transactional
public interface PaymentDao extends JpaRepository<PaymentEntity, Integer>{

	PaymentEntity getByPaymetId(String order_id);
	
	List<PaymentEntity> getByUserId(String userid);
}

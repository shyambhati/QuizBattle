package com.info.sky.quizbattle.service;

import java.util.List;

import com.info.sky.quizbattle.entity.PaymentEntity;
public interface PaymentService 
{
	public void save(PaymentEntity model);
	public PaymentEntity getByPaymentId(String order_id);
	
	public List<PaymentEntity> getByUserId(String userid);
	
	
	public List<PaymentEntity> getList();
	
	
}

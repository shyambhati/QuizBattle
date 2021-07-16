package com.info.sky.quizbattle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.PaymentDao;
import com.info.sky.quizbattle.entity.PaymentEntity;


@Service
public class PaymentServiceImp implements PaymentService {

	@Autowired 
	private PaymentDao dao;
	
	@Override
	public void save(PaymentEntity model) {
		 dao.save(model);
	}

	@Override
	public PaymentEntity getByPaymentId(String order_id) {
		return dao.getByPaymetId(order_id);
	}

	

	@Override
	public List<PaymentEntity> getByUserId(String userid) {
		return dao.getByUserId(userid);
	}

	
	
	@Override
	public List<PaymentEntity> getList() {
		return dao.findAll();
	}

}

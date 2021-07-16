package com.info.sky.quizbattle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.sky.quizbattle.Dao.SlideImageDao;
import com.info.sky.quizbattle.entity.SlideImageEntity;

@Service
public class OtherServiceImp implements OtherService {

	@Autowired
	private SlideImageDao dao;

	@Override
	public void save(SlideImageEntity model) {
		dao.save(model);
	}

	@Override
	public List<SlideImageEntity> getlist() {
		return dao.findAll();
	}

	@Override
	public SlideImageEntity getimage(int id) {
		return dao.getOne(id);
	}

	@Override
	public void delete(String id) {
		dao.deleteById(Integer.parseInt(id));
	}

}

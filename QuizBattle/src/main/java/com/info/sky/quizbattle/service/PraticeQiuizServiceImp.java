package com.info.sky.quizbattle.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.info.sky.quizbattle.Dao.PraticeQuizDao;
import com.info.sky.quizbattle.entity.PraticeQuizEntity;

@Service
public class PraticeQiuizServiceImp implements PraticeQiuizService {

	@Autowired
	private PraticeQuizDao dao;
	
	@Override
	public void save(PraticeQuizEntity model) {
		model.setUqid(UUID.randomUUID() + "");
		dao.save(model);
	}
	
	@Override
	public List<PraticeQuizEntity> getlist() {
		return dao.findAll();
	}

	@Override
	public void delet(int id) {
		dao.deleteById(id);
	}

}

package com.info.sky.quizbattle.service;

import java.util.List;

import com.info.sky.quizbattle.entity.SlideImageEntity;

public interface OtherService 
{
	public void save(SlideImageEntity model); 
	public List<SlideImageEntity> getlist();
	public SlideImageEntity getimage(int id);
	public void delete(String id);
}

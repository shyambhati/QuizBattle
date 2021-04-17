package com.info.sky.quizbattle.service;

import java.util.ArrayList;
import java.util.List;

import com.info.sky.quizbattle.entity.CategoryEntity;

public class CategoryService 
{
	public static List<CategoryEntity> getCategoryData()
	{
		List<CategoryEntity> list=new ArrayList<>();
		
		CategoryEntity model;
		
		for(int i=1;i<=10000;i++)
		{
			model=new CategoryEntity(i, "Hindi "+i, "Yes");		
			list.add(model);
		}
		
		return list;
	}
}

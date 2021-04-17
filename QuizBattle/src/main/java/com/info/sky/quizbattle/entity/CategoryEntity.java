package com.info.sky.quizbattle.entity;

public class CategoryEntity 
{
	private int id;
	
	private String name;
	
	private String isNew;

	
	
	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CategoryEntity(int id, String name, String isNew) {
		super();
		this.id = id;
		this.name = name;
		this.isNew = isNew;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	
}

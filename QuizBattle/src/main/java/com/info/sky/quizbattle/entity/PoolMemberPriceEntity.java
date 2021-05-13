package com.info.sky.quizbattle.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class PoolMemberPriceEntity implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	private int position;
	private int price;
	private int member;
	
	
}

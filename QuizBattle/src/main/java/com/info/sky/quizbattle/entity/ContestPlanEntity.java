package com.info.sky.quizbattle.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contest_rank_plan_table")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class ContestPlanEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "plan_name")
	private String name;
	
	@Column(name = "pool_size")
	private int poolSize;
	
	@Column(name = "min_pool_size")
	private int minPoolSize;
	
	@Column(name = "pool_prize")
	private int poolPrice;
	
	@Column(name = "entry_fees")
	private int entryFee;
	
	@Column(name = "member_price")
	private ArrayList<PoolMemberPriceEntity> member;

}

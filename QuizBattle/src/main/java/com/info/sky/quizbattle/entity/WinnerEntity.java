package com.info.sky.quizbattle.entity;


import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class WinnerEntity 
{
private static final long serialVersionUID = 1L;

	private String userId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private UserEntity user_model;
	
	private String userRank;
	private String winningAmount;
}

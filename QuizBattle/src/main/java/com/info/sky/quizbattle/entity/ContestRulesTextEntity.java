package com.info.sky.quizbattle.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contest_rules_table")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class ContestRulesTextEntity extends CommonEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	@JsonIgnore
	@Column(name = "rule_name")
	private String name;
	
	@Column(name = "contest_rules")
	private String contestRules;
}

package com.info.sky.quizbattle.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contest_table")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ContestEntity extends CommonEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "contest_name")
	private String name;
		
	@Column(name = "contest_start_date_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startDateTime;
	
	@Column(name = "contest_status")
	private String contestStatus;
	
	@Column(name = "total_contest_totaltime")
	private String totaltime;
	
	@Column(name = "total_contest_quiztime")
	private String quiztime;
	
	@Column(name = "contest_question")
	private String question;
	
	@Column(name = "contest_question_option1")
	private String option1;
	
	@Column(name = "contest_question_option2")
	private String option2;
	
	@Column(name = "contest_question_option3")
	private String option3;
	
	@Column(name = "contest_question_option4")
	private String option4;
	
	@Column(name = "contest_question_answer")
	private String answer;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private CategoryEntity category_model;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private ContestRulesTextEntity rule_model;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private ContestPoolEntity plan_model;
	
	
//	@Column(name = "contest_status")
//	private String contest_status;
}

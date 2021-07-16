package com.info.sky.quizbattle.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Quiz_Exam")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class QuizExamDetailsEntity 
{
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "userId")
	private String userId;
	
	
	@Column(name = "contestId")
	private String contestId;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "allOption")
	private String allOption;
	
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "userAnswer")
	private String userAnswer;
	
	
	@Column(name = "timeStampStartQuiz")
	private String timeStampStartQuiz;
	
	@Column(name = "timeStampEndQuiz")
	private String timeStampEndQuiz;
	
	@Column(name = "counterSecondStamp")
	private long  counterSecondStamp;
	
	@Column(name = "counterNanosecondsStamp")
	private long  counterNanosecondsStamp;
		
	@JsonIgnore
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
    private Date createdAt;

	/* @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss a") */
	@JsonIgnore
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt; 
    	
	
	
	@Schema(hidden = true)
	@Column(name = "uqid")
	private String uqid;

}
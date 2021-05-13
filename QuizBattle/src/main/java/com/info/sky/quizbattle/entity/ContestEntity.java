package com.info.sky.quizbattle.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column(name = "contest_rules")
	private String contestRules;
}

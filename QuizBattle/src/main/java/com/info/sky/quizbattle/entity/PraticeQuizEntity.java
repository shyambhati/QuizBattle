package com.info.sky.quizbattle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class PraticeQuizEntity {

	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
}

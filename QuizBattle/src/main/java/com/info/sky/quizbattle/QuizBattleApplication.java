package com.info.sky.quizbattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



/*@OpenAPIDefinition(info =@Info(
		title = "Quiz Maffia API Document",
		version = "2.0",description = "This is Quiz Battle Application") )*/

@SpringBootApplication
public class QuizBattleApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizBattleApplication.class, args);
	}

}

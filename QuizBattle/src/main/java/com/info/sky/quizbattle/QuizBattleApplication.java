package com.info.sky.quizbattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



/*@OpenAPIDefinition(info =@Info(
		title = "Quiz Maffia API Document",
		version = "2.0",description = "This is Quiz Battle Application") )*/



//extends SpringBootServletInitializer for war file export and add <packaging>war</packaging> in pom.xml

@SpringBootApplication
public class QuizBattleApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(QuizBattleApplication.class, args);
	}

}

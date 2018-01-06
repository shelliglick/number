package com.demo.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumberGuessingApplication {

	@Autowired
	GameManager game;

	public static void main(String[] args) {
		SpringApplication.run(NumberGuessingApplication.class, args);
	}


//	@Bean(initMethod="init")
//	@Scope("session")
//	public GameManager gameManager() {
//		GameManagerImpl game = new GameManagerImpl();
//		return game;
//	}

//	@Bean
//	public ProfilingAspect profileAspect() {
//		return new ProfilingAspect();
//	}


}

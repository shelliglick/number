package com.demo.springboot;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
//@Scope(value="session")
public class GameManagerImpl implements GameManager {
	
	private int numberToGuess;
	
	private int counter;


	@PostConstruct
	public void init() {
		init((int)(Math.random() * 10) + 1);
	}
	
	protected void init(int num) {
		numberToGuess = num;
		counter = 0;
		System.out.println("setting number to guess to " + numberToGuess);
	}
	
	
	@Override
	public String guess(int num) {
		System.out.println("guessing " + num);
		counter++;
		if (num == numberToGuess){
			String retVal = "You won at the " + counter + " guess";
			init();
			return retVal;
		}
		if (counter == 5) {
			init();
			return "Game Over";
		}
		return "try again " + counter;
	}


	protected int getNumberToGuess() {
		return numberToGuess;
	}


	protected void setNumberToGuess(int numberToGuess) {
		this.numberToGuess = numberToGuess;
	}
	
	
	

}

package com.demo.springboot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
//@Scope(value="session")
public class GameManagerImpl implements GameManager {
	
	private int numberToGuess;
	
	private int counter;

	@Value("${game.top}")
	private int top;

	@Value("${game.limit}")
	private int limit;

	@PostConstruct
	public void init() {
		init((int)(Math.random() * top) + 1);
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
		if (counter == limit) {
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

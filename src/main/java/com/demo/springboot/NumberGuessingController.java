package com.demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value="session")
public class NumberGuessingController {
	
	private GameManager game;
	
	@Autowired
	public NumberGuessingController(GameManager game) {
		super();
		this.game = game;
	}

	@RequestMapping(value="/guess")
	public String guess(@RequestParam int num) {
		return game.guess(num);
	}

}

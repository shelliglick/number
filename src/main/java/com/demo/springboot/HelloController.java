package com.demo.springboot;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	@ResponseStatus(HttpStatus.OK)
	public Future<String> hello(@RequestParam String name) {
		
		return CompletableFuture.supplyAsync(() -> "Hello "+ name).thenApplyAsync(String::toUpperCase);
	}

}

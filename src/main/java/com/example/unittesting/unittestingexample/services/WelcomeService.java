package com.example.unittesting.unittestingexample.services;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	public String welcomeMsg() {
		return "Hello!!";
	}
}

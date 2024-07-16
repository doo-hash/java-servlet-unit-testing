package com.example.unittesting.unittestingexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.unittesting.unittestingexample.services.WelcomeService;

@RestController
@RequestMapping("/")
public class WelcomeController {

	@Autowired
	private WelcomeService service;
	
	@GetMapping("hello")
	public ResponseEntity<String> message(){
		return new ResponseEntity<>(service.welcomeMsg(),HttpStatus.OK);
	}
}

package com.practice.rest_starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	@GetMapping("/message")
	public String getMessage() {
		
		return "Hello World!";
	}
}

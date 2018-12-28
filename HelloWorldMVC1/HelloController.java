package com.cg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String sayHello(){
		System.out.println("hii");
		return "welcome to spring MVC!";
	}

}

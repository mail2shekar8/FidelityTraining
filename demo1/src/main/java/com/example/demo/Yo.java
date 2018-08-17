package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Yo {a
	
	@GetMapping("/yo/{txt}")
	
	public String sayYo (@PathVariable String txt) {
	
	return txt;
	}
}

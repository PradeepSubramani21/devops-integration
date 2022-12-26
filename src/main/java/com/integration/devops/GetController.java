package com.integration.devops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

	@GetMapping("/")
	public String getValue() {
		System.out.println("***** getValue *******");
		return "Greetings from Pradeep !";
	}

	@GetMapping("/hi")
	public String getOptions(){
		return "Hey !!";
	}
}

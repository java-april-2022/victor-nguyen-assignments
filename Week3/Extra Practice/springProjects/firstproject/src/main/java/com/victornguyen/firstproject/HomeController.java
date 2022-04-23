package com.victornguyen.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello() { // 3
            return "Hello World!";
    }
	
	
	@RequestMapping("/test")
	public String test() {
		return "Test";
	}
}

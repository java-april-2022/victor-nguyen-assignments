package com.victor.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HumanController {

	@RequestMapping("")
	
	public String giveName(
			@RequestParam(value="first_name", required = false) String first_name,
			@RequestParam(value="last_name", required = false) String last_name,
			@RequestParam(value="times", required = false) Integer times
			) {
		
		String full_name;
		
		if (first_name == null && last_name == null) {
			full_name = "Human";
		}
		else if (first_name != null && last_name != null) {
			full_name = first_name + " " + last_name;
		}
		else {
			full_name = first_name == null ?
					"Mr./Mrs. " + last_name:
					first_name;
		}
		
		String phrase = String.format(
				"<h1> Hello %s! </h1>"
				+ "", full_name);
		
		if (times == null) {
			return phrase;
		}
		else {
			return phrase.repeat(times);
		}
	}
}

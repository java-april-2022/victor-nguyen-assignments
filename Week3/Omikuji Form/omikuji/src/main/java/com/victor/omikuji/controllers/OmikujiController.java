package com.victor.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String omikuji() {
		return "omikuji.jsp";
	}
	
	@GetMapping("/omikuji/show")
	public String fortune(HttpSession session, Model model) {
		String fortune = (String) session.getAttribute("fortune");
		model.addAttribute("fortune", fortune);
		return "fortune.jsp";
	}
	
	@PostMapping("/omikujiform")
	public String process(
				@RequestParam("number") int number,
				@RequestParam("city") String city,
				@RequestParam("person") String person,
				@RequestParam("hobby") String hobby,
				@RequestParam("thing") String thing,
				@RequestParam("nicequote") String nicequote,
				HttpSession session
			)
		{
			String fortune = String.format("In %s years, you will live in %s with %s as your roommate, %s as a living. The next time you see a %s, you will have good luck. Also, %s.",
					number, city, person, hobby, thing, nicequote);
			session.setAttribute("fortune", fortune);
			return "redirect:/omikuji/show";
		}
	
}

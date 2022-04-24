package com.victor.counter.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter/")
	public String counter(HttpSession session, Model model, HttpServletRequest request) {
		Integer currentCount = 0;
		
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			currentCount = (Integer) session.getAttribute("count");
		}
		
		String homeUrl = request.getRequestURL().toString();
		
		model.addAttribute("count", currentCount);
		
		model.addAttribute("homepage", homeUrl.substring(0,homeUrl.length()-9));
		
		return "counter.jsp";
	}
	
	@RequestMapping("/doublecounter/")
	public String doublecounter(HttpSession session, Model model) {
		
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount+=2;
			session.setAttribute("count", currentCount);
		}
		
		return "doublecounter.jsp";
	}
	
	@RequestMapping("/resetcounter")
	public String resetcounter(HttpSession session, Model model, HttpServletRequest request) {
		
		session.setAttribute("count", 0);
		
		return "redirect:/counter/";
	}
	
}

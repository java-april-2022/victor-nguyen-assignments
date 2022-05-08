package com.victor.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.victor.dojosninjas.models.Dojo;
import com.victor.dojosninjas.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojos;
	
	@GetMapping("/")
	public String home(Model model) {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List <Dojo> allDojos = dojos.all();
		model.addAttribute("allDojos", allDojos);
		return "adddojo.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojos.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "showdojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result
			)
	{
		if (result.hasErrors()) {
			return "adddojo.jsp";
		}
		else {
			dojos.createDojo(dojo);
			return "redirect:/ninjas/new";
		}	
	}
}

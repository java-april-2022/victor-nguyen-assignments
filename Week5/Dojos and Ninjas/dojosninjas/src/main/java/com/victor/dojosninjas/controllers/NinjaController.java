package com.victor.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.victor.dojosninjas.models.Dojo;
import com.victor.dojosninjas.models.Ninja;
import com.victor.dojosninjas.services.DojoService;
import com.victor.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService ninjas;
	@Autowired
	private DojoService dojos;
	
	@GetMapping("/ninjas/new")
	public String newNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojos.all();
		model.addAttribute("allDojos", allDojos);
		return "addninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result
			)
	{
		if (result.hasErrors()) {
			return "addninja.jsp";
		}
		else {
			ninja = ninjas.createNinja(ninja);
			return String.format("redirect:/dojos/%s", ninja.getDojo().getId());
			// can also be return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
	
}

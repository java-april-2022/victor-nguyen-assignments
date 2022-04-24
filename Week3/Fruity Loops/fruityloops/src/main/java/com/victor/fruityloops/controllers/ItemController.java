package com.victor.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.victor.fruityloops.models.Item;

//... imports (Use shift+ctrl+O or shift+cmd+O to import as you code)
@Controller
public class ItemController {
 
 @RequestMapping("/")
 public String index(Model model) {
     
     ArrayList<Item> fruits = new ArrayList<Item>();
     fruits.add(new Item("Kiwi1", 1.51));
     fruits.add(new Item("Mango1", 2.01));
     fruits.add(new Item("Goji Berries1", 4.01));
     fruits.add(new Item("Guava1", 1.75));
     
     // Add fruits your view model here
     model.addAttribute("fruits", fruits);
     
     return "fruityloops.jsp";
 }
}


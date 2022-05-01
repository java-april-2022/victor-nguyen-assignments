package com.victor.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.victor.savetravels.models.Expense;
import com.victor.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String home(Model model) {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "show.jsp";
	}
	
	@GetMapping("/expenses/new")
	public String newExpense(@ModelAttribute("expense") Expense expense) {
		return "new.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		model.addAttribute("expenses", expenseService.allExpenses());
		return "edit.jsp";
	}
	
	@PostMapping("/expenses")
	public String create(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result
			)
	{
		if (result.hasErrors()) {
			return "index.jsp";
	}
		else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
		
	}
	
	@PutMapping("/expenses/{id}")
	public String update(
			@PathVariable("id") Long id, 
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model
			) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
			return "edit.jsp";
		}
		else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping("/expenses/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}

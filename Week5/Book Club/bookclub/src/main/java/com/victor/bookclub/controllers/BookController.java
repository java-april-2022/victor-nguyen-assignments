package com.victor.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.victor.bookclub.models.Book;
import com.victor.bookclub.models.User;
import com.victor.bookclub.services.BookService;
import com.victor.bookclub.services.UserService;

@Controller
public class BookController {

	@Autowired
	private BookService books;
	@Autowired
	private UserService users;
	
	@GetMapping("/books")
	public String books(HttpSession session, Model model) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		else {
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("books", books.all());
			model.addAttribute("user", users.findById(userId));
			return "books.jsp";
		}
	}
	
	@GetMapping("/books/new")
	public String addBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("userId");
		User user = users.findById(userId);
		model.addAttribute("user", user);
		return "addbook.jsp";
		
	}
	
	@PostMapping("books/new")
	public String addBookPost(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result
			) {
		
		if (result.hasErrors()) {
			return "addbook.jsp";
		}
		else {
			books.create(book);
			return "redirect:/books";
		}
		
	}
	
	@GetMapping("/books/{id}")
	public String showBook(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		else {
			Book book = books.findById(id);
			User user = book.getUser();
			Long bookUserId = user.getId();
			if (session.getAttribute("userId") != bookUserId) {				
				model.addAttribute("book", book);
				model.addAttribute("user", users.findById((Long) session.getAttribute("userId")));
				return "showbook.jsp";
			}
			else {
				model.addAttribute("book", book);
				model.addAttribute("user", users.findById((Long) session.getAttribute("userId")));
				return "showbookuseredit.jsp";
			}
			
		}
		
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		else {
			Book book = books.findById(id);
			model.addAttribute("book", book);
			return "editbook.jsp";
		}
	}
	
	@PutMapping("/books/{id}/edit")
	public String editBookPut(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model model
			) {
		
		if (result.hasErrors()) {
			return "editbook.jsp";
		}
		else {
			books.update(book);
			return "redirect:/books";
		}
	}
	
	
}

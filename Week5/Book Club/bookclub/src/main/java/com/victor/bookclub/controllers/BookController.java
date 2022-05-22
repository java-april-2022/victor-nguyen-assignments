package com.victor.bookclub.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.victor.bookclub.models.Book;
import com.victor.bookclub.models.User;
import com.victor.bookclub.services.BookService;
import com.victor.bookclub.services.UserService;

@Controller
public class BookController {

	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/books")
	public String books(HttpSession session, Model model) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		else {
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("books", bookServ.allBooks());
			model.addAttribute("user", userServ.findById(userId));
			return "books.jsp";
		}
	}
	
	@GetMapping("/books/new")
	public String addBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userServ.findById(userId);
		model.addAttribute("user", user);
		return "addbook.jsp";
		
	}
	
	@PostMapping("books/new")
	public String addBookPost(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			HttpSession session
			) {
		
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/logout";
		}
		
		if (result.hasErrors()) {
			return "addbook.jsp";
		}
		else {
			bookServ.createBook(new Book(book.getTitle(), book.getAuthor(), book.getThoughts(), userServ.findById(userId)));
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
			Book book = bookServ.findBookById(id);
			User user = book.getUser();
			Long bookUserId = user.getId();
			if (session.getAttribute("userId") != bookUserId) {				
				model.addAttribute("book", book);
				model.addAttribute("user", userServ.findById((Long) session.getAttribute("userId")));
				return "showbook.jsp";
			}
			else {
				model.addAttribute("book", book);
				model.addAttribute("user", userServ.findById((Long) session.getAttribute("userId")));
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
			Book book = bookServ.findBookById(id);
			model.addAttribute("book", book);
			return "editbook.jsp";
		}
	}
	
	@PutMapping("/books/{id}/edit")
	public String editBookPut(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		if (result.hasErrors()) {
			return "editbook.jsp";
		}
		else {
			bookServ.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/bookmarket")
	public String bookmarket(HttpSession session, Model model) {
	 
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userServ.findById(userId));

		List<Book> books = bookServ.unborrowedBooks(userServ.findById(userId));
		model.addAttribute("books", books);

		List<Book> myBooks = bookServ.borrowedBooks(userServ.findById(userId));
		model.addAttribute("myBooks", myBooks);
		 
		return "bookmarket.jsp";
	}
	
	@RequestMapping("/bookmarket/{bookID}")
	public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		bookServ.addBorrower(bookServ.findBookById(bookID), userServ.findById(userId));
		 
		return "redirect:/bookmarket";
	}
	
	@RequestMapping("/bookmarket/return/{bookID}")
	public String returnBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		bookServ.removeBorrower(bookServ.findBookById(bookID));
		 
		return "redirect:/bookmarket";
	}
	
}

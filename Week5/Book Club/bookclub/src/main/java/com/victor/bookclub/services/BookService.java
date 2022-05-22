package com.victor.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.bookclub.models.Book;
import com.victor.bookclub.models.User;
import com.victor.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo ) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public List<Book> unborrowedBooks(User user) {
		return bookRepo.findByBorrowerIdIsOrUserIdIs(null, user.getId());
	}
	
	public List<Book> borrowedBooks(User user) {
		return bookRepo.findByBorrowerIdIs(user.getId());
	}
	
	public List<Book> myBooks(User user) {
		return bookRepo.findByUserIdIs(user.getId());
	}
	
	public Book findBookById(Long id) {
		
		Optional<Book> result = bookRepo.findById(id);
		
		if (result.isPresent()) {
			return result.get();
		}
		else {
			return null;
		}
		
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	public void deleteBook(Book book) {
		bookRepo.delete(book);
		
	}
	
	public void removeBorrower(Book book) {
		book.setBorrower(null);
		bookRepo.save(book);
	}
	
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepo.save(book);
	}
}

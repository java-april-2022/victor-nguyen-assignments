package com.victor.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.bookclub.models.Book;
import com.victor.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> all() {
		return bookRepo.findAll();
	}
	
	public Book findById(Long id) {
		
		Optional<Book> result = bookRepo.findById(id);
		
		if (result.isPresent()) {
			return result.get();
		}
		else {
			return null;
		}
		
	}
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
	public void delete(Book book) {
		bookRepo.delete(book);
		
	}
}

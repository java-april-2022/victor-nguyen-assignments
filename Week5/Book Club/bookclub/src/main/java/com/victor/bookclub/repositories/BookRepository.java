package com.victor.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.victor.bookclub.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByUserIdIs(Long userId);
	List<Book> findByBorrowerIdIs(Long userId);
	List<Book> findByBorrowerIdIsOrUserIdIs(Long borrowerID, Long userId);
}

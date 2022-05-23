package com.victor.productmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.victor.productmanager.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

	List<Task> findAll();
	List<Task> findByProjectIdIs(Long id);
	
}

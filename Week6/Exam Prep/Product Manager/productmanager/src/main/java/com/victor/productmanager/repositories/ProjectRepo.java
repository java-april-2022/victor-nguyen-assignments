package com.victor.productmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.victor.productmanager.models.Project;
import com.victor.productmanager.models.User;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

	List<Project> findAll();
	Project findByIdIs(Long id);
	List<Project> findAllByUsers(User user);
	List<Project> findByUsersNotContains(User user);
	
}

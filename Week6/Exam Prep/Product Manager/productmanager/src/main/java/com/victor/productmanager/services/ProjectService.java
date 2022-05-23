package com.victor.productmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.productmanager.models.Project;
import com.victor.productmanager.models.User;
import com.victor.productmanager.repositories.ProjectRepo;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepo projectRepo;
	
	public ProjectService(ProjectRepo projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	public Project findById(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}else {
			return null;
		}
	}
	
	public Project addProject(Project project) {
		return projectRepo.save(project);
	}
	
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	public void deleteProject(Project project) {
		projectRepo.delete(project);
	}
	
	public List<Project> getAssignedUsers(User user){
		return projectRepo.findAllByUsers(user);
	}
	
	public List<Project> getUnassignedUsers(User user){
		return projectRepo.findByUsersNotContains(user);
	}
	
}

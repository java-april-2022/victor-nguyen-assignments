package com.victor.productmanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.victor.productmanager.models.Task;
import com.victor.productmanager.repositories.TaskRepo;

@Service
public class TaskService {

	private TaskRepo taskRepo;
	
	public TaskService(TaskRepo taskRepo) {
		this.taskRepo = taskRepo;
	}
	
	public List<Task> allTasks() {
		return taskRepo.findAll();
	}
	
	public List<Task> projectTasks(Long projectId) {
		return taskRepo.findByProjectIdIs(projectId);
	}
	
	public Task addTask(Task task) {
		return taskRepo.save(task);
	}
	
	public void deleteTask(Task task) {
		taskRepo.delete(task);
	}
	
}

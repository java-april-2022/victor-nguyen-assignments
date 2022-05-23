package com.victor.productmanager.controllers;

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

import com.victor.productmanager.models.Project;
import com.victor.productmanager.models.Task;
import com.victor.productmanager.services.ProjectService;
import com.victor.productmanager.services.TaskService;
import com.victor.productmanager.services.UserService;

@Controller
public class TaskController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private ProjectService projectServ;
	
	@Autowired
	private TaskService taskServ;
	
	@GetMapping("/projects/{id}/tasks")
	public String viewProjectTasks(@PathVariable("id") Long id, HttpSession session, Model model, @ModelAttribute("task") Task task) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectServ.findById(id);
		model.addAttribute("project", project);
		model.addAttribute("tasks", taskServ.projectTasks(id));
		return "tasks.jsp";
	}
	
	@PostMapping("/projects/{id}/tasks")
	public String newProjectTask(
			@PathVariable("id") Long id, 
			HttpSession session, 
			Model model, 
			@Valid @ModelAttribute("task") Task task, 
			BindingResult result) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectServ.findById(id);
		
		if(result.hasErrors()) {
			model.addAttribute("project", project);
			model.addAttribute("tasks", taskServ.projectTasks(id));
			return "tasks.jsp";
		}else {
			Task newTask = new Task(task.getTaskTicket());
			newTask.setProject(project);
			newTask.setCreator(userServ.findById(userId));
			taskServ.addTask(newTask);
			return "redirect:/projects/" + id + "/tasks";
		}
	}
	
}

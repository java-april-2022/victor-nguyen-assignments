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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.victor.productmanager.models.Project;
import com.victor.productmanager.models.Task;
import com.victor.productmanager.models.User;
import com.victor.productmanager.services.ProjectService;
import com.victor.productmanager.services.TaskService;
import com.victor.productmanager.services.UserService;

@Controller
public class ProjectController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private ProjectService projectServ;
	
	@Autowired
	private TaskService taskServ;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		else {
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("unassignedProjects", projectServ.getUnassignedUsers(userServ.findById(userId)));
			model.addAttribute("assignedProjects", projectServ.getAssignedUsers(userServ.findById(userId)));
			return "dashboard.jsp";
		}
	}
	
	@RequestMapping("/dashboard/join/{id}")
	public String joinTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectServ.findById(id);
		User user = userServ.findById(userId);
		
		user.getProjects().add(project);
		userServ.updateUser(user);
		
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("unassignedProjects", projectServ.getUnassignedUsers(user));
		model.addAttribute("assignedProjects", projectServ.getAssignedUsers(user));
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard/leave/{id}")
	public String leaveTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectServ.findById(id);
		User user = userServ.findById(userId);
		
		user.getProjects().remove(project);
		userServ.updateUser(user);
		
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("unassignedProjects", projectServ.getUnassignedUsers(user));
		model.addAttribute("assignedProjects", projectServ.getAssignedUsers(user));
		
		return "redirect:/dashboard";
	
	}
	
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		return "new_project.jsp";
	}
	
	@PostMapping("/projects/new")
	public String addNewProject(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		if(result.hasErrors()) {
			return "new_project.jsp";
		}else {
			User user = userServ.findById(userId);
			Project newProject = new Project(project.getTitle(), project.getDueDate(), project.getDescription(), project.getLead());
			newProject.setLead(user);
			projectServ.addProject(newProject);
			user.getProjects().add(newProject);
			userServ.updateUser(user);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/projects/{id}")
	public String viewProject(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectServ.findById(id);
		model.addAttribute("project", project);
		return "view_project.jsp";
	}
	
	@GetMapping("/projects/edit/{id}")
	public String openEditProject(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectServ.findById(id);
		model.addAttribute("project", project);
		return "edit_project.jsp";
	}
	
	@PutMapping("/projects/edit/{id}")
	public String editProject(
			@PathVariable("id") Long id, 
			@Valid @ModelAttribute("project") Project project, 
			BindingResult result, 
			HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		User user = userServ.findById(userId);
		
		if(result.hasErrors()) {
			return "edit_project.jsp";
		}else {
			Project thisProject = projectServ.findById(id);
			project.setUsers(thisProject.getUsers());
			project.setLead(user);
			projectServ.updateProject(project);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		User user = userServ.findById(userId);
		
		Project project = projectServ.findById(id);
		
		// We need to make sure all tasks associated with the project we are deleting are deleted first
		for(Task t:taskServ.projectTasks(id)) {
			taskServ.deleteTask(t);
		}
		
		// Once the tasks are deleted, we can safely delete our project
		projectServ.deleteProject(project);
		model.addAttribute("unassignedProjects", projectServ.getUnassignedUsers(user));
		model.addAttribute("assignedProjects", projectServ.getAssignedUsers(user));
		return "redirect:/dashboard";
	}
	
}

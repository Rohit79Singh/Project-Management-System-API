package com.springboot.projectmanagementAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.projectmanagementAPI.Service.ProjectService;
import com.springboot.projectmanagementAPI.model.ProjectEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	
	    @Autowired
	    private ProjectService projectService;

	    @PostMapping
	    public ProjectEntity createProject(@Valid @RequestBody ProjectEntity project) {
	        return projectService.createProject(project);
	    }

	    @GetMapping
	    public List<ProjectEntity> getAllProjects() {
	        return projectService.getAllProjects();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ProjectEntity> getProjectById(@PathVariable Long id) {
	    	ProjectEntity project = projectService.getProjectById(id).orElseThrow(() -> new RuntimeException("Project not found"));
	        return ResponseEntity.ok(project);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ProjectEntity> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectEntity projectDetails) {
	    	ProjectEntity updatedProject = projectService.updateProject(id, projectDetails);
	        return ResponseEntity.ok(updatedProject);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
	        projectService.deleteProject(id);
	        return ResponseEntity.noContent().build();	    
	        
	    }
	    
	}
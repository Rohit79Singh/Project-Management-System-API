package com.springboot.projectmanagementAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.projectmanagementAPI.Repository.ProjectRepository;
import com.springboot.projectmanagementAPI.model.ProjectEntity;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
    private ProjectRepository projectRepository;

    public ProjectEntity createProject(ProjectEntity project) {
        return projectRepository.save(project);
    }

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<ProjectEntity> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public ProjectEntity updateProject(Long id, ProjectEntity projectDetails) {
    	ProjectEntity project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    
    	project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate()); 
        
        return projectRepository.save(project);
        
    }

    public void deleteProject(Long id) {
    	ProjectEntity project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        projectRepository.delete(project);
    }
	
}

package com.springboot.projectmanagementAPI.Service;

import java.util.List;
import java.util.Optional;

import com.springboot.projectmanagementAPI.model.ProjectEntity;

public interface ProjectService {

	ProjectEntity createProject(ProjectEntity project);
	List<ProjectEntity> getAllProjects();
	Optional<ProjectEntity> getProjectById(Long id);
	ProjectEntity updateProject(Long id, ProjectEntity projectDetails);
	void deleteProject(Long id);
	
}

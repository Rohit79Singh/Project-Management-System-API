package com.springboot.projectmanagementAPI.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springboot.projectmanagementAPI.Repository.ProjectRepository;
import com.springboot.projectmanagementAPI.model.ProjectEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class ProjectServiceImplTest {
	
	    @Mock
	    private ProjectRepository projectRepository;

	    @InjectMocks
	    private ProjectService projectService;

	    private ProjectEntity project;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	        project = new ProjectEntity();
	        project.setId(1L);
	        project.setName("Test Project");
	        project.setDescription("Test Description");
	        project.setStartDate(LocalDate.now());
	    }

	    @Test
	    public void testCreateProject() {
	        when(projectRepository.save(any(ProjectEntity.class))).thenReturn(project);

	        ProjectEntity createdProject = projectService.createProject(project);
	        assertNotNull(createdProject);
	        assertEquals(project.getName(), createdProject.getName());
	    }

	    @Test
	    public void testGetProjectById() {
	        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

	        Optional<ProjectEntity> foundProject = projectService.getProjectById(1L);
	        assertTrue(foundProject.isPresent());
	        assertEquals(project.getName(), foundProject.get().getName());
	    }

	    @Test
	    public void testUpdateProject() {
	        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
	        when(projectRepository.save(any(ProjectEntity.class))).thenReturn(project);

	        ProjectEntity updatedProject = projectService.updateProject(1L, project);
	        assertNotNull(updatedProject);
	        assertEquals(project.getName(), updatedProject.getName());
	    }

	    @Test
	    public void testDeleteProject() {
	        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
	        doNothing().when(projectRepository).delete(project);

	        projectService.deleteProject(1L);
	        verify(projectRepository, times(1)).delete(project);
	        
	    }
	    
	}

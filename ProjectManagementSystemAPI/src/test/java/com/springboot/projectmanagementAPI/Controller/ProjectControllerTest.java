package com.springboot.projectmanagementAPI.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.projectmanagementAPI.Repository.ProjectRepository;
import com.springboot.projectmanagementAPI.model.ProjectEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @Autowired
	    private ProjectRepository projectRepository;

	    @Autowired
	    private ObjectMapper objectMapper;

	    @Test
	    public void testCreateProject() throws Exception {
	    	ProjectEntity project = new ProjectEntity();
	        project.setName("Integration Test Project");
	        project.setDescription("Integration Test Description");
	        project.setStartDate(LocalDate.now());

	        mockMvc.perform(post("/api/projects")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(project)))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.name").value("Integration Test Project"));
	    }

	    @Test
	    public void testGetAllProjects() throws Exception {
	        mockMvc.perform(get("/api/projects"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
	    }

	    @Test
	    public void testGetProjectById() throws Exception {
	    	ProjectEntity project = new ProjectEntity();
	        project.setName("Integration Test Project");
	        project.setDescription("Integration Test Description");
	        project.setStartDate(LocalDate.now());
	        projectRepository.save(project);

	        mockMvc.perform(get("/api/projects/" + project.getId()))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.name").value("Integration Test Project"));
	    }

	    @Test
	    public void testUpdateProject() throws Exception {
	    	ProjectEntity project = new ProjectEntity();
	        project.setName("Integration Test Project");
	        project.setDescription("Integration Test Description");
	        project.setStartDate(LocalDate.now());
	        projectRepository.save(project);

	        project.setName("Updated Integration Test Project");

	        mockMvc.perform(put("/api/projects/" + project.getId())
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(project)))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.name").value("Updated Integration Test Project"));
	    }

	    @Test
	    public void testDeleteProject() throws Exception {
	    	ProjectEntity project = new ProjectEntity();
	        project.setName("Integration Test Project");
	        project.setDescription("Integration Test Description");
	        project.setStartDate(LocalDate.now());
	        projectRepository.save(project);

	        mockMvc.perform(delete("/api/projects/" + project.getId()))
	                .andExpect(status().isNoContent());
	        
	    }
	    
	}

package com.springboot.projectmanagementAPI.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class ProjectEntity {	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    @Size(max = 100)
	    private String name;

	    @Size(max = 250)
	    private String description;

	    private LocalDate startDate;
	    private LocalDate endDate;
	    
		public ProjectEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ProjectEntity(Long id, @NotBlank @Size(max = 100) String name, @Size(max = 250) String description,
				LocalDate startDate, LocalDate endDate) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		
		
		@Override
		public String toString() {
			return "Project [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
					+ ", endDate=" + endDate + "]";
		}   	    
	    	    
	}

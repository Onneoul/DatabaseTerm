package com.teammate.find.Project;

import java.util.List;

public class Projects {
	private List<Project> projects;
	
	public Projects () {
		
	}
	
	public Projects (List<Project> projects) {
		super();
		this.projects = projects;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}

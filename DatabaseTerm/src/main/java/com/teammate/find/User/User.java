package com.teammate.find.User;

import java.util.List;

import com.teammate.find.Project.Project;
import com.teammate.find.User.UserTech;

public class User {
	private int code;
	private String id;
	private String password;
	private String email;
	private String name;
	private String githubLink;
	private int level;
	
	private List<Project> projects;
	private List<UserTech> userTechs;
	
	public User() {
		
	}
	
	public User(int code, String id, String password, String email, String name, String githubLink, int level, List<Project> projects, List<UserTech> userTechs) {
		super();
		this.code = code;
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.githubLink = githubLink;
		this.level = level;
		this.projects = projects;
		this.userTechs = userTechs;
	}

	public int getCode() {
		return code;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getGithubLink() {
		return githubLink;
	}
	public int getLevel() {
		return level;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public List<UserTech> getUserTechs() {
		return userTechs;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void seteMail(String eMail) {
		this.email = eMail;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public void setUserTechs(List<UserTech> userTechs) {
		this.userTechs = userTechs;
	}
	
}

package com.teammate.find.User;

public class User {
	private int code;
	private String id;
	private String password;
	private String email;
	private String name;
	private String githubLink;
	
	public User() {
		
	}
	
	public User(int code, String id, String password, String eMail, String name, String githubLink) {
		super();
		this.code = code;
		this.id = id;
		this.password = password;
		this.email = eMail;
		this.name = name;
		this.githubLink = githubLink;
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
	public String geteMail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getGithubLink() {
		return githubLink;
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
}

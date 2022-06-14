package com.teammate.find.Project;

public class PromoteProject {
	private int code;
	private String id;
	private String name;
	
	public PromoteProject () {
		
	}
	
	public PromoteProject(int code, String id, String name) {
		super();
		this.code = code;
		this.id = id;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}

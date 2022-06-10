package com.teammate.find.User;

public class UserTech {
	private int userCode;
	private String techName;
	private int techCode;
	private int level;
	
	public UserTech() {
		
	}
	
	public UserTech(int userCode, String techName, int techCode, int level) {
		super();
		this.userCode = userCode;
		this.techName = techName;
		this.techCode = techCode;
		this.level = level;
	}
	
	public int getUserCode() {
		return userCode;
	}
	public int getTechCode() {
		return techCode;
	}
	public String getTechName() {
		return techName;
	}
	public int getLevel() {
		return level;
	}
	
	
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public void setTechCode(int techCode) {
		this.techCode = techCode;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}

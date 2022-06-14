package com.teammate.find.Project;

public class Offer {
	private int number;
	private int projectCode;
	private String userName;
	private int userCode;
	private String comment;
	
	public Offer() {
		
	}
	
	public Offer(int number, int projectCode, String userName, int userCode, String comment) {
		super();
		this.number = number;
		this.projectCode = projectCode;
		this.userName = userName;
		this.userCode = userCode;
		this.comment = comment;
	}
	
	public int getNumber() {
		return number;
	}
	public int getProjectCode() {
		return projectCode;
	}
	public String getUserName() {
		return userName;
	}
	public int getUserCode() {
		return userCode;
	}
	public String getComment() {
		return comment;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

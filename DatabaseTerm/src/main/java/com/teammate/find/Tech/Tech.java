package com.teammate.find.Tech;

public class Tech {
	private int techCode;
	private String techName; 
	
	public Tech () {
		
	}
	
	public Tech (int techCode, String techName) {
		super();
		this.techCode = techCode;
		this.techName = techName;
	}
	 
	public int getTechCode() {return techCode;}
	public String getTechName() {return techName;}
	
	public void setTechCode(int techCode) {this.techCode = techCode;}
	public void setTechName(String techName) {this.techName = techName;}
}

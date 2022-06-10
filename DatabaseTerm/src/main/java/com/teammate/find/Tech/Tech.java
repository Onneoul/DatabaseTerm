package com.teammate.find.Tech;

import org.springframework.stereotype.Repository;

@Repository
public class Tech {
	private int code;
	private String techName;
	
	public Tech () {
		
	}
	
	public Tech (int techCode, String techName) {
		super();
		this.code = techCode;
		this.techName = techName;
	}
	 
	public int getTechCode() {return code;}
	public String getTechName() {return techName;}
	
	public void setTechCode(int techCode) {this.code = techCode;}
	public void setTechName(String techName) {this.techName = techName;}
}

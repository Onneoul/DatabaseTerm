package com.teammate.find.User;

import java.util.List;

public class Users {
	private List<User> user;
	
	public Users() {
		
	}
	
	public Users(List<User> user) {
		super();
		this.user = user;
	} 
	
	public List<User> getUser() {
		return user;
	}
	
	public void setUser(List<User> user) {
		this.user = user;
	}
	

	// 사용자 지정 서식으로 getUsers 를 
	// public void getUsers() {
	//		return a;
	//} 로 설정, 
	
}

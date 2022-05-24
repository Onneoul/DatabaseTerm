package com.teammate.find.User;

public class User {
	private String userId;
	private String userPw;
	private String userName;
	private String githubId;
	private String eMail;
	
	public User() {
		
	}
	
	public User(String userId, String userPw, String userName, String githubId, String eMail) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.githubId = githubId;
		this.eMail = eMail;
	}
	
	public String getuserId () {return userId; }
	public String getuserPw () {return userPw; }
	public String getuserName () {return userName; }
	public String getgithubId () {return githubId; }
	public String geteMail () {return eMail; }
	
	public void setuserId (String userId) {this.userId = userId; }
	public void setuserPw (String userPw) {this.userPw = userPw; }
	public void setuserName (String userName) {this.userName = userName; }
	public void setgithubId (String githubId) {this.githubId = githubId; }
	public void seteMail (String eMail) {this.eMail = eMail; }
}

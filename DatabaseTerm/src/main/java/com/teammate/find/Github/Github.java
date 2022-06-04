package com.teammate.find.Github;

import org.springframework.stereotype.Repository;

@Repository
public class Github {
	private String client_id = "9560c4b82e839019b0eb";
	private String client_secret = "209cc5d84fb3f533d51a59682223c72769381761";
	private String code;
	
	public Github() {
		
	}
	
	public Github(String code, String client_id, String client_secret) {
		super();
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.code = code;
	}
	
	public String getClient_id() {return client_id; }
	public String getClient_secret() {return client_secret;	}
	public String getCode() {return code; }
	
	public void setCode(String code) {this.code = code; }
	
}
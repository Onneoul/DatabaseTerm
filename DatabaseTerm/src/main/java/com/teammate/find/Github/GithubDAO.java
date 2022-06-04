package com.teammate.find.Github;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private Github g;
	
	public String getGitAccessToken(String code, HttpServletRequest req, HttpServletResponse res) {
		String Client_id = g.getClient_id();
		String Client_secret = g.getClient_secret();
		
		
		System.out.println("https://github.com/login/oauth/access_token?client_id="+Client_id+"&client_secret="+Client_secret+"&code="+code);
		
		String accessToken = "Temporary";
		res.setHeader("token", accessToken);
		
		
		return "id";
	}
}

package com.teammate.find.Github;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import com.teammate.find.User.UserDAO;

@Controller
public class GithubController {

	@Autowired
	private GithubDAO gDAO;
	
	@Autowired
	private UserDAO uDAO;
	
	
	
	@RequestMapping(value = "/github", method = RequestMethod.GET)
	public String gitHubLogin(HttpServletRequest req, HttpServletResponse res) throws RestClientException, URISyntaxException {
		
		uDAO.loginCheck(req, res);
		
		gDAO.getUser(gDAO.getGitAccessToken(req, res), req, res);
		
		uDAO.userJoinCheck(req, res);
		String joinStatus = (String) req.getAttribute("joinStatus");
		
		if (joinStatus.equals("false")) {
			req.setAttribute("content", "./user/join.jsp"); // 비 회원가입일 시 회원가입창 반환
		} else if (joinStatus.equals("true")) {

			req.setAttribute("content", "home.jsp");
		} else {
			req.setAttribute("content", "home.jsp");
			req.setAttribute("result", "Error"); // 만약 둘다 아닐시 (오류상황시)
		}
		
		return "index";
	}
	
	
	@RequestMapping(value = " ", method = RequestMethod.GET)
	public String getAccessToken (HttpServletRequest req, HttpServletResponse res) {
	
		
		req.setAttribute("content", " .jsp");
		return "index";
	}
	
//	
//	    url = "https://github.com/login/oauth/access_token";
//	    fetch("https://github.com/login/oauth/access_token", {
//	        method: "POST",
//
//	            "client_id": "9560c4b82e839019b0eb",
//	            "client_secret": "209cc5d84fb3f533d51a59682223c72769381761",
//	            "code": token
//
//
//	    url = "https://github.com/login/oauth/access_token";
//	    "https://api.github.com/user";
//	    method: "GET";
//	        
//	            "Authorization": "token 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"

	
}

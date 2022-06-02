package com.teammate.find.User;


import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO uDAO;
	
	@RequestMapping(value="user.profile.view", method=RequestMethod.POST)
	public String projectView(User u, HttpServletRequest req, HttpServletResponse res) {
		uDAO.viewProfile(u, req, res);
		req.setAttribute("content", "/user/profile.jsp");
		req.setAttribute("userCode", u.getUserCode());
		return "index";
	}
	
	@RequestMapping(value = "user.login.go", method = RequestMethod.POST)
	public String userLoginGo(User u, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		req.setAttribute("content", "/user/login.jsp");
		return "index";
	}
	
	@RequestMapping(value = "user.login", method = RequestMethod.POST)
	public String userLogin(User u, HttpServletRequest req, HttpServletResponse res) {
		uDAO.login(u, req, res);
		uDAO.loginCheck(req, res);
		req.setAttribute("content", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/github", method = RequestMethod.GET)
	public String gitHubLogin(HttpServletRequest req, HttpServletResponse res) {
		
		req.setAttribute("content", "/user/githubLoginTest.jsp");
		return "index";
	}
	
	@RequestMapping(value = "user.join.go", method = RequestMethod.POST)
	public String toUserJoin(User u, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		uDAO.join(u, req, res);
		req.setAttribute("content", "/user/join.jsp");
		return "index";
	}
	
	@RequestMapping(value = "user.logout", method = RequestMethod.GET)
	public String userLogout(HttpServletRequest req, HttpServletResponse res) {
		if (uDAO.loginCheck(req, res)) {
			uDAO.logout(req, res);
			req.setAttribute("content", "home.jsp");
		}
		return "index";
	}
	
}

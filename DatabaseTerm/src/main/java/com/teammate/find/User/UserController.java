package com.teammate.find.User;


import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teammate.find.Github.GithubDAO;

@Controller
public class UserController {
	
	@Autowired
	private GithubDAO gDAO;
	
	@Autowired
	private UserDAO uDAO;
	
	@RequestMapping(value="user.detail.view", method=RequestMethod.GET)
	public String projectView(User u, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		u.setCode(Integer.parseInt(req.getParameter("userCode")));
		uDAO.viewProfile(u, req, res);
		
		req.setAttribute("content", "./user/profile.jsp");
		return "index";
	}
	
	@RequestMapping(value = "user.login.go", method = RequestMethod.POST)
	public String userLoginGo(User u, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		req.getSession().setAttribute("sessionTest", "TestValue");
		req.setAttribute("content", "./user/login.jsp");
		return "index";
	}
	@RequestMapping(value = "user.login", method = RequestMethod.POST)
	public String userLogin(User u, HttpServletRequest req, HttpServletResponse res) {
		uDAO.login(u, req, res);
		uDAO.loginCheck(req, res);
		
		req.setAttribute("content", "home.jsp");
		
		return "index";
	}
	@RequestMapping(value = "user.logout", method = RequestMethod.GET)
	public String userLogout(HttpServletRequest req, HttpServletResponse res) {
		if (uDAO.loginCheck(req, res)) {
			uDAO.logout(req, res);
			req.setAttribute("loginPage", "./user/login.jsp");
		}
		req.setAttribute("content", "home.jsp");
		return "index";
	}

	
	@RequestMapping(value = "user.join.go", method = RequestMethod.GET)
	public String toUserJoin(User u, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		gDAO.getUser(gDAO.getGitAccessToken(req, res), req, res);
		req.setAttribute("content", "./user/join.jsp");
		return "index";
	}
	@RequestMapping(value = "user.join", method = RequestMethod.POST)
	public String userJoin(User u, HttpServletRequest req, HttpServletResponse res) {
		
		uDAO.join(u, req, res);
		uDAO.loginCheck(req, res);
		req.setAttribute("content", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "toUserUpdate", method = RequestMethod.GET)
	public String toUserUpdate (HttpServletRequest req, HttpServletResponse res) {

		req.setAttribute("content", " .jsp");
		return "index";
	}
	
	
}

package com.teammate.find.Github;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GithubController {

	@Autowired
		private GithubDAO gDAO;
	
	@RequestMapping(value = "/github", method = RequestMethod.GET)
	public String gitHubLogin(HttpServletRequest req, HttpServletResponse res) {
		
		String code = req.getParameter("code");
		System.out.println(code);
		
		req.setAttribute("code", code);
		
		req.setAttribute("content", "./user/githubLoginTest.jsp");
		return "index";
	}
	
}

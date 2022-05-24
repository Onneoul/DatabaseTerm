package com.teammate.find.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value="user.profile.view", method=RequestMethod.GET)
	public String projectView(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("content", "/user/profile.jsp");
		return "index";
	}
	
}

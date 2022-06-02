package com.teammate.find;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teammate.find.User.UserDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserDAO uDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse res) {
		if (uDAO.loginCheck(req, res)) {
			req.setAttribute("loginCheck", "./user/loginSuccess.jsp");
		} else {
			req.setAttribute("loginCheck", "./user/login.jsp");
		}
		req.setAttribute("content", "home.jsp");
		
		return "index";
	}
	

	
	public String indexDo(HttpServletRequest req, HttpServletResponse res) {
		return home(req,res);
	}
	
}

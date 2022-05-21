package com.teammate.find.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {
	
	@RequestMapping(value="project.select", method=RequestMethod.GET)
	public String projectView(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("content", "/project/select.jsp");
		return "index";
	}
}

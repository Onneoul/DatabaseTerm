package com.teammate.find.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
	
	@RequestMapping(value="project.select", method=RequestMethod.GET)
	public String projectView(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("content", "/project/select.jsp");
		return "index";
	}
	
	@RequestMapping(value = "project.insert", method = RequestMethod.POST)
	public String projectInsert(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("content", "/project/insert.jsp");
		return "index";
	}
	
	
//	@RequestMapping(value = "project. ", method = RequestMethod.GET) - 특정 프로젝트 선택시 보이는 화면
//	public String requestMethodName(HttpServletRequest req, HttpServletResponse res) {
//		req.setAttribute("content", SomeData);
//		return "index";
//	}

}

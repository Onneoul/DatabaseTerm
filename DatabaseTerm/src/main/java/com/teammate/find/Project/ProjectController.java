package com.teammate.find.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teammate.find.User.UserDAO;

@Controller
public class ProjectController {
	
	@Autowired
	private UserDAO uDAO;
	
	@Autowired
	private ProjectDAO pDAO;
	
	@RequestMapping(value="project.view", method=RequestMethod.GET)
	public String projectView(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		req.setAttribute("content", "./project/projectList.jsp");
		return "index";
	}
	@RequestMapping(value = "project.detail", method = RequestMethod.GET)
	public String projectDetailView(Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		
		pDAO.viewProjectDetail(p, req, res);
		
		req.setAttribute("detailBody", "./project/content/projectDetail.jsp");
		req.setAttribute("content", "./project/projectHeader.jsp");
		return "index";
	}
	@RequestMapping(value = "project.todo", method = RequestMethod.GET)
	public String projectTodoView(Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		req.setAttribute("detailBody", "./project/content/todoList.jsp");
		req.setAttribute("content", "./project/projectHeader.jsp");
		return "index";
	}
	@RequestMapping(value = "project.readme", method = RequestMethod.GET)
	public String projectReadMe(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		req.setAttribute("detailBody", "");
		req.setAttribute("content", "./project/projectHeader.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "to.project.create", method = RequestMethod.GET)
	public String toCreateProject(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		req.setAttribute("content", "./project/projectCreate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "project.create", method = RequestMethod.POST)
	public String createProject(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		req.setAttribute("content", "./project/projectCreate.jsp");
		return "index";
	}

	@RequestMapping(value = "to.project.update", method = RequestMethod.GET)
	public String toUpdateProject(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		req.setAttribute("content", "./project/projectUpdate.jsp");
		return "index";
	}
	@RequestMapping(value = "project.update", method = RequestMethod.POST)
	public String updateProject(Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		req.setAttribute("content", "./project/projectDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "project.delete", method = RequestMethod.GET)
	public String deleteProject(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		req.setAttribute("content", "./project/projectList.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "project.feedback", method = RequestMethod.GET)
	public String feedbackProject(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		req.setAttribute("content", "./project/projectDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "project.join.request", method = RequestMethod.GET)
	public String projectJoinRequest(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		req.setAttribute("content", "./project/projectDetail.jsp");
		return "index";
	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String projectJoinAccept(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		req.setAttribute("content", ".jsp");
		return "index";
	}
}

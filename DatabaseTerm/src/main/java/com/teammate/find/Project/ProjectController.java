package com.teammate.find.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teammate.find.Site.SiteOption;
import com.teammate.find.User.UserDAO;

@Controller
public class ProjectController {
	
	@Autowired
	private UserDAO uDAO;
	
	@Autowired
	private ProjectDAO pDAO;
	
	
	// Project View 파트
	@RequestMapping(value="project.list", method=RequestMethod.GET)
	public String projectView(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		SiteOption.clearSearch(req, res);
		SiteOption.clearSearchDate(req, res);
		pDAO.viewProject(1, req, res);
		
		req.setAttribute("content", "./project/projectList.jsp");
		return "index";
	}
	@RequestMapping(value = "project.page.change", method = RequestMethod.GET)
	public String projectPageChange(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		req.setAttribute("content", " .jsp");
		return "index";
	}
	@RequestMapping(value = "project.detail", method = RequestMethod.GET)
	public String projectDetailView(Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		p.setCode(Integer.parseInt(req.getParameter("projectCode")));
		pDAO.viewProjectDetail(p, req, res);
		
		req.setAttribute("detailBody", "./content/projectDetail.jsp");
		req.setAttribute("content", "./project/projectHeader.jsp");
		
		return "index";
	}
	
	
	// Project Detail의 세부 파트
	@RequestMapping(value = "project.todo", method = RequestMethod.GET)
	public String projectTodoView(Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		req.setAttribute("detailBody", "./content/todoList.jsp");
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
	
	
	// Project Join 파트
	@RequestMapping(value = "project.join", method = RequestMethod.GET)
	public String projectJoin (Offer o, Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		
		p.setCode(Integer.parseInt(req.getParameter("projectCode")));
		pDAO.joinTeam(o, req, res);
		pDAO.viewProjectDetail(p, req, res);
		
		req.setAttribute("detailBody", "./content/projectDetail.jsp");
		req.setAttribute("content", "./project/projectHeader.jsp");
		return "index";
	}
	@RequestMapping(value = "project.join.accept", method = RequestMethod.GET)
	public String joinAccept(Offer o, Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		p.setCode(Integer.parseInt(req.getParameter("projectCode")));
		
		o.setNumber(Integer.parseInt(req.getParameter("offerNumber")));
		o.setProjectCode(Integer.parseInt(req.getParameter("projectCode")));
		o.setUserCode(Integer.parseInt(req.getParameter("userCode")));
		System.out.println(o.getProjectCode());
		System.out.println(o.getUserCode());
		
		pDAO.acceptTeam(o, req, res);
		pDAO.viewProjectDetail(p, req, res);
		
		req.setAttribute("detailBody", "./content/projectDetail.jsp");
		req.setAttribute("content", "./project/projectHeader.jsp");
		return "index";
	}
	@RequestMapping(value = "project.join.denied", method = RequestMethod.GET)
	public String joinDenied(Offer o, Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		p.setCode(Integer.parseInt(req.getParameter("projectCode")));
		
		o.setNumber(Integer.parseInt(req.getParameter("offerNumber")));
		o.setProjectCode(Integer.parseInt(req.getParameter("projectCode")));
		o.setUserCode(Integer.parseInt(req.getParameter("userCode")));
		
		pDAO.deniedTeam(o, req, res);
		pDAO.viewProjectDetail(p, req, res);
		
		req.setAttribute("detailBody", "./content/projectDetail.jsp");
		req.setAttribute("content", "./project/projectHeader.jsp");
		return "index";
	}
	
	
	// Project CUD 파트
	@RequestMapping(value = "to.project.create", method = RequestMethod.GET)
	public String toCreateProject(HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		req.setAttribute("content", "./project/projectCreate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "project.create", method = RequestMethod.POST)
	public String createProject(Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		pDAO.createProject(p, req, res);
		req.setAttribute("content", "./project/content/projectDetail.jsp");
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

		pDAO.updateProject(p, req, res);
		req.setAttribute("content", "./project/content/projectDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "project.delete", method = RequestMethod.GET)
	public String deleteProject(Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		p.setCode(Integer.parseInt(req.getParameter("projectCode")));
		pDAO.deleteProject(p, req, res);
		pDAO.viewProject(1, req, res);
		req.setAttribute("content", "./project/projectList.jsp");
		return "index";
	}
	
	
	// FeedBack 파트
	@RequestMapping(value = "project.feedback.create", method = RequestMethod.POST)
	public String feedbackCreate(FeedBack f, Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		pDAO.createFeedBack(f, req, res);
		
		p.setCode(Integer.parseInt(req.getParameter("projectCode")));
		pDAO.viewProjectDetail(p, req, res);
		req.setAttribute("detailBody", "./content/projectDetail.jsp");
		req.setAttribute("content", "./project/projectHeader.jsp");
		return "index";
	}
	@RequestMapping(value = "project.feedback.delete", method = RequestMethod.GET)
	public String feedbackDelete(FeedBack f, Project p, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		f.setFeedBackCode(Integer.parseInt(req.getParameter("feedBackCode")));
		pDAO.deleteFeedBack(f, req, res);
		
		p.setCode(Integer.parseInt(req.getParameter("projectCode")));
		pDAO.viewProjectDetail(p, req, res);
		req.setAttribute("detailBody", "./content/projectDetail.jsp");
		req.setAttribute("content", "./project/projectHeader.jsp");
		return "index";
	}
}

package com.teammate.find.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teammate.find.TokenMaker;
import com.teammate.find.Site.SiteOption;
import com.teammate.find.User.UserDAO;

@Controller
public class QuestionController {
	
	@Autowired
	private UserDAO uDAO;
	
	@Autowired
	private QuestionDAO qDAO;
	
	@RequestMapping(value = "to.question.create", method = RequestMethod.GET)
	public String toQuestionCreate (HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		TokenMaker.make(req, res);
		
		req.setAttribute("content", "./question/questionCreate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "question.create", method = RequestMethod.POST)
	public String createQuestion (Question q, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		qDAO.createQuestion(q, req, res);
		qDAO.viewQuestion(1, req, res);
		
		req.setAttribute("content", "./question/questionList.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "question.list", method = RequestMethod.GET)
	public String toQuestionList (HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		SiteOption.clearSearch(req, res);
		SiteOption.clearSearchDate(req, res);
		qDAO.viewQuestion(1, req, res);
		
		req.setAttribute("content", "./question/questionList.jsp");
		return "index";
	}
	
	@RequestMapping(value = "question.page.change", method = RequestMethod.GET)
	public String questionPageChange(HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		uDAO.loginCheck(req, res);
		
		int page = Integer.parseInt(req.getParameter("page"));
		qDAO.viewQuestion(page, req, res);
		
		req.setAttribute("content", "./question/questionList.jsp");
		return "index";
	}
	
	@RequestMapping(value = "question.detail", method = RequestMethod.GET)
	public String viewQuestionDetail (Question q, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		q.setCode(Integer.parseInt(req.getParameter("questionCode")));
		qDAO.viewQuestionDetail(q, req, res);
		
		String tag = req.getParameter("tags");
		
		req.setAttribute("content", "./question/questionDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "to.question.update", method = RequestMethod.GET)
	public String toQuestionUpdate (Question q, HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		uDAO.loginCheck(req, res);
		
		q.setCode(Integer.parseInt(req.getParameter("questionCode")));
		qDAO.viewQuestionDetail(q, req, res);
		
		req.setAttribute("content", "./question/questionUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "question.update", method = RequestMethod.POST)
	public String updateQuestion (Question q, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		qDAO.updateQuestion(q, req, res);
		
		qDAO.viewQuestionDetail(q, req, res);
		req.setAttribute("content", "./question/questionDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "question.delete", method = RequestMethod.GET)
	public String deleteQuestion (Question q, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);

		q.setCode(Integer.parseInt(req.getParameter("questionCode")));
		qDAO.deleteQuestion(q, req, res);
		
		qDAO.viewQuestion(1, req, res);
		req.setAttribute("content", "./question/questionList.jsp");
		return "index";
	}
	
	// Answer 파트
	@RequestMapping(value = "answer.create", method = RequestMethod.GET)
	public String createAnswer(Answer a, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		Question q = new Question();
		q.setCode(a.getQuestionCode());
		
		qDAO.createAnswer(a, req, res);
		
		qDAO.viewQuestionDetail(q, req, res);
		req.setAttribute("content", "./question/questionDetail.jsp");
		return "index";
	}
	@RequestMapping(value = "answer.delete", method = RequestMethod.GET)
	public String deleteAnswer(Answer a, HttpServletRequest req, HttpServletResponse res) {
		uDAO.loginCheck(req, res);
		
		Question q = new Question();
		q.setCode(Integer.parseInt(req.getParameter("questionCode")));
		
		a.setcode(Integer.parseInt(req.getParameter("answerCode")));
		qDAO.deleteAnswer(a, req, res);

		qDAO.viewQuestionDetail(q, req, res);
		req.setAttribute("content", "./question/questionDetail.jsp");
		return "index";
	}
}

package com.teammate.find.Event;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.ognl.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teammate.find.TokenMaker;
import com.teammate.find.Site.SiteOption;
import com.teammate.find.User.UserDAO;

@Controller
public class EventController {
	
	@Autowired
	private EventDAO eDAO;
	
	@Autowired
	private UserDAO uDAO;
	
	// Create Part
	@RequestMapping(value = "teammate.toEventCreate", method = RequestMethod.GET)
	public String toEventCreate(Event e, HttpServletRequest req, HttpServletResponse res) {
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(d);
		req.setAttribute("now", now);
		
		req.setAttribute("content", "./event/eventCreate.jsp");
		return "index";
	}
	@RequestMapping(value = "event.create", method = RequestMethod.POST)
	public String eventCreate(Event e, HttpServletRequest req, HttpServletResponse res) {
	
		TokenMaker.make(req, res);
//		uDAO.loginCheck(req, res);
		eDAO.createEvent(e, req, res);
		eDAO.viewEvent(1, req, res);
		req.setAttribute("content", "./event/eventList.jsp");
		return "index";
	}
	
	
	// Select Part
	@RequestMapping(value = "teammate.eventList", method = RequestMethod.GET)
	public String eventList(HttpServletRequest req, HttpServletResponse res) {
		
//		uDAO.loginCheck(req, res);
		SiteOption.clearSearch(req, res);
		SiteOption.clearSearchDate(req, res);
		eDAO.viewEvent(1, req, res);
		
		req.setAttribute("content", "./event/eventList.jsp");
		return "index";
	}
	@RequestMapping(value = "teammate.eventDetail", method = RequestMethod.GET)
	public String viewEventDetail (HttpServletRequest req, HttpServletResponse res) {
		
		int eventCode = Integer.parseInt(req.getParameter("eventCode"));
		eDAO.viewEventDetail(eventCode, req, res);
		
		req.setAttribute("content", "./event/eventDetail.jsp");
		return "index";
	}
	@RequestMapping(value = "event.page.change", method = RequestMethod.GET)
	public String eventPageChange(HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		int page = Integer.parseInt(req.getParameter("page"));
//		uDAO.loginCheck(req, res);
		eDAO.viewEvent(page, req, res);
		
		req.setAttribute("content", "./event/eventList.jsp");
		return "index";
	}
	
	
	// Update Part
	@RequestMapping(value = "teammate.toEventUpdate", method = RequestMethod.GET)
	public String toEventUpdate (Event e, HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
//		if (uDAO.loginCheck(req, res)) {
		int code = Integer.parseInt(req.getParameter("code"));
		eDAO.viewEventDetail(code, req, res);
		
		req.setAttribute("content", "./event/eventUpdate.jsp");
		return "index";
	}
	@RequestMapping(value = "teammate.eventUpdate", method = RequestMethod.POST)
	public String eventUpdate(Event e, HttpServletRequest req, HttpServletResponse res) {
	
		eDAO.updateEvent(e, req, res);
		eDAO.viewEventDetail(e.getCode().intValue(), req, res);
		req.setAttribute("content", "./event/eventDetail.jsp");
		return "index";
	}
	
	// Delete Part
	@RequestMapping(value = "teammate.eventDelete", method = RequestMethod.GET)
	public String eventDelete(Event e, HttpServletRequest req, HttpServletResponse res) {
		int code = Integer.parseInt(req.getParameter("code"));
		e.setCode(new BigDecimal(code));
		eDAO.deleteEvent(e, req, res);
		
		eDAO.viewEvent(1, req, res);
		req.setAttribute("content", "./event/eventList.jsp");
		return "index";
	}
}

package com.teammate.find.Site.Event;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teammate.find.User.UserDAO;

@Controller
public class EventController {
	
	@Autowired
	private EventDAO eDAO;
	
	@Autowired
	private UserDAO uDAO;
	
	@RequestMapping(value = "to event.create", method = RequestMethod.GET)
	public String toEventCreate(Event e, HttpServletRequest req, HttpServletResponse res) {
		int memberLevel = (e, req, res);
		req.setAttribute("content", "eventView.jsp");
		return "index";
	}
	
	@RequestMapping(value = "event.create", method = RequestMethod.GET)
	public String eventCreate(Event e, HttpServletRequest req, HttpServletResponse res) {
		eDAO.createEvent(e, req, res);
		req.setAttribute("content", "eventView.jsp");
		return "index";
	}
}

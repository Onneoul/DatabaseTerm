package com.teammate.find.Event;

import java.io.FileOutputStream;
import java.io.IOException;

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
		
		req.setAttribute("content", "/event/eventInsert.jsp");
		return "index";
	}
	
//	@RequestMapping(value = "event.create", method = RequestMethod.GET)
//	public String eventCreate(Event e, HttpServletRequest req, HttpServletResponse res) {
//		eDAO.createEvent(e, req, res);
//		req.setAttribute("content", "eventView.jsp");
//		return "index";
//	}
	
	@RequestMapping(value = "teammate/eventList", method = RequestMethod.GET)
	public String eventList(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String uri = req.getRequestURI();
		
		FileOutputStream output = new FileOutputStream("d:/result.txt");
            output.write(uri.getBytes());
        output.close();
		
		req.setAttribute("content", "/event/eventList.jsp");
		return "index";
	}
}
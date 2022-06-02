package com.teammate.find.Event;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Service
public class EventDAO {

	@Autowired
	SqlSession ss;
	
//	public void createEvent(Event e, HttpServletRequest req, HttpServletResponse res) {
//		String path = req.getSession().getServletContext().getRealPath("resources/img");
//		MultipartRequest mr = null;
//		
//		try {
//			mr = new MultipartRequest(req, path, 10*1024*1024, "utf-8", new ) { };
//			
//		} catch (Exception err) {
//			err.printStackTrace();
//			req.setAttribute("result", "등록 오류");
//			return;
//		}
//		
//	}
	
	public void editEvent() {
		
	}
	
	public void deleteEvent() {
		
	}
	
	public void viewEvent(int eventCode) {
		
	}
}

package com.teammate.find.Event;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.teammate.find.Site.SiteOption;

@Service
public class EventDAO {
	private int allEventCount;
	
	public int getAllEventCount() {return allEventCount; }
	public void setAllEventCount(int allEventCount) {this.allEventCount = allEventCount; }
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;
	
	public void countEvents() {
		EventSelector eS = new EventSelector("", null, null, null, null);
		allEventCount = ss.getMapper(EventMapper.class).getEventCount(eS);
	}
	
	public void createEvent(Event e, HttpServletRequest req, HttpServletResponse res) {

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(d);
		
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			
			if (successToken != null && token.equals(successToken)) {
				return;
			}
			
			String eventContent = (String) req.getParameter("content");
			eventContent.replace("\r\n", "<br>");
			e.setContent(eventContent); 
			e.setLink( (String) req.getParameter("link"));
			// title, content, link set
			
			e.setStartDate(req.getParameter("startDate"));
			if (req.getParameter("endDate") != "") {
				e.setEndDate((String) req.getParameter("endDate")); 
			} else {
				e.setEndDate(null);
			}
			

			
			
			if (ss.getMapper(EventMapper.class).createEvent(e) == 1) {
				req.setAttribute("result", "작성 완료");
				allEventCount++;
				req.getSession().setAttribute("successToken", token);
				System.out.println("작성완료"); // 테스트용
			} else {
				req.setAttribute("result", "작성 실패");
				System.out.println("작성실패"); // 테스트용
			}
			
			
		} catch (Exception err) {
			err.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
		
	}
	
	// Select Part
	public void searchEvent(EventSelector eS, HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("search", eS);
	}
	
	public void viewEvent(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			int count = 10; // 임시로 넣는 값 - 나중에 해결
		
			System.out.println(allEventCount); //테스트
			System.out.println(count); //테스트
			
			int start = (pageNo - 1) * count + 1;
			int end = start + (count - 1);
			
			System.out.println(req.getSession().getAttribute("search")); //테스트용
			EventSelector search = (EventSelector) req.getSession().getAttribute("search");
			
			int eventCount = 0;
			
			if (search == null) {
				search = new EventSelector("", new BigDecimal(start), new BigDecimal(end), null, null);
				eventCount = allEventCount;
			} else {
				search.setStart(new BigDecimal(start));
				search.setEnd(new BigDecimal(end));
				eventCount = ss.getMapper(EventMapper.class).getEventCount(search);
			}
			
			System.out.println("search = " + search.getSearch() + " start = "+ search.getStart() +" end = " + search.getEnd());
			
			
			List<Event> eS = ss.getMapper(EventMapper.class).viewEvent(search);
			
			for (Event event : eS) {
				System.out.println(event.getCode());;
			}
			
			
			req.setAttribute("eS", eS);
			req.setAttribute("curPage", pageNo);
			int pageCount = (int) Math.ceil(eventCount / (double)count);
			req.setAttribute("pageCount", pageCount);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		
	}
	
	public void viewEventDetail(int eventCode, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			Event e = new Event();
			e.setCode(new BigDecimal(eventCode));
			e = ss.getMapper(EventMapper.class).viewEventDetail(e);
			
			req.setAttribute("eventDetail", e);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
// Update Part	

	public void updateEvent(Event e, HttpServletRequest req, HttpServletResponse res) {
			
		try {			
			if (ss.getMapper(EventMapper.class).updateEvent(e) == 1) {
				req.setAttribute("result", "글 수정 성공");
			} else {
				req.setAttribute("result", "글 수정 실패");
			}
		} catch (Exception err) {
			err.printStackTrace();
			req.setAttribute("result", "글 수정 실패");
		}
	}
// Delete Part
	
	public void deleteEvent(Event e, HttpServletRequest req, HttpServletResponse res) {
		
		try {			
			if (ss.getMapper(EventMapper.class).deleteEvent(e) == 1) {
				req.setAttribute("result", "글 삭제 성공");
			} else {
				req.setAttribute("result", "글 삭제 실패");
			}
		} catch (Exception err) {
			err.printStackTrace();
			req.setAttribute("result", "글 삭제 실패");
		}
	}

}

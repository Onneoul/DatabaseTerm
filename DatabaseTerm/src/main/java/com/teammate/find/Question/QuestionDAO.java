package com.teammate.find.Question;

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
public class QuestionDAO {
	private int allQuestionCount;
	
	public int getAllQuestionCount() {return allQuestionCount; }
	public void setAllQuestionCount(int allQuestionCount) {this.allQuestionCount = allQuestionCount; }
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;
	
	public void countQuestions() {
		QuestionSelector eS = new QuestionSelector("", null, null);
		allQuestionCount = ss.getMapper(QuestionMapper.class).getQuestionCount(eS);
		
	}
	
	public void createQuestion(Question e, HttpServletRequest req, HttpServletResponse res) {

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(d);
		
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			
			if (successToken != null && token.equals(successToken)) {
				return;
			}
			
			String QuestionContent = (String) req.getParameter("content");
			QuestionContent.replace("\r\n", "<br>");
			e.setContent(QuestionContent); 
			e.setLink( (String) req.getParameter("link"));
			// title, content, link set
			
			e.setStartDate(req.getParameter("startDate"));
			if (req.getParameter("endDate") != "") {
				e.setEndDate((String) req.getParameter("endDate")); 
			} else {
				e.setEndDate(null);
			}
			
			System.out.println("e.get메소드 출력 "); // 테스트용
			System.out.println(e.getTitle()); // 테스트용
			System.out.println(e.getContent()); // 테스트용
			System.out.println(e.getLink()); // 테스트용
			System.out.println(e.getstartDate()); // 테스트용
			System.out.println(e.getEndDate()); // 테스트용

			
			
			if (ss.getMapper(QuestionMapper.class).createQuestion(e) == 1) {
				req.setAttribute("result", "작성 완료");
				allQuestionCount++;
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
	
	public void updateQuestion(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public void deleteQuestion(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public void viewQuestion(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			int count = so.getCountPerPage();
			
			int start = (pageNo - 1) * count + 1;
			int end = start + (count - 1);
			
			QuestionSelector search = (QuestionSelector) req.getSession().getAttribute("search");
			int QuestionCount = 0;
			
			if (search == null) {
				search = new QuestionSelector("", new BigDecimal(start), new BigDecimal(end));
				QuestionCount = allQuestionCount;
			} else {
				search.setStart(new BigDecimal(start));
				search.setEnd(new BigDecimal(end));
				QuestionCount = ss.getMapper(QuestionMapper.class).getQuestionCount(search);
			}
			
			List<Question> eS = ss.getMapper(QuestionMapper.class).viewQuestion(search);
			
			for (Question Question : eS) {
				
			}
			
		} catch (Exception err) {
			// TODO: handle exception
		}
		
	}
	
	public void viewQuestionDetail(int QuestionCode, HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public void searchQuestion(QuestionSelector eS, HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("search", eS);
	}
}

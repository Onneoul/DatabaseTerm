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

import com.teammate.find.DateCreate;
import com.teammate.find.Event.EventMapper;
import com.teammate.find.Site.SiteOption;
import com.teammate.find.User.User;
import com.teammate.find.User.UserMapper;

@Service
public class QuestionDAO {
	private int allQuestionCount;
	
	public int getAllQuestionCount() {return allQuestionCount; }
	public void setAllQuestionCount(int allQuestionCount) {this.allQuestionCount = allQuestionCount; }
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;
	
	private DateCreate DC;
	
	public void countQuestions() {
		QuestionSelector eS = new QuestionSelector("", null, null);
		allQuestionCount = ss.getMapper(QuestionMapper.class).getQuestionCount(eS);
		
	}
	
	// CreateQuestion 할 때 테크 코드를 받는다. list<Tech>를 받아서 Foreach문을 통해 QuestionTech 테이블에 Insert 하면 될듯?
	public void createQuestion(Question q, HttpServletRequest req, HttpServletResponse res) {

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
			q.setContent(QuestionContent); 
			q.setReportDate(now);
			
			
			System.out.println("e.get메소드 출력 "); // 테스트용
			System.out.println(q.getTitle()); // 테스트용
			System.out.println(q.getContent()); // 테스트용

			
			
			if (ss.getMapper(QuestionMapper.class).createQuestion(q) == 1) {
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
	
	public void updateQuestion(Question q, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String now = sdf.format(d);
			
			q.setReportDate(now);
			if (ss.getMapper(QuestionMapper.class).updateQuestion(q) == 1) {
				req.setAttribute("result", "글 수정 성공");
			} else {
				req.setAttribute("result", "글 수정 실패");
			}
		} catch (Exception err) {
			err.printStackTrace();
			req.setAttribute("result", "글 수정 실패");
		}
		
	}
	
	public void deleteQuestion(Question q, HttpServletRequest req, HttpServletResponse res) {
		
		try {			
			if (ss.getMapper(QuestionMapper.class).deleteQuestion(q) == 1) {
				req.setAttribute("result", "글 삭제 성공");
			} else {
				req.setAttribute("result", "글 삭제 실패");
			}
		} catch (Exception err) {
			err.printStackTrace();
			req.setAttribute("result", "글 삭제 실패");
		}
		
	}
	
	public void viewQuestion(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
//			int count = so.getCountPerPage();
			int count = 10;
			
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
			User u = new User();
			
			List<Question> questionList = ss.getMapper(QuestionMapper.class).viewQuestion(search);
			for (Question question : questionList) {
				u.setCode(question.getWriter());
				question.setWriterName(ss.getMapper(UserMapper.class).getUserNameByCode(u));
			}
			
			System.out.println(questionList);
			
			req.setAttribute("questionList", questionList);
			req.setAttribute("curPage", pageNo);
			int pageCount = (int) Math.ceil(QuestionCount / (double)count);
			req.setAttribute("pageCount", pageCount);
			
//			for (Question Question : eS) {
//				
//			}
			
		} catch (Exception err) {
			// TODO: handle exception
		}
		
	}
	
	public void viewQuestionDetail(Question q, HttpServletRequest req, HttpServletResponse res) {
		try {
			
			q = ss.getMapper(QuestionMapper.class).getQuestionDetail(q);
			q.setQuestionTechs(ss.getMapper(QuestionMapper.class).getQuestionTechs(q));
			
			User u = new User();
			
			q.setAnswers(ss.getMapper(QuestionMapper.class).getQuestionAnswers(q));
			for (Answer answers : q.getAnswers()) {
				u.setCode(answers.getWriter());
				answers.setWriterName(ss.getMapper(UserMapper.class).getUserNameByCode(u));
			}
			
			u.setCode(q.getWriter());
			q.setWriterName(ss.getMapper(UserMapper.class).getUserNameByCode(u));
			req.setAttribute("questionDetail", q);
			
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	public void searchQuestion(QuestionSelector eS, HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("search", eS);
	}
	
	public void createAnswer(Answer a, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String now = sdf.format(d);
			
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			
			if (successToken != null && token.equals(successToken)) {
				return;
			}
			
			String AnswerContent = (String) req.getParameter("content");
			AnswerContent.replace("\r\n", "<br>");
			a.setContent(AnswerContent); 
			a.setWriteDate(now);
			
			
			if (ss.getMapper(QuestionMapper.class).createAnswer(a) == 1) {
				req.setAttribute("result", "답변 작성 완료");
				req.getSession().setAttribute("successToken", token);
				System.out.println("작성완료"); // 테스트용
			} else {
				req.setAttribute("result", "답변 작성 실패");
				System.out.println("작성실패"); // 테스트용
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteAnswer(Answer a, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			if(ss.getMapper(QuestionMapper.class).deleteAnswer(a) == 1) {
				req.setAttribute("result", "글 삭제 성공");
			} else {
				req.setAttribute("result", "글 삭제 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "답변 삭제 실패");
		}
		
	}
}

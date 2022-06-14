package com.teammate.find.Project;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teammate.find.DateCreate;
import com.teammate.find.Question.Question;
import com.teammate.find.Question.QuestionMapper;
import com.teammate.find.Question.QuestionSelector;
import com.teammate.find.User.User;
import com.teammate.find.User.UserDAO;
import com.teammate.find.User.UserMapper;

@Service
public class ProjectDAO {
	
	private int allProjectCount;
	
	public int getAllProjectCount() {return allProjectCount; }
	public void setAllProjectCount(int allProjectCount) {this.allProjectCount = allProjectCount; }
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private UserDAO uDAO;
	
	DateCreate DC;
	
	public void countProjects() {
		ProjectSelector ps = new ProjectSelector("", null, null);
		allProjectCount = ss.getMapper(ProjectMapper.class).getProjectCount(ps);
		
	}
	
	public void createProject(Project p, HttpServletRequest req, HttpServletResponse res) {

		try {
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String now = sdf.format(d);
			
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			
			if (successToken != null && token.equals(successToken)) {
				return;
			}
			
			String projectContent = (String) req.getParameter("content");
			projectContent.replace("\r\n", "<br>");
			p.setContent(projectContent);
			p.setStartDate(now);
			
			if (ss.getMapper(ProjectMapper.class).createProject(p) == 1) {
				Project cL = ss.getMapper(ProjectMapper.class).getProjectCode(p);
				ss.getMapper(ProjectMapper.class).createLeader(cL);
				allProjectCount++;
				req.getSession().setAttribute("successToken", token);
				viewProjectDetail(cL, req, res);
				
				req.setAttribute("result", "작성 완료");
			} else {
				req.setAttribute("result", "작성 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "작성 실패");
		}
		
	}
	
	
	public void viewProject(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		
		try {
//			int count = so.getCountPerPage();
			int count = 10;

			int start = (pageNo - 1) * count + 1;
			int end = start + (count - 1);
			
			ProjectSelector search = (ProjectSelector) req.getSession().getAttribute("search");
			int projectCount = 0;

			if (search == null) {
				search = new ProjectSelector("", new BigDecimal(start), new BigDecimal(end));
				projectCount = allProjectCount;
			} else {
				search.setStart(new BigDecimal(start));
				search.setEnd(new BigDecimal(end));
				projectCount = ss.getMapper(ProjectMapper.class).getProjectCount(search);
			}
			
			System.out.println(search.getSearch());
			List<Project> projectList = ss.getMapper(ProjectMapper.class).viewProject(search);
			
			User u = new User();
			
			for (Project project : projectList) {
				project.setTechs(ss.getMapper(ProjectMapper.class).getProjectTech(project));
				u.setCode(project.getLeader());
				project.setLeaderName(ss.getMapper(UserMapper.class).getUserNameByCode(u));
			}
			
			req.setAttribute("projectList", projectList);
			req.setAttribute("curPage", pageNo);
			int pageCount = (int) Math.ceil(projectCount / (double)count);
			req.setAttribute("pageCount", pageCount);
			
			
			
		} catch (Exception err) {
			// TODO: handle exception
		}
		
	}
	
	public void viewProjectDetail(Project p, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			Project projectDetail = ss.getMapper(ProjectMapper.class).viewProjectDetail(p);
			User u = new User();
			
			projectDetail.setOffers(ss.getMapper(ProjectMapper.class).getProjectOffer(projectDetail));
			for (Offer offers : projectDetail.getOffers()) {
				u.setCode(offers.getUserCode());
				offers.setUserName(ss.getMapper(UserMapper.class).getUserNameByCode(u));
			}
			
			projectDetail.setFeedbacks(ss.getMapper(ProjectMapper.class).getProjectFeedBack(projectDetail));
			for (FeedBack feedbacks : projectDetail.getFeedbacks()) {
				u.setCode(feedbacks.getWriter());
				feedbacks.setWriterName(ss.getMapper(UserMapper.class).getUserNameByCode(u));
			}
			projectDetail.setTechs(ss.getMapper(ProjectMapper.class).getProjectTech(projectDetail));
			projectDetail.setMembers(ss.getMapper(ProjectMapper.class).getProjectMembers(projectDetail));
			
			
			req.setAttribute("projectDetail", projectDetail);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "조회 실패");
		}
	}
	

	public void updateProject(Project p, HttpServletRequest req, HttpServletResponse res) {

		try {
			if (ss.getMapper(ProjectMapper.class).updateProject(p) == 1) {
				viewProjectDetail(p, req, res);
				req.setAttribute("result", "글 수정 성공");
			} else {
				req.setAttribute("result", "글 수정 실패");
			}
		} catch (Exception err) {
			err.printStackTrace();
			req.setAttribute("result", "글 수정 실패");
		}
	}
	
	public void deleteProject(Project p, HttpServletRequest req, HttpServletResponse res) {
		try {			
			if (ss.getMapper(ProjectMapper.class).deleteProject(p) == 1) {
				req.setAttribute("result", "글 삭제 성공");
			} else {
				req.setAttribute("result", "글 삭제 실패");
			}
		} catch (Exception err) {
			err.printStackTrace();
			req.setAttribute("result", "글 삭제 실패");
		}
	}
	
	public void joinTeam(Offer o, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			if(ss.getMapper(ProjectMapper.class).createOffer(o) == 1) {
				req.setAttribute("result", "신청 성공");
			} else {
				req.setAttribute("result", "참가 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "신청 실패");
		}
		
	}
	
	public void acceptTeam(Offer o, HttpServletRequest req, HttpServletResponse res) {
		try {
			
			if(ss.getMapper(ProjectMapper.class).acceptOffer(o) == 1) {
				req.setAttribute("result", "수락 성공");
				ss.getMapper(ProjectMapper.class).deleteOffer(o);
			} else {
				req.setAttribute("result", "수락 실패");
			}
			
		} catch (Exception e) {
			req.setAttribute("result", "요청 실패");
		}
	}
	
	public void deniedTeam(Offer o, HttpServletRequest req, HttpServletResponse res) {
		try {
			
			if(ss.getMapper(ProjectMapper.class).deleteOffer(o) == 1) {
				req.setAttribute("result", "수락 성공");
			} else {
				req.setAttribute("result", "수락 실패");
			}
			
		} catch (Exception e) {
			req.setAttribute("result", "요청 실패");
		}
	}

	public void quitTeam(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	
	//FeedBack Part
	public void createFeedBack(FeedBack f, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String now = sdf.format(d);
			f.setWriteDate(now);
			
			if (ss.getMapper(ProjectMapper.class).createFeedBack(f) == 1) {
				Project p = new Project();
				p.setCode(f.getProjectCode());
				viewProjectDetail(p, req, res);
				req.setAttribute("result", "피드백 작성 성공");
			} else {

				req.setAttribute("result", "피드백 작성 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "피드백 작성 실패");
		}
	}
	public void deleteFeedBack(FeedBack f,HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			if (ss.getMapper(ProjectMapper.class).deleteFeedBack(f) == 1) {
				
				req.setAttribute("result", "피드백 삭제 성공");
				
			} else {

				req.setAttribute("result", "피드백 삭제 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "피드백 삭제 실패");
		}
	}
	
}

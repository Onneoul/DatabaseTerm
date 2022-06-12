package com.teammate.find.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teammate.find.Question.QuestionMapper;
import com.teammate.find.User.User;
import com.teammate.find.User.UserDAO;

@Service
public class ProjectDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private UserDAO uDAO;
	
	public void createProject(Project p, HttpServletRequest req, HttpServletResponse res) {
		// 프로젝트 등록하고 자기 자신을 프로젝트 리더로 등록
	}
	
	
	public void viewProject(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public void viewProjectDetail(Project p, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			Project projectDetail = ss.getMapper(ProjectMapper.class).viewProjectDetail(p);
			
			projectDetail.setFeedbacks(ss.getMapper(ProjectMapper.class).viewProjectFeedBack(projectDetail));
			projectDetail.setTechs(ss.getMapper(ProjectMapper.class).viewProjectTechs(projectDetail));
			
			
			req.setAttribute("projectDetail", projectDetail);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	public void updateProject(Project p, HttpServletRequest req, HttpServletResponse res) {

		try {
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
	
	public void joinTeam(Project p, User u, HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public void acceptTeam(User u, HttpServletRequest req, HttpServletResponse res) {
		
	}

	public void quitTeam(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	
}

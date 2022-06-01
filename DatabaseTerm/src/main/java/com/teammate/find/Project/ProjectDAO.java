package com.teammate.find.Project;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.teammate.find.User.User;
import com.teammate.find.User.UserDAO;

public class ProjectDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private UserDAO uDAO;
	
	public void createProject(Project p) {
		// 프로젝트 등록하고 자기 자신을 프로젝트 리더로 등록
	}
	
	public void editProject(int projectNo) {
		// 프로젝트 내용 수정
	}
	
	public void viewProject() {
		
	}
	
	public void viewProjectDetail(int projectNo) {
		// 클릭시 프로젝트 상세 정보 보이게
	}
	
	public void deleteProject(int projectNo) {
		
	}
	
	public void joinTeam(int projectNo, User u) {
		
	}
	
	public void acceptTeam(User u/*userNo?*/) {
		
	}

	public void quitTeam() {
		
	}
	
	
}

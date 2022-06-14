package com.teammate.find.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.Session;
import com.teammate.find.Github.GithubDAO;
import com.teammate.find.Tech.Tech;

import testPackage.TestMapper;

@Service
public class UserDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private GithubDAO gDAO;
	
	public void join(User u, HttpServletRequest req, HttpServletResponse res) {
		try {
			System.out.println(u.getId());
			System.out.println(u.getName());
			System.out.println(u.getPassword());
			System.out.println(u.getGithubLink());
			System.out.println(u.getEmail()); // 테스트용
			
			if (ss.getMapper(UserMapper.class).joinUser(u) == 1) {
				req.setAttribute("result", "가입 성공");
			} else {
				req.setAttribute("result", "가입 실패");
			}
			
		} catch (Exception err) {
			err.printStackTrace();
			req.setAttribute("result", "가입 실패");
		}
	}
	
	public void userJoinCheck(HttpServletRequest req, HttpServletResponse res) {
		try {
			User u = new User();
			String ID = (String) req.getAttribute("loginGitId");
			
			u.setId(ID);
			User checkUser = ss.getMapper(UserMapper.class).userJoinCheck(u);
			
			if (checkUser == null) {
				System.out.println("비 회원가입 회원");
				req.setAttribute("joinStatus", "false");
			} else {
				System.out.println("이미 회원가입된 회원");
				req.setAttribute("joinStatus", "true");
				login(checkUser, req, res);
				req.setAttribute("loginPage", "./user/loginSuccess.jsp");
			}
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	public boolean loginCheck(HttpServletRequest req, HttpServletResponse res) {
		User u = (User) req.getSession().getAttribute("loginUser");
		if (u != null) {
			req.setAttribute("loginPage", "./user/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "./user/login.jsp");
			return false;
		}
	}
	
	public void login(User u, HttpServletRequest req, HttpServletResponse res) {
		try {
			User loginUser = ss.getMapper(UserMapper.class).userLogin(u);
			if (loginUser != null) {
				if (u.getPassword().equals(loginUser.getPassword())) {
					req.setAttribute("loginUser", loginUser);
					
					req.getSession().setAttribute("loginUser", loginUser);
					
					User test = (User) req.getSession().getAttribute("loginUser");
					
					System.out.println("loginUser's property is " + test.getId() + " code = " + test.getCode());
					
					System.out.println("로그인 성공");
					req.setAttribute("result", "로그인 성공");
				} else {
					req.setAttribute("result", "비밀번호가 다릅니다.");
				}
			} else {
				req.setAttribute("result", "존재하지 않는 아이디입니다.");
			}		
		} catch (Exception err) {
			err.printStackTrace();
			req.setAttribute("result", "로그인 실패");
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("loginUser", null);
	}
	
	
	public void viewProfile(User u, HttpServletRequest req, HttpServletResponse res) {
		try {
			User userDetail = ss.getMapper(UserMapper.class).getUserbyCode(u);
			userDetail.setUserTechs(ss.getMapper(UserMapper.class).getUserTechs(userDetail));
			userDetail.setProjects(ss.getMapper(UserMapper.class).getUserProjects(userDetail));
			
			
			req.setAttribute("userTechs", userDetail.getUserTechs());
			req.setAttribute("userDetail", userDetail);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	public void updateUser(User u, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			if (ss.getMapper(UserMapper.class).updateUser(u) == 1) {
				req.setAttribute("result", "수정 성공");
			} else {
				req.setAttribute("result", "수정 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int checkUserLevel(User u, HttpServletRequest req, HttpServletResponse res) {
		
		
		return 0;
	}
	
	
}

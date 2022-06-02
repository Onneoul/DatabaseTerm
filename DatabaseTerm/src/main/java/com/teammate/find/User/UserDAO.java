package com.teammate.find.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {
	
	@Autowired
	SqlSession ss;
	
	public void join(User u, HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public boolean loginCheck(HttpServletRequest req, HttpServletResponse res) {
		User u = (User) req.getSession().getAttribute("loginUser");
		if (u != null) {
			req.setAttribute("loginPage", "user/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "user/login.jsp");
			return false;
		}
	}
	
	public void login(User u, HttpServletRequest req, HttpServletResponse res) {
		try {
			User dbUser = ss.getMapper(UserMapper.class).userLogin(u);
			if (dbUser != null) {
				if (u.getuserPw().equals(dbUser.getuserPw())) {
					req.getSession().setAttribute("loginMember", dbUser);
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
		req.getSession().setAttribute("loginMember", null);
	}
	
	public void viewProfile(User u, HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public int checkUserLevel(User u, HttpServletRequest req, HttpServletResponse res) {
		
		
		return 0;
	}
	
}

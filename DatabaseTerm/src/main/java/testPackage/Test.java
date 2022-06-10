package testPackage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teammate.find.Tech.Tech;
import com.teammate.find.User.User;

@Service
public class Test {
		@Autowired
		SqlSession ss;
		
		
		public void listTest (HttpServletRequest req, HttpServletResponse res) {
			try {
				
				User u = new User();
				u.setCode(1);
				System.out.println(u.getCode());
				List<Tech> tc = ss.getMapper(TestMapper.class).getListTest(u);
				System.out.println(tc);
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
}

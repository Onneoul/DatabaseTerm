package testPackage;

import java.util.List;

import com.teammate.find.Tech.Tech;
import com.teammate.find.User.User;

public interface TestMapper {
	public abstract List<Tech> getListTest(User u);
}

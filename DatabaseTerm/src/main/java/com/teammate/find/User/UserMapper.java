package com.teammate.find.User;

import java.util.List;

import com.teammate.find.Project.Project;
import com.teammate.find.Tech.Tech;

public interface UserMapper {
	public abstract User viewUserProfile(User u);
	public abstract int getUserLevel(User u);
	public abstract User getUserbyCode(User u);
	public abstract User userLogin(User u);
	public abstract User userJoinCheck(User u);
	
	public abstract String getUserNameByCode(User u);
	
	public abstract List<Project> getUserProjects(User u);
	public abstract List<UserTech> getUserTechs(User u);
	
	public abstract int joinUser(User u);
	
	public abstract int updateUser(User u);
	public abstract int deleteUser(User u);
}

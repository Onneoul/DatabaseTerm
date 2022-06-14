package com.teammate.find.Project;

import java.util.List;

import com.teammate.find.Tech.Tech;
import com.teammate.find.User.User;

public interface ProjectMapper {
	public abstract int getProjectCount(ProjectSelector ps);
	
	public abstract List<Project> viewProject(ProjectSelector ps);
	public abstract Project viewProjectDetail(Project p);
	
	public abstract int createProject(Project p);
	public abstract Project getProjectCode(Project p);
	public abstract int createLeader(Project p);
	
	public abstract int updateProject(Project p);
	public abstract int deleteProject(Project p);
	
	
	public abstract List<Offer> getProjectOffer(Project p);
	public abstract List<FeedBack> getProjectFeedBack(Project p);
	public abstract List<Tech> getProjectTech(Project p);
	public abstract List<User> getProjectMembers(Project p);
	
	public abstract int createFeedBack(FeedBack f);
	public abstract int updateFeedBack(FeedBack f);
	public abstract int deleteFeedBack(FeedBack f);
	
	
	public abstract int createOffer(Offer o);
	public abstract int deleteOffer(Offer o);
	
	public abstract int acceptOffer(Offer o);
	public abstract int deniedOffer(Offer o);
	
//	public abstract List<TodoList> viewTodoList(Project p);
//	public abstract int createTodoList(TodoList td);
//	public abstract int updateTodoList(TodoList td);
//	public abstract int deleteTodoList(TodoList td);
	
	
}

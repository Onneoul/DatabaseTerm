package com.teammate.find.Project;

import java.util.List;

public interface ProjectMapper {
//	public abstract List<Project> viewProject(ProjectSelector);
	public abstract Project viewProjectDetail(Project p);
	public abstract Feedback viewProjectFeedBack(Project p);
	
//	
//	public abstract List<TodoList> viewTodoList(Project p);
//	public abstract int createTodoList(TodoList td);
//	public abstract int updateTodoList(TodoList td);
//	public abstract int deleteTodoList(TodoList td);
	
	
	public abstract int createProject(Project p);
	public abstract int updateProject(Project p);
	public abstract int deleteProject(Project p);
}

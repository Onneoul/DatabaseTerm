package com.teammate.find.Project;

import java.util.List;
import com.teammate.find.Tech.Tech;

public class Project {
	private int code;
	private String title;
	private String content;
	private int leader;
	private String githubLink;
	private int status;
	private int level;
	private int recommend;
	
	private List<Tech> techs;
	private List<Feedback> feedbacks;
	
	public Project() {
		
	}
	
	public Project(int code, String title, String content, int leader, String githubLink, int status, int level, int recommend, List<Tech> techs, List<Feedback> feedbacks) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.leader = leader;
		this.githubLink = githubLink;
		this.status = status;
		this.level = level;
		this.recommend = recommend;
		this.techs = techs;
		this.feedbacks = feedbacks;
	}
	
	public int getCode() {
		return code;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getLeader() {
		return leader;
	}
	public String getGithubLink() {
		return githubLink;
	}
	public int getStatus() {
		return status;
	}
	public int getLevel() {
		return level;
	}
	public int getRecommend() {
		return recommend;
	}
	public List<Tech> getTechs() {
		return techs;
	}
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setLeader(int leader) {
		this.leader = leader;
	}
	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public void setTechs(List<Tech> techs) {
		this.techs = techs;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
}

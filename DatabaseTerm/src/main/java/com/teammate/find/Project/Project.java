package com.teammate.find.Project;

import java.util.List;
import com.teammate.find.Tech.Tech;
import com.teammate.find.User.User;

public class Project {
	private int code;
	private String title;
	private String content;
	private int leader;
	private String leaderName;
	private String githubLink;
	private String startDate;
	
	private int status;
	private int level;
	private int recommend;
	
	private List<Offer> offers;
	private List<User> members;
	private List<Tech> techs;
	private List<FeedBack> feedbacks;
	
	
	public Project() {
		
	}
	
	public Project(int code, String title, String content, int leader, String leaderName, String githubLink, String startDate, int status, int level, int recommend, List<Offer> offers, List<User> members, List<Tech> techs, List<FeedBack> feedbacks) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.leader = leader;
		this.leaderName = leaderName;
		this.githubLink = githubLink;
		this.startDate = startDate;
		this.status = status;
		this.level = level;
		this.recommend = recommend;
		
		this.offers = offers;
		this.members = members;
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
	public String getLeaderName() {
		return leaderName;
	}
	public String getGithubLink() {
		return githubLink;
	}
	public String getStartDate() {
		return startDate;
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
	
	public List<Offer> getOffers() {
		return offers;
	}
	public List<User> getMembers() {
		return members;
	}
	public List<Tech> getTechs() {
		return techs;
	}
	public List<FeedBack> getFeedbacks() {
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
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
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
	
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public void setTechs(List<Tech> techs) {
		this.techs = techs;
	}
	public void setFeedbacks(List<FeedBack> feedbacks) {
		this.feedbacks = feedbacks;
	}
}

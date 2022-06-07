package com.teammate.find.Question;
import java.util.Date;
import java.util.List;

import com.teammate.find.Tech.Tech;

public class Question {
	private String title;
	private String content;
	private int writer;
	private Date date;
	
	private List<Tech> techs;
	private List<Answer> answers;
	
	public Question() {
		
	}
	
	public Question(String title, String content, int writer, Date date, List<Tech> techs, List<Answer> answers) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.techs = techs;
		this.answers = answers;
	}
	
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getWriter() {
		return writer;
	}
	public Date getDate() {
		return date;
	}
	public List<Tech> getTechs() {
		return techs;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTechs(List<Tech> techs) {
		this.techs = techs;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}

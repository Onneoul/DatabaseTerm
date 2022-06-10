package com.teammate.find.Question;
import java.util.Date;
import java.util.List;

import com.teammate.find.Tech.Tech;

public class Question {
	private int code;
	private String title;
	private String content;
	private int writer;
	private String reportDate;
	
	private List<QuestionTech> questionTechs;
	private List<Answer> answers;
	
	public Question() {
		
	}
	
	public Question(int code, String title, String content, int writer, String reportDate, List<QuestionTech> questionTechs, List<Answer> answers) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.reportDate = reportDate;
		this.questionTechs = questionTechs;
		this.answers = answers;
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
	public int getWriter() {
		return writer;
	}
	public String getReportDate() {
		return reportDate;
	}
	public List<QuestionTech> getQuestionTechs() {
		return questionTechs;
	}
	public List<Answer> getAnswers() {
		return answers;
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
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public void setQuestionTechs(List<QuestionTech> questionTechs) {
		this.questionTechs = questionTechs;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}

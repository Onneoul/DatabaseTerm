package com.teammate.find.Question;

import java.util.List;

public class Questions {
	private List<Question> questions;
	
	public Questions() {
		
	}
	
	public Questions(List<Question> questions) {
		super();
		this.questions = questions;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}

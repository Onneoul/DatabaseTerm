package com.teammate.find.Question;

import java.util.List;

public class Answers {
private List<Answer> Answers;
	
	public Answers() {
		
	}
	
	public Answers(List<Answer> Answers) {
		super();
		this.Answers = Answers;
	}
	
	public List<Answer> getAnswers() {
		return Answers;
	}
	
	public void setAnswers(List<Answer> answers) {
		Answers = answers;
	}
}

package com.teammate.find.Question;

import java.util.List;

public interface QuestionMapper {
	public abstract Question getQuestionDetail(Question q);
	public abstract List<Answer> getQuestionAnswers (Question q);
	public abstract List<QuestionTech> getQuestionTechs (Question q);
	
	public abstract int getQuestionCount(QuestionSelector eS);
	
	public abstract int createQuestion(Question q);
	public abstract int createAnswer(Answer a);
	public abstract int updateQuestion(Question q);
	public abstract int updateAnswer(Answer a);
	public abstract int deleteQuestion(Question q);
	public abstract int deleteAnswer(Answer a);
	
	public abstract List<Question> viewQuestion(QuestionSelector search);

}

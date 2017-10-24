package quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizVO {
	String quizSub, quizQue;
	List<ExampleVO> examples = new ArrayList<>();
	public List<ExampleVO> getExamples() {
		return examples;
	}
	public void setExamples(ExampleVO examples) {
		this.examples.add(examples);
	}
	Integer testCode, quizNo, quizAnser, quizScore;
	public String getQuizSub() {
		return quizSub;
	}
	public void setQuizSub(String quizSub) {
		this.quizSub = quizSub;
	}
	
	public String getQuizQue() {
		return quizQue;
	}
	public void setQuizQue(String quizQue) {
		this.quizQue = quizQue;
	}
	public Integer getTestCode() {
		return testCode;
	}
	public void setTestCode(Integer testCode) {
		this.testCode = testCode;
	}
	public Integer getQuizNo() {
		return quizNo;
	}
	public void setQuizNo(Integer quizNo) {
		this.quizNo = quizNo;
	}
	public Integer getQuizAnser() {
		return quizAnser;
	}
	public void setQuizAnser(Integer quizAnser) {
		this.quizAnser = quizAnser;
	}
	public Integer getQuizScore() {
		return quizScore;
	}
	public void setQuizScore(Integer quizScore) {
		this.quizScore = quizScore;
	}
}

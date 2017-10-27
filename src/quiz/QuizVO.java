package quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizVO {
	public Integer getQuizScore() {
		return quizScore;
	}
	
	public void setQuizScore(Integer quizScore) {
		this.quizScore = quizScore;
	}

	public Integer getQuizCode() {
		return quizCode;
	}

	public void setQuizCode(Integer quizCode) {
		this.quizCode = quizCode;
	}

	String quizSub, quizQue;
	Integer quizCode;
	List<ExampleVO> examples = new ArrayList<>();

	public List<ExampleVO> getExamples() {
		return examples;
	}

	public void setExamples(ExampleVO examples) {
		this.examples.add(examples);
	}

	Integer testCode, quizNo, quizanwser, quizScore;

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

	public Integer getQuizAnswer() {
		return quizanwser;
	}

	public void setQuizAnswer(Integer quizanwser) {
		this.quizanwser = quizanwser;
	}

	@Override
	public String toString() {
		return "QuizVO [quizSub=" + quizSub + ", quizQue=" + quizQue + ", quizCode=" + quizCode + ", examples="
				+ examples + ", testCode=" + testCode + ", quizNo=" + quizNo + ", quizanwser=" + quizanwser
				+ ", quizScore=" + quizScore + "]";
	}
	
	
}

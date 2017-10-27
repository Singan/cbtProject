package quiz;

public class AnswerVO {
	Integer quizCode,answer,quizNo,score;
	String ansQue ;
	public String getAnsQue() {
		return ansQue;
	}

	public void setAnsQue(String ansQue) {
		this.ansQue = ansQue;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getQuizNo() {
		return quizNo;
	}

	public void setQuizNo(Integer quizNo) {
		this.quizNo = quizNo;
	}

	public Integer getQuizCode() {
		return quizCode;
	}

	public void setQuizCode(Integer quizCode) {
		this.quizCode = quizCode;
	}

	public Integer getAnswer() {
		return answer;
	}

	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
}

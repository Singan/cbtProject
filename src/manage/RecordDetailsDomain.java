package manage;

public class RecordDetailsDomain {
	private int recordNo;
	private int quizNo;
	private String recordResult;
	private int recordAnswer;
	private int quizAnswer;
	
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	public int getQuizNo() {
		return quizNo;
	}
	public void setQuizNo(int quizNo) {
		this.quizNo = quizNo;
	}
	public String getRecordResult() {
		return recordResult;
	}
	public void setRecordResult(String recordResult) {
		this.recordResult = recordResult;
	}
	public int getRecordAnswer() {
		return recordAnswer;
	}
	public void setRecordAnswer(int recordAnswer) {
		this.recordAnswer = recordAnswer;
	}
	public int getQuizAnswer() {
		return quizAnswer;
	}
	public void setQuizAnswer(int quizAnswer) {
		this.quizAnswer = quizAnswer;
	}
}

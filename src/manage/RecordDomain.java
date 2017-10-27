package manage;

import java.util.Date;

public class RecordDomain {
	private int recordNo;
	private String id;
	private int testCode;
	private int score;
	private Date recordDate;
	
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTestCode() {
		return testCode;
	}
	public void setTestCode(int testCode) {
		this.testCode = testCode;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
}

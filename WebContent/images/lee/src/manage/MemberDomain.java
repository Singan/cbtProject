package manage;

import java.util.Date;

public class MemberDomain {
	private String id;
	private String pass;
	private String name;
	private String admin;
	private Date regDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegdate(Date regDate) {
		this.regDate = regDate;
	}
}

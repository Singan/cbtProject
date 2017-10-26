package login;

import java.util.Date;

public class MemberVO {
	private String id;
	private String pass;
	private String name;
	private String admin;
	private Date accestime;
	
	public Date getAccestime() {
		return accestime;
	}
	public void setAccestime(Date accestime) {
		this.accestime = accestime;
	}
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
	
	
}

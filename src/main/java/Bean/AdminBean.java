package Bean;

public class AdminBean {
	private String uname;
	private String pword;
	private String email;
	private long phone;
	public AdminBean() {
		
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "AdminBean [uname=" + uname + ", pword=" + pword + ", email=" + email + ", phone=" + phone + "]";
	}
	

}

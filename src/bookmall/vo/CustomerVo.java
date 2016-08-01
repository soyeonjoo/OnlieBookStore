package bookmall.vo;

public class CustomerVo {
	private Long customNo;
	private String customName;
	private String phn;
	private String email;
	private String pw;
	public Long getCustomNo() {
		return customNo;
	}
	public void setCustomNo(Long customNo) {
		this.customNo = customNo;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getPhn() {
		return phn;
	}
	public void setPhn(String phn) {
		this.phn = phn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "no:"+customNo + " name:"+ customName+", phn:"+ phn+", emil:"+email+", pw:"+pw;
	}
	
	
	
}


public class updateVO {
	//myPage테이블에서 수정시 사용할 컬럼
	private String id;
	private String pw;
	private String newPwEmail;
	private String newPw;
	private String newEmail;
	private String check;
	
	public updateVO(String id, String pw, String newPwEmail, String check) {
		this.id = id;
		this.pw = pw;
		this.newPwEmail = newPwEmail;
		this.check = check;
	}
	
	
	public updateVO(String id, String pw, String newPw, String newEmail, String check) {
		this.id = id;
		this.pw = pw;
		this.newPw = newPw;
		this.newEmail = newEmail;
		this.check = check;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getNewPwEmail() {
		return newPwEmail;
	}


	public void setNewPwEmail(String newPwEmail) {
		this.newPwEmail = newPwEmail;
	}


	public String getNewPw() {
		return newPw;
	}


	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}


	public String getNewEmail() {
		return newEmail;
	}


	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}


	public String getCheck() {
		return check;
	}


	public void setCheck(String check) {
		this.check = check;
	}
	
	
}

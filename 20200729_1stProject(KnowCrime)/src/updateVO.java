
public class updateVO {
	//myPage테이블에서 수정시 사용할 컬럼
	private String id;
	private String pw;
	private String newPwEmail;
	private String newPw;
	private String newEmail;
	private String click;
	
	//회원수정시 비밀번호 혹은 이메일 중 1개만 수정 시
	public updateVO(String id, String pw, String newPwEmail, String click) {
		this.id = id;
		this.pw = pw;
		this.newPwEmail = newPwEmail;
		this.click = click;
	}
	
	//회원수정시 비밀번호와 이메일 둘 다 변경을 원하는 경우
	public updateVO(String id, String pw, String newPw, String newEmail, String click) {
		this.id = id;
		this.pw = pw;
		this.newPw = newPw;
		this.newEmail = newEmail;
		this.click = click;
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


	public String getclick() {
		return click;
	}


	public void setclick(String click) {
		this.click = click;
	}
	
	
}

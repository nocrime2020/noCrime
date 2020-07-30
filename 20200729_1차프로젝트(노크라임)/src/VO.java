

public class VO {	//아래컬럼 하나로 묶어서 관리할 수 있는 메소드
	//member테이블이 가지고 있는 컬럼
	private String id;
	private String pw;
	private String name;
	private String email;
	
	public VO(String id, String pw, String name, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}

	public VO(String id, String pw) {
		this.id = id;
		this.pw = pw;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

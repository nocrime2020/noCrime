
public class VO_alarm {
	private String id;
	private String set_start;
	private String set_end;
	private String cr_cnt;
	
	public VO_alarm(String id, String set_start, String set_end, String cr_cnt) {
		this.id = id;
		this.set_start = set_start;
		this.set_end = set_end;
		this.cr_cnt = cr_cnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSet_start() {
		return set_start;
	}
	public void setSet_start(String set_start) {
		this.set_start = set_start;
	}
	public String getSet_end() {
		return set_end;
	}
	public void setSet_end(String set_end) {
		this.set_end = set_end;
	}
	public String getCr_cnt() {
		return cr_cnt;
	}
	public void setCr_cnt(String cr_cnt) {
		this.cr_cnt = cr_cnt;
	}
	
	
}

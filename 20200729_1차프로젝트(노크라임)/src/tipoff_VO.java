
public class tipoff_VO {
	
	private String cr_id;
	private String cr_loc_id;
	private String cr_date;
	private String cr_type_id;
	private String tip_id;
	private String cr_name;
	
	
	public tipoff_VO(String cr_id, String cr_loc_id, String cr_date, String cr_type_id, String tip_id, String cr_name) {
		this.cr_id = cr_id;
		this.cr_loc_id = cr_loc_id;
		this.cr_date = cr_date;
		this.cr_type_id = cr_type_id;
		this.tip_id = tip_id;
		this.cr_name = cr_name;
	}
	public String getCr_id() {
		return cr_id;
	}
	public void setCr_id(String cr_id) {
		this.cr_id = cr_id;
	}
	public String getCr_loc_id() {
		return cr_loc_id;
	}
	public void setCr_loc_id(String cr_loc_id) {
		this.cr_loc_id = cr_loc_id;
	}
	public String getCr_date() {
		return cr_date;
	}
	public void setCr_date(String cr_date) {
		this.cr_date = cr_date;
	}
	public String getCr_type_id() {
		return cr_type_id;
	}
	public void setCr_type_id(String cr_type_id) {
		this.cr_type_id = cr_type_id;
	}
	public String getTip_id() {
		return tip_id;
	}
	public void setTip_id(String tip_id) {
		this.tip_id = tip_id;
	}
	public String getCr_name() {
		return cr_name;
	}
	public void setCr_name(String cr_name) {
		this.cr_name = cr_name;
	}
	

}

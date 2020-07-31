
public class tipoff_VO {
	
	private String tip_info_id;
	private String cr_type_id;
	private String cr_date;
	private String cr_loc_id;
	private String evidence;
	private String cr_name;
	public tipoff_VO(String tip_info_id, String cr_type_id, String cr_date, String cr_loc_id, String evidence,
			String cr_name) {
		super();
		this.tip_info_id = tip_info_id;
		this.cr_type_id = cr_type_id;
		this.cr_date = cr_date;
		this.cr_loc_id = cr_loc_id;
		this.evidence = evidence;
		this.cr_name = cr_name;
	}
	public String getTip_info_id() {
		return tip_info_id;
	}
	public void setTip_info_id(String tip_info_id) {
		this.tip_info_id = tip_info_id;
	}
	public String getCr_type_id() {
		return cr_type_id;
	}
	public void setCr_type_id(String cr_type_id) {
		this.cr_type_id = cr_type_id;
	}
	public String getCr_date() {
		return cr_date;
	}
	public void setCr_date(String cr_date) {
		this.cr_date = cr_date;
	}
	public String getCr_loc_id() {
		return cr_loc_id;
	}
	public void setCr_loc_id(String cr_loc_id) {
		this.cr_loc_id = cr_loc_id;
	}
	public String getEvidence() {
		return evidence;
	}
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}
	public String getCr_name() {
		return cr_name;
	}
	public void setCr_name(String cr_name) {
		this.cr_name = cr_name;
	}
}
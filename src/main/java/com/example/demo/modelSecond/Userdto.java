package com.example.demo.modelSecond;

import java.util.Date;

public class Userdto {

	private long userid;
	private String userlogin;
	private String userpwd;
	private Integer useretat;
	private Integer userprofil;
	private String usernom;
	private String userprenom;
	private Date usercreated;
	private String userupdatby;
	private Date userupDated;
	private String usercomment;
	private String useremail;
	private String connecte;
	private String sessionid;
	private Integer userflagnotif;
	private String useremailnotif;
	private String userdmodpass;
	private String userdelaiexpire;
	private long fournid;
	private long distribid;
	private long adminid;
	
	public Userdto() {
		super();
	}
	public Userdto(long userid, String userlogin, String userpwd, Integer useretat, Integer userprofil, String usernom,
			String userprenom, Date usercreated, String userupdatby, Date userupDated, String usercomment,
			String useremail, String connecte, String sessionid, Integer userflagnotif, String useremailnotif,
			String userdmodpass, String userdelaiexpire, long fournid, long distribid, long adminid) {
		super();
		this.userid = userid;
		this.userlogin = userlogin;
		this.userpwd = userpwd;
		this.useretat = useretat;
		this.userprofil = userprofil;
		this.usernom = usernom;
		this.userprenom = userprenom;
		this.usercreated = usercreated;
		this.userupdatby = userupdatby;
		this.userupDated = userupDated;
		this.usercomment = usercomment;
		this.useremail = useremail;
		this.connecte = connecte;
		this.sessionid = sessionid;
		this.userflagnotif = userflagnotif;
		this.useremailnotif = useremailnotif;
		this.userdmodpass = userdmodpass;
		this.userdelaiexpire = userdelaiexpire;
		this.fournid = fournid;
		this.distribid = distribid;
		this.adminid = adminid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUserlogin() {
		return userlogin;
	}
	public void setUserlogin(String userlogin) {
		this.userlogin = userlogin;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public Integer getUseretat() {
		return useretat;
	}
	public void setUseretat(Integer useretat) {
		this.useretat = useretat;
	}
	public Integer getUserprofil() {
		return userprofil;
	}
	public void setUserprofil(Integer userprofil) {
		this.userprofil = userprofil;
	}
	public String getUsernom() {
		return usernom;
	}
	public void setUsernom(String usernom) {
		this.usernom = usernom;
	}
	public String getUserprenom() {
		return userprenom;
	}
	public void setUserprenom(String userprenom) {
		this.userprenom = userprenom;
	}
	public Date getUsercreated() {
		return usercreated;
	}
	public void setUsercreated(Date usercreated) {
		this.usercreated = usercreated;
	}
	public String getUserupdatby() {
		return userupdatby;
	}
	public void setUserupdatby(String userupdatby) {
		this.userupdatby = userupdatby;
	}
	public Date getUserupDated() {
		return userupDated;
	}
	public void setUserupDated(Date userupDated) {
		this.userupDated = userupDated;
	}
	public String getUsercomment() {
		return usercomment;
	}
	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getConnecte() {
		return connecte;
	}
	public void setConnecte(String connecte) {
		this.connecte = connecte;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public Integer getUserflagnotif() {
		return userflagnotif;
	}
	public void setUserflagnotif(Integer userflagnotif) {
		this.userflagnotif = userflagnotif;
	}
	public String getUseremailnotif() {
		return useremailnotif;
	}
	public void setUseremailnotif(String useremailnotif) {
		this.useremailnotif = useremailnotif;
	}
	public String getUserdmodpass() {
		return userdmodpass;
	}
	public void setUserdmodpass(String userdmodpass) {
		this.userdmodpass = userdmodpass;
	}
	public String getUserdelaiexpire() {
		return userdelaiexpire;
	}
	public void setUserdelaiexpire(String userdelaiexpire) {
		this.userdelaiexpire = userdelaiexpire;
	}
	public long getFournid() {
		return fournid;
	}
	public void setFournid(long fournid) {
		this.fournid = fournid;
	}
	public long getDistribid() {
		return distribid;
	}
	public void setDistribid(long distribid) {
		this.distribid = distribid;
	}
	public long getAdminid() {
		return adminid;
	}
	public void setAdminid(long adminid) {
		this.adminid = adminid;
	}
	
	
	

	

}

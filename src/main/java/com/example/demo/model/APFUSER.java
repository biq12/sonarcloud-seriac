package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@SequenceGenerator(name = "seq_user_id",allocationSize=1)
public class APFUSER {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq_user_id")
	@Column(name = "USERID", unique = true, nullable = false)
	private Long USERID;
	@Column(name = "USERLOGIN", unique = true, nullable = false)
	private String userlogin;
	@Column(name = "USERPWD")
	private String userpwd;
	private int USERETAT;
	private int USERPROFIL;
	private String USERNOM;
	private String USERPRENOM;
	private Date USERCREATED;
	private String USERUPDATBY;
	private Date USERUPDATED;
	private String USERCOMMENT;
	private String USEREMAIL;
	private String CONNECTE;
	private String SESSIONID;
	private int USERFLAGNOTIF;
	private String USEREMAILNOTIF;
	private String USERDMODPASS;
	private String USERDELAIEXPIRE;

	private Long fournid;
	private Long distribid;
	private Long adminid;
		

	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<Apfrole> roles=new ArrayList<>();
	
	@ManyToMany()
	private Collection<Apfecran> screns=new ArrayList<>();
	/*
	 * 
	 */
	private Long USERCODEREINTIAL;
	

	public APFUSER() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "APFUSER [USERID=" + USERID + ", userlogin=" + userlogin + ", USERPWD=" + userpwd + ", USERETAT="
				+ USERETAT + ", USERPROFIL=" + USERPROFIL + ", USERNOM=" + USERNOM + ", USERPRENOM=" + USERPRENOM
				+ ", USERCREATED=" + USERCREATED + ", USERUPDATBY=" + USERUPDATBY + ", USERUPDATED=" + USERUPDATED
				+ ", USERCOMMENT=" + USERCOMMENT + ", USEREMAIL=" + USEREMAIL + ", CONNECTE=" + CONNECTE
				+ ", SESSIONID=" + SESSIONID + ", USERFLAGNOTIF=" + USERFLAGNOTIF + ", USEREMAILNOTIF=" + USEREMAILNOTIF
				+ ", fournid=" + fournid + ", distribid=" + distribid + ", adminid=" + adminid + ", screns=" + screns
				+ "]";
	}



	public APFUSER(Long uSERID, String userlogin, String userpwd, int uSERETAT, int uSERPROFIL, String uSERNOM,
			String uSERPRENOM, Date uSERCREATED, String uSERUPDATBY, Date uSERUPDATED, String uSERCOMMENT,
			String uSEREMAIL, String cONNECTE, String sESSIONID, int uSERFLAGNOTIF, String uSEREMAILNOTIF,
			String uSERDMODPASS, String uSERDELAIEXPIRE, Long fournid, Long distribid, Long adminid) {
		super();
		USERID = uSERID;
		this.userlogin = userlogin;
		this.userpwd = userpwd;
		USERETAT = uSERETAT;
		USERPROFIL = uSERPROFIL;
		USERNOM = uSERNOM;
		USERPRENOM = uSERPRENOM;
		USERCREATED = uSERCREATED;
		USERUPDATBY = uSERUPDATBY;
		USERUPDATED = uSERUPDATED;
		USERCOMMENT = uSERCOMMENT;
		USEREMAIL = uSEREMAIL;
		CONNECTE = cONNECTE;
		SESSIONID = sESSIONID;
		USERFLAGNOTIF = uSERFLAGNOTIF;
		USEREMAILNOTIF = uSEREMAILNOTIF;
		USERDMODPASS = uSERDMODPASS;
		USERDELAIEXPIRE = uSERDELAIEXPIRE;
		this.fournid = fournid;
		this.distribid = distribid;
		this.adminid = adminid;
	}
	

	public APFUSER(Long uSERID, String userlogin, String userpwd, int uSERETAT, int uSERPROFIL, String uSERNOM,
			String uSERPRENOM, Date uSERCREATED, String uSERUPDATBY, Date uSERUPDATED, String uSERCOMMENT,
			String uSEREMAIL, String cONNECTE, String sESSIONID, int uSERFLAGNOTIF, String uSEREMAILNOTIF,
			String uSERDMODPASS, String uSERDELAIEXPIRE, Long fournid, Long distribid, Long adminid,
			Long uSERCODEREINTIAL) {
		super();
		USERID = uSERID;
		this.userlogin = userlogin;
		this.userpwd = userpwd;
		USERETAT = uSERETAT;
		USERPROFIL = uSERPROFIL;
		USERNOM = uSERNOM;
		USERPRENOM = uSERPRENOM;
		USERCREATED = uSERCREATED;
		USERUPDATBY = uSERUPDATBY;
		USERUPDATED = uSERUPDATED;
		USERCOMMENT = uSERCOMMENT;
		USEREMAIL = uSEREMAIL;
		CONNECTE = cONNECTE;
		SESSIONID = sESSIONID;
		USERFLAGNOTIF = uSERFLAGNOTIF;
		USEREMAILNOTIF = uSEREMAILNOTIF;
		USERDMODPASS = uSERDMODPASS;
		USERDELAIEXPIRE = uSERDELAIEXPIRE;
		this.fournid = fournid;
		this.distribid = distribid;
		this.adminid = adminid;
		USERCODEREINTIAL = uSERCODEREINTIAL;
	}

	public Long getUSERCODEREINTIAL() {
		return USERCODEREINTIAL;
	}

	public void setUSERCODEREINTIAL(Long uSERCODEREINTIAL) {
		USERCODEREINTIAL = uSERCODEREINTIAL;
	}

	public Long getUSERID() {
		return USERID;
	}
	public void setUSERID(Long uSERID) {
		USERID = uSERID;
	}

	public String getUserlogin() {
		return userlogin;
	}


	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public void setUserlogin(String userlogin) {
		this.userlogin = userlogin;
	}


	public int getUSERETAT() {
		return USERETAT;
	}
	public void setUSERETAT(int uSERETAT) {
		USERETAT = uSERETAT;
	}
	public int getUSERPROFIL() {
		return USERPROFIL;
	}
	public void setUSERPROFIL(int uSERPROFIL) {
		USERPROFIL = uSERPROFIL;
	}
	public String getUSERNOM() {
		return USERNOM;
	}
	public void setUSERNOM(String uSERNOM) {
		USERNOM = uSERNOM;
	}
	public String getUSERPRENOM() {
		return USERPRENOM;
	}
	public void setUSERPRENOM(String uSERPRENOM) {
		USERPRENOM = uSERPRENOM;
	}
	public Date getUSERCREATED() {
		return USERCREATED;
	}
	public void setUSERCREATED(Date uSERCREATED) {
		USERCREATED = uSERCREATED;
	}
	public String getUSERUPDATBY() {
		return USERUPDATBY;
	}
	public void setUSERUPDATBY(String uSERUPDATBY) {
		USERUPDATBY = uSERUPDATBY;
	}
	public Date getUSERUPDATED() {
		return USERUPDATED;
	}
	public void setUSERUPDATED(Date uSERUPDATED) {
		USERUPDATED = uSERUPDATED;
	}
	public String getUSERCOMMENT() {
		return USERCOMMENT;
	}
	public void setUSERCOMMENT(String uSERCOMMENT) {
		USERCOMMENT = uSERCOMMENT;
	}
	public String getUSEREMAIL() {
		return USEREMAIL;
	}
	public void setUSEREMAIL(String uSEREMAIL) {
		USEREMAIL = uSEREMAIL;
	}
	public String getCONNECTE() {
		return CONNECTE;
	}
	public void setCONNECTE(String cONNECTE) {
		CONNECTE = cONNECTE;
	}
	public String getSESSIONID() {
		return SESSIONID;
	}
	public void setSESSIONID(String sESSIONID) {
		SESSIONID = sESSIONID;
	}
	public int getUSERFLAGNOTIF() {
		return USERFLAGNOTIF;
	}
	public void setUSERFLAGNOTIF(int uSERFLAGNOTIF) {
		USERFLAGNOTIF = uSERFLAGNOTIF;
	}
	public String getUSEREMAILNOTIF() {
		return USEREMAILNOTIF;
	}
	public void setUSEREMAILNOTIF(String uSEREMAILNOTIF) {
		USEREMAILNOTIF = uSEREMAILNOTIF;
	}
	
	
	public String getUSERDMODPASS() {
		return USERDMODPASS;
	}

	public void setUSERDMODPASS(String uSERDMODPASS) {
		USERDMODPASS = uSERDMODPASS;
	}

	public String getUSERDELAIEXPIRE() {
		return USERDELAIEXPIRE;
	}

	public void setUSERDELAIEXPIRE(String uSERDELAIEXPIRE) {
		USERDELAIEXPIRE = uSERDELAIEXPIRE;
	}

	public Long getFournid() {
		return fournid;
	}
	public void setFournid(Long fournid) {
		this.fournid = fournid;
	}
	public Long getDistribid() {
		return distribid;
	}
	public void setDistribid(Long distribid) {
		this.distribid = distribid;
	}
	public Long getAdminid() {
		return adminid;
	}
	public void setAdminid(Long adminid) {
		this.adminid = adminid;
	}
	
	
    public Collection<Apfecran> getScrens() {
		return screns;
	}
	public void setScrens(Collection<Apfecran> screns) {
		this.screns = screns;
	}

	public Collection<Apfrole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Apfrole> roles) {
		this.roles = roles;
	}
	


}

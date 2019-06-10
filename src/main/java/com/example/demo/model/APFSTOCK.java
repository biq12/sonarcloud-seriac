package com.example.demo.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class APFSTOCK {
	
    private Long USERID;
    private String USERLOGIN;
    private String USERPWD;
    private int USERETAT;
    private int USERPROFIL;
    private String USERNOM;
    private String USERPRENOM;
    private Date USERCREATED;
    private String USERUPDATBY;
    private Date    USERUPDATED;
    private String USERCOMMENT;
    private String  USEREMAIL;
    private int CONNECTE;
    private String   SESSIONID;
    private  int USERFLAGNOTIF;
    private String USEREMAILNOTIF;

    public APFSTOCK()
    {

    }
    public APFSTOCK(String USERLOGIN, String USERPWD, int USERETAT, int USERPROFIL, String USERNOM, String USERPRENOM, Date USERCREATED, String USERUPDATBY, Date USERUPDATED, String USERCOMMENT, String USEREMAIL, int CONNECTE, String SESSIONID, int USERFLAGNOTIF, String USEREMAILNOTIF) {
        this.USERLOGIN = USERLOGIN;
        this.USERPWD = USERPWD;
        this.USERETAT = USERETAT;
        this.USERPROFIL = USERPROFIL;
        this.USERNOM = USERNOM;
        this.USERPRENOM = USERPRENOM;
        this.USERCREATED = USERCREATED;
        this.USERUPDATBY = USERUPDATBY;
        this.USERUPDATED = USERUPDATED;
        this.USERCOMMENT = USERCOMMENT;
        this.USEREMAIL = USEREMAIL;
        this.CONNECTE = CONNECTE;
        this.SESSIONID = SESSIONID;
        this.USERFLAGNOTIF = USERFLAGNOTIF;
        this.USEREMAILNOTIF = USEREMAILNOTIF;
    }

    public Long getUSERID() {
        return USERID;
    }

    public void setUSERID(Long USERID) {
        this.USERID = USERID;
    }

    public String getUSERLOGIN() {
        return USERLOGIN;
    }

    public void setUSERLOGIN(String USERLOGIN) {
        this.USERLOGIN = USERLOGIN;
    }

    public String getUSERPWD() {
        return USERPWD;
    }

    public void setUSERPWD(String USERPWD) {
        this.USERPWD = USERPWD;
    }

    public int getUSERETAT() {
        return USERETAT;
    }

    public void setUSERETAT(int USERETAT) {
        this.USERETAT = USERETAT;
    }

    public int getUSERPROFIL() {
        return USERPROFIL;
    }

    public void setUSERPROFIL(int USERPROFIL) {
        this.USERPROFIL = USERPROFIL;
    }

    public String getUSERNOM() {
        return USERNOM;
    }

    public void setUSERNOM(String USERNOM) {
        this.USERNOM = USERNOM;
    }

    public String getUSERPRENOM() {
        return USERPRENOM;
    }

    public void setUSERPRENOM(String USERPRENOM) {
        this.USERPRENOM = USERPRENOM;
    }

    public Date getUSERCREATED() {
        return USERCREATED;
    }

    public void setUSERCREATED(Date USERCREATED) {
        this.USERCREATED = USERCREATED;
    }

    public String getUSERUPDATBY() {
        return USERUPDATBY;
    }

    public void setUSERUPDATBY(String USERUPDATBY) {
        this.USERUPDATBY = USERUPDATBY;
    }

    public Date getUSERUPDATED() {
        return USERUPDATED;
    }

    public void setUSERUPDATED(Date USERUPDATED) {
        this.USERUPDATED = USERUPDATED;
    }

    public String getUSERCOMMENT() {
        return USERCOMMENT;
    }

    public void setUSERCOMMENT(String USERCOMMENT) {
        this.USERCOMMENT = USERCOMMENT;
    }

    public String getUSEREMAIL() {
        return USEREMAIL;
    }

    public void setUSEREMAIL(String USEREMAIL) {
        this.USEREMAIL = USEREMAIL;
    }

    public int getCONNECTE() {
        return CONNECTE;
    }

    public void setCONNECTE(int CONNECTE) {
        this.CONNECTE = CONNECTE;
    }

    public String getSESSIONID() {
        return SESSIONID;
    }

    public void setSESSIONID(String SESSIONID) {
        this.SESSIONID = SESSIONID;
    }

    public int getUSERFLAGNOTIF() {
        return USERFLAGNOTIF;
    }

    public void setUSERFLAGNOTIF(int USERFLAGNOTIF) {
        this.USERFLAGNOTIF = USERFLAGNOTIF;
    }

    public String getUSEREMAILNOTIF() {
        return USEREMAILNOTIF;
    }

    public void setUSEREMAILNOTIF(String USEREMAILNOTIF) {
        this.USEREMAILNOTIF = USEREMAILNOTIF;
    }
}

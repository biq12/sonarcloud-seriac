package com.example.demo.modelSecond;

import java.util.Date;

import javax.persistence.Id;

public class EnteteReceptionSearch {

	private Long     sercinrec	;
	private Long     sercincde  ;//	n	number(9)	n			code interne commande
	
	private Date	serdrecrmin;//	n	date	n			date de reception min
	private Date	serdrecrmax;//	n	date	n			date de reception max
	
	private Date	serdcommin	;//n	date	n			        date de commande
	private Date	serdcommax	;//n	date	n			        date de commande
	private String	sercexcde ;//	n	varchar2(13)	        code externe commande
	private Long     sersite	;//code de site
	private  String serensCode;//code ensign 
	
	private String   fccnum	;//contrat commerçiale

	
	
	
	
	public String getSerensCode() {
		return serensCode;
	}
	public void setSerensCode(String serensCode) {
		this.serensCode = serensCode;
	}
	public Long getSersite() {
		return sersite;
	}
	public void setSersite(Long sersite) {
		this.sersite = sersite;
	}
	public Long getSercinrec() {
		return sercinrec;
	}
	public void setSercinrec(Long sercinrec) {
		this.sercinrec = sercinrec;
	}

	public Long getSercincde() {
		return sercincde;
	}

	public void setSercincde(Long sercincde) {
		this.sercincde = sercincde;
	}
	
	
	public Date getSerdrecrmin() {
		return serdrecrmin;
	}
	public void setSerdrecrmin(Date serdrecrmin) {
		this.serdrecrmin = serdrecrmin;
	}
	public Date getSerdrecrmax() {
		return serdrecrmax;
	}
	public void setSerdrecrmax(Date serdrecrmax) {
		this.serdrecrmax = serdrecrmax;
	}
	public Date getSerdcommin() {
		return serdcommin;
	}
	public void setSerdcommin(Date serdcommin) {
		this.serdcommin = serdcommin;
	}
	public Date getSerdcommax() {
		return serdcommax;
	}
	public void setSerdcommax(Date serdcommax) {
		this.serdcommax = serdcommax;
	}
	
	
	public String getSercexcde() {
		return sercexcde;
	}
	public void setSercexcde(String sercexcde) {
		this.sercexcde = sercexcde;
	}
	public String getFccnum() {
		return fccnum;
	}
	public void setFccnum(String fccnum) {
		this.fccnum = fccnum;
	}//n	varchar2(8)	n			code externe contrat commercial
	
	
	
	public EnteteReceptionSearch() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EnteteReceptionSearch [sercinrec=" + sercinrec + ", sercincde=" + sercincde + ", serdrecrmin="
				+ serdrecrmin + ", serdrecrmax=" + serdrecrmax + ", serdcommin=" + serdcommin + ", serdcommax="
				+ serdcommax + ", fccnum=" + fccnum + "]";
	}


	
	
	
}

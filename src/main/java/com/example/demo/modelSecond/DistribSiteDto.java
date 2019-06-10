package com.example.demo.modelSecond;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.model.APFDISTRIB;
import com.example.demo.model.APFVILLE;

public class DistribSiteDto {
	//verifier
	
	private Long sitecod;///it s the primary if the class
	private String sitelib;
	private int sitetype;
	private String siteadfa;
	private String siteadli;	
	private Date sitcreated;
	private String situpdatby;
	private Date situpdated;
	private APFVILLE  apfville;
	private Integer siteaffichable;
	private String sitenscod;  
	private Long distribid ;

	
	public DistribSiteDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public DistribSiteDto(Long sitecod, String sitelib, int sitetype, String siteadfa, String siteadli, Date sitcreated,
			String situpdatby, Date situpdated, APFVILLE apfville, Integer siteaffichable, String sitenscod,
			Long distribid) {
		super();
		this.sitecod = sitecod;
		this.sitelib = sitelib;
		this.sitetype = sitetype;
		this.siteadfa = siteadfa;
		this.siteadli = siteadli;
		this.sitcreated = sitcreated;
		this.situpdatby = situpdatby;
		this.situpdated = situpdated;
		this.apfville = apfville;
		this.siteaffichable = siteaffichable;
		this.sitenscod = sitenscod;
		this.distribid = distribid;
	}



	public Long getSitecod() {
		return sitecod;
	}


	public void setSitecod(Long sitecod) {
		this.sitecod = sitecod;
	}


	public String getSitelib() {
		return sitelib;
	}


	public void setSitelib(String sitelib) {
		this.sitelib = sitelib;
	}


	public int getSitetype() {
		return sitetype;
	}


	public void setSitetype(int sitetype) {
		this.sitetype = sitetype;
	}


	public String getSiteadfa() {
		return siteadfa;
	}


	public void setSiteadfa(String siteadfa) {
		this.siteadfa = siteadfa;
	}


	public String getSiteadli() {
		return siteadli;
	}


	public void setSiteadli(String siteadli) {
		this.siteadli = siteadli;
	}


	public Date getSitcreated() {
		return sitcreated;
	}


	public void setSitcreated(Date sitcreated) {
		this.sitcreated = sitcreated;
	}


	public String getSitupdatby() {
		return situpdatby;
	}


	public void setSitupdatby(String situpdatby) {
		this.situpdatby = situpdatby;
	}


	public Date getSitupdated() {
		return situpdated;
	}


	public void setSitupdated(Date situpdated) {
		this.situpdated = situpdated;
	}


	public APFVILLE getApfville() {
		return apfville;
	}


	public void setApfville(APFVILLE apfville) {
		this.apfville = apfville;
	}


	public Integer getSiteaffichable() {
		return siteaffichable;
	}


	public void setSiteaffichable(Integer siteaffichable) {
		this.siteaffichable = siteaffichable;
	}


	public String getSitenscod() {
		return sitenscod;
	}


	public void setSitenscod(String sitenscod) {
		this.sitenscod = sitenscod;
	}


	public Long getDistribid() {
		return distribid;
	}


	public void setDistribid(Long distribid) {
		this.distribid = distribid;
	}
	

}
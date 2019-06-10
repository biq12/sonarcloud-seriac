package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

// Table des distributeurs  « APFDISTRIB » :
@Entity
@SequenceGenerator(name = "seq_distrib_id",allocationSize=1)
public class APFDISTRIB {
	//distrib
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq_distrib_id")
	private Long DISTRIBID;
    @Column(unique = true)
	private String DISTRIBCOD;
	private String DISTRIBLIB;
	private String  DISTRIBREM;	
	private Date  DISCREATED;
	private String DISUPDATBY;
	private Date  DISUPDATED;
	
	
	public APFDISTRIB(String dISTRIBCOD, String dISTRIBLIB, String dISTRIBREM, Date dISCREATED, String dISUPDATBY,Date dISUPDATED)
	{
		super();
		DISTRIBCOD = dISTRIBCOD;
		DISTRIBLIB = dISTRIBLIB;
		DISTRIBREM = dISTRIBREM;
		DISCREATED = dISCREATED;
		DISUPDATBY = dISUPDATBY;
		DISUPDATED = dISUPDATED;
	}
	public APFDISTRIB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getDISTRIBID() {
		return DISTRIBID;
	}
	public void setDISTRIBID(Long dISTRIBID) {
		DISTRIBID = dISTRIBID;
	}
	public String getDISTRIBCOD() {
		return DISTRIBCOD;
	}
	public void setDISTRIBCOD(String dISTRIBCOD) {
		DISTRIBCOD = dISTRIBCOD;
	}
	public String getDISTRIBLIB() {
		return DISTRIBLIB;
	}
	public void setDISTRIBLIB(String dISTRIBLIB) {
		DISTRIBLIB = dISTRIBLIB;
	}
	public String getDISTRIBREM() {
		return DISTRIBREM;
	}
	public void setDISTRIBREM(String dISTRIBREM) {
		DISTRIBREM = dISTRIBREM;
	}
	public Date getDISCREATED() {
		return DISCREATED;
	}
	public void setDISCREATED(Date dISCREATED) {
		DISCREATED = dISCREATED;
	}
	public String getDISUPDATBY() {
		return DISUPDATBY;
	}
	public void setDISUPDATBY(String dISUPDATBY) {
		DISUPDATBY = dISUPDATBY;
	}
	public Date getDISUPDATED() {
		return DISUPDATED;
	}
	public void setDISUPDATED(Date dISUPDATED) {
		DISUPDATED = dISUPDATED;
	}
	

}


/*
 DISTRIBID	N	NUMBER(9)	N			Id distributeur (Sequenceur) SEQ_DISTRIB_ID
DISTRIBCOD	N	VARCHAR2(12)	N			Code distributeur
DISTRIBLIB	N	VARCHAR2(30)	N			Libelle distributeur
DISTRIBREM	N	VARCHAR2(250)	N			Remarques divers
DISCREATED	N	DATE	N			Date de creation
DISUPDATED	N	DATE	Y			Dernier utilisateur
DISUPDATBY	N	VARCHAR2(30)	Y			date de la derniere mise a jour

 */

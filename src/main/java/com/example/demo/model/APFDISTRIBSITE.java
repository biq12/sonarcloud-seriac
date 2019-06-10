package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class APFDISTRIBSITE {
	@Id
	private Long SITECOD;
	private String SITELIB;
	private int SITETYPE;
	private String SITEADFA;
	private String SITEADLI;	
	private Date SITCREATED;
	private String SITUPDATBY;
	private Date SITUPDATED;
	@ManyToOne()
	@JoinColumn(name = "SITEVILLE")
	private APFVILLE  APFVILLE;
	
	private Integer SITEAFFICHABLE;
	
	////  LES PROBLEMENE RECONTRE DOIT REALISER DES BATCH REGULIER  TOUT EN RESPECTANT SINON ON
	private String SITENSCOD;   ///its s the foreign key of the class Ensigne 

	@ManyToOne()
	@JoinColumn(name = "DISTRIBID")
	private APFDISTRIB   APFDISTRIB;

	
	public APFDISTRIBSITE() {
		super();
	}

	public APFDISTRIBSITE(Long sITECOD, String sITELIB, int sITETYPE, String sITEADFA, String sITEADLI, Date sITCREATED,
			String sITUPDATBY, Date sITUPDATED, com.example.demo.model.APFVILLE aPFVILLE, Integer sITEAFFICHABLE,
			String sITENSCOD, com.example.demo.model.APFDISTRIB aPFDISTRIB) {
		super();
		SITECOD = sITECOD;
		SITELIB = sITELIB;
		SITETYPE = sITETYPE;
		SITEADFA = sITEADFA;
		SITEADLI = sITEADLI;
		SITCREATED = sITCREATED;
		SITUPDATBY = sITUPDATBY;
		SITUPDATED = sITUPDATED;
		APFVILLE = aPFVILLE;
		SITEAFFICHABLE = sITEAFFICHABLE;
		SITENSCOD = sITENSCOD;
		APFDISTRIB = aPFDISTRIB;
	}

	public Long getSITECOD() {
		return SITECOD;
	}

	public void setSITECOD(Long sITECOD) {
		SITECOD = sITECOD;
	}

	public String getSITELIB() {
		return SITELIB;
	}

	public void setSITELIB(String sITELIB) {
		SITELIB = sITELIB;
	}

	public int getSITETYPE() {
		return SITETYPE;
	}

	public void setSITETYPE(int sITETYPE) {
		SITETYPE = sITETYPE;
	}

	public String getSITEADFA() {
		return SITEADFA;
	}

	public void setSITEADFA(String sITEADFA) {
		SITEADFA = sITEADFA;
	}

	public String getSITEADLI() {
		return SITEADLI;
	}

	public void setSITEADLI(String sITEADLI) {
		SITEADLI = sITEADLI;
	}

	public Date getSITCREATED() {
		return SITCREATED;
	}

	public void setSITCREATED(Date sITCREATED) {
		SITCREATED = sITCREATED;
	}

	public String getSITUPDATBY() {
		return SITUPDATBY;
	}

	public void setSITUPDATBY(String sITUPDATBY) {
		SITUPDATBY = sITUPDATBY;
	}

	public Date getSITUPDATED() {
		return SITUPDATED;
	}

	public void setSITUPDATED(Date sITUPDATED) {
		SITUPDATED = sITUPDATED;
	}

	public APFVILLE getAPFVILLE() {
		return APFVILLE;
	}

	public void setAPFVILLE(APFVILLE aPFVILLE) {
		APFVILLE = aPFVILLE;
	}

	public Integer getSITEAFFICHABLE() {
		return SITEAFFICHABLE;
	}

	public void setSITEAFFICHABLE(Integer sITEAFFICHABLE) {
		SITEAFFICHABLE = sITEAFFICHABLE;
	}

	public String getSITENSCOD() {
		return SITENSCOD;
	}

	public void setSITENSCOD(String sITENSCOD) {
		SITENSCOD = sITENSCOD;
	}

	public APFDISTRIB getAPFDISTRIB() {
		return APFDISTRIB;
	}

	public void setAPFDISTRIB(APFDISTRIB aPFDISTRIB) {
		APFDISTRIB = aPFDISTRIB;
	}//////////It s the primary key of Distirbuteur........
	


}

/*

DISTRIBID	N	NUMBER(9)	N			Id distributeur
SITECOD	N	NUMBER(5)	N			Code site
SITELIB	N	VARCHAR2(36)	N			Libelle site
SITETYPE	N	NUMBER(2)	N			Type de site : 0 = magasin, 1 = entrepot
SITEADFA	N	VARCHAR2(255)	N			Adresse de facturation
SITEADLI	N	VARCHAR2(255)	N			Adresse de livraison
SITCREATED	N	DATE	N			Date de creation
SITUPDATED	N	DATE	N			Dernier utilisateur
SITUPDATBY	N	VARCHAR2(30)	N			date de la derniere mise a jour
SITENSCOD	N	VARCHAR2(20)	Y			code enseigne
SITEVILLE	N	VARCHAR2(20)	Y			Ville du site
SITEAFFICHABLE	N	NUMBER(1)	Y			1 ou null le site est affichable 0:non affichable

*/
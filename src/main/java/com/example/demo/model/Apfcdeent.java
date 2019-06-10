package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity 
public class Apfcdeent implements Serializable{
///Classe verifier 

	@Id
	@NotNull
	private Long ECDCINCDE ; //code interne commande

	@NotNull
	@Column(unique=true)
	private String  ECDCEXCDE ;//code externe commande
	

	@ManyToOne()
	@JoinColumn(name = "DISTRIBID")
	private APFDISTRIB APFDISTRIB;  
	
	@ManyToOne()
	@JoinColumn(name = "ECDSITE")
	private APFDISTRIBSITE APFDISTRIBSITE ;  //site

	
	@ManyToOne()
	@JoinColumn(name = "FOURNID")
	private APFFOURN    APFFOURN;//Supplier ID ...
	
	private Long    ECDNFILF  ; //code filiere fournisseur  
	private Integer ECDETATAPF;   ///etat de commande dans applicaiton fournisseur
    private Date	ECDDCOM ;    ///date commande  
    private Date	ECDDLIV ;    //date livraision date heure 
    private Date	ECDDLIM   ;     //date limite de livraison 
	private Integer ECDETAT ;    //   état de la commande *table 502 GOLD 
	private Date    ECDDMAJ  ;      //date de mise a jour gold  
	private Date    ECDDMAJAPF ;   //    Date de mise à jour Application Fournisseur
    private String	ECDUPDATBY  ;//Dernier utilisateur écran
	private Date    ECDUPDATED  ;  //Dernière date modification par écran       
	private Date    ECDCREATED ;   //Date de création      
    private String	FCCNUM  ;  //Code externe contrat commercial
	private String  TYPEEXP  ;
	private Date    DATPRISCOMPTE  ;      //rnedr edans ne pas supplier rien de ce que je vois devant irne de ce que je vois un élement   
	private Integer    PRISCOMPTAUSERV ; // à la fois on a pas triter ces élement rien des test des performances 
	private Long SITECOD;
	

	
	
	public Apfcdeent() {
		super();
	}
	public Apfcdeent(@NotNull Long eCDCINCDE, @NotNull String eCDCEXCDE, com.example.demo.model.APFDISTRIB aPFDISTRIB,
			com.example.demo.model.APFDISTRIBSITE aPFDISTRIBSITE, com.example.demo.model.APFFOURN aPFFOURN,
			Long eCDNFILF, Integer eCDETATAPF, Date eCDDCOM, Date eCDDLIV, Date eCDDLIM, Integer eCDETAT, Date eCDDMAJ,
			Date eCDDMAJAPF, String eCDUPDATBY, Date eCDUPDATED, Date eCDCREATED, String fCCNUM, String tYPEEXP,
			Date dATPRISCOMPTE, Integer pRISCOMPTAUSERV, Long sITECOD) {
		super();
		ECDCINCDE = eCDCINCDE;
		ECDCEXCDE = eCDCEXCDE;
		APFDISTRIB = aPFDISTRIB;
		APFDISTRIBSITE = aPFDISTRIBSITE;
		APFFOURN = aPFFOURN;
		ECDNFILF = eCDNFILF;
		ECDETATAPF = eCDETATAPF;
		ECDDCOM = eCDDCOM;
		ECDDLIV = eCDDLIV;
		ECDDLIM = eCDDLIM;
		ECDETAT = eCDETAT;
		ECDDMAJ = eCDDMAJ;
		ECDDMAJAPF = eCDDMAJAPF;
		ECDUPDATBY = eCDUPDATBY;
		ECDUPDATED = eCDUPDATED;
		ECDCREATED = eCDCREATED;
		FCCNUM = fCCNUM;
		TYPEEXP = tYPEEXP;
		DATPRISCOMPTE = dATPRISCOMPTE;
		PRISCOMPTAUSERV = pRISCOMPTAUSERV;
		SITECOD = sITECOD;
	}
	public Long getECDCINCDE() {
		return ECDCINCDE;
	}
	public void setECDCINCDE(Long eCDCINCDE) {
		ECDCINCDE = eCDCINCDE;
	}
	public String getECDCEXCDE() {
		return ECDCEXCDE;
	}
	public void setECDCEXCDE(String eCDCEXCDE) {
		ECDCEXCDE = eCDCEXCDE;
	}
	public APFDISTRIB getAPFDISTRIB() {
		return APFDISTRIB;
	}
	public void setAPFDISTRIB(APFDISTRIB aPFDISTRIB) {
		APFDISTRIB = aPFDISTRIB;
	}
	public APFDISTRIBSITE getAPFDISTRIBSITE() {
		return APFDISTRIBSITE;
	}
	public void setAPFDISTRIBSITE(APFDISTRIBSITE aPFDISTRIBSITE) {
		APFDISTRIBSITE = aPFDISTRIBSITE;
	}
	public APFFOURN getAPFFOURN() {
		return APFFOURN;
	}
	public void setAPFFOURN(APFFOURN aPFFOURN) {
		APFFOURN = aPFFOURN;
	}
	public Long getECDNFILF() {
		return ECDNFILF;
	}
	public void setECDNFILF(Long eCDNFILF) {
		ECDNFILF = eCDNFILF;
	}

	public Date getECDDCOM() {
		return ECDDCOM;
	}
	public void setECDDCOM(Date eCDDCOM) {
		ECDDCOM = eCDDCOM;
	}
	public Date getECDDLIV() {
		return ECDDLIV;
	}
	public void setECDDLIV(Date eCDDLIV) {
		ECDDLIV = eCDDLIV;
	}
	public Date getECDDLIM() {
		return ECDDLIM;
	}
	public void setECDDLIM(Date eCDDLIM) {
		ECDDLIM = eCDDLIM;
	}
	
	public Date getECDDMAJ() {
		return ECDDMAJ;
	}
	public void setECDDMAJ(Date eCDDMAJ) {
		ECDDMAJ = eCDDMAJ;
	}
	public Date getECDDMAJAPF() {
		return ECDDMAJAPF;
	}
	public void setECDDMAJAPF(Date eCDDMAJAPF) {
		ECDDMAJAPF = eCDDMAJAPF;
	}
	public String getECDUPDATBY() {
		return ECDUPDATBY;
	}
	public void setECDUPDATBY(String eCDUPDATBY) {
		ECDUPDATBY = eCDUPDATBY;
	}
	public Date getECDUPDATED() {
		return ECDUPDATED;
	}
	public void setECDUPDATED(Date eCDUPDATED) {
		ECDUPDATED = eCDUPDATED;
	}
	public Date getECDCREATED() {
		return ECDCREATED;
	}
	public void setECDCREATED(Date eCDCREATED) {
		ECDCREATED = eCDCREATED;
	}
	public String getFCCNUM() {
		return FCCNUM;
	}
	public void setFCCNUM(String fCCNUM) {
		FCCNUM = fCCNUM;
	}
	public String getTYPEEXP() {
		return TYPEEXP;
	}
	public void setTYPEEXP(String tYPEEXP) {
		TYPEEXP = tYPEEXP;
	}
	public Date getDATPRISCOMPTE() {
		return DATPRISCOMPTE;
	}
	public void setDATPRISCOMPTE(Date dATPRISCOMPTE) {
		DATPRISCOMPTE = dATPRISCOMPTE;
	}
	public Integer getECDETATAPF() {
		return ECDETATAPF;
	}
	public void setECDETATAPF(Integer eCDETATAPF) {
		ECDETATAPF = eCDETATAPF;
	}
	public Integer getECDETAT() {
		return ECDETAT;
	}
	public void setECDETAT(Integer eCDETAT) {
		ECDETAT = eCDETAT;
	}
	public Integer getPRISCOMPTAUSERV() {
		return PRISCOMPTAUSERV;
	}
	public void setPRISCOMPTAUSERV(Integer pRISCOMPTAUSERV) {
		PRISCOMPTAUSERV = pRISCOMPTAUSERV;
	}
	public Long getSITECOD() {
		return SITECOD;
	}
	public void setSITECOD(Long sITECOD) {
		SITECOD = sITECOD;
	}



}
/***

ECDCINCDE	N	NUMBER(9)	N			Code interne commande
ECDCEXCDE	N	VARCHAR2(13)	N			Code externe commande
DISTRIBID	N	NUMBER(9)	N			Id distributeur dans application fournisseur*
ECDSITE	N	NUMBER(5)	N			Site
FOURNID	N	NUMBER(9)	N			Id Fournisseur dans application fournisseur*
ECDNFILF	N	NUMBER(5)	N			Code filiere fournisseur 
ECDETATAPF	N	NUMBER(2)	N			etat de commande dans application fournisseur
ECDDCOM	N	DATE	N			Date de commande
ECDDLIV	N	DATE	N			Date de livraison prevue (date et heure)
ECDDLIM	N	DATE	N			Date limite de livraison (date et heure) 
ECDETAT	N	NUMBER(3)	N			etat de la commande *table 502 GOLD 
ECDDMAJ	N	DATE	N			Date de mise a jour GOLD
ECDDMAJAPF	N	DATE	N			Date mise a jour ProC
ECDUPDATBY	N	VARCHAR2(30)	N			Dernier utilisateur
ECDUPDATED	N	DATE	N			Derniere date mise a jour ecran
ECDCREATED	N	DATE	N			Date de creation
FCCNUM	N	VARCHAR2(8)	N			Code externe contrat commercial
TYPEEXP	N	VARCHAR2(1)	N	'N'		Type d'expedition - N=Non definie - M:manuel - A:Automatique
DATPRISCOMPTE	N	DATE	Y			date prise en compte par le fournisseur
PRISCOMPTAUSERV	N	NUMBER(1)	Y	0		flag prise en comppte taux service (0=non flague, 1=flague)
	N		Y			




*/
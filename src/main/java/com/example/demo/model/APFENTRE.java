package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class APFENTRE {
@Id
private Long    SERCINREC	;//N	NUMBER(8)	N			NO RECEPTION INTERNE
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name = "SERSITE")
private APFDISTRIBSITE APFDISTRIBSITE;
private Long DISTRIBID;//	N	NUMBER(9)	N			Id distributeur dans application fournisseur*
private Date SERDREC ;//	N	DATE	N			Date de reception (date et heure)
@ManyToOne()
@JoinColumn(name = "FOURNID")
private APFFOURN    APFFOURN;//Supplier IDX .
private String   FCCNUM	;//N	VARCHAR2(8)	N			Code externe contrat commercial
private Long     SERFILF	  ;//N	NUMBER(5)	N			Code filiere fournisseur
private Long    SERCINCDE  ;//	N	NUMBER(9)	N			Code interne commande
private String	SERNUSR;  //	N	VARCHAR2(13)	N			No reception utilisateur
private String	SERTRAN;  //	N	VARCHAR2(15)	Y			Nom du transporteur
private String	SERBLIV	;  //N	VARCHAR2(15)	Y			Code externe bon de livraison
private Date    SERDECP ;//	N	DATE	Y			        Date echeance prevue
private Date	SERDCOM	;//N	DATE	N			        Date de commande
private String	SERMREG	 ;//N	VARCHAR2(250)	Y			Code mode de reglement *Table 5
private String	SERMODE ;//N	VARCHAR2(250)	Y		Mode de compensation *Table 510
private Date	SERDCRE	;//N	DATE	N			        Date de creation
private Date	SERDMAJ	 ;//N	DATE	N			        Date de derniere mise a jour
private String	SERCEXCDE ;//	N	VARCHAR2(13)	        Code externe commande
private Date	SERDRECR;//	N	DATE	N		         	Date reelle de reception
private Date	SERDLIVP;//	N	DATE	N			        Date de livraison prevue
private Integer	SERTMVT ;//	N	NUMBER(1)	N			        Type de mouvement 
private String	 SERETAFACRET ; //	N	VARCHAR2(255)	Y	'Non Traitee'		Etat facture en cas de retour
private String 	 SERNUMTRAIT	 ;//N	VARCHAR2(30)	Y	Numero de traite
private String 		SERCODMODE ;//	N	VARCHAR2(30)	Y	Code mode compensation
private String 		SERUPDATBY	;//N	VARCHAR2(30)	Y	Dernier utilisateur
private Date	SERCREATED ;//	N	DATE	Y			    Date de creation
private Date	SERUPDATED ;//	N	DATE	Y			    Derniere date mise a jour ecran
private Long 	SERNUMRET ;//	N	NUMBER(9)	Y			Numero de retour
private Long	SERETATBURORD ;//	N	NUMBER(3)	Y		Etat Facture bureau ordre 1=Rapproche 0=En litige
private Long	SERNUMSEQFAC	;//N	NUMBER(20)	Y		Numero de sequence de la facture
private String	SERNUMFAC;//N	VARCHAR2(31)	Y			Numero de facture bureau ordre
private Date	SERFACDATDEP ;//	N	DATE	Y			Date depot facture
private Long	SERETATREC ;//	N	NUMBER(3)	Y			Etat entete reception 
private String		SERNEDIT ;//	N	VARCHAR2(22 CHAR)	En RIS:Numero Util -En GOLD:Numero de bordereau d edition de l entete de reception ou de retour



public APFENTRE() {
	super();
}
public Long getSERCINREC() {
	return SERCINREC;
}
public void setSERCINREC(Long sERCINREC) {
	SERCINREC = sERCINREC;
}


public APFDISTRIBSITE getAPFDISTRIBSITE() {
	return APFDISTRIBSITE;
}
public void setAPFDISTRIBSITE(APFDISTRIBSITE aPFDISTRIBSITE) {
	APFDISTRIBSITE = aPFDISTRIBSITE;
}
public Long getDISTRIBID() {
	return DISTRIBID;
}
public void setDISTRIBID(Long dISTRIBID) {
	DISTRIBID = dISTRIBID;
}
public Date getSERDREC() {
	return SERDREC;
}
public void setSERDREC(Date sERDREC) {
	SERDREC = sERDREC;
}

 
public APFFOURN getAPFFOURN() {
	return APFFOURN;
}
public void setAPFFOURN(APFFOURN aPFFOURN) {
	APFFOURN = aPFFOURN;
}
public String getFCCNUM() {
	return FCCNUM;
}
public void setFCCNUM(String fCCNUM) {
	FCCNUM = fCCNUM;
}
public Long getSERFILF() {
	return SERFILF;
}
public void setSERFILF(Long sERFILF) {
	SERFILF = sERFILF;
}
public Long getSERCINCDE() {
	return SERCINCDE;
}
public void setSERCINCDE(Long sERCINCDE) {
	SERCINCDE = sERCINCDE;
}
public String getSERNUSR() {
	return SERNUSR;
}
public void setSERNUSR(String sERNUSR) {
	SERNUSR = sERNUSR;
}
public String getSERTRAN() {
	return SERTRAN;
}
public void setSERTRAN(String sERTRAN) {
	SERTRAN = sERTRAN;
}
public String getSERBLIV() {
	return SERBLIV;
}
public void setSERBLIV(String sERBLIV) {
	SERBLIV = sERBLIV;
}
public Date getSERDECP() {
	return SERDECP;
}
public void setSERDECP(Date sERDECP) {
	SERDECP = sERDECP;
}
public Date getSERDCOM() {
	return SERDCOM;
}
public void setSERDCOM(Date sERDCOM) {
	SERDCOM = sERDCOM;
}
public String getSERMREG() {
	return SERMREG;
}
public void setSERMREG(String sERMREG) {
	SERMREG = sERMREG;
}
public String getSERMODE() {
	return SERMODE;
}
public void setSERMODE(String sERMODE) {
	SERMODE = sERMODE;
}
public Date getSERDCRE() {
	return SERDCRE;
}
public void setSERDCRE(Date sERDCRE) {
	SERDCRE = sERDCRE;
}
public Date getSERDMAJ() {
	return SERDMAJ;
}
public void setSERDMAJ(Date sERDMAJ) {
	SERDMAJ = sERDMAJ;
}
public String getSERCEXCDE() {
	return SERCEXCDE;
}
public void setSERCEXCDE(String sERCEXCDE) {
	SERCEXCDE = sERCEXCDE;
}
public Date getSERDRECR() {
	return SERDRECR;
}
public void setSERDRECR(Date sERDRECR) {
	SERDRECR = sERDRECR;
}
public Date getSERDLIVP() {
	return SERDLIVP;
}
public void setSERDLIVP(Date sERDLIVP) {
	SERDLIVP = sERDLIVP;
}
public Integer getSERTMVT() {
	return SERTMVT;
}
public void setSERTMVT(Integer sERTMVT) {
	SERTMVT = sERTMVT;
}
public String getSERETAFACRET() {
	return SERETAFACRET;
}
public void setSERETAFACRET(String sERETAFACRET) {
	SERETAFACRET = sERETAFACRET;
}
public String getSERNUMTRAIT() {
	return SERNUMTRAIT;
}
public void setSERNUMTRAIT(String sERNUMTRAIT) {
	SERNUMTRAIT = sERNUMTRAIT;
}
public String getSERCODMODE() {
	return SERCODMODE;
}
public void setSERCODMODE(String sERCODMODE) {
	SERCODMODE = sERCODMODE;
}
public String getSERUPDATBY() {
	return SERUPDATBY;
}
public void setSERUPDATBY(String sERUPDATBY) {
	SERUPDATBY = sERUPDATBY;
}
public Date getSERCREATED() {
	return SERCREATED;
}
public void setSERCREATED(Date sERCREATED) {
	SERCREATED = sERCREATED;
}
public Date getSERUPDATED() {
	return SERUPDATED;
}
public void setSERUPDATED(Date sERUPDATED) {
	SERUPDATED = sERUPDATED;
}
public Long getSERNUMRET() {
	return SERNUMRET;
}
public void setSERNUMRET(Long sERNUMRET) {
	SERNUMRET = sERNUMRET;
}
public Long getSERETATBURORD() {
	return SERETATBURORD;
}
public void setSERETATBURORD(Long sERETATBURORD) {
	SERETATBURORD = sERETATBURORD;
}
public Long getSERNUMSEQFAC() {
	return SERNUMSEQFAC;
}
public void setSERNUMSEQFAC(Long sERNUMSEQFAC) {
	SERNUMSEQFAC = sERNUMSEQFAC;
}
public String getSERNUMFAC() {
	return SERNUMFAC;
}
public void setSERNUMFAC(String sERNUMFAC) {
	SERNUMFAC = sERNUMFAC;
}
public Date getSERFACDATDEP() {
	return SERFACDATDEP;
}
public void setSERFACDATDEP(Date sERFACDATDEP) {
	SERFACDATDEP = sERFACDATDEP;
}
public Long getSERETATREC() {
	return SERETATREC;
}
public void setSERETATREC(Long sERETATREC) {
	SERETATREC = sERETATREC;
}
public String getSERNEDIT() {
	return SERNEDIT;
}
public void setSERNEDIT(String sERNEDIT) {
	SERNEDIT = sERNEDIT;
}













}

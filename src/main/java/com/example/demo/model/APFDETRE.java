package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class APFDETRE implements Serializable{

/*
//primary key  CLEPRIMAIREDETREC	Primary	DISTRIBID, SDRCINREC, SDRNLREC, SDRNLIGP	Y				N	N	02/08/2017 20:00:43
*/
@Id	
private Long    SDRCINR ;//	N	NUMBER(9)	N			Code interne article racine


@ManyToOne()
@JoinColumn(name = "SDRCINREC")
private APFENTRE SDRENTRE; //receptio n jointure

private Long  SDRNLREC;//	N	NUMBER(5)	N			No de ligne de reception
private Long  SDRNLIGP;//	N	NUMBER(9)	N			No de ligne de prix

@ManyToOne()
@JoinColumn(name = "SDRSITE")
private APFDISTRIBSITE DISTRIBSITE;
@ManyToOne()
@JoinColumn(name = "DISTRIBID")
private APFDISTRIB  DISTRIB; 

private Date    SDRSDRC;//	N	DATE	N			Date de reception
@ManyToOne()
@JoinColumn(name = "SDRCINCDE")
private Apfcdeent COMMANDE;//	N	NUMBER(9)	N			Code interne commande
private String  SDRNLCDE	; //N	VARCHAR2(13)	Y			No de ligne de commande
private String    SDRCODE;//	N	VARCHAR2(20)	Y			Code article receptionne
private Long      FOURNID	;//N	NUMBER(9)	N			Id Fournisseur dans application fournisseur*
private  String   FCCNUM ;//	N	VARCHAR2(8)	N			 Code externe contrat 
private  Long     SDRQTEA ;//	N	NUMBER(9,3)	N			Quantite recue
private  Long     SDRPDSA	;//N	NUMBER(9,3)	N			Poids recu
private  Long     SDRQTER;//	N	NUMBER(9,3)	N			Quantite refusee
private  String   SDRMOTI;//	N	VARCHAR2(250)	Y			Motif de refus *Table 505
private  Date     SDRDMAJ	;//N	DATE	N			Date de derniere mise a jour
private  Long     SDRPDSR;//	N	NUMBER(9,3)	N			Poids refuse
private  Long     SDRQTEF;//	N	NUMBER(9,3)	N			Quantite en gratuit inconditionnel
private  Long     SDRPDSF	;//N	NUMBER(9,3)	N			Poids en gratuit inconditionnel
private  Long     SDRPBFA;//	N	NUMBER(15,5)	Y			Prix achat brut facture
private  Long     SDRPNFA;//	N	NUMBER(15,5)	Y			Prix net facture
private  Long     SDRPRIA;//	N	NUMBER(15,5)	Y			Prix net achat stock (la difference avec le prix net facture c'est que celui ci prends en compte les remises pieds et les gratuites)
private  String   SDRARTLIB;//	N	VARCHAR2(250)	Y			libelle article receptionne
private  String   SDRGPDS;//N	VARCHAR2(30)	Y			Unite de stock
private  String   SDRTYPUL;//	N	VARCHAR2(30)	Y			Code Type UL
private  Long     SDRUAUVC	;//N	NUMBER(9,3)	Y			Coefficient de conversion d'UA a UVC
private  String   SDRUPDATBY;//	N	VARCHAR2(30)	Y			Dernier utilisateur
private Date      SDRCREATED;//	N	DATE	Y			Date de creation
private Date      SDRUPDATED	;//N	DATE	Y			Derniere date mise a jour ecran


public APFDETRE() {
	super();
}


public APFENTRE getSDRENTRE() {
	return SDRENTRE;
}


public void setSDRENTRE(APFENTRE sDRENTRE) {
	SDRENTRE = sDRENTRE;
}


public Long getSDRNLREC() {
	return SDRNLREC;
}
public void setSDRNLREC(Long sDRNLREC) {
	SDRNLREC = sDRNLREC;
}
public Long getSDRNLIGP() {
	return SDRNLIGP;
}
public void setSDRNLIGP(Long sDRNLIGP) {
	SDRNLIGP = sDRNLIGP;
}

public APFDISTRIBSITE getDISTRIBSITE() {
	return DISTRIBSITE;
}
public void setDISTRIBSITE(APFDISTRIBSITE dISTRIBSITE) {
	DISTRIBSITE = dISTRIBSITE;
}

public APFDISTRIB getDISTRIB() {
	return DISTRIB;
}
public void setDISTRIB(APFDISTRIB dISTRIB) {
	DISTRIB = dISTRIB;
}
public Date getSDRSDRC() {
	return SDRSDRC;
}


public void setSDRSDRC(Date sDRSDRC) {
	SDRSDRC = sDRSDRC;
}


public Apfcdeent getCOMMANDE() {
	return COMMANDE;
}
public void setCOMMANDE(Apfcdeent cOMMANDE) {
	COMMANDE = cOMMANDE;
}
public String getSDRNLCDE() {
	return SDRNLCDE;
}
public void setSDRNLCDE(String sDRNLCDE) {
	SDRNLCDE = sDRNLCDE;
}
public Long getSDRCINR() {
	return SDRCINR;
}
public void setSDRCINR(Long sDRCINR) {
	SDRCINR = sDRCINR;
}
public String getSDRCODE() {
	return SDRCODE;
}
public void setSDRCODE(String sDRCODE) {
	SDRCODE = sDRCODE;
}
public Long getFOURNID() {
	return FOURNID;
}
public void setFOURNID(Long fOURNID) {
	FOURNID = fOURNID;
}
public String getFCCNUM() {
	return FCCNUM;
}
public void setFCCNUM(String fCCNUM) {
	FCCNUM = fCCNUM;
}
public Long getSDRQTEA() {
	return SDRQTEA;
}
public void setSDRQTEA(Long sDRQTEA) {
	SDRQTEA = sDRQTEA;
}
public Long getSDRPDSA() {
	return SDRPDSA;
}
public void setSDRPDSA(Long sDRPDSA) {
	SDRPDSA = sDRPDSA;
}
public Long getSDRQTER() {
	return SDRQTER;
}
public void setSDRQTER(Long sDRQTER) {
	SDRQTER = sDRQTER;
}
public String getSDRMOTI() {
	return SDRMOTI;
}
public void setSDRMOTI(String sDRMOTI) {
	SDRMOTI = sDRMOTI;
}
public Date getSDRDMAJ() {
	return SDRDMAJ;
}
public void setSDRDMAJ(Date sDRDMAJ) {
	SDRDMAJ = sDRDMAJ;
}
public Long getSDRPDSR() {
	return SDRPDSR;
}
public void setSDRPDSR(Long sDRPDSR) {
	SDRPDSR = sDRPDSR;
}
public Long getSDRQTEF() {
	return SDRQTEF;
}
public void setSDRQTEF(Long sDRQTEF) {
	SDRQTEF = sDRQTEF;
}
public Long getSDRPDSF() {
	return SDRPDSF;
}
public void setSDRPDSF(Long sDRPDSF) {
	SDRPDSF = sDRPDSF;
}
public Long getSDRPBFA() {
	return SDRPBFA;
}
public void setSDRPBFA(Long sDRPBFA) {
	SDRPBFA = sDRPBFA;
}
public Long getSDRPNFA() {
	return SDRPNFA;
}
public void setSDRPNFA(Long sDRPNFA) {
	SDRPNFA = sDRPNFA;
}
public Long getSDRPRIA() {
	return SDRPRIA;
}
public void setSDRPRIA(Long sDRPRIA) {
	SDRPRIA = sDRPRIA;
}
public String getSDRARTLIB() {
	return SDRARTLIB;
}
public void setSDRARTLIB(String sDRARTLIB) {
	SDRARTLIB = sDRARTLIB;
}
public String getSDRGPDS() {
	return SDRGPDS;
}
public void setSDRGPDS(String sDRGPDS) {
	SDRGPDS = sDRGPDS;
}
public String getSDRTYPUL() {
	return SDRTYPUL;
}
public void setSDRTYPUL(String sDRTYPUL) {
	SDRTYPUL = sDRTYPUL;
}
public Long getSDRUAUVC() {
	return SDRUAUVC;
}
public void setSDRUAUVC(Long sDRUAUVC) {
	SDRUAUVC = sDRUAUVC;
}
public String getSDRUPDATBY() {
	return SDRUPDATBY;
}
public void setSDRUPDATBY(String sDRUPDATBY) {
	SDRUPDATBY = sDRUPDATBY;
}
public Date getSDRCREATED() {
	return SDRCREATED;
}
public void setSDRCREATED(Date sDRCREATED) {
	SDRCREATED = sDRCREATED;
}
public Date getSDRUPDATED() {
	return SDRUPDATED;
}
public void setSDRUPDATED(Date sDRUPDATED) {
	SDRUPDATED = sDRUPDATED;
}















}

package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Apfcdedet {

@Id	
private Long     DCDCINR	;//		code interne article racine
@NotNull
@Column(unique=true)
private String    DCDNOLIGN ;    //no de ligne 
private Long      ECDCINCDE  ;         //code interne commande
private String    ECDCEXCDE ;      //code externe commande

@ManyToOne()
@JoinColumn(name = "DCDSITE")
private APFDISTRIBSITE DISTRIBSITE ;  //site




private String    ARCCODE ;           //code caisse our code ean
private String    STOBDESC ;          // Libelle article : jointure avec la table 
private String    DCDTYPUL  ;        //Code interne ULdcdtypul
private Long      DCDPCU  ;           // Poids ** contenance UVC
private Long      DCDQTEC ;           //Quantité commandée en UVC

private Long      DISTRIBID   ;   
private Long      FOURNID   ;    

private Long      TVATAUX   ;       // Taux de la TVA : jointure avec TVAS des champs CDEDETCDE.DCDCTVA et TVAS.TVACODE
private Long      DCDETATAPF ;  
private Long      DCDPRIX  ;       //prix achat brut (quantitative incl. et en devise)


private Date      DCDCREATED ;     //Date de création   
private String    DCDUPDATBY ;     //Dernier utilisateur
private Date      DCDUPDATED ;     //date de la dernière mise a jour    
private Date      DCDDMAJAPF ;     //Date de mise à jour Application Fournisseur


private Long      DCDQTPREAPFUVC   ;  //Dernières quantités préparées en UVC
private Long      DCDQTEXPAPFUVC   ;  //Somme des quantités expédiées en UVC
private Long      DCDETAT        ; //Etat GOLD de la ligne   
private Long      DCDUAUVC     ;   //Coefficient de conversion d'UA a UVC

//commande o réception ? 

private Long      DCDQTPREAPFUA;//		Dernieres quantites preparees en UA
private Long      DCDQTEXPAPFUA	;//			Somme des quantites expediees en UA
private String    DCDUAPP	;//			Prix d'unite d'application
private String    DCDGPDS	;//			Unite de stock

private Long      DCDQTEXPAPFPOID	;//		Somme des quantites expediees en Poids
private Long      DCDQTPREAPFPOID	;//		Dernieres quantites preparees en Poids
private Long      DCDUAUT    ;    ///Nombre d'unite de tarif par unite d'achat


private String  DCDOSEXT;	//	Code externe OS
private String  DCDCEXOS;//			Code Externe OS
private Integer     DCDINCLUS	;//		Flag inclusion dans le taux de service de marjane 1:inclue - 0:exclue 
private Long    DCDPVSA	;//		Prix de valorisation stocks achat
private Long    DCDPRFA	;//Prix net sur facture



public Apfcdedet() {
	super();
	// TODO Auto-generated constructor stub
}

public APFDISTRIBSITE getDISTRIBSITE() {
	return DISTRIBSITE;
}

public void setDISTRIBSITE(APFDISTRIBSITE dISTRIBSITE) {
	DISTRIBSITE = dISTRIBSITE;
}

public Integer getDCDINCLUS() {
	return DCDINCLUS;
}

public void setDCDINCLUS(Integer dCDINCLUS) {
	DCDINCLUS = dCDINCLUS;
}

public String getDCDTYPUL() {
	return DCDTYPUL;
}
public void setDCDTYPUL(String dCDTYPUL) {
	DCDTYPUL = dCDTYPUL;
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
public String getDCDNOLIGN() {
	return DCDNOLIGN;
}
public void setDCDNOLIGN(String dCDNOLIGN) {
	DCDNOLIGN = dCDNOLIGN;
}

public String getARCCODE() {
	return ARCCODE;
}
public void setARCCODE(String aRCCODE) {
	ARCCODE = aRCCODE;
}
public String getSTOBDESC() {
	return STOBDESC;
}
public void setSTOBDESC(String sTOBDESC) {
	STOBDESC = sTOBDESC;
}

public Long getDCDPCU() {
	return DCDPCU;
}
public void setDCDPCU(Long dCDPCU) {
	DCDPCU = dCDPCU;
}
public Long getDCDQTEC() {
	return DCDQTEC;
}
public void setDCDQTEC(Long dCDQTEC) {
	DCDQTEC = dCDQTEC;
}
public Long getDISTRIBID() {
	return DISTRIBID;
}
public void setDISTRIBID(Long dISTRIBID) {
	DISTRIBID = dISTRIBID;
}
public Long getFOURNID() {
	return FOURNID;
}
public void setFOURNID(Long fOURNID) {
	FOURNID = fOURNID;
}
public Long getTVATAUX() {
	return TVATAUX;
}
public void setTVATAUX(Long tVATAUX) {
	TVATAUX = tVATAUX;
}
public Long getDCDETATAPF() {
	return DCDETATAPF;
}
public void setDCDETATAPF(Long dCDETATAPF) {
	DCDETATAPF = dCDETATAPF;
}
public Long getDCDPRIX() {
	return DCDPRIX;
}
public void setDCDPRIX(Long dCDPRIX) {
	DCDPRIX = dCDPRIX;
}
public Date getDCDCREATED() {
	return DCDCREATED;
}
public void setDCDCREATED(Date dCDCREATED) {
	DCDCREATED = dCDCREATED;
}
public String getDCDUPDATBY() {
	return DCDUPDATBY;
}
public void setDCDUPDATBY(String dCDUPDATBY) {
	DCDUPDATBY = dCDUPDATBY;
}
public Date getDCDUPDATED() {
	return DCDUPDATED;
}
public void setDCDUPDATED(Date dCDUPDATED) {
	DCDUPDATED = dCDUPDATED;
}
public Date getDCDDMAJAPF() {
	return DCDDMAJAPF;
}
public void setDCDDMAJAPF(Date dCDDMAJAPF) {
	DCDDMAJAPF = dCDDMAJAPF;
}
public Long getDCDQTPREAPFUVC() {
	return DCDQTPREAPFUVC;
}
public void setDCDQTPREAPFUVC(Long dCDQTPREAPFUVC) {
	DCDQTPREAPFUVC = dCDQTPREAPFUVC;
}
public Long getDCDQTEXPAPFUVC() {
	return DCDQTEXPAPFUVC;
}
public void setDCDQTEXPAPFUVC(Long dCDQTEXPAPFUVC) {
	DCDQTEXPAPFUVC = dCDQTEXPAPFUVC;
}
public Long getDCDETAT() {
	return DCDETAT;
}
public void setDCDETAT(Long dCDETAT) {
	DCDETAT = dCDETAT;
}
public Long getDCDUAUVC() {
	return DCDUAUVC;
}
public void setDCDUAUVC(Long dCDUAUVC) {
	DCDUAUVC = dCDUAUVC;
}
public Long getDCDQTPREAPFUA() {
	return DCDQTPREAPFUA;
}
public void setDCDQTPREAPFUA(Long dCDQTPREAPFUA) {
	DCDQTPREAPFUA = dCDQTPREAPFUA;
}
public Long getDCDQTEXPAPFUA() {
	return DCDQTEXPAPFUA;
}
public void setDCDQTEXPAPFUA(Long dCDQTEXPAPFUA) {
	DCDQTEXPAPFUA = dCDQTEXPAPFUA;
}
public String getDCDUAPP() {
	return DCDUAPP;
}
public void setDCDUAPP(String dCDUAPP) {
	DCDUAPP = dCDUAPP;
}
public String getDCDGPDS() {
	return DCDGPDS;
}
public void setDCDGPDS(String dCDGPDS) {
	DCDGPDS = dCDGPDS;
}
public Long getDCDCINR() {
	return DCDCINR;
}
public void setDCDCINR(Long dCDCINR) {
	DCDCINR = dCDCINR;
}
public Long getDCDQTEXPAPFPOID() {
	return DCDQTEXPAPFPOID;
}
public void setDCDQTEXPAPFPOID(Long dCDQTEXPAPFPOID) {
	DCDQTEXPAPFPOID = dCDQTEXPAPFPOID;
}
public Long getDCDQTPREAPFPOID() {
	return DCDQTPREAPFPOID;
}
public void setDCDQTPREAPFPOID(Long dCDQTPREAPFPOID) {
	DCDQTPREAPFPOID = dCDQTPREAPFPOID;
}
public Long getDCDUAUT() {
	return DCDUAUT;
}
public void setDCDUAUT(Long dCDUAUT) {
	DCDUAUT = dCDUAUT;
}
public String getDCDOSEXT() {
	return DCDOSEXT;
}
public void setDCDOSEXT(String dCDOSEXT) {
	DCDOSEXT = dCDOSEXT;
}
public String getDCDCEXOS() {
	return DCDCEXOS;
}
public void setDCDCEXOS(String dCDCEXOS) {
	DCDCEXOS = dCDCEXOS;
}

public Long getDCDPVSA() {
	return DCDPVSA;
}
public void setDCDPVSA(Long dCDPVSA) {
	DCDPVSA = dCDPVSA;
}
public Long getDCDPRFA() {
	return DCDPRFA;
}
public void setDCDPRFA(Long dCDPRFA) {
	DCDPRFA = dCDPRFA;
} 


}

/*********************
 
ECDCINCDE	N	NUMBER(9)	N			Code interne commande
ECDCEXCDE	N	VARCHAR2(13)	N			Code externe commande
DCDNOLIGN	N	VARCHAR2(13)	N			no de ligne
DCDSITE	N	NUMBER(5)	N			code site
ARCCODE	N	VARCHAR2(14)	N			Code caisse  ou code EAN
STOBDESC	N	VARCHAR2(60)	N			Libelle article : jointure avec la table 
DCDTYPUL	N	VARCHAR2(30)	N			Code interne UL
DCDPCU	N	NUMBER(8,3)	N			Poids/contenance UVC
DCDQTEC	N	NUMBER(9,3)	N			Quantite commandee en UVC
DISTRIBID	N	NUMBER(9)	N			Id distributeur dans application fournisseur
FOURNID	N	NUMBER(9)	N			Id fournisseur dans application fournisseur
TVATAUX	N	NUMBER(5,2)	N			Taux de la TVA
DCDETATAPF	N	NUMBER(3)	Y			Etat commande dans Application Fournisseur
DCDPRIX	N	NUMBER(15,5)	Y			prix achat brut (quantitative incl. et en devise)
DCDCREATED	N	DATE	Y			Date de creation
DCDUPDATBY	N	VARCHAR2(30)	Y			Dernier utilisateur
DCDUPDATED	N	DATE	Y			date de la derniere mise a jour
DCDDMAJAPF	N	DATE	Y			Date de mise a jour Application Fournisseur
DCDQTPREAPFUVC	N	NUMBER(9,3)	Y			Dernieres quantites preparees en UVC
DCDQTEXPAPFUVC	N	NUMBER(9,3)	Y			Somme des quantites expediees en UVC
DCDETAT	N	NUMBER(3)	Y			Etat GOLD de la ligne
DCDUAUVC	N	NUMBER(9,3)	Y			Coefficient de conversion d'UA a UVC
DCDQTPREAPFUA	N	NUMBER(9,3)	Y			Dernieres quantites preparees en UA
DCDQTEXPAPFUA	N	NUMBER(9,3)	Y			Somme des quantites expediees en UA
DCDUAPP	N	VARCHAR2(30)	Y			Prix d'unite d'application
DCDGPDS	N	VARCHAR2(30)	Y			Unite de stock
DCDCINR	N	NUMBER(9)	N			code interne article racine
DCDQTEXPAPFPOID	N	NUMBER(9,3)	Y			Somme des quantites expediees en Poids
DCDQTPREAPFPOID	N	NUMBER(9,3)	Y			Dernieres quantites preparees en Poids
DCDUAUT	N	NUMBER(9,3)	N			Nombre d'unite de tarif par unite d'achat
DCDOSEXT	N	VARCHAR2(13)	Y			Code externe OS
DCDCEXOS	N	VARCHAR2(13)	Y			Code Externe OS
DCDINCLUS	N	NUMBER(2)	Y	0		Flag inclusion dans le taux de service de marjane 1:inclue - 0:exclue 
DCDPVSA	N	NUMBER(20,10)	Y			Prix de valorisation stocks achat
DCDPRFA	N	NUMBER(20,10)	Y			Prix net sur facture


  
 */

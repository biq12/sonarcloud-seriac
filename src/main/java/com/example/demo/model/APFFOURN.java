package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@SequenceGenerator(name = "Seq_Fourn_Id",allocationSize=1)
public class APFFOURN {
	//verifier
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Seq_Fourn_Id")
	private Long FOURNID;
	@Column(unique = true)
	private String FOURCOD	;//	Code fournisseur
	private String  FOURLIB	;	//	Libelle fournisseur
	private String FOURCON	;//			Contact
	private Date  FOUCREATED	;	//	Date de creation
	private String   FOUUPDATBY	;  //			Dernier utilisateur
	private Date    FOUUPDATED	;//		date de la derniere mise a jour
	
	private String     FOUCOMMENT;//	N	VARCHAR2(255)	Y			Commentaire
	private String     NOTE		;//	Note Fournisseur
	private String     COMMANDEA	;//	commande a - Fournisseur
	private String     REGLERA	;//- Fournisseur
	private String    FACTURERPAR	;//		facturer par - Fournisseur
	private String     LIVRERPAR	;//- Fournisseur

	private String    LOGO	;//		Logo fournisseur
	private String    FOURNUMTEL	;//		Numero telephone fournisseur
	private String    FOUREMAIL;//		Email fournisseur
	private String   FOURRIB;//			RIB fournisseur
	private String   FOURTYPSOCIETE	;//			Type Societe
	private String   FOURIDENTIFSTE	;//			Identifiant de la societe
	private String   FOURCAPITAL	;//			Capital

	private Integer  FOURABONN	;//		Flag abbonement 0=Non Abonne 1=Abonne 2=Bloque
	private Integer  FOURETAT	;//		Etat fournisseur 1=Actif 2=Gele 3=Supprime table RIS ...
	
	private Date   FOURDATABON	;//	Date abonnement fournisseur
	
	private Integer FOURPURGEVENT  ;	//		Purger les ventes : 1=Non 0 ou null=Oui
	private Integer  FOURPURGECMD	;//		Purger les commandes : 1=Non 0 ou null=Oui
	private Integer FOURPURGEREC   ;//		Purger les receptions : 1=Non 0 ou null=Oui
	private Integer FOURPURGEREG	;//		Purger les Reglements: 1=Non 0 ou null=Oui
	private Integer FOURPURGERFA	;//		Purger les Rfa: 1=Non 0 ou null=Oui
	private Integer FOURPURGEBURORD	;//			Purger les factures  bureau ordre + reception avec facture non parvenues  : 1=Non 0 ou null=Oui
	private Integer FOURPURGESTATCMD	;//			Purger les stat. taux de services : 1=Non 0 ou null=Oui
	private Integer FOURVALTX	;//			Visualisation Valorisation Taux de rupture 1:Oui - 0 ou null non
	@Null
	private Integer FOUREXPSTAT	;//			Ensemble d un fournisseur pour un type d export des statistiques de vente (1,2,3...)
	
	private String  FOURMSGFRS	;//		Message affiche au fournisseur par le distributeur
	private Date  FOURDDEBMSG	;//		Date debut affichage message
	private Date  FOURDFINMSG	;//			Date fin affichage message
	private int FOURABONNWS	;//		Flag abbonement Web Service 0=Non Abonne 1=Abonne
	private Date  FOURDATDESABON;//	Date dasabonnement du portail
	private Long  FOURNBRACCESWSJOUR	;//		Nombre limite d acces au portail par web Service
	private String    RAYON	;
	
	
	
	
	public APFFOURN() {
		super();
		// TODO Auto-generated constructor stub
	}

	



	public APFFOURN(String fOURCOD, String fOURLIB, String fOURCON, Date fOUCREATED, String fOUUPDATBY, Date fOUUPDATED,
			String fOUCOMMENT, String nOTE, String cOMMANDEA, String rEGLERA, String fACTURERPAR, String lIVRERPAR,
			String lOGO, String fOURNUMTEL, String fOUREMAIL, String fOURRIB, String fOURTYPSOCIETE,
			String fOURIDENTIFSTE, String fOURCAPITAL, Integer fOURABONN, Integer fOURETAT, Date fOURDATABON,
			Integer fOURPURGEVENT, Integer fOURPURGECMD, Integer fOURPURGEREC, Integer fOURPURGEREG,
			Integer fOURPURGERFA, Integer fOURPURGEBURORD, Integer fOURPURGESTATCMD, Integer fOURVALTX,
			@Null Integer fOUREXPSTAT, String fOURMSGFRS, Date fOURDDEBMSG, Date fOURDFINMSG, int fOURABONNWS,
			Date fOURDATDESABON, Long fOURNBRACCESWSJOUR, String rAYON) {
		super();
		FOURCOD = fOURCOD;
		FOURLIB = fOURLIB;
		FOURCON = fOURCON;
		FOUCREATED = fOUCREATED;
		FOUUPDATBY = fOUUPDATBY;
		FOUUPDATED = fOUUPDATED;
		FOUCOMMENT = fOUCOMMENT;
		NOTE = nOTE;
		COMMANDEA = cOMMANDEA;
		REGLERA = rEGLERA;
		FACTURERPAR = fACTURERPAR;
		LIVRERPAR = lIVRERPAR;
		LOGO = lOGO;
		FOURNUMTEL = fOURNUMTEL;
		FOUREMAIL = fOUREMAIL;
		FOURRIB = fOURRIB;
		FOURTYPSOCIETE = fOURTYPSOCIETE;
		FOURIDENTIFSTE = fOURIDENTIFSTE;
		FOURCAPITAL = fOURCAPITAL;
		FOURABONN = fOURABONN;
		FOURETAT = fOURETAT;
		FOURDATABON = fOURDATABON;
		FOURPURGEVENT = fOURPURGEVENT;
		FOURPURGECMD = fOURPURGECMD;
		FOURPURGEREC = fOURPURGEREC;
		FOURPURGEREG = fOURPURGEREG;
		FOURPURGERFA = fOURPURGERFA;
		FOURPURGEBURORD = fOURPURGEBURORD;
		FOURPURGESTATCMD = fOURPURGESTATCMD;
		FOURVALTX = fOURVALTX;
		FOUREXPSTAT = fOUREXPSTAT;
		FOURMSGFRS = fOURMSGFRS;
		FOURDDEBMSG = fOURDDEBMSG;
		FOURDFINMSG = fOURDFINMSG;
		FOURABONNWS = fOURABONNWS;
		FOURDATDESABON = fOURDATDESABON;
		FOURNBRACCESWSJOUR = fOURNBRACCESWSJOUR;
		RAYON = rAYON;
	}





	@Override
	public String toString() {
		return "APFFOURN [FOURNID=" + FOURNID + ", FOURCOD=" + FOURCOD + ", FOURLIB=" + FOURLIB + ", FOURCON=" + FOURCON
				+ ", FOUCREATED=" + FOUCREATED + ", FOUUPDATBY=" + FOUUPDATBY + ", FOUUPDATED=" + FOUUPDATED
				+ ", FOUCOMMENT=" + FOUCOMMENT + ", NOTE=" + NOTE + ", COMMANDEA=" + COMMANDEA + ", REGLERA=" + REGLERA
				+ ", FACTURERPAR=" + FACTURERPAR + ", LIVRERPAR=" + LIVRERPAR + ", LOGO=" + LOGO + ", FOURNUMTEL="
				+ FOURNUMTEL + ", FOUREMAIL=" + FOUREMAIL + ", FOURRIB=" + FOURRIB + ", FOURTYPSOCIETE="
				+ FOURTYPSOCIETE + ", FOURIDENTIFSTE=" + FOURIDENTIFSTE + ", FOURCAPITAL=" + FOURCAPITAL
				+ ", FOURABONN=" + FOURABONN + ", FOURETAT=" + FOURETAT + ", FOURDATABON=" + FOURDATABON
				+ ", FOURPURGEVENT=" + FOURPURGEVENT + ", FOURPURGECMD=" + FOURPURGECMD + ", FOURPURGEREC="
				+ FOURPURGEREC + ", FOURPURGEREG=" + FOURPURGEREG + ", FOURPURGERFA=" + FOURPURGERFA
				+ ", FOURPURGEBURORD=" + FOURPURGEBURORD + ", FOURPURGESTATCMD=" + FOURPURGESTATCMD + ", FOURVALTX="
				+ FOURVALTX + ", FOUREXPSTAT=" + FOUREXPSTAT + ", FOURMSGFRS=" + FOURMSGFRS + ", FOURDDEBMSG="
				+ FOURDDEBMSG + ", FOURDFINMSG=" + FOURDFINMSG + ", FOURABONNWS=" + FOURABONNWS + ", FOURDATDESABON="
				+ FOURDATDESABON + ", FOURNBRACCESWSJOUR=" + FOURNBRACCESWSJOUR + ", RAYON=" + RAYON + "]";
	}





	public Long getFOURNID() {
		return FOURNID;
	}




	public void setFOURNID(Long fOURNID) {
		FOURNID = fOURNID;
	}




	public String getFOURCOD() {
		return FOURCOD;
	}




	public void setFOURCOD(String fOURCOD) {
		FOURCOD = fOURCOD;
	}




	public String getFOURLIB() {
		return FOURLIB;
	}




	public void setFOURLIB(String fOURLIB) {
		FOURLIB = fOURLIB;
	}




	public String getFOURCON() {
		return FOURCON;
	}




	public void setFOURCON(String fOURCON) {
		FOURCON = fOURCON;
	}




	public Date getFOUCREATED() {
		return FOUCREATED;
	}




	public void setFOUCREATED(Date fOUCREATED) {
		FOUCREATED = fOUCREATED;
	}




	public String getFOUUPDATBY() {
		return FOUUPDATBY;
	}




	public void setFOUUPDATBY(String fOUUPDATBY) {
		FOUUPDATBY = fOUUPDATBY;
	}




	public Date getFOUUPDATED() {
		return FOUUPDATED;
	}




	public void setFOUUPDATED(Date fOUUPDATED) {
		FOUUPDATED = fOUUPDATED;
	}




	public String getFOUCOMMENT() {
		return FOUCOMMENT;
	}




	public void setFOUCOMMENT(String fOUCOMMENT) {
		FOUCOMMENT = fOUCOMMENT;
	}




	public String getNOTE() {
		return NOTE;
	}




	public void setNOTE(String nOTE) {
		NOTE = nOTE;
	}




	public String getCOMMANDEA() {
		return COMMANDEA;
	}




	public void setCOMMANDEA(String cOMMANDEA) {
		COMMANDEA = cOMMANDEA;
	}




	public String getREGLERA() {
		return REGLERA;
	}




	public void setREGLERA(String rEGLERA) {
		REGLERA = rEGLERA;
	}




	public String getFACTURERPAR() {
		return FACTURERPAR;
	}




	public void setFACTURERPAR(String fACTURERPAR) {
		FACTURERPAR = fACTURERPAR;
	}




	public String getLIVRERPAR() {
		return LIVRERPAR;
	}




	public void setLIVRERPAR(String lIVRERPAR) {
		LIVRERPAR = lIVRERPAR;
	}




	public String getLOGO() {
		return LOGO;
	}




	public void setLOGO(String lOGO) {
		LOGO = lOGO;
	}




	public String getFOURNUMTEL() {
		return FOURNUMTEL;
	}




	public void setFOURNUMTEL(String fOURNUMTEL) {
		FOURNUMTEL = fOURNUMTEL;
	}




	public String getFOUREMAIL() {
		return FOUREMAIL;
	}




	public void setFOUREMAIL(String fOUREMAIL) {
		FOUREMAIL = fOUREMAIL;
	}




	public String getFOURRIB() {
		return FOURRIB;
	}




	public void setFOURRIB(String fOURRIB) {
		FOURRIB = fOURRIB;
	}




	public String getFOURTYPSOCIETE() {
		return FOURTYPSOCIETE;
	}




	public void setFOURTYPSOCIETE(String fOURTYPSOCIETE) {
		FOURTYPSOCIETE = fOURTYPSOCIETE;
	}




	public String getFOURIDENTIFSTE() {
		return FOURIDENTIFSTE;
	}




	public void setFOURIDENTIFSTE(String fOURIDENTIFSTE) {
		FOURIDENTIFSTE = fOURIDENTIFSTE;
	}




	public String getFOURCAPITAL() {
		return FOURCAPITAL;
	}




	public void setFOURCAPITAL(String fOURCAPITAL) {
		FOURCAPITAL = fOURCAPITAL;
	}




	public Integer getFOURABONN() {
		return FOURABONN;
	}




	public void setFOURABONN(Integer fOURABONN) {
		FOURABONN = fOURABONN;
	}




	public Integer getFOURETAT() {
		return FOURETAT;
	}




	public void setFOURETAT(Integer fOURETAT) {
		FOURETAT = fOURETAT;
	}




	public Date getFOURDATABON() {
		return FOURDATABON;
	}




	public void setFOURDATABON(Date fOURDATABON) {
		FOURDATABON = fOURDATABON;
	}




	public Integer getFOURPURGEVENT() {
		return FOURPURGEVENT;
	}




	public void setFOURPURGEVENT(Integer fOURPURGEVENT) {
		FOURPURGEVENT = fOURPURGEVENT;
	}




	public Integer getFOURPURGECMD() {
		return FOURPURGECMD;
	}




	public void setFOURPURGECMD(Integer fOURPURGECMD) {
		FOURPURGECMD = fOURPURGECMD;
	}




	public Integer getFOURPURGEREC() {
		return FOURPURGEREC;
	}




	public void setFOURPURGEREC(Integer fOURPURGEREC) {
		FOURPURGEREC = fOURPURGEREC;
	}




	public Integer getFOURPURGEREG() {
		return FOURPURGEREG;
	}




	public void setFOURPURGEREG(Integer fOURPURGEREG) {
		FOURPURGEREG = fOURPURGEREG;
	}




	public Integer getFOURPURGERFA() {
		return FOURPURGERFA;
	}




	public void setFOURPURGERFA(Integer fOURPURGERFA) {
		FOURPURGERFA = fOURPURGERFA;
	}




	public Integer getFOURPURGEBURORD() {
		return FOURPURGEBURORD;
	}




	public void setFOURPURGEBURORD(Integer fOURPURGEBURORD) {
		FOURPURGEBURORD = fOURPURGEBURORD;
	}




	public Integer getFOURPURGESTATCMD() {
		return FOURPURGESTATCMD;
	}




	public void setFOURPURGESTATCMD(Integer fOURPURGESTATCMD) {
		FOURPURGESTATCMD = fOURPURGESTATCMD;
	}




	public Integer getFOURVALTX() {
		return FOURVALTX;
	}




	public void setFOURVALTX(Integer fOURVALTX) {
		FOURVALTX = fOURVALTX;
	}




	public Integer getFOUREXPSTAT() {
		return FOUREXPSTAT;
	}




	public void setFOUREXPSTAT(Integer fOUREXPSTAT) {
		FOUREXPSTAT = fOUREXPSTAT;
	}




	public String getFOURMSGFRS() {
		return FOURMSGFRS;
	}




	public void setFOURMSGFRS(String fOURMSGFRS) {
		FOURMSGFRS = fOURMSGFRS;
	}




	public Date getFOURDDEBMSG() {
		return FOURDDEBMSG;
	}




	public void setFOURDDEBMSG(Date fOURDDEBMSG) {
		FOURDDEBMSG = fOURDDEBMSG;
	}




	public Date getFOURDFINMSG() {
		return FOURDFINMSG;
	}




	public void setFOURDFINMSG(Date fOURDFINMSG) {
		FOURDFINMSG = fOURDFINMSG;
	}




	public int getFOURABONNWS() {
		return FOURABONNWS;
	}




	public void setFOURABONNWS(int fOURABONNWS) {
		FOURABONNWS = fOURABONNWS;
	}




	public Date getFOURDATDESABON() {
		return FOURDATDESABON;
	}




	public void setFOURDATDESABON(Date fOURDATDESABON) {
		FOURDATDESABON = fOURDATDESABON;
	}




	public Long getFOURNBRACCESWSJOUR() {
		return FOURNBRACCESWSJOUR;
	}




	public void setFOURNBRACCESWSJOUR(Long fOURNBRACCESWSJOUR) {
		FOURNBRACCESWSJOUR = fOURNBRACCESWSJOUR;
	}




	public String getRAYON() {
		return RAYON;
	}




	public void setRAYON(String rAYON) {
		RAYON = rAYON;
	}

	
	
	
	
	

}









/*
 
FOURNID	N	NUMBER(9)	N			Id fournisseur (Sequenceur) SEQ_FOURN_ID
FOURCOD	N	VARCHAR2(12)	N			Code fournisseur
FOURLIB	N	VARCHAR2(40)	N			Libelle fournisseur
FOURCON	N	VARCHAR2(100)	Y			Contact
FOUCREATED	N	DATE	N			Date de creation
FOUUPDATBY	N	VARCHAR2(30)	N			Dernier utilisateur
FOUUPDATED	N	DATE	N			date de la derniere mise a jour
FOUCOMMENT	N	VARCHAR2(255)	Y			Commentaire
NOTE	N	VARCHAR2(1000)	Y			Note Fournisseur
COMMANDEA	N	VARCHAR2(255)	Y			commande a - Fournisseur
REGLERA	N	VARCHAR2(255)	Y			regler a - Fournisseur
LIVRERPAR	N	VARCHAR2(255)	Y			livrer par - Fournisseur
FACTURERPAR	N	VARCHAR2(255)	Y			facturer par - Fournisseur
LOGO	N	VARCHAR2(100)	Y			Logo fournisseur
FOURNUMTEL	N	VARCHAR2(30)	Y			Numero telephone fournisseur
FOUREMAIL	N	VARCHAR2(100)	Y			Email fournisseur
FOURRIB	N	VARCHAR2(100)	Y			RIB fournisseur
FOURTYPSOCIETE	N	VARCHAR2(100)	Y			Type Societe
FOURIDENTIFSTE	N	VARCHAR2(100)	Y			Identifiant de la societe
FOURCAPITAL	N	VARCHAR2(100)	Y			Capital
FOURABONN	N	NUMBER(1)	Y	1		Flag abbonement 0=Non Abonne 1=Abonne 2=Bloque
FOURETAT	N	NUMBER(3)	Y			Etat fournisseur 1=Actif 2=Gele 3=Supprime table RIS ...
FOURDATABON	N	DATE	Y			Date abonnement fournisseur
FOURPURGEVENT	N	NUMBER(1)	Y			Purger les ventes : 1=Non 0 ou null=Oui
FOURPURGECMD	N	NUMBER(1)	Y			Purger les commandes : 1=Non 0 ou null=Oui
FOURPURGEREC	N	NUMBER(1)	Y			Purger les receptions : 1=Non 0 ou null=Oui
FOURPURGEREG	N	NUMBER(1)	Y			Purger les Reglements: 1=Non 0 ou null=Oui
FOURPURGERFA	N	NUMBER(1)	Y			Purger les Rfa: 1=Non 0 ou null=Oui
FOURPURGEBURORD	N	NUMBER(1)	Y			Purger les factures  bureau ordre + reception avec facture non parvenues  : 1=Non 0 ou null=Oui
FOURPURGESTATCMD	N	NUMBER(1)	Y			Purger les stat. taux de services : 1=Non 0 ou null=Oui
FOURVALTX	N	NUMBER(1)	Y			Visualisation Valorisation Taux de rupture 1:Oui - 0 ou null non
FOUREXPSTAT	N	NUMBER(2)	Y			Ensemble d un fournisseur pour un type d export des statistiques de vente (1,2,3...)
FOURMSGFRS	N	VARCHAR2(512)	Y			Message affiche au fournisseur par le distributeur
FOURDDEBMSG	N	DATE	Y			Date debut affichage message
FOURDFINMSG	N	DATE	Y			Date fin affichage message
FOURABONNWS	N	NUMBER(1)	Y	0		Flag abbonement Web Service 0=Non Abonne 1=Abonne
FOURDATDESABON	N	DATE	Y			Date dasabonnement du portail
FOURNBRACCESWSJOUR	N	NUMBER(5)	Y			Nombre limite d acces au portail par web Service
RAYON	N	VARCHAR2(40)	Y			
 
 
 
 
 
 
 
 
 
 
 
 
 
 */

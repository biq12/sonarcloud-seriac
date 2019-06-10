package com.example.demo.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "seq_ens_id",allocationSize=1)
public class APFDISTRIBENSEIGNE {
	//verifier
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq_ens_id")
	private Long ENSCINENS;
	@NotNull
	@Column(unique=true)
	//code de l'ensigne : 
	private String ENSCODE;
	//libelle de ensigne : 
	private String  ENSLIB;
	private Date ENSCREATED;
	
	private Date ENSUPDATED;
	private String ENSUPDATBY;
	private String ENSCODGRAM;
	@NotNull
	private Long   DISTRIBID;
	


	
	public APFDISTRIBENSEIGNE() {
		super();
	}


	public APFDISTRIBENSEIGNE(@NotNull String eNSCODE, String eNSLIB, Date eNSCREATED, Date eNSUPDATED,
			String eNSUPDATBY, String eNSCODGRAM, @NotNull Long dISTRIBID) {
		super();
		ENSCODE = eNSCODE;
		ENSLIB = eNSLIB;
		ENSCREATED = eNSCREATED;
		ENSUPDATED = eNSUPDATED;
		ENSUPDATBY = eNSUPDATBY;
		ENSCODGRAM = eNSCODGRAM;
		DISTRIBID = dISTRIBID;
	}


	public APFDISTRIBENSEIGNE(Long eNSCINENS, @NotNull String eNSCODE, String eNSLIB, Date eNSCREATED, Date eNSUPDATED,
			String eNSUPDATBY, String eNSCODGRAM, @NotNull Long dISTRIBID) {
		super();
		ENSCINENS = eNSCINENS;
		ENSCODE = eNSCODE;
		ENSLIB = eNSLIB;
		ENSCREATED = eNSCREATED;
		ENSUPDATED = eNSUPDATED;
		ENSUPDATBY = eNSUPDATBY;
		ENSCODGRAM = eNSCODGRAM;
		DISTRIBID = dISTRIBID;
	}


	public Long getENSCINENS() {
		return ENSCINENS;
	}

	public void setENSCINENS(Long eNSCINENS) {
		ENSCINENS = eNSCINENS;
	}

	public String getENSCODE() {
		return ENSCODE;
	}

	public void setENSCODE(String eNSCODE) {
		ENSCODE = eNSCODE;
	}

	public String getENSLIB() {
		return ENSLIB;
	}

	public void setENSLIB(String eNSLIB) {
		ENSLIB = eNSLIB;
	}

	public Date getENSCREATED() {
		return ENSCREATED;
	}

	public void setENSCREATED(Date eNSCREATED) {
		ENSCREATED = eNSCREATED;
	}

	public Date getENSUPDATED() {
		return ENSUPDATED;
	}

	public void setENSUPDATED(Date eNSUPDATED) {
		ENSUPDATED = eNSUPDATED;
	}

	public String getENSUPDATBY() {
		return ENSUPDATBY;
	}

	public void setENSUPDATBY(String eNSUPDATBY) {
		ENSUPDATBY = eNSUPDATBY;
	}

	public String getENSCODGRAM() {
		return ENSCODGRAM;
	}

	public void setENSCODGRAM(String eNSCODGRAM) {
		ENSCODGRAM = eNSCODGRAM;
	}

	public Long getDISTRIBID() {
		return DISTRIBID;
	}

	public void setDISTRIBID(Long dISTRIBID) {
		DISTRIBID = dISTRIBID;
	}


	

	
	
}

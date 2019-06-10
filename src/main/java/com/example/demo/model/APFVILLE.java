package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class APFVILLE {
    @Id
	private String  VILLENOM	;//N	VARCHAR2(20)	N			NOM DE LA VILLE
	private Long VILLEID;//		CODE VILLE
	private String  VILLEPAYS ;//	N	VARCHAR2(20)	Y			PAYS DE LA VILLE
	
	
	public APFVILLE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public APFVILLE(Long vILLEID, String vILLENOM, String vILLEPAYS) {
		super();
		VILLEID = vILLEID;
		VILLENOM = vILLENOM;
		VILLEPAYS = vILLEPAYS;
	}
	public APFVILLE(String vILLENOM, String vILLEPAYS) {
		super();
		VILLENOM = vILLENOM;
		VILLEPAYS = vILLEPAYS;
	}
	public Long getVILLEID() {
		return VILLEID;
	}
	public void setVILLEID(Long vILLEID) {
		VILLEID = vILLEID;
	}
	public String getVILLENOM() {
		return VILLENOM;
	}
	public void setVILLENOM(String vILLENOM) {
		VILLENOM = vILLENOM;
	}
	public String getVILLEPAYS() {
		return VILLEPAYS;
	}
	public void setVILLEPAYS(String vILLEPAYS) {
		VILLEPAYS = vILLEPAYS;
	}

	
	
	
}

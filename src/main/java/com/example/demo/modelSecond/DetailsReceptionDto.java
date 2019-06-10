package com.example.demo.modelSecond;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.model.APFDETRE;
import com.example.demo.model.APFDISTRIB;
import com.example.demo.model.APFDISTRIBSITE;
import com.example.demo.model.Apfcdedet;
import com.example.demo.model.Apfcdeent;

public class DetailsReceptionDto {

	private  APFDETRE   detail;
	private  Long DCDPCU;
	
	public DetailsReceptionDto() {
		super();
	}

	public DetailsReceptionDto(APFDETRE detail, Long dCDPCU) {
		super();
		this.detail = detail;
		DCDPCU = dCDPCU;
	}

	public APFDETRE getDetail() {
		return detail;
	}

	public void setDetail(APFDETRE detail) {
		this.detail = detail;
	}

	public Long getDCDPCU() {
		return DCDPCU;
	}
	public void setDCDPCU(Long dCDPCU) {
		DCDPCU = dCDPCU;
	}


}

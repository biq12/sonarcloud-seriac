package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@SequenceGenerator(name = "seq_ecranss_id",allocationSize=1)
@Table(name="APFECRAN")
public class Apfecran {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq_ecranss_id")
	private Long id;
	@Column(unique=true,name="ECRANNAME")
	@NotNull
	private String ecranname;
	private String descriptif;
	private Date datecreation;
	private String updateby;

	private Date  dateupdate;
	
	public Apfecran() {
		super();
	}
	
	public Apfecran(@NotNull String ecranname, String descriptif, Date datecreation, String updateby, Date dateupdate) {
		super();
		this.ecranname = ecranname;
		this.descriptif = descriptif;
		this.datecreation = datecreation;
		this.updateby = updateby;
		this.dateupdate = dateupdate;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEcranname() {
		return ecranname;
	}
	public void setEcranname(String ecranname) {
		this.ecranname = ecranname;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	public String getUpdateby() {
		return updateby;
	}
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}
	public Date getDateupdate() {
		return dateupdate;
	}
	public void setDateupdate(Date dateupdate) {
		this.dateupdate = dateupdate;
	}
	
	
	
	
	
	
	
	
	
}

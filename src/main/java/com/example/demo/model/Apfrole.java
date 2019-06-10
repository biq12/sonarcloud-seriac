package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="APFROLE")
@SequenceGenerator(name = "seq_role_id",allocationSize=1)
public class Apfrole {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq_role_id")
	private Long id;
	@Column(unique=true)
	@NotNull
	private String rolename;
	


	public Apfrole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Apfrole(@NotNull String rolename) {
		super();
		this.rolename = rolename;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
	
}

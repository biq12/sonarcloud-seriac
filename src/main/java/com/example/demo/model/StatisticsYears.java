package com.example.demo.model;

public class StatisticsYears {

	private Integer years;
	private Long quantite;
	

	public StatisticsYears(Integer years, Long quantite) {
		super();
		this.years = years;
		this.quantite = quantite;
	}
	public Long getQuantite() {
		return quantite;
	}
	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}

	
}

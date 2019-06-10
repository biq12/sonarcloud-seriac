package com.example.demo.modelSecond;

import java.util.Date;

import com.example.demo.model.APFDISTRIBSITE;
import com.example.demo.model.APFFOURN;

public class EnteteComandeSearch {

	  private String ecdcexcde;//code externe commande
	  private Long siteCod ;  //site
	  private String ensCode;
      private int ecdetatapf ;   ///etat de commande dans applicaiton fournisseur
	  private Date  ecddcommin;    ///Date commande
	  private Date ecddcommax ;    ///Date commande
	  
	  private Date ecddminliv ;     //Date  min livraision Date heure
	  private Date ecddmaxliv;     //Date limite de livraison
	  
	  private String  ecdcontrat;  //code externe contrat commercial
	  
	  
		public EnteteComandeSearch() {
		super();
		// TODO Auto-generated constructor stub
	}
		public String getEcdcexcde() {
			return ecdcexcde;
		}
		public void setEcdcexcde(String ecdcexcde) {
			this.ecdcexcde = ecdcexcde;
		}
		
		
		public Long getSiteCod() {
			return siteCod;
		}
		public void setSiteCod(Long siteCod) {
			this.siteCod = siteCod;
		}
		public String getEnsCode() {
			return ensCode;
		}
		public void setEnsCode(String ensCode) {
			this.ensCode = ensCode;
		}
		public int getEcdetatapf() {
			return ecdetatapf;
		}
		public void setEcdetatapf(int ecdetatapf) {
			this.ecdetatapf = ecdetatapf;
		}
		public Date getEcddcommin() {
			return ecddcommin;
		}
		public void setEcddcommin(Date ecddcommin) {
			this.ecddcommin = ecddcommin;
		}
		public Date getEcddcommax() {
			return ecddcommax;
		}
		public void setEcddcommax(Date ecddcommax) {
			this.ecddcommax = ecddcommax;
		}
		public Date getEcddminliv() {
			return ecddminliv;
		}
		public void setEcddminliv(Date ecddminliv) {
			this.ecddminliv = ecddminliv;
		}
		public Date getEcddmaxliv() {
			return ecddmaxliv;
		}
		public void setEcddmaxliv(Date ecddmaxliv) {
			this.ecddmaxliv = ecddmaxliv;
		}
		public String getEcdcontrat() {
			return ecdcontrat;
		}
		public void setEcdcontrat(String ecdcontrat) {
			this.ecdcontrat = ecdcontrat;
		}
		
		@Override
		public String toString() {
			return "EnteteComandeSearch [ecdcexcde=" + ecdcexcde + ", siteCod=" + siteCod + ", ensCode=" + ensCode
					+ ", ecdetatapf=" + ecdetatapf + ", ecddcommin=" + ecddcommin + ", ecddcommax=" + ecddcommax
					+ ", ecddminliv=" + ecddminliv + ", ecddmaxliv=" + ecddmaxliv + ", ecdcontrat=" + ecdcontrat + "]";
		}

		
	  
	  
	
}

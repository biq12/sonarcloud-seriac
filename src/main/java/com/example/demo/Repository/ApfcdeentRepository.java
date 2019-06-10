package com.example.demo.Repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.*;


public interface ApfcdeentRepository extends JpaRepository<Apfcdeent,Long>{ 
 
	 //(MONTH(ecddcom)=MONTH(:x3d) and  year(ecddcom)=year(:x3d) and day(ecddcom)=day(:x3d))
	  //Preferable in moment
	
	/*@Query("select e from Apfcdeent e where ( (:x1 is null)  or  ECDCEXCDE=:x1)  and  (:x2n=0 or ECDETATAPF=:x2n)   and"
	  		+ "                  (:x3d is null or   ECDDCOM >= :x3d  )  and (:x4d is null or ecddcom <:x4d)  and "
	  		+ " (:x5d is null or   ECDDLIV >= :x5d)  and (:x6d is null or   ECDDLIV <= :x6d)   and (:x7  is null or  FCCNUM=:x7)  and (:x8 is null or  APFDISTRIBSITE.SITECOD=:x8) "
	  		+ "and (:x9 is null or APFDISTRIBSITE.SITENSCOD=:x9 )  and  (:sup is null or APFFOURN.FOURNID=:sup ) ")
	  Page<Apfcdeent> SearchBYFiltre(@Param("x1") String cmdInterne,@Param("x2n") Integer  ECDETATAPF,@Param("x3d") Date datCommin ,@Param("x4d") Date datCommax,
    		  @Param("x5d") Date datlivmin,@Param("x6d") Date datlivmax,@Param("x7") String contrat,@Param("x8") Long sitCod,@Param("x9") String ensCod,@Param("sup") Long idSupplier,Pageable  p);

     */
	
	@Query("select e from Apfcdeent e where ( (:x1 is null)  or  ECDCEXCDE=:x1)  and  (:x2n=0 or ECDETATAPF=:x2n)   and"
	  		+ "                  (:x3d is null or   ECDDCOM >= :x3d  )  and (:x4d is null or ECDDCOM <=:x4d)  and "
	  		+ " (:x5d is null or   ECDDLIV >= :x5d)  and (:x6d is null or   ECDDLIV <= :x6d)  and (:x7  is null or  FCCNUM=:x7)  and (:x8 is null or  APFDISTRIBSITE.SITECOD=:x8)  "
	  		+ "and (:x9 is null or APFDISTRIBSITE.SITENSCOD=:x9 )  and  (:sup is null or APFFOURN.FOURNID=:sup )  ")
	Page<Apfcdeent> SearchBYFiltre(@Param("x1") String cmdInterne,@Param("x2n") Integer  ECDETATAPF,@Param("x3d") Date datCommin ,@Param("x4d") Date datCommax,
  		  @Param("x5d") Date datlivmin,@Param("x6d") Date datlivmax,@Param("x7") String contrat,@Param("x8") Long sitCod,@Param("x9") String ensCod,@Param("sup") Long idSupplier,Pageable  p);

	 

	  /**
	   * utiliser pour comptere test avant de supprimer
	   * @param idDistrib 
	   * @return nbr de commande by distrib
	   */
    @Query("SELECT COUNT(u) FROM Apfcdeent u WHERE u.APFDISTRIB.DISTRIBID=:idS")
	Long CountCommandbyDISTRIBID(@Param("idS") Long idDistrib);

	@Query("SELECT COUNT(u) FROM Apfcdeent u WHERE u.APFFOURN.FOURNID=:idS")
	Long CountCommandbyFournID(@Param("idS") Long idS);

	@Query("SELECT COUNT(u) FROM Apfcdeent u WHERE u.APFDISTRIBSITE.SITECOD=:idS")
	long countnbrSitActuelle(@Param("idS") Long idS);

	 

}

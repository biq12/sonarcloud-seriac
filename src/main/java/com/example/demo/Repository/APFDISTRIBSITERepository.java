package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.APFDISTRIB;
import com.example.demo.model.APFDISTRIBSITE;

public interface APFDISTRIBSITERepository extends JpaRepository<APFDISTRIBSITE,Long> {
	
	/*
	 * search with all param ..
	 */
	@Query("select e from APFDISTRIBSITE e where sitenscod=:x1 ")
	 APFDISTRIBSITE searchByCodeSite(@Param("x1") Long codeSite);

	 @Query("select e from APFDISTRIBSITE e where sitelib like :x and   sitenscod  like :codEnsi ")
	 Page<APFDISTRIBSITE> searchByMotCleCod(@Param("x") String x,@Param("codEnsi") String codEnsi, Pageable pageReq);

	 @Query("select e from APFDISTRIBSITE e where  DISTRIBID=:x")
	 Page<APFDISTRIBSITE> searchByMotCleIdDistrib(@Param("x") Long x,Pageable pageReq);

	
	  @Query("select e from APFDISTRIBSITE e where ( (:x is null) or SITECOD=:x ) and  (:lib is null or SITELIB like :lib) ")
	  Page<APFDISTRIBSITE> SearchSiteBylibelleAndCod(@Param("x") Long codSite,@Param("lib") String libelle, Pageable  of);

	  /////for caclule le nombre des enign e
	  @Query("select Count(e) from APFDISTRIBSITE e where SITENSCOD=:x ")
	  Long CountEnsigneCod(@Param("x") String ensCod);

	  @Query("select e from APFDISTRIBSITE e where  SITECOD=:x ")
	   APFDISTRIBSITE searchByCodSite(@Param("x") Long distribid);


  

}

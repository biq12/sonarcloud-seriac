package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.*;




public interface APFDISTRIBRepository extends JpaRepository<APFDISTRIB,Long>{
		 
	 @Query("select e from APFDISTRIB e where DISTRIBCOD like :x order by DISTRIBID desc ")
	 Page<APFDISTRIB> searchByMotCle(@Param("x") String x,Pageable pageReq);

	 
	 ///fonction automatique by distrib data 
	 @Query("select e from APFDISTRIB e where DISTRIBCOD like :x  ")
	APFDISTRIB SearchDistribByCod(@Param("x") String cod);
	 
	 
	 
	 
	 
}

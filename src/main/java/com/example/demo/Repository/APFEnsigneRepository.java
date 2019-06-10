package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;

import com.example.demo.model.APFDISTRIBENSEIGNE;

public interface APFEnsigneRepository extends JpaRepository<APFDISTRIBENSEIGNE, Long>{
	 @Query("select e from APFDISTRIBENSEIGNE e where LOWER(ENSCODE)  like :x ")
	 Page<APFDISTRIBENSEIGNE> SearchByMotCle(@Param("x") String x,Pageable pageReq);

	 @Query("select e from APFDISTRIBENSEIGNE e where ENSCODE like :x ")
	 APFDISTRIBENSEIGNE SearchByCod(@Param("x") String enscode);

	 
	 
	@Query("select e from APFDISTRIBENSEIGNE e where LOWER(ENSCODE)=LOWER(:x) ")
	APFDISTRIBENSEIGNE  SearchByCode(@Param("x") String enscode);
	
	
	
	
}

package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.APFDETRE;
import com.example.demo.modelSecond.DetailsReceptionDto;


public interface APFDETRERepository extends JpaRepository<APFDETRE, Long> {

	//@Query("select           u  from APFDETRE u where u.SDRCINREC=:x ")
	/*
	@Query("select d,e.DCDQTEC  FROM APFDETRE d,Apfcdedet e where  d.SDRCINR=e.DCDCINR and d.SDRCINREC=:x   ")
	List<DetailsReceptionDto> SearchFiltres(@Param("x") Long codReceptionInterne)Z; */
	
	@Query("select u  FROM APFDETRE  u where  u.SDRENTRE.SERCINREC=:x   and u.SDRENTRE.SERTMVT=1 ")
	List<APFDETRE> SearchFiltres(@Param("x") Long codReceptionInterne);

}

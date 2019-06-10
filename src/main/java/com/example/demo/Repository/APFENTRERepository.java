package com.example.demo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.APFENTRE;



public interface APFENTRERepository extends CrudRepository<APFENTRE, Long>  {

	@Query("select e from APFENTRE e ")
    Slice<APFENTRE> get(Pageable p);
	
	@Query("select e from APFENTRE e ")
	Page<APFENTRE> getpage(Pageable p);

	
	@Query("select e from APFENTRE e where ( :x1 is null  or   SERCINREC=:x1 ) and (:x2d is null or :x2d<= SERDCOM) "
	+ "and (:x3d is null or :x3d>= SERDCOM)  and (:x4 is null or :x4=FCCNUM)  "
	+ "and (:x5d is null or :x5d<= SERDREC) and (:x6d is null or :x6d>= SERDREC) "
	+ "and (:x7 is null or :x7=SERCEXCDE ) and (:x8 is null or :x8=APFDISTRIBSITE.SITECOD)"
	+ "and (:x9 is null or :x9=APFDISTRIBSITE.SITENSCOD) ")
	Page<APFENTRE> SearchReception(@Param("x1") Long  SERCINREC,@Param("x2d") Date SERDCOMMIN,@Param("x3d") Date SERDCOMMAX,
			@Param("x4") String FCCNUM,@Param("x5d") Date SERDRECRMIN,@Param("x6d") Date SERDRECRMAX,
			@Param("x7") String Sercexcde,@Param("x8") Long SERSITE,@Param("x9") String codensigne,Pageable p);

	


}

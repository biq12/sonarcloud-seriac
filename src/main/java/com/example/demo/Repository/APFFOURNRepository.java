package com.example.demo.Repository; 


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.*;


public interface APFFOURNRepository extends JpaRepository<APFFOURN,Long>{
  @Query("select e from APFFOURN e where FOURCOD like :x order by FOURNID desc")
  Page<APFFOURN>  getAllFournByMotCle(@Param("x") String x,Pageable pageReq);
  
  @Query("select e from APFFOURN e where  FOURNID=:x order by FOURNID desc ")
  Page<APFFOURN>  getAllFournByID(@Param("x") Long x,Pageable pageReq);
  
  @Query("select e from APFFOURN e where FOUREMAIL like :x order by FOURNID desc ")
  Page<APFFOURN>  getAllFournByEmail(@Param("x") String x,Pageable pageReq);
  
  @Query("select e from APFFOURN e where  FOURCOD like :x or FOUREMAIL like :x  order by FOURNID desc ")
  Page<APFFOURN>  getAllFournByM(@Param("x") String x,Pageable pageReq);
 
  @Query("select e from APFFOURN e where FOURCOD=:x")
  APFFOURN searchByCod(@Param("x") String fourcod);
  
}

package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Apfecran;

public interface APFEcranRepository  extends JpaRepository<Apfecran,Long>{
   @Query("select e from Apfecran e where LOWER(ecranName)=LOWER(:x)")
	public Apfecran  SearchByecranName(@Param("x") String ecranName);
   
   @Query("select e from Apfecran e where LOWER(ecranName) like :x")
   public List<Apfecran> FiltreByName(@Param("x")  String string);
	

}

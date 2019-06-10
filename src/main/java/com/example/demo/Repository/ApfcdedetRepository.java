package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Apfcdedet;

public interface ApfcdedetRepository extends JpaRepository<Apfcdedet,Long> {

	/*
	 * commade details
	 */
	@Query("select u  from Apfcdedet u where u.ECDCINCDE=:x  " )
	List<Apfcdedet> SearchByFiltre(@Param("x") Long ecdcincde); 
	

	
}

package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.APFVILLE;

public interface ApfvilleRepository extends JpaRepository<APFVILLE, String> {

	@Query("select u from APFVILLE u WHERE LOWER(VILLENOM) like :x")
	List<APFVILLE> SearchByName(@Param("x") String nomVille);

	
}

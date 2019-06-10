package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Apfrole;

public interface ApfRoleRepository  extends JpaRepository<Apfrole,Long>{

	 @Query("select e from Apfrole e where  LOWER(rolename)=LOWER(:x) ")
	 public Apfrole SerachRoleByNom(@Param("x") String name);
	 
	 
	 
}

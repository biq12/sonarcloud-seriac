package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.*;
import com.example.demo.modelSecond.Userdto;

public interface APFUSERRepository extends JpaRepository<APFUSER, Long> {
	
	
	public APFUSER findByUserlogin(String Userlogin);
	
	@Query("select e from APFUSER e where LOWER(userlogin)=LOWER(:x)")
	public APFUSER SearchEqualsToLogin(@Param("x") String Userlogin);



	@Query("select e from APFUSER e where (:login is null or  LOWER(userlogin) like LOWER(:login))  and  (:email is null or  LOWER(USEREMAIL) like LOWER(:email))   "
			+ "and  (:nom is null or  LOWER(USERNOM) like LOWER(:nom))  and  (:prenom is null or  LOWER(USERPRENOM) like LOWER(:prenom)) "
			+ "and  (:profil is null or  USERPROFIL=:profil )  and  (:profil is null or  USERPROFIL=:profil )  and  (:etat is null or   USERETAT=:etat )  ")
	public Page<APFUSER> searchUsers(@Param("login") String login,@Param("email") String email,@Param("nom") String nom,@Param("prenom") String prenom, 
			@Param("profil") Integer profil,@Param("etat") Integer etat,Pageable pageReq);
    
    
    
	
	
	
	@Query("select e from APFUSER e where usernom like :x order by userid desc")
	Page<APFUSER> searchByMotCle(@Param("x") String x, Pageable pageReq);

	@Query("select e from APFUSER e where LOWER(userlogin) like LOWER(:x) order by userid desc")
	Page<APFUSER> SearchUSERLOGIN(@Param("x") String x, Pageable pageReq);

	@Query("select e from APFUSER e where userlogin like :login and useremail like :email    and usernom like :fname and userprenom like :lname "
			+ "  order by userid desc")
	Page<APFUSER> SearchByFiltres0(@Param("login") String login, @Param("email") String email,
			@Param("lname") String lastName, @Param("fname") String firstName, Pageable pageReq);

	@Query("select e from APFUSER e where userlogin like :login and useremail like :email    and usernom like :fname and userprenom like :lname "
			+ " and useretat = :x order by userid desc")
	Page<APFUSER> SearchByFiltres1(@Param("login") String login, @Param("email") String email,
			@Param("lname") String lastName, @Param("fname") String firstName, @Param("x") Long etat,Pageable pageReq);

	/// If the Profil is Fournisseur and Status all
	@Query("select e from APFUSER e where userlogin like :login and useremail like :email    and usernom like :fname and userprenom like :lname "
			+ " and fournid <> -1 order by userid desc")
	Page<APFUSER> SearchByFiltresFourn2(@Param("login") String login, @Param("email") String email,
			@Param("lname") String lastName, @Param("fname") String firstName, Pageable pageReq);

	@Query("select e from APFUSER e where userlogin like :login and useremail like :email    and usernom like :fname and userprenom like :lname "
			+ " and fournid <> -1 and etat = :x order by userid desc")
	Page<APFUSER> SearchByFiltresFourn2Etat(@Param("login") String login, @Param("email") String email,
			@Param("lname") String lastName, @Param("fname") String firstName,@Param("x") Long etat, Pageable pageReq);

	

	
	
	
	
	@Query("select e from APFUSER e where userlogin like :login and useremail like :email    and usernom like :fname and userprenom like :lname "
			+ " and distribid <> -1 order by userid desc")
	Page<APFUSER> SearchByFiltresDistrib2(@Param("login") String login, @Param("email") String email,
			@Param("lname") String lastName, @Param("fname") String firstName, Pageable pageReq);

	@Query("select e from APFUSER e where userlogin like :login and useremail like :email    and usernom like :fname and userprenom like :lname "
			+ " and distribid <> -1 and etat = :x order by userid desc")
	Page<APFUSER> SearchByFiltresDistrib2Etat(@Param("login") String login, @Param("email") String email,
			@Param("lname") String lastName, @Param("fname") String firstName,@Param("x") Long etat, Pageable pageReq);
	
	
	@Query("select e from APFUSER e where userlogin like :login and useremail like :email    and usernom like :fname and userprenom like :lname "
			+ " and adminid <> -1  order by userid desc")
	Page<APFUSER> SearchByFiltresAdmin2(@Param("login") String login, @Param("email") String email,
			@Param("lname") String lastName, @Param("fname") String firstName, Pageable pageReq);
	

	@Query("select e from APFUSER e where userlogin like :login and useremail like :email    and usernom like :fname and userprenom like :lname "
			+ " and adminid <> -1  and etat = :x order by userid desc")
	Page<APFUSER> SearchByFiltresAdmin2Etat(@Param("login") String login, @Param("email") String email,
			@Param("lname") String lastName, @Param("fname") String firstName,@Param("x") Long etat,Pageable pageReq);

	

	////////////////////////////////////Statistics///////////////////////
    @Query("SELECT COUNT(u) FROM APFUSER u WHERE year(u.USERCREATED)=:years")
	Long SearchByYearsParam(Integer years);

 
   
    @Query("SELECT u FROM APFUSER u WHERE year(u.USERCREATED)=:years")
    List<APFUSER> getAllUSERSMonths(@Param("years") int years);
    
 
    @Query("SELECT COUNT(u) FROM APFUSER u WHERE (MONTH(u.USERCREATED)=:month) and (year(u.USERCREATED)=:years )")
	Long  CountByMonth(@Param("month")Integer month,@Param("years") Integer years);

    @Query("SELECT u FROM APFUSER u WHERE USEREMAIL=:x ")
	public APFUSER searchByEmail(@Param("x") String email);

    
	
    
    
    
    
}

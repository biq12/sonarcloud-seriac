package com.example.demo.web;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.APFENTRERepository;
//import com.example.demo.Repository.ApfEntRecRepository;
import com.example.demo.model.APFENTRE;
import com.example.demo.model.Apfcdeent;
import com.example.demo.model.Apfcdedet;
import com.example.demo.modelSecond.EnteteComandeSearch;
import com.example.demo.modelSecond.EnteteReceptionSearch;

@RestController
@CrossOrigin("*")
public class ApfentreRestController {

	@Autowired
	private  APFENTRERepository repository ;
	
	@PersistenceContext
	private EntityManager em;
	/**
	 * fonction de chargement intiale
	 * @param size = size a charge de 5 a 20 max
	 * @return Page result d une conversion
	 */
	@PostMapping("supplier/ListEnteteReceptions")
	public Page<APFENTRE> getListReception(@RequestParam Integer size){
		
		//return (List<APFENTRE>) repository.findAll().
		/*
		 Query query= em.createQuery("select e from APFENTRE e",APFENTRE.class);
	    List<APFENTRE> list1=(List<APFENTRE>)query.setMaxResults(size).getResultList();
	    //convertir list to page
	    Page<APFENTRE> page1 = new PageImpl<>(list1);
	    
	    return page1;*/
		
		//return  repository.get(PageRequest.of(0,size));
		return  repository.getpage(PageRequest.of(0,size));
		
	}
	
	@PostMapping("supplier/SearchReceptions")
	public Page<APFENTRE> SearchReception(
	@RequestParam(name="page",defaultValue="0") int p,@RequestParam(name="size",defaultValue="5") int s,
	@RequestBody EnteteReceptionSearch entetes,String loginConnecte)
	{
	
		return repository.SearchReception(entetes.getSercinrec(),entetes.getSerdcommin(),entetes.getSerdcommax(),
				entetes.getFccnum(),entetes.getSerdrecrmin(),entetes.getSerdrecrmax(),
				entetes.getSercexcde(),entetes.getSersite(),entetes.getSerensCode(),
		        PageRequest.of(p, s));
	}

	
	
	
	
	
	
	
	
	
	

	
	

	
	
}

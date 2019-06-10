package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Repository.APFDETRERepository;
import com.example.demo.model.APFDETRE;
import com.example.demo.model.APFENTRE;
import com.example.demo.model.Apfcdedet;
import com.example.demo.modelSecond.DetailsReceptionDto;

@RestController
@CrossOrigin("*")
public class ApfdetreRestController {

	@Autowired
	private APFDETRERepository repository;
	/*
	 * Detail d'une réception
	 */
	@PostMapping(value="supplier/DetailsReceptions/{id}")
	public List<APFDETRE> getDetailsReceptions(@PathVariable("id") Long sercinrec){
		try {
			System.out.println("==>"+sercinrec);
			return repository.SearchFiltres(sercinrec);
		}catch(Exception e) {
			return new ArrayList<APFDETRE>();
		}
		
	}
	
}

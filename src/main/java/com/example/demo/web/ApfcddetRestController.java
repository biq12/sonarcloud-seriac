package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ApfcdedetRepository;
import com.example.demo.model.Apfcdeent;
import com.example.demo.model.Apfcdedet;

@RestController
@CrossOrigin("*")
public class ApfcddetRestController {

	@Autowired
	private ApfcdedetRepository apfcdedetRepository;
	/*
	 * detail d'une entetes de commandes 
	 */
	@PostMapping("supplier/DetailCommandes")
	public List<Apfcdedet> getDetailRecepption(@RequestBody Apfcdeent entityApfcdeent){
	
		return apfcdedetRepository.SearchByFiltre(entityApfcdeent.getECDCINCDE());
	}
	
	
	
	
	
	
	
	
	
	
	
}

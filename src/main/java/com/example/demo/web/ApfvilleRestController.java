package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ApfvilleRepository;
import com.example.demo.model.APFVILLE;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class ApfvilleRestController {

	@Autowired
	 ApfvilleRepository  apfvillerepository;
	
	@PostMapping("/ListVilles")
	public List<APFVILLE> getListVille(){	
		return apfvillerepository.findAll();
	}
	@PostMapping("/VilleFiltre")
	public List<APFVILLE> getListVilleByName(String nomVille){	
		
		return apfvillerepository.SearchByName("%"+nomVille.toLowerCase()+"%");
	}
	
	
}

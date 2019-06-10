package com.example.demo.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.APFUSERRepository;
import com.example.demo.Repository.ApfcdeentRepository;
import com.example.demo.model.APFUSER;
import com.example.demo.model.Apfcdeent;
import com.example.demo.modelSecond.EnteteComandeSearch;

@RestController
@CrossOrigin("*")
public class ApfcdeentRestController {

    @Autowired
	private ApfcdeentRepository apfcdeentRepository;
    
    
    @Autowired
	APFUSERRepository apfuserRepository;
    
    ///7olo badila mabrinach 7olo badila 7olol badil
	@GetMapping(value="supplier"
			+ "/EntetesCmdes") 
	public Page<Apfcdeent>  APFENTETE(
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int s){
	
		   return apfcdeentRepository.findAll(PageRequest.of(p, s));
	}
	
	@RequestMapping(value="supplier/SearchCommandes",method=RequestMethod.POST)
	public Page<Apfcdeent> searchCommandes(
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int s,
			@RequestBody EnteteComandeSearch entetes,
			String loginConnecte)
	{

		APFUSER userConnecte=apfuserRepository.findByUserlogin(loginConnecte);
		Long idSupplier=null;
	
	
	    if(entetes.getEcdcontrat()!=null) {  if(entetes.getEcdcontrat().isEmpty()) {  entetes.setEcdcontrat(null);   }  }
	    if(entetes.getEcdcexcde()!=null) {  if(entetes.getEcdcexcde().isEmpty()) {  entetes.setEcdcexcde(null);   }  }
	    if(entetes.getEnsCode()!=null) { if(entetes.getEnsCode().isEmpty()) {  entetes.setEnsCode(null);  }  }
	
		Date ecddminliv=null;
		if(entetes.getEcddminliv()!=null) {
			 ecddminliv=entetes.getEcddminliv();
		}
		Date ecddmaxliv=null;
		if(entetes.getEcddmaxliv()!=null) {
			ecddmaxliv=entetes.getEcddmaxliv();
		}
		
		return apfcdeentRepository.SearchBYFiltre(entetes.getEcdcexcde(),entetes.getEcdetatapf(),
				entetes.getEcddcommin(),entetes.getEcddcommax(),entetes.getEcddminliv(),entetes.getEcddmaxliv(),entetes.getEcdcontrat(),entetes.getSiteCod(),entetes.getEnsCode(),idSupplier,PageRequest.of(p, s));
	

	
	}
	


}

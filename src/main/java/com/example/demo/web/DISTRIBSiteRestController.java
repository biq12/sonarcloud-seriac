package com.example.demo.web; 

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.APFDISTRIBRepository;
import com.example.demo.Repository.APFDISTRIBSITERepository;
import com.example.demo.Repository.ApfcdeentRepository;
import com.example.demo.model.*;
import com.example.demo.modelSecond.DistribSiteDto;

@RestController
@CrossOrigin("*")

public class DISTRIBSiteRestController {

	@Autowired
	private APFDISTRIBSITERepository xrepository;
	 @Autowired
	private ApfcdeentRepository apfcdeentRepository;

	@Autowired
	APFDISTRIBRepository apfdistribRepository;
	
	@GetMapping(value="/getAllDistribSite")
	public Page<APFDISTRIBSITE> getAllDistribSite(@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="0") int si)
	{
		Page<APFDISTRIBSITE>  DISTRIBSITELists=xrepository.findAll(PageRequest.of(p, si));	
		return DISTRIBSITELists;
	}
	@GetMapping(value="/getAllDistribSiteByMot")
	public Page<APFDISTRIBSITE> Search(
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="8") int si,
			@RequestParam(name="wordidDistrib",defaultValue="0")Long idD,
			@RequestParam(name="wordlibellSite",defaultValue="")String  wordlibellSite,
			@RequestParam(name="wordcodEnsigne",defaultValue="")String  wordcodEnsigne,
			@RequestParam(name="wordcodSite",defaultValue="")String  wordcodSite)
	{
		
		Page<APFDISTRIBSITE>  DISTRIBSITELists=xrepository.searchByMotCleCod("%"+wordlibellSite+"%","%"+wordcodEnsigne+"%",PageRequest.of(p, si));
		return DISTRIBSITELists;
	}

	@GetMapping("/getSiteByLibelleAndCod")
	public Page<APFDISTRIBSITE>   SearchSiteBylibelleAndCod(
			@RequestParam(name="page",defaultValue="0") int p, 
			@RequestParam(name="size",defaultValue="8") int s,
			Long  wordcodSite,String libelleSite )
	{
	
		System.out.println("Code  :"+wordcodSite);
		System.out.println("libelleSite : "+libelleSite);
		Page<APFDISTRIBSITE>  DISTRIBSITELists=xrepository.SearchSiteBylibelleAndCod(wordcodSite,libelleSite,PageRequest.of(p, s));
		return DISTRIBSITELists;
	}
	
	@GetMapping(value="/getAllDistribSiteById")
	public Page<APFDISTRIBSITE> SearchById(@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int si,
			@RequestParam(name="idDistrib",defaultValue="0")Long idDistrib)
	{
		Page<APFDISTRIBSITE>  DISTRIBSITELists=xrepository.searchByMotCleIdDistrib(idDistrib,PageRequest.of(p, si));	
		return DISTRIBSITELists;
	}
	@GetMapping(value="/getByIDXMDistribSite/{idS}")
	public APFDISTRIBSITE GetByIdDistribSite(@PathVariable Long idS)
	{
		APFDISTRIBSITE  distribSite= xrepository.findById(idS).get();	
		return distribSite;
	}
	
	@RequestMapping(value="/DistribSite",method=RequestMethod.POST)
	public ResponseEntity Save(@RequestBody DistribSiteDto entit)
	{
        Optional<APFDISTRIBSITE> distribSite= xrepository.findById(entit.getSitecod());
		if(distribSite.isPresent()) {
			return new ResponseEntity("CODE de site  existe déja",HttpStatus.OK);
	     }
		 else {
			 
			APFDISTRIB distrib=apfdistribRepository.findById(entit.getDistribid()).get();
		    APFDISTRIBSITE entityToSave=new APFDISTRIBSITE(entit.getSitecod(),entit.getSitelib(), entit.getSitetype(),entit.getSiteadfa(), entit.getSiteadli(), entit.getSitcreated(), entit.getSitupdatby(), entit.getSitupdated(),entit.getApfville(), entit.getSiteaffichable(),entit.getSitenscod(),distrib);
			return new ResponseEntity<APFDISTRIBSITE>(xrepository.save(entityToSave),HttpStatus.OK);

		 }

	}
	@RequestMapping(value="/DistribSite/{idS}",method=RequestMethod.PUT)
	public ResponseEntity Update(@PathVariable Long idS, @RequestBody DistribSiteDto entit)
	{
	    entit.setSitecod(idS);
	    Optional<APFDISTRIBSITE> distribSite= xrepository.findById(entit.getSitecod());	
		if(distribSite.isPresent()) {
			APFDISTRIB distrib=apfdistribRepository.findById(entit.getDistribid()).get();
		    APFDISTRIBSITE entityToSave=new APFDISTRIBSITE(entit.getSitecod(),entit.getSitelib(), entit.getSitetype(),entit.getSiteadfa(), entit.getSiteadli(), entit.getSitcreated(), entit.getSitupdatby(), entit.getSitupdated(),entit.getApfville(), entit.getSiteaffichable(),entit.getSitenscod(),distrib);
			return new ResponseEntity<APFDISTRIBSITE>(xrepository.save(entityToSave),HttpStatus.OK);
	     }
		 else
		 {
				return new ResponseEntity("Site inexistant",HttpStatus.OK);
		 }
	}
	
 /**
  * This function permit to delete entity user
  * @param idS
  * @return
  */
	@RequestMapping(value="/DistribSite/{idS}",method=RequestMethod.DELETE)
	public ResponseEntity Delete(@PathVariable Long idS)
	{
		//condition 1 : if number of site which are related to commande greater than 0 .then no dlete this site44
		long nbr=apfcdeentRepository.countnbrSitActuelle(idS);
	    if(nbr>0) {
	    	return new ResponseEntity("Impossible de supprimer des commandes en liaisons ",HttpStatus.BAD_REQUEST);
	    }else
	    {
		    try {
		    	xrepository.deleteById(idS);
			    return new ResponseEntity("Elément supprimer  avec succés ",HttpStatus.BAD_REQUEST);
		    }catch(Exception e) {
		    	   return new ResponseEntity("Erreur lors de la suppression , possible element inexstant  ",HttpStatus.BAD_REQUEST);
		    }
	    }
		
	}
	
	
	
	
	
	
}

package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.*;

import com.example.demo.model.*;

@RestController
@CrossOrigin("*")
public class DistribRestController {
	
	@Autowired
	APFDISTRIBRepository apfdistribRepository;
	@Autowired
	ApfcdeentRepository apfcdeentRepository;
	
	@GetMapping(value="/getAllXMDISTRIB")
	public Page<APFDISTRIB> getALLDistrib(@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int si)
	{
		Page<APFDISTRIB>  DISTRIBLists=apfdistribRepository.findAll(PageRequest.of(p,si));	
		return DISTRIBLists;
	}
	@GetMapping(value="/getAllXMDISTRIBbyMotCle") 
	public Page<APFDISTRIB> SearchDistrib(
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="8") int si,
			@RequestParam(name="motCle",defaultValue="") String motCle)
	{
		Page<APFDISTRIB>  DISTRIBLists=apfdistribRepository.searchByMotCle("%"+motCle+"%",PageRequest.of(p,si));	
		return DISTRIBLists;
	}
	
	@PostMapping(value="/getByIDXMDistrib/{idS}")
	public APFDISTRIB getBYIDSupplier(@PathVariable Long idS)
	{
		APFDISTRIB  distrib= apfdistribRepository.findById(idS).get();	
		return distrib;
	}
	
	@RequestMapping(value="/Distribs",method=RequestMethod.POST)
	public ResponseEntity  Save(@RequestBody APFDISTRIB entity)
	{
	
		List<APFDISTRIB> list=apfdistribRepository.findAll();
		for(APFDISTRIB p:list) {
			if( (p.getDISTRIBCOD().toLowerCase()).equals(entity.getDISTRIBCOD().toLowerCase())) {
				  return new ResponseEntity("Code Distributeur existe déja",HttpStatus.BAD_REQUEST);
			}
		}          
	    return new ResponseEntity(apfdistribRepository.save(entity),HttpStatus.OK);
	}
	/**
	 *Update distributor
	 * @param idS is id of distributor
	 * @param entity
	 * @return   distibutor updated
	 */
	@RequestMapping(value="/Distribs/{idS}",method=RequestMethod.PUT)
	public  ResponseEntity<APFDISTRIB> Update(@PathVariable Long idS, @RequestBody APFDISTRIB entity)
	{
		System.out.println(idS+"  Entity : "+entity.getDISTRIBREM());
		
		entity.setDISTRIBID(idS);
		APFDISTRIB distriboriginal=apfdistribRepository.findById(idS).get();///distirb orginal
		APFDISTRIB distrib=apfdistribRepository.SearchDistribByCod(entity.getDISTRIBCOD().toLowerCase());
		System.out.print("entity"+entity.getDISTRIBCOD().toLowerCase());
 ///Nouveau code 
		if(distrib!=null) {
			///if he is the same code of ancien do update
			if(distriboriginal.getDISTRIBCOD().toLowerCase().equals(distrib.getDISTRIBCOD().toLowerCase())) {
				return new ResponseEntity<APFDISTRIB>(apfdistribRepository.save(entity),HttpStatus.OK);
			}
			///
			else
			{
				  return new ResponseEntity("Cod existe déja",HttpStatus.BAD_REQUEST);

			}
		}
	
		//Code Existe déja..............
		return new ResponseEntity<APFDISTRIB>(apfdistribRepository.save(entity),HttpStatus.OK);
	}
	@RequestMapping(value="/Distribs/{idS}",method=RequestMethod.DELETE)
	public ResponseEntity Delete(@PathVariable Long idS)
	{
		///before delete we choice test if the distrib has relation to site to ensignes to commandes 
		////Par rapport aux commandes 
		Long nbrDistrib=apfcdeentRepository.CountCommandbyDISTRIBID(idS);
		//System.out.println("Nbr is : "+nbrDistrib);
		//System.out.println("Distrib is :"+idS);
		if(nbrDistrib==0) {
			 apfdistribRepository.deleteById(idS);
				return new ResponseEntity<Boolean>(HttpStatus.OK);
		}
		else if(nbrDistrib>0) {
			return new ResponseEntity("Impossible de supprimer tant que des commandes sans en liason",HttpStatus.BAD_REQUEST);
			
		}else
		{
			return new ResponseEntity("Erreur Non Logique nbrDistrib<0",HttpStatus.BAD_REQUEST);
		}
		
		 
	}



}

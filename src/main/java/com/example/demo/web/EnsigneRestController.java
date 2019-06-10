package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.APFDISTRIBSITERepository;
import com.example.demo.Repository.APFEnsigneRepository;
import com.example.demo.model.APFDISTRIB;
import com.example.demo.model.APFDISTRIBENSEIGNE;

@RestController
@CrossOrigin("*")
public class EnsigneRestController {
	
	@Autowired
	private APFEnsigneRepository xrepository;
	@Autowired
	private APFDISTRIBSITERepository ensignexrepository;
	@Autowired
	private APFDISTRIBSITERepository sitexrepository;
	
	@RequestMapping(value="/ALLEnsignes",method=RequestMethod.GET)
	public Page<APFDISTRIBENSEIGNE> Search(@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="8") int size,
			@RequestParam(name="motCle",defaultValue="") String motCle) 
	{
		return xrepository.SearchByMotCle("%"+motCle.toLowerCase()+"%",PageRequest.of(page, size));
	}
	
	@RequestMapping(value="/ALLEnsignes/{id}",method=RequestMethod.GET)
	public APFDISTRIBENSEIGNE GetEnsigneById(@PathVariable Long id)
	{
		APFDISTRIBENSEIGNE  ensigne= xrepository.findById(id).get();
		return ensigne;
	}
	/***
	 * 
	 * @param entitUpdate
	 * @return Ensigne 
	 */
	@RequestMapping(value="/ALLEnsignes",method=RequestMethod.POST)
	public ResponseEntity<APFDISTRIBENSEIGNE> Save(@RequestBody APFDISTRIBENSEIGNE entitAdd)
	{
		 APFDISTRIBENSEIGNE ensigne=xrepository.SearchByCode(entitAdd.getENSCODE());
		 if(ensigne!=null)
		 {
		  
		   return new ResponseEntity("Code Ensigne existe déja",HttpStatus.BAD_REQUEST);

		 }
		 else
		{
			
			 xrepository.save(entitAdd);
			 return new ResponseEntity<APFDISTRIBENSEIGNE>(xrepository.save(entitAdd),HttpStatus.OK);
		}
	
	}
	
	@RequestMapping(value="/ALLEnsignes/{idE}",method=RequestMethod.PUT)
	public ResponseEntity<APFDISTRIBENSEIGNE>   Update(@PathVariable Long idE, @RequestBody APFDISTRIBENSEIGNE entitUpdate)
	{
		 //entitUpdate.setENSCODE(cod);
		 APFDISTRIBENSEIGNE ensigneOriginal=xrepository.findById(idE).get();
		 
		 APFDISTRIBENSEIGNE ensigneUpdate=xrepository.SearchByCode(entitUpdate.getENSCODE());
		 
		 if(ensigneOriginal!=null)
		 {
			 //si'il est lié à un site ? ne pas modifier then this one is reponse 
			 
			 /////on va caculer puisque le site et liéee seulment aux code pas a l id ou lentité 
			 Long nbr=sitexrepository.CountEnsigneCod(ensigneOriginal.getENSCODE());
			 System.out.println("******************************  :" +nbr);
			 if(nbr>0)
			 {
				   return new ResponseEntity("Impossibles de modifier dess sites et des commandes sont en liasion ",HttpStatus.OK);
			 }
			 else 
			 {
					 if(ensigneUpdate!=null)
					 {
						 if(entitUpdate.getENSCODE().toLowerCase().equals(ensigneOriginal.getENSCODE().toLowerCase())) {
							 //if ensigne c est le meme code que l'originale ......
							   xrepository.save(entitUpdate);
							   return new ResponseEntity("Modifié avec Succés",HttpStatus.OK);
						 }
						 else
						 {
							   return new ResponseEntity("Code Ensigne existe déja ",HttpStatus.OK);
						 }
						 
					 }
					 else
					 {
						 //c'est le code n'existe pas ....la 1er fois 
						 xrepository.save(entitUpdate);
						 return new ResponseEntity("Ensigne modifié avec succés ",HttpStatus.OK);
					 }
				 }
			 
		 }
		 else
		{
			   return new ResponseEntity("Entite  n'existes pas ,veuillez refraichir...",HttpStatus.OK);
		}
	
		
	}
	@RequestMapping(value="/ALLEnsignes/{idE}",method=RequestMethod.DELETE)
	public ResponseEntity Delete(@PathVariable Long idE)
	{
		 APFDISTRIBENSEIGNE ensigneOrigin=xrepository.findById(idE).get();
		 		 
		 if(ensigneOrigin!=null)
		 {
			 //si'il est lié à un site ? ne pas modifier then this one is reponse 
			 
			 /////on va caculer puisque le site et liéee seulment aux code pas a l id ou lentité 
			 Long nbr=sitexrepository.CountEnsigneCod(ensigneOrigin.getENSCODE());
			 System.out.println("******************************  :" +nbr);
			 if(nbr>0)
			 {
				   return new ResponseEntity("Impossibles de supprimer  dess sites et des commandes sont en liasion ",HttpStatus.OK);
			 }else
			 {
				   xrepository.deleteById(idE);
				   return new ResponseEntity("Supprimé avec Succés ",HttpStatus.OK);

			 }
		 }else
		 {
			   return new ResponseEntity("Entite  n'existes pas supprimé ,veuillez refraichir...",HttpStatus.OK);
		 }
	}
		 

	
	
	
}

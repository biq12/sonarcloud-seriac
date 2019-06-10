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

import com.example.demo.Repository.APFFOURNRepository;
import com.example.demo.Repository.ApfcdeentRepository;
import com.example.demo.model.*;

@RestController
@CrossOrigin("*")
public class FournRestController {

	@Autowired
	APFFOURNRepository apffournRepository;
	@Autowired
	ApfcdeentRepository apfcdeentRepository;
	
	
	@GetMapping(value="/getAllXMSuppliers")
	public Page<APFFOURN> getALLSuppl(@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="8") int si)
	{
		Page<APFFOURN>  SuppliersLists=apffournRepository.findAll(PageRequest.of(p, si));	
		return SuppliersLists;
	}
	@GetMapping(value="/getAllXMSuppliers2")
	public Page<APFFOURN> getALLSupplByMotCle(@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="8") int si,
			@RequestParam(name="motCle",defaultValue="") String mc,
		
			@RequestParam(name="typeCod",defaultValue="false") Boolean tcod,
			@RequestParam(name="typeEmail",defaultValue="false") Boolean temail)
	{
		System.out.println("tlib");

		Page<APFFOURN>  SuppliersLists;

		if(tcod)
		{
			SuppliersLists=apffournRepository.getAllFournByMotCle("%"+mc+"%",PageRequest.of(p, si));
		}
		else if(temail)
		{
		   SuppliersLists=apffournRepository.getAllFournByEmail("%"+mc+"%",PageRequest.of(p, si));

		}
		else if(tcod && temail)
		{
			   SuppliersLists=apffournRepository.getAllFournByM("%"+mc+"%",PageRequest.of(p, si));

		}
		else
		{
			SuppliersLists=apffournRepository.getAllFournByMotCle("%"+mc+"%",PageRequest.of(p, si));

		}
	
		return SuppliersLists;
	}
	@GetMapping(value="/getByIDXMSuppliers/{idS}")
	public APFFOURN getBYIDSupplier(@PathVariable Long idS)
	{
		APFFOURN  Supplier= apffournRepository.findById(idS).get();	
		return Supplier;
	}
	
	@RequestMapping(value="/Suppliers",method=RequestMethod.POST)
	public  ResponseEntity<APFFOURN> Save(@RequestBody APFFOURN APFFourn)
	{
		///vERIFIER L exitence d'une entite avec meme champs
		APFFOURN entity=apffournRepository.searchByCod(APFFourn.getFOURCOD());
		
		if(entity!=null) {
			return new ResponseEntity("Code existe déja",HttpStatus.OK);
		}else
		{
			return new ResponseEntity<APFFOURN>(apffournRepository.save(APFFourn),HttpStatus.OK);

		}
	}
	//Tester good 
	@RequestMapping(value="/Suppliers/{idS}",method=RequestMethod.PUT)
	public ResponseEntity<APFFOURN> Update(@PathVariable Long idS, @RequestBody APFFOURN entity)
	{
		APFFOURN entityOrigin=apffournRepository.findById(idS).get();
        if(entityOrigin!=null) {
        	if(entityOrigin.getFOURCOD().toLowerCase().equals(entity.getFOURCOD().toLowerCase())){
    			return new ResponseEntity<APFFOURN>(apffournRepository.save(entity),HttpStatus.OK);
        	}else
        	{
    			return new ResponseEntity("Code Fournisseur existe déja",HttpStatus.OK);
        	}
        }
        else
        {
        	apffournRepository.save(entity);
			return new ResponseEntity("Ajoute avec succés",HttpStatus.OK);

        }
	}
	//Tester good 
	@RequestMapping(value="Admin/Suppliers/{idS}",method=RequestMethod.DELETE)
	public ResponseEntity Delete(@PathVariable Long idS)
	{
		System.out.println("id :"+idS);

	
		///before delete we choice test if the distrib has relation to site to ensignes to commandes 
		////Par rapport aux commandes 
		try {	
				Long nbrSupplier=apfcdeentRepository.CountCommandbyFournID(idS);
			
				if(nbrSupplier==0) {
					Optional<APFFOURN> c=apffournRepository.findById(idS);
					if(c.isPresent()) {
						apffournRepository.deleteById(idS);
						 return new ResponseEntity<String>( "Supprimé avec Succés",HttpStatus.OK);
					}
					return new ResponseEntity<String>("ELément innexistant refraichir votre page",HttpStatus.OK);
				}
				return new ResponseEntity<String>("Impossible de supprimer tant que des commandes sans en cour",HttpStatus.OK);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<String>("Impossible de supprimer cet élements r",HttpStatus.OK);	
         }
	}
	
	
	
	
}

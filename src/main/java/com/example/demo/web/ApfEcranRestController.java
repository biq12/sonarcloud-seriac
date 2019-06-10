package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.APFEcranRepository;
import com.example.demo.model.Apfecran;

@RestController
@CrossOrigin("*")
public class ApfEcranRestController {

	@Autowired
	APFEcranRepository apfEcranRepository;
	
	
	@RequestMapping(value="admin/AddEcran",method=RequestMethod.POST)
	public ResponseEntity<Apfecran> addScreen(@RequestBody Apfecran  apfEcran) {
	   Apfecran ecran=apfEcranRepository.SearchByecranName(apfEcran.getEcranname());
	   
	   if(ecran!=null) {
		   return new ResponseEntity("Nom Ecran existe déja",HttpStatus.OK);
	   }else
	   {
		   apfEcranRepository.save(apfEcran);
		   return new ResponseEntity("Ajouter avec Succés",HttpStatus.OK);

	   }
	}
	/**
	 * Update Ecran
	 * @return
	 */

	@RequestMapping(value="admin/UpdateEcran",method=RequestMethod.PUT)
	public ResponseEntity Save(@RequestBody Apfecran entity)
	{
		try {
				Apfecran ecranOrigin=apfEcranRepository.findById(entity.getId()).get();
				Apfecran ecranToSav=apfEcranRepository.SearchByecranName(entity.getEcranname());
				if(ecranToSav!=null) {
					if(ecranOrigin.getEcranname().toLowerCase().contentEquals(entity.getEcranname().toLowerCase())) {
						apfEcranRepository.save(entity);
						 return new ResponseEntity("Modifié avec Succés",HttpStatus.OK);
					}
					return new ResponseEntity("Nom écran existe déja ",HttpStatus.OK);
				}
				else {
					apfEcranRepository.save(entity);
					 return new ResponseEntity("Modifié avec Succés",HttpStatus.OK);
				}
		 }
		 catch(Exception e) {
			 return new ResponseEntity("Ecran erreur lors de la mise à jour ",HttpStatus.OK);
		 }
		
	}
	
	@RequestMapping(value="admin/deleteEcran/{idS}",method=RequestMethod.DELETE)
	public ResponseEntity Delete(@PathVariable Long idS)
	{
		try {
				Apfecran ecran=apfEcranRepository.findById(idS).get();
				if(ecran==null) {
					return new ResponseEntity("Ecran Inexistante ",HttpStatus.BAD_REQUEST);
				}else
				{
					apfEcranRepository.deleteById(idS);
					return new ResponseEntity("Ecran Supprimé ",HttpStatus.OK);
				}
		}catch(Exception e) {
			return new ResponseEntity("Erreur coté server :"+e.getMessage(),HttpStatus.BAD_REQUEST);
		}


	}
	

	
	@RequestMapping(value="admin/getEcrans",method=RequestMethod.POST)
	public List<Apfecran> getAllEcran() {
		   return apfEcranRepository.findAll();

	}
   /**
    * Search Ecran by his name 
    * @param ecranName
    * @return
    */
	@RequestMapping(value="admin/SearchEcran",method=RequestMethod.POST)
	public List<Apfecran>  getEcranbyname(@RequestParam String ecranName) {
		
		   return apfEcranRepository.FiltreByName("%"+ecranName.toLowerCase()+"%");

	}

	
	
	
	
}

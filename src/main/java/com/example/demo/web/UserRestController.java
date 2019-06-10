package com.example.demo.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import com.example.demo.Services.IUserServices;
import com.example.demo.model.*;
import com.example.demo.modelSecond.Userdto;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@RestController
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	APFUSERRepository apfuserRepository;
	
	@Autowired
	IUserServices  iuserServices;
	
    @Autowired
    APFFOURNRepository apfFOURNRepository;
    @Autowired
    APFEcranRepository aPFEcranRepository;
	@Autowired
	private ApfRoleRepository apfRoleRepository ;
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    private static  Long codeSecurity;

	@GetMapping(value="/getAllUsersList")
	public List<APFUSER> getAllUsersList()
	{
		List<APFUSER>  listUser=apfuserRepository.findAll();	
		return listUser;
	}

	
	@PostMapping(value="/getAllListStaticsByYears")
	public List<StatisticsYears> getStaitistics(){
		List<APFUSER>  listUser=apfuserRepository.findAll();
		Map<Integer,Long>  mapStaticsBymonth=new HashMap();
		List<StatisticsYears>  listStaticsBymonth=new ArrayList<StatisticsYears>();
	
		Long quantite=0L;
		for(APFUSER p:listUser) {
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(p.getUSERCREATED());
			Integer year = calendar.get(Calendar.YEAR);
			quantite=apfuserRepository.SearchByYearsParam(year);
			mapStaticsBymonth.put(year,quantite);
		}
		for (Map.Entry<Integer,Long> entry : mapStaticsBymonth.entrySet()) {
			listStaticsBymonth.add(new StatisticsYears(entry.getKey(),entry.getValue()));
		}
		return listStaticsBymonth;
	}
	

	@PostMapping(value="/getAllListStaticsByYearsAndMonth")
	public List<StatiscticByMonthAndYear> getStaitisticsbyMonthAndYears(
			@RequestParam(name="years",value="")Integer years){
		
		List<APFUSER>  listUser=apfuserRepository.getAllUSERSMonths(years);
		Map<Integer,Long>  mapStaticsBymonth=new HashMap();
		List<StatiscticByMonthAndYear>  listStaticsBymonth=new ArrayList<StatiscticByMonthAndYear>();
		//Il suffit de triez ce truc oko :) 
		Long quantite=0L;
		///We use map because he doesn t accepte doublons 
		for(APFUSER p:listUser) {
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(p.getUSERCREATED());
			Integer month = calendar.get(Calendar.MONTH)+1;
	          System.out.println(p.getUSERCREATED().getMonth()+" comp +"+month);
			   quantite=apfuserRepository.CountByMonth(month,years);
	          System.out.println(quantite);

			mapStaticsBymonth.put(month,quantite);
		}
		boolean exit=false;
		
			for(int i=1;i<12;i++) {
				for (Map.Entry<Integer,Long> entry : mapStaticsBymonth.entrySet()) {
					if(i==entry.getKey()) {
						exit =true;
					}
			    }
				if(!exit) {
					mapStaticsBymonth.put(i,0L);
				}
				exit=false;
		    }
	     
		for (Map.Entry<Integer,Long> entry : mapStaticsBymonth.entrySet()) {
			if(entry.getKey()==1) { listStaticsBymonth.add(new StatiscticByMonthAndYear("January",entry.getValue()));}
			if(entry.getKey()==2) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Fevrier",entry.getValue()));}
			if(entry.getKey()==3) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Mars",entry.getValue()));}
			if(entry.getKey()==4) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Avril",entry.getValue()));}
			if(entry.getKey()==5) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Mai",entry.getValue()));}
			if(entry.getKey()==6) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Juin",entry.getValue()));}
			if(entry.getKey()==7) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Juillet",entry.getValue()));}
			if(entry.getKey()==8) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Aout",entry.getValue()));}
			if(entry.getKey()==9) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Spetembre",entry.getValue()));}
			if(entry.getKey()==10) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Novemebre",entry.getValue()));}
			if(entry.getKey()==11) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Octobre",entry.getValue()));}
			if(entry.getKey()==12) { listStaticsBymonth.add(new StatiscticByMonthAndYear("Decembre",entry.getValue()));}	
		
		}
		//
		return listStaticsBymonth;
	}
	
	
	

	@GetMapping(value="/getAllXMUsers")
	public Page<APFUSER> getAllUsers(@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int si)
	{
		Page<APFUSER>  listUser=apfuserRepository.findAll(PageRequest.of(p, si));	
		return listUser;
	}
	@GetMapping(value="/getAllXMUsers2")
	public Page<APFUSER> getAllUsers2(
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int si,
			@RequestParam(name="motCle",defaultValue="") String motCle)
	{
		Page<APFUSER>  ListUser=apfuserRepository.SearchUSERLOGIN("%"+motCle+"%",PageRequest.of(p, si));
		return ListUser;
	}
	/*
	 * getAllUsersByAllFiltres
	 */
	@GetMapping(value="/getAllUsersByAllFiltres")
	public Page<APFUSER> getAllUserByWorld(
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int si,
			@RequestParam(name="login",defaultValue="") String login,
			@RequestParam(name="email",defaultValue="") String email,
			@RequestParam(name="lastName",defaultValue="") String lastName,
			@RequestParam(name="firstName",defaultValue="") String firstName,
			@RequestParam(name="checkprofil",defaultValue="-1")Long  checkprofil,
			@RequestParam(name="checketat",defaultValue="-1")Long checketat
			){
		   // 
		Page<APFUSER>  ListUser=null;
		//Etat et Profil ne sont pas ni administrateur And 
		if(checketat==-1 && checkprofil==-1) {
			 ListUser=apfuserRepository.SearchByFiltres0("%"+login+"%","%"+email+"%","%"+lastName+"%",
					"%"+firstName+"%",PageRequest.of(p, si));
		}
		/*  Etat (Status) (status in english ) have two case one 1 is active 0 disabled
		 *  if Status equals a -1 status it s not important to tr  
		 */
		
		else if(checketat!=-1 && checkprofil ==-1) {
			//i HE IS A sUPPLIER ? fOURNISSEUR if he search Supplier :) 
				ListUser=apfuserRepository.SearchByFiltres1("%"+login+"%","%"+email+"%","%"+lastName+"%",
						"%"+firstName+"%",checketat,PageRequest.of(p, si));
		}
		/**
		 * to check by all Parametre it s not a problem ..
		 */
        else if(checketat==-1 && checkprofil !=-1) {
        	if(checkprofil==2) {
        		ListUser=apfuserRepository.SearchByFiltresFourn2("%"+login+"%","%"+email+"%","%"+lastName+"%",
    					"%"+firstName+"%",PageRequest.of(p, si));
        	}
        	if(checkprofil==1) {
        		ListUser=apfuserRepository.SearchByFiltresDistrib2("%"+login+"%","%"+email+"%","%"+lastName+"%",
    					"%"+firstName+"%",PageRequest.of(p, si));
        	}
        	if(checkprofil==0) {
        		ListUser=apfuserRepository.SearchByFiltresAdmin2("%"+login+"%","%"+email+"%","%"+lastName+"%",
    					"%"+firstName+"%",PageRequest.of(p, si));
        	}
        	
		}
        else if(checketat!=-1 && checkprofil !=-1) {
        	if(checkprofil==2) {
        			ListUser=apfuserRepository.SearchByFiltresFourn2Etat("%"+login+"%","%"+email+"%","%"+lastName+"%",
        					"%"+firstName+"%",checketat,PageRequest.of(p, si));
        	}
        	if(checkprofil==1) {
        		ListUser=apfuserRepository.SearchByFiltresDistrib2Etat("%"+login+"%","%"+email+"%","%"+lastName+"%",
    					"%"+firstName+"%",checketat,PageRequest.of(p, si));
        	}
        	if(checkprofil==0) {
        		ListUser=apfuserRepository.SearchByFiltresAdmin2Etat("%"+login+"%","%"+email+"%","%"+lastName+"%",
    					"%"+firstName+"%",checketat,PageRequest.of(p, si));
        	}
        	
		}
		return ListUser;
	}
	
	
	@PostMapping(value="admin/Searchusers")
	public Page<APFUSER> searchUsers(
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int si,
			@RequestBody Userdto userdto)
	{
		try {
			Page<APFUSER>  listUser=apfuserRepository.searchUsers(userdto.getUserlogin(),userdto.getUseremail(),userdto.getUsernom(),userdto.getUserprenom(),
					userdto.getUserprofil(),userdto.getUseretat(),PageRequest.of(p, si));
			return listUser;
		}catch(Exception e) {
			System.out.println("erreur fetch users in searchUsers method ");
			return null;
		}
	}
	
	
	
	
	@GetMapping(value="/getByIDXMUsers/{idS}")
	public APFUSER getBYID(@PathVariable Long idS)
	{
		APFUSER  user= apfuserRepository.findById(idS).get();	
		return user;
	}

	public void InitialiserRole(){
		Apfrole roleuser=apfRoleRepository.SerachRoleByNom("USER");
    	Apfrole roleAdmin=apfRoleRepository.SerachRoleByNom("ADMIN");
    	
       if(roleuser==null) {
    	    apfRoleRepository.save(new Apfrole("USER"));
       }
       if(roleAdmin==null) {
    	   apfRoleRepository.save(new Apfrole("ADMIN"));
       }
	}
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public ResponseEntity Save(@RequestBody APFUSER  user)
	{
       try {
	    	   APFUSER userSerach=apfuserRepository.SearchEqualsToLogin(user.getUserlogin());
		   		if(userSerach!=null) {
		   			return new ResponseEntity("Login existe déja ",HttpStatus.BAD_REQUEST);
		   		}else
		   		{
		   			InitialiserRole();
		   			user.setUserpwd(bCryptPasswordEncoder.encode(user.getUserpwd()));
		   			//If user is profil admin o distrib oe utilisateur do this ..
		   	         user.getRoles().add(apfRoleRepository.SerachRoleByNom("USER"));
		   	         //if user profil is admin 
		   			if(user.getUSERPROFIL()==0){
		   		         user.getRoles().add(apfRoleRepository.SerachRoleByNom("ADMIN"));
		   			}
		   		
		   			return new ResponseEntity<APFUSER>(apfuserRepository.save(user),HttpStatus.OK);
		   		}
       }catch(Exception e) {
  			return new ResponseEntity(e.getCause(),HttpStatus.BAD_REQUEST);

       }
		
	}
	
	
	
	//Tester 
	@RequestMapping(value="/users/{idS}",method=RequestMethod.PUT)
	public ResponseEntity<APFUSER> Update(@PathVariable Long idS, @RequestBody APFUSER user)
	{	
		APFUSER  originEntity=apfuserRepository.findById(idS).get();
		try {
              //traiter si le login initical egale au vouveau 
			if(originEntity.getUserlogin().equals(user.getUserlogin())) {
				//pour eviter de cryoter un password deja crypter 
				 if(!user.getUserpwd().equals(originEntity.getUserpwd())) {
						user.setUserpwd(bCryptPasswordEncoder.encode(user.getUserpwd()));
				 }
				user.getRoles().removeAll(user.getRoles());//suprimer les roles admin et user 
				//les reinseres suivant son profil ......
				//En general un utilisateur soit administrateur soit un fourniseur ou distrib à la role USER
		         user.getRoles().add(apfRoleRepository.SerachRoleByNom("USER"));
		         //Si l'utilisateur est un administrateur il aura le role de PROFIL.. 
				if(user.getUSERPROFIL()==0){
			         user.getRoles().add(apfRoleRepository.SerachRoleByNom("ADMIN"));
				}
			
				return new ResponseEntity<APFUSER>(apfuserRepository.save(user),HttpStatus.OK);
			}else
			{
				 //traiter si le nouveau login n'existe pas déja 
				 APFUSER  entity=apfuserRepository.findByUserlogin(user.getUserlogin());
				 if(entity!=null) {
						return new ResponseEntity("Login existe déja",HttpStatus.OK);
				 }else
				 {
					//pour eviter de cryoter un password deja crypter 
					 if(!user.getUserpwd().equals(originEntity.getUserpwd())) {
							user.setUserpwd(bCryptPasswordEncoder.encode(user.getUserpwd()));
					 }
					user.getRoles().removeAll(user.getRoles());//suprimer les roles admin et user 
					//les reinseres suivant son profil ......
					//En general un utilisateur soit administrateur soit un fourniseur ou distrib à la role USER
			         user.getRoles().add(apfRoleRepository.SerachRoleByNom("USER"));
			         //Si l'utilisateur est un administrateur il aura le role de PROFIL.. 
					if(user.getUSERPROFIL()==0){
				         user.getRoles().add(apfRoleRepository.SerachRoleByNom("ADMIN"));
					}
					return new ResponseEntity<APFUSER>(apfuserRepository.save(user),HttpStatus.OK);
				 }
			}
		}catch(Exception e) {
			List<String> list=new ArrayList<String>();
			list.add(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity(list,HttpStatus.OK);

		}
	}
	
	
	
	
	/**
	 * this function permit to delete an entity uSER  
	 * @param idS
	 * @return
	 */
	@RequestMapping(value="/user/{idS}",method=RequestMethod.DELETE)
	public Boolean Delete(@PathVariable Long idS)
	{
		 apfuserRepository.deleteById(idS);
		 return true;
	}
	/**
	 * Set ecrans of user .............
	 * @param idS
	 * @param screenName
	 * @return
	 */
	/**
	 * Roen de c e  queu ejsusiu biq khalid
	 * @param idS
	 * @param screenName
	 * @return
	 */
	
	@RequestMapping(value="/usersSetEcran/{idS}",method=RequestMethod.POST)
	public Boolean SetScreenOfUser(@PathVariable("idS") Long idS,@RequestBody List<String> screenName)
	{
		System.out.print("Ecran :u="+screenName);
		
		APFUSER userp= apfuserRepository.findById(idS).get();
		System.out.println("Login ==> "+userp.getUserlogin());
		if(userp!=null) {
			userp.getScrens().removeAll(userp.getScrens());//setScrens();
			for(String s: screenName) {
				Apfecran ecran= aPFEcranRepository.SearchByecranName(s);
				if(ecran!=null) {
					System.out.println("Big one "+ecran);
			        userp.getScrens().add(ecran);
				}
			}
			apfuserRepository.save(userp);
		}
		 return true;
	}
	/**
	 * Return List Ecrans ...
	 * @param login
	 * @return
	 */
	@RequestMapping(value="admin/usergetEcrans/{login}",method=RequestMethod.POST)
	public List<String> getAllEcranOFUser(@PathVariable("login") String login) {
		/*
		APFUSER  entity=apfuserRepository.findByUserlogin(login);
       //retourner user ajouter les écrans sinon on a travailler sur la gestion des écrans 
		List<String> listEcrans=new ArrayList<String>();
		
		Collection<Apfecran> list= entity.getScrens();
		//insere name of ecrans ..........
		for (Apfecran apfecran : list) {
			listEcrans.add(apfecran.getEcranname());
		}
		return listEcrans;*/
		return iuserServices.getEcranOfUser(login);
	}
	/*
	 * login reste provosiore
	 */
	@RequestMapping(value="/sendreinitailiser",method=RequestMethod.POST)
	public boolean SendCodeReintialisation(@RequestBody APFUSER user) {
		APFUSER UserToUpdate=apfuserRepository.findByUserlogin(user.getUserlogin());
		APFUSER user2=apfuserRepository.searchByEmail(user.getUSEREMAIL());
		
		
		if(user2!=null) {
			InternetAddress[] c=null;
			Random r = new Random();
	        int n1 = r.nextInt(99987);
	        n1=n1+924;
	        user2.setUSERCODEREINTIAL(new Long(n1));
	        apfuserRepository.save(user2);
	        try {
	        	
	        		
			/*	EnvoyerMail(new InternetAddress(user2.getUSEREMAIL()),n1+" est votre code de récupération de compte RIS MARJANE",
						 " <div style='width:70%;font-family:Century Gothic;font-size: 14px;color:#8c8c8c;'> <h5> Bonjour Mr "+user.getUserlogin()+"</h5>"
						+ "<p> Nous avons reçu une demande de réinitialisation de votre mot de passe RIS Marjane " + 
						"Entrez le code de réinitialisation du mot de passe suivant :</p>  "
						+ "<span style='width:100px';background-color:#f5f5f5; border-color: #ddd;'>""</span>"
						
						);*/
	        		String text=" <div style=\"background-color:#dcdcdc;padding:35px 60px 30px 60px;\">"
	        				+ "<div style=\"background-color: #ffffff;\"> " + 
		        				"    <div style=\" padding:2px 10px 2px 10px; text-align: center;\"> " + 
				        				"            <h4 style=\"font-weight: bold;font-size:18px;\">PORTAIL <span style=\"color: rgb(52,56,114)\" >R</span><span  style=\"color: red\">I</span><span  style=\"color:  black\">S</span></h4>\r\n" + 
		        				"    "
		        				+ "</div>" + 
	        				
	   
	        				"    <div style=\"margin-top:0px;background-color: #ffffff;text-align: left;padding:0px 10px 10px 10px;\">\r\n" + 
	        				"      <p style=\"font-weight: bold\"> Bonsoir Mr "+user.getUserlogin()+" </p>\r\n" + 
	        				"\r\n" + 
	        				"      <p> Nous avons reçu une demande de réinitialisation de votre mot de passe RIS Marjane\r\n" + 
	        				"        Entrez le code de réinitialisation du mot de passe suivant :</p>\r\n" + 
	        				"      <label style=\"padding:10px 20px 10px 20px; width:100px;background-color:#cccccc; border-color: #ddd;\">"+n1+"</label>\r\n" + 
	        				"    </div>\r\n" + 
	        				"\r\n" + 
	        				"    <div style=\"margin-top:15px;background-color:#ededed;padding:10px 10px 10px 10px;\">\r\n" + 
	
	        				"        <p style=\"font-size: 11px;text-align:center;\"> " + 
	        				"            Privacy statement | Cookies | Contact us | Visit ris.com <br/>"
	        				+        "</p>" + 
	        				"        <p style=\"font-size: 11px;text-align:left;\">"
	        				+ "         If you prefer not to receive future marketing communications including event, research, analysis or marketing information, please contact our.<br/>" + 
	        				 
	        				"           ©All Rights Reserved. | Seriacom, 2ème étage Technnopark  , N bureau 234 , Casablanca, Maroc,Fixe : 0512458978 ,GSM : 0612879589 " + 
	        				"       </p>" + 
	        				"    </div>\r\n" + 
	        				"\r\n" + 
	        				"  </div>\r\n" + 
	        				"\r\n" + 
	        				"</div>";
	        	
	        	
	        	EnvoyerMail(new InternetAddress(user2.getUSEREMAIL()),n1+" est votre code de récupération de compte RIS MARJANE",text);
			
	        } catch (AddressException e) {
				return false;
			}   	
		  return true;
		}
		return false;
	}
	/*
	 * verifier le code send by user with other in database 
	 */
	@RequestMapping(value="verifyCodSend/{code}",method=RequestMethod.POST)
	public boolean VerifyCodSend(@PathVariable("code") Long code,@RequestParam("email") String email) {
		APFUSER UserToUpdate2=apfuserRepository.searchByEmail(email);

		System.out.println("email"+email +"code et enrigis => "+code+"==?"+UserToUpdate2.getUSERCODEREINTIAL());
		if(UserToUpdate2.getUSERCODEREINTIAL().equals(code))
		{
			return true;
		}else
		{
			 return false;
		}
	}
	
	@RequestMapping(value="updatePassword",method=RequestMethod.POST)
	public String UpdatePassword(@RequestParam("email") String email, @RequestParam("pwd") String pwd) {
		
		System.out.println("email !" + email );

		//APFUSER UserToUpdate=apfuserRepository.findByUserlogin(user.getUserlogin());
		APFUSER UserToUpdate=apfuserRepository.searchByEmail(email);
		System.out.println("here");
		
		if(UserToUpdate!=null) {
			try 
			{
				UserToUpdate.setUserpwd(bCryptPasswordEncoder.encode(pwd));
		        apfuserRepository.save(UserToUpdate);
		       
		        
		        
		       
		        
		        
		    	String text=" <div style=\"background-color:#dcdcdc;padding:35px 60px 30px 60px;\">"
        				+ "<div style=\"background-color: #ffffff;\"> " + 
	        				"    <div style=\" padding:2px 10px 2px 10px; text-align: center;\"> " + 
			        				"            <h4 style=\"font-weight: bold;font-size:18px;\">PORTAIL <span style=\"color: rgb(52,56,114)\" >R</span><span  style=\"color: red\">I</span><span  style=\"color:  black\">S</span></h4>\r\n" + 
	        				"    "
	        				+ "</div>" + 
        				
   
        				"    <div style=\"margin-top:0px;background-color: #ffffff;text-align: left;padding:0px 10px 10px 10px;\">\r\n" + 
        				"      <p style=\"font-weight: bold\"> Bonsoir Mr "+UserToUpdate.getUserlogin()+" </p>\r\n" + 
        				
						"Suite à votre demande nous avons Réintialiser votre mot,c'est vous avez pas aucun relation avec cette action veuillez nous contacter votre information actuelle sont  : <br> login "+UserToUpdate.getUserlogin()+ 
						"  Votre mot de Passe  : "+pwd+""
								+ "</p>"

        				+ "</div>\r\n" + 
        				
                      	"    <div style=\"margin-top:15px;background-color:#ededed;padding:10px 10px 10px 10px;\">\r\n" + 
	
	        				"        <p style=\"font-size: 11px;text-align:center;\"> " + 
	        				"            Privacy statement | Cookies | Contact us | Visit ris.com <br/>"
	        				+        "</p>" + 
	        				"        <p style=\"font-size: 11px;text-align:left;\">"
	        				+ "         If you prefer not to receive future marketing communications including event, research, analysis or marketing information, please contact our.<br/>" + 
	        				 
	        				"           ©All Rights Reserved. | Seriacom, 2ème étage Technnopark  , N bureau 234 , Casablanca, Maroc,Fixe : 0512458978 ,GSM : 0612879589 " + 
	        				"       </p>" + 
	        				"    </div>\r\n" + 
	        				"\r\n" + 
	        				"  </div>\r\n" + 
	        				"\r\n" + 
	        				"</div>";
	        			  EnvoyerMail(new InternetAddress(email),"RIS mot de Passe modifié",text);
		                  return "Modifié ave succés";
			    				
			}
			catch(Exception e)
			{
				 return "Probléme veuillez retentez";
			}
		
		}else
			 
			return "Probléme leur de la modification ";
	
	}
	
	
	public  void EnvoyerMail(InternetAddress adress,String objet, String corps) {
        final String username = "ris@seriacom.ma";
        final String password = "email";
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.ssl.enable", "true");

        props.put("mail.smtp.host", "smtp.seriacom.ma");

        props.put("mail.smtp.port", "465");  //587 //465

        props.setProperty("mail.smtp.ssl.trust", "smtp.seriacom.ma");               

        Session session = Session.getInstance(props,

          new javax.mail.Authenticator() {

              protected PasswordAuthentication getPasswordAuthentication() {

                   return new PasswordAuthentication(username, password);

              }

          });

        //session.setDebug(true);

        try {
              Message message = new MimeMessage(session);

              message.setFrom(new InternetAddress("noreply@seriacom.ma"));

              message.setRecipient(Message.RecipientType.TO,adress);

              message.setSubject(objet);

              message.setContent(corps,"text/html");

              message.setSentDate(new java.util.Date());
              
           
              
              
              
              
              
              
              
              
              
              
              Transport.send(message);
        } catch (MessagingException e) {

              e.printStackTrace();

        }
	}
	
	

	
	
	
	
	
}////////////////////////classe proinceipe






class StatiscticByMonthAndYear{
	public String month;
	public Long quantite;
	//List of statistics i a mnot tooken 
	public StatiscticByMonthAndYear() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatiscticByMonthAndYear(String month, Long quantite) {
		super();
		this.month = month;
		this.quantite = quantite;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Long getQuantite() {
		return quantite;
	}
	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}
	
}


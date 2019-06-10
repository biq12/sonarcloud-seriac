package com.example.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import com.example.demo.Repository.APFEcranRepository;
import com.example.demo.Repository.APFUSERRepository;
import com.example.demo.Repository.ApfRoleRepository;
import com.example.demo.Repository.ApfcdeentRepository;
import com.example.demo.model.APFUSER;
import com.example.demo.model.Apfecran;
import com.example.demo.model.Apfrole;
import com.example.demo.model.Apfcdeent;


@SpringBootApplication
public class SeriacomProjetApplication implements CommandLineRunner {

		@Autowired
		private APFUSERRepository apfUSERRepository;
		@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;
		@Autowired
		private ApfRoleRepository apfRoleRepository ;
		
	    public static void main(String[] args) {
	        SpringApplication.run(SeriacomProjetApplication.class, args);
	    }

	    @Override
	    public void run(String... args) throws Exception {
         
	    	Apfrole roleuser=apfRoleRepository.SerachRoleByNom("USER");
	    	Apfrole roleAdmin=apfRoleRepository.SerachRoleByNom("ADMIN");
	    	
	    	
           if(roleuser==null) {
        	    apfRoleRepository.save(new Apfrole("USER"));
           }
           if(roleAdmin==null) {
        	   apfRoleRepository.save(new Apfrole("ADMIN"));
           }
           

/*
          APFUSER p=new APFUSER();
          p.setUserlogin("yas11");
          p.setUserpwd(bCryptPasswordEncoder.encode("123"));
          p.setUSERETAT(1);
          p.setUSERFLAGNOTIF(1);
          p.setUSERPROFIL(1);
          p.setUSERNOM("khalid");
          p.setUSERPRENOM("BIQ");
          p.setUSEREMAIL("khalid.biq2017@gmail.com");
          p.setUSERCREATED(new Date());
          p.setUSERUPDATBY("khalid");
          p.setUSERUPDATED(new Date());
         
          Collection<Apfecran> list=new ArrayList<Apfecran>();
          p.getRoles().add(apfRoleRepository.SerachRoleByNom("USER"));
          p.getRoles().add(apfRoleRepository.SerachRoleByNom("ADMIN"));
          apfUSERRepository.save(p);
          */
          /*
 
	      
		          p=new APFUSER();
		          p.setUserlogin("yos2");
		          p.setUSERETAT(1);
		          p.setUSERFLAGNOTIF(1);
		          p.setUSERPROFIL(1);
		          p.setUserpwd(bCryptPasswordEncoder.encode("123"));
		          Collection<Apfecran> list2=new ArrayList<Apfecran>();
		          p.getRoles().add(apfRoleRepository.findById(2L).get());
		          //p.setScrens();
		          apfUSERRepository.save(p);
		          System.out.println("test d");
	        */
          
          
	    }
	    
	
		@Bean
		BCryptPasswordEncoder getBCPE() {
			return new BCryptPasswordEncoder();
		}
	
		@Bean
		public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		    StrictHttpFirewall firewall = new StrictHttpFirewall();
		    firewall.setAllowUrlEncodedSlash(true);    
		    return firewall;
		}

	
	
}

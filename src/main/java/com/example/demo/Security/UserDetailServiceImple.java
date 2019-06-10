package com.example.demo.Security;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.APFUSERRepository;
import com.example.demo.model.APFUSER;

@Service
public class UserDetailServiceImple implements UserDetailsService{

    @Autowired
	private APFUSERRepository  apfUSERRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		APFUSER appUser=apfUSERRepository.findByUserlogin(username);
		//System.out.print("============>  "+appUser+"---------------------------------------------------");
		if(appUser==null) throw new UsernameNotFoundException("Login incorrecte");
	    //	User c=new User
		 Collection<GrantedAuthority> autorities=new ArrayList<>();
			appUser.getRoles().forEach(r->{
				autorities.add(new SimpleGrantedAuthority(r.getRolename()));
			});
		
			
		    return new User(appUser.getUserlogin(),appUser.getUserpwd(),autorities);		
	}

	
	
	
	
	
	
	
	
	

}

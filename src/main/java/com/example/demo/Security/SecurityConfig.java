package com.example.demo.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////copyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy
///////////////////////////////////////
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//interface interne de spring security 
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
   @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		//userdetailservice interface interface interne en sprins securty
		//il utilise bcryptpasswordEncoder comme coder 
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
  

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/managederap/**");
		http.csrf().disable();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		http.authorizeRequests().antMatchers("/login","/managederap/**","/updatePassword","/sendreinitailiser","/verifyCodSend/*").permitAll();
		http.authorizeRequests().antMatchers("/supplier/**").hasAuthority("USER"); 
		http.authorizeRequests().antMatchers("/ALLEnsignes","/getSiteByLibelleAndCod").hasAuthority("USER"); 
		http.authorizeRequests().antMatchers("/**").hasAuthority("ADMIN");
	
		http.authorizeRequests().antMatchers("/**/**").hasAuthority("ADMIN");
		
		
		http.authorizeRequests().antMatchers("/login").permitAll();
		
		
		///autohrizer login sans authentification : et register :
	
		http.authorizeRequests().anyRequest().authenticated();///tous les anti demande une authoficiat
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));//ce filtre va ne pemet de gere le tooken .......
	
		///cette ligne c est de signer :) et veirfier signtaure appres recip
		//addFilterBefore(filter, beforeFilter)
		http.addFilterBefore(new JWTAuthorizationFIlter(), UsernamePasswordAuthenticationFilter.class);
/*
 * i had never seen then sene thens ene then sene threns ene thens een then sene hen sene then seen then sene then 
 * i am not tooken to 
 */
	 
	
	}
	
	
	
	
     

   
   
   
   
   
}

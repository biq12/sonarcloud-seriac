package com.example.demo.Security; 

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.Services.IUserServices;
import com.example.demo.model.APFUSER;
import com.example.demo.model.Apfecran;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	
	private AuthenticationManager  authenticationManager;
	
	@Autowired
	IUserServices  iuserServices;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
	//	super();
		this.authenticationManager = authenticationManager;
	}
/*
 * (non-Javadoc)
 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
    		throws AuthenticationException {
	    
	     	APFUSER appUser;
	    	try {
	    		 appUser= new ObjectMapper().readValue(request.getInputStream(),APFUSER.class);
	    		 
	    		return authenticationManager.authenticate(
	    					new UsernamePasswordAuthenticationToken(
	    							appUser.getUserlogin(), 
	    							appUser.getUserpwd()
	    							));
	    		} catch (Exception e) {
                      throw new RuntimeException("login invalide or password incorrecte");
	    		} 
    }
/*

rien de plus spéciale i am not tooken to seen
 *//*
    List<String> getEcranUser(){
    	APFUSER   entity=iuserServices.searchUserBylogin(springUser.getUsername());
		List<String> listEcrans=new ArrayList<>();
		Collection<Apfecran> list= entity.getScrens();
		for (Apfecran apfecran : list) {
			listEcrans.add(apfecran.getEcranname());
		}
		return listEcrans;
    }*/

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
		Authentication authResult) throws IOException, ServletException {
		
		User springUser=(User)authResult.getPrincipal();//return user authenticate..
		List<String> roles=new ArrayList<>();
				authResult.getAuthorities().forEach(a->{
					roles.add(a.getAuthority());
		});
		
		
							
		String jwt=JWT.create() 
				 .withIssuer(request.getRequestURI())
				 .withSubject(springUser.getUsername())
				 .withArrayClaim("roles",roles.toArray(new String[roles.size()]))
				 .withExpiresAt(new Date(System.currentTimeMillis()+10*24*3600*10000))
				  .sign(Algorithm.HMAC256("secretNom"));//un Secret de nom .........
		  
		// authorization  = nom ; jwt on le precede avec un prefix
		///		response.addHeader("Autorization","Bearer"+jwt);

		 response.addHeader("Authorization",jwt);
		
		
	}

}

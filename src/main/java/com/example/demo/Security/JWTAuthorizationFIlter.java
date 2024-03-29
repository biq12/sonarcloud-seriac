package com.example.demo.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthorizationFIlter extends OncePerRequestFilter{


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With,Content-Type, Access-Control-Request-Method, Access-Control-RequestHeaders,authorization");
		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials, authorization");
	    response.addHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,PATCH");
	   
	  
		if(request.getMethod().equals("OPTIONS")){
		   response.setStatus(HttpServletResponse.SC_OK);
		}
		else if(request.getRequestURI().equals("/login")) {
			filterChain.doFilter(request, response);
		}
		else if(request.getRequestURI().equals("/managederap/**")) {
			filterChain.doFilter(request, response);
		}
		else {

			String jwt=request.getHeader("Authorization");///recupere le jwt il a nom authiriuzation 
		//	System.out.println("Tokken with header ="+jwt);
			if(jwt==null || !jwt.startsWith("NomPrefix")) {
				filterChain.doFilter(request, response);// si non je oasse au filtre ssuivant 
				return ;
			}
			
				 JWTVerifier verifier=JWT.require(Algorithm.HMAC256("secretNom")).build();
				 DecodedJWT decodedJWT=verifier.verify(jwt.substring("NomPrefix".length()));

				 String username=decodedJWT.getSubject();
				 List<String> roles=decodedJWT.getClaims().get("roles").asList(String.class);
				
				 
				 Collection<GrantedAuthority> authorities=new ArrayList<>();
				 roles.forEach(rn->{
					 authorities.add(new SimpleGrantedAuthority(rn));
				 });
				 UsernamePasswordAuthenticationToken user=new UsernamePasswordAuthenticationToken(username,null,authorities);
				 SecurityContextHolder.getContext().setAuthentication(user);
				 filterChain.doFilter(request, response);
		} 

		
		
		
	}

	

}

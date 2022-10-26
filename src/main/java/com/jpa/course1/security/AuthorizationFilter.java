package com.jpa.course1.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter{
	
	public AuthorizationFilter(AuthorizationManager authManager)
	{
		super((AuthenticationManager) authManager);
	}
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		String header=req.getHeader(SecurityConstant.HEADER_STRING);
		if(header==null || !header.startsWith(SecurityConstant.TOKEN_PREFIX))
		{
			chain.doFilter(req, res);
			return;
		}
		UsernamePasswordAuthenticationToken authorization=getAuthentication(req);
		SecurityContextHolder.getContext().setAuthentication(authorization);
		chain.doFilter(req, res);
		
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req)
	{
		String token=req.getHeader(SecurityConstant.HEADER_STRING);
		if(token!=null)
		{
			token=token.replace(SecurityConstant.TOKEN_PREFIX,"");
			
			String user= Jwts.parser()
					 .setSigningKey(SecurityConstant.getTokenSecret())
					 .parseClaimsJws(token)
					 .getBody()
					 .getSubject();
			if(user!=null)
			{
				return new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
			}
		}
		return null;
	}

}

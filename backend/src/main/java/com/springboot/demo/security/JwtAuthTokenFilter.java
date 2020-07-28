package com.springboot.demo.security;

import java.io.IOException;
 
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthTokenFilter extends OncePerRequestFilter {
 
  @Autowired
  private JwtProvider tokenProvider;
 
  @Autowired
  private UserDetailsServiceImpl userDetailsService;
 
  private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
          //chec JWT if it is valid--get user details amd store it in securotuiconfig.
      String jwt = getJwt(request);
      if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
    	  
    	  //if jwt is valid -->  extracts username/password from the received token using JwtProvider
        String username = tokenProvider.getUserNameFromJwtToken(jwt);
        
         /* Then based on the extracted data, JwtAuthTokenFilter:
           – creates a AuthenticationToken (that implements Authentication)
           – uses the AuthenticationToken as Authentication object and 
         stores it in the SecurityContext for future filter uses (e.g: Authorization filters).
         */
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        
        //check the JWT with user details
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
 
        
       // SecurityContextHolder is the most fundamental object where we store  details of the principal).
        //Spring Security uses an Authentication object to represent this information 
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
       
      }
    } catch (Exception e) {
      logger.error("Can NOT set user authentication -> Message: {}", e);
    }
 
    //continue the chain..input is validated
    filterChain.doFilter(request, response);
  }
 
  private String getJwt(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");     // check for header
 
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      return authHeader.replace("Bearer ", "");
    }
 
    return null;
  }
}
package com.scalops.Scallops.secuirty;/*  gaajiCode
    99
    30/08/2024
    */

import com.scalops.Scallops.CustomUserDetailService;
import com.scalops.Scallops.util.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component

public class JWTAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final  String authHeader=request.getHeader("Authorization");
        final String jwtToken;
        final  String userEmail;

        if (authHeader ==null || authHeader.isBlank()){
            filterChain.doFilter(request,response);
            return;
        }
        jwtToken=authHeader.substring(7);
        userEmail=jwtUtils.extractUsername(jwtToken);

        if (userEmail !=null && SecurityContextHolder.getContext().getAuthentication() ==null){
            UserDetails userDetails=customUserDetailService.loadUserByUsername(userEmail);
            if (jwtUtils.isValidToken(jwtToken,userDetails)){
                SecurityContext securityContext=SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken tokens=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                tokens.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                securityContext.setAuthentication(tokens);
                SecurityContextHolder.setContext(securityContext);
            }
        }
        filterChain.doFilter(request,response);
    }
}

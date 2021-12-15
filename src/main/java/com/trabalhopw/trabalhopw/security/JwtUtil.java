package com.trabalhopw.trabalhopw.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public  boolean tokenValido(String token) {
        Claims claims = getClams(token);
        if(claims != null){
            String username = claims.getSubject();
            Date expirationdate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            if(username != null && expirationdate != null && now.before(expirationdate)){
                return  true;
            }
        }
        return false;
    }

    public String getUserName(String token) {
        Claims claims = getClams(token);
        if(claims != null){
            return claims.getSubject();
        }
        return null;
    }

    private Claims getClams(String token) {
        try{
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        } catch (Exception ex){
            return null;
        }

    }

    public String generateToken(String login){
        return Jwts.builder().setSubject(login)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512,secret.getBytes())
                .compact();
    }
}

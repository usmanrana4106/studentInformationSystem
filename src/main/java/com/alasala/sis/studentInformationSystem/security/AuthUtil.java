package com.alasala.sis.studentInformationSystem.security;

import com.alasala.sis.studentInformationSystem.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {

    @Value("${jwt.secretkey}")
    public String jwtSecretKey;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(User user){
        String id = String.valueOf(user.getId());
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId",id)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*10 ))
                .signWith(getSecretKey())
                .compact();

    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }
}

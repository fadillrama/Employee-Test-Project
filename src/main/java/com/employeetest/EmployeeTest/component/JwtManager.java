package com.employeetest.EmployeeTest.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtManager {

    private final String SECRET_KEY = "this-is-secret-key-for-generate-token";

    private Date getIssueDate(){
        var now = LocalDateTime.now();
        var systemTime = now.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(systemTime);
    }

    public Claims getClaims(String token){
        var parser = Jwts.parser().setSigningKey(SECRET_KEY);
        var signatureAndClaims = parser.parseClaimsJws(token);
        var claims = signatureAndClaims.getBody();
        return claims;
    }

    public Long getId(String token){
        var claims = getClaims(token);
        return claims.get("id", Long.class);
    }

    public String getUsername(String token){
        var claims = getClaims(token);
        return claims.get("username", String.class);
    }

    public String generateToken(Long id, String username, String subject, String audience, String secretKey){
        var builder = Jwts.builder();
        builder = builder
                .setAudience(audience)
                .setSubject(subject)
                .claim("username", username)
                .claim("id", id)
                .setIssuer("http://localhost:7007")
                .setIssuedAt(getIssueDate())
                .signWith(SignatureAlgorithm.HS256, secretKey);
        return builder.compact();
    }
}

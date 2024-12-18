package com.example.demo.service;

import com.example.demo.model.AuthRequest;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTService {

    // Secret Key
    private final String SECRET_KEY = "dobpIz0BDIuIZsbAPAK2Zf2+0YkH98L90todZX2h9RY=";
    // sprktechnologies_123

    public String generateToken(AuthRequest authRequest) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(authRequest.getUsername(), claims);

    }

    private String createToken(String userName, Map<String, Object> claims) {


        return Jwts.builder()
                .header().add(Map.of("alg", "HS256", "typ",
                        "JWT", "org", "sprk technologies"))
                .and()
                .claims(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 1)) // 1 minute
                .signWith(getSignInKey())
                .compact();
        /*
         * 1000 ms * 60 s * 15 min
         */
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
package com.example.demo.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JsonWebToken {

    // Utilisez une clé secrète générée de manière sécurisée
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    private static final long EXPIRATION_TIME = 36000000;

    public static String generateToken(String data) {
        return Jwts.builder()
                .setSubject(data)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static String extractValue(String token, String key) throws Exception {
        System.out.println("IsExpired: " + JsonWebToken.isTokenExpired(token));
        System.out.println("tafiditra");
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Replace with your secret key
                .build()
                .parseClaimsJws(token)
                .getBody();

        // Extract the subject
        String data = claims.getSubject();

        // Split the subject into key-value pairs
        String[] keyValuePairs = data.split(";");
        for (String pair : keyValuePairs) {
            String[] parts = pair.split("=");
            if (parts.length == 2 && parts[0].equals(key)) {
                return parts[1];
            }
        }

        return null; // Key not found
    }

    public static boolean isTokenExpired(String token) {
        System.out.println("exipire*****");
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Remplacez par votre clé secrète
                .build()
                .parseClaimsJws(token)
                .getBody();

        // Récupérer la date d'expiration du token
        Long expirationTime = claims.getExpiration().getTime();

        // Comparer avec l'heure actuelle
        return expirationTime < System.currentTimeMillis();
    }

}

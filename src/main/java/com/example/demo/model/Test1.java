package com.example.demo.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

    // Utilisez une clé secrète générée de manière sécurisée
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    private static final long EXPIRATION_TIME = 4000000; // 10 jours en millisecondes

    public static String generateToken(Map<String, String> data) {
        return Jwts.builder()
                .setClaims(data)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static String extractValue(String token, String key) throws Exception {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Replace with your secret key
                .build()
                .parseClaimsJws(token)
                .getBody();

        // Extract the value for the specified key
        return claims.get(key, String.class);
    }

    public static boolean isTokenExpired(String token) {
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

    public static void main(String[] args) {
        // Exemple d'utilisation
        Map<String, String> data = new HashMap<>();
        data.put("userId", "123");
        data.put("role", "admin");

        String jwt = generateToken(data);
        System.out.println("Token généré : " + jwt);

        try {
            String userId = extractValue(jwt, "userId");
            System.out.println("User ID extrait : " + userId);
        } catch (Exception e) {
            System.err.println("Erreur d'extraction de la valeur : " + e.getMessage());
        }
    }
}


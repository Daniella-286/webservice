package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.JsonWebToken;
import com.example.demo.model.Utilisateur;
import com.example.demo.service.UtilisateurService;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UtilisateurService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserController(UtilisateurService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public String accueil(@RequestParam String email, String mdp){
        /*String email = user.getEmail();
        String mdp = user.getMdp();*/
        String msg="";
        /*String email = user.getEmail();
        String mdp = user.getMdp();*/
        ResponseEntity<Utilisateur> users = validation(email,mdp);
        if(users.getBody()!=null){
            msg = JsonWebToken.generateToken("userId=" + users.getBody().getId_user());
        }else{
            msg = "Desoler mot de passe incorrect";
        }
        // Affichez les données dans la console
        /*logger.info("Données reçues du formulaire: email={}, password={}", email, mdp);
        String message = "Authentification réussie!"+email;*/
        return msg;
    }

    @PostMapping("/login1")
    public int accueil1(@RequestBody Utilisateur user){
        /*String email = user.getEmail();
        String mdp = user.getMdp();*/
        String msg="";
        /*String email = user.getEmail();
        String mdp = user.getMdp();*/
        //ResponseEntity<Utilisateur> users = validation(email,mdp);
        if(user.getEmail().equals("admin@gmail.com") && user.getMdp().equals("admin")){
           return 1;
        }else{
            return 0;
        }
        // Affichez les données dans la console
        /*logger.info("Données reçues du formulaire: email={}, password={}", email, mdp);
        String message = "Authentification réussie!"+email;*/
      
    }

    @PostMapping("/checking")
    public String checkUtilisateur(String email,String mdp) {
            ResponseEntity<Utilisateur> user = validation("Daniella@gmail.com","1234");
            String msg = "";
            //HttpHeaders headers = user.getHeaders();
            //long contentLength = headers.getContentLength();
            //Employer utilisateur = new Employer(1,"Rindra","Juvenal");
            System.out.println("Exemple token***************: " + user.getBody());
            if(user.getBody()!=null){
                String token = JsonWebToken.generateToken("userId=" + user.getBody().getId_user());
            //System.out.println("Exemple token: " + token);
            //System.out.println("Token[userRole]: " + JsonWebToken.extractValue(token, "userRole"));
                msg = "{\"message\": \"Vous êtes connecté\", \"token\": \"" + token + "\"}";
            }else{
             msg = "Desoler mot de passe incorrect";
            }
            return msg;
       // return ResponseEntity.ok("{\"message\": \"Erreur, echec de connexion\"}");
    }

    @PostMapping("/auth")
    public String authentificate(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                // Extraire le token après "Bearer "
                String token = authorizationHeader.substring(7);

                System.out.println("Token from JS: " + token);
                System.out.println("Token[userRole]: " + JsonWebToken.extractValue(token, "userId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"message\": \"Exception, Session expiree\"}";
        }

        return "{\"message\": \"Authentification reussi\"}";
    }

    @GetMapping("/insertUser")
    public ResponseEntity<Utilisateur> insertUser(@RequestParam String nom,String prenom,String dtn,String email,String telephone,String adresse, String mdp, String dte) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dtn);
        Date date1 = dateFormat.parse(dte);
        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setDtn(date);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setAdresse(adresse);
        user.setMdp(mdp);
        user.setDte(date1);
        return userService.saveUser(user);
    }

    @GetMapping("/validation")
    public ResponseEntity<Utilisateur> validation(String email,String mdp){
        return userService.validationParEmailEtMdp(email, mdp);
    }

}

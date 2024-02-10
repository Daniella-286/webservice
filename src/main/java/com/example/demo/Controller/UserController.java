package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public String accueil(@RequestBody Utilisateur user){
        /*String email = user.getEmail();
        String mdp = user.getMdp();*/
        String msg="";
        String email = user.getEmail();
        String mdp = user.getMdp();
        ResponseEntity<Utilisateur> users = validation(email,mdp);
        System.out.println("tonga ato ny entana*******");
        if(users.getBody()!=null){
            System.out.println("tonga ato ny entana*******");
            msg = JsonWebToken.generateToken("userId=" + users.getBody().getId_user());
        }else{
            msg = "null";
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
    public ResponseEntity<Utilisateur> insertUser(@RequestParam String nom,String prenom,String dateNaissance,String email,String telephone,String adresse, String motDepasse) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date date = dateFormat.parse("2000-09-09");
        LocalDate datet = LocalDate.now();
        Date dates = Date.from(datet.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setPrenom(prenom);
        if (dateNaissance != null && !dateNaissance.isEmpty()) {
            Date dates1 = dateFormat.parse(dateNaissance);
            user.setDtn(dates1);
            System.out.println("met"+dates1);
        } else {
            System.out.println("tay"+dateNaissance);
        }
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setAdresse(adresse);
        user.setMdp(motDepasse);
        user.setDte(dates);
        return userService.saveUser(user);
    }

    @GetMapping("/validation")
    public ResponseEntity<Utilisateur> validation(String email,String mdp){
        return userService.validationParEmailEtMdp(email, mdp);
    }

    @GetMapping("/getInfoUser")
    public ResponseEntity<Utilisateur> getInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        System.out.println("tsy azoko mintsy hgvygvygvghv");
        int id=0;
        try {
            String t = token.substring(7);
            id = Integer.parseInt(JsonWebToken.extractValue(t, "userId"));
            System.out.println("******************** daniella"+id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userService.getUserById(id);
    }



}

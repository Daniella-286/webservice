package com.example.demo.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.JsonWebToken;
import com.example.demo.model.Messagerie;
import com.example.demo.service.MessageService;

@RestController
public class MsgController {
    @Autowired
    private final MessageService msgService;

    public MsgController(MessageService msgService) {
        this.msgService = msgService;
    }
    /*@GetMapping("/chat")
    public ResponseEntity<List<Messagerie>> getChat(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) throws Exception{
        ResponseEntity<List<Messagerie>> responseEntity = null;
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                // Extraire le token après "Bearer "
                String token = authorizationHeader.substring(7);

                System.out.println("Token from JS: " + token);
                System.out.println("Token[userRole]: " + JsonWebToken.extractValue(token, "userId"));
                responseEntity = msgService.getAllMessageUser(1); 
            }else{
                throw new Exception("Connecter vous pour envoyer un message");
            }
        } catch (Exception e) {
            throw e;
        }      
         return responseEntity;
    }*/
    @GetMapping("/sendMsg")

    public ResponseEntity<?> envoyerMessage(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader,@RequestParam int emetteur,int recepteur,String msg) {
        Messagerie msgs = new Messagerie();
        msgs.setEmetteur(emetteur);
        msgs.setRecepteur(recepteur);
        msgs.setMessages(msg);
        LocalDate localDate = LocalDate.now();
        Date utilDate = java.sql.Date.valueOf(localDate);
        msgs.setDateMessage(utilDate);
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                System.out.println("Token from JS: " + token);
                System.out.println("Token[userRole]: " + JsonWebToken.extractValue(token, "userId"));
                return msgService.saveMessage(msgs);
            } else {
                // Si l'authentification échoue, renvoyer une réponse avec un code 401 (Unauthorized)
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Connectez-vous pour envoyer un message");
            }
        } catch (Exception e) {
            // En cas d'erreur non prévue, renvoyer une réponse avec un code 500 (Internal Server Error)
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Connectez-vous pour envoyer un message");
        }
       
    }

    @GetMapping("/chat")
    public ResponseEntity<?> getChat(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader,int id) {
    try {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // Extraire le token après "Bearer "
            //String token = authorizationHeader.substring(7);

            //System.out.println("Token from JS: " + token);
            //System.out.println("Token[userRole]: " + JsonWebToken.extractValue(token, "userId"));
            
            // Utiliser votre service pour récupérer les messages
            ResponseEntity<List<Messagerie>> messages = msgService.getAllMessageUser(id);
            // Retourner une réponse avec les messages récupérés
            return messages;
        } else {
            // Si l'authentification échoue, renvoyer une réponse avec un code 401 (Unauthorized)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Connectez-vous pour envoyer un message");
        }
    } catch (Exception e) {
        // En cas d'erreur non prévue, renvoyer une réponse avec un code 500 (Internal Server Error)
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Connectez-vous pour envoyer un message");
    }
}


}

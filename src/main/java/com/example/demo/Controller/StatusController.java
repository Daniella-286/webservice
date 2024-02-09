package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.StatusService;
// StatusController.java
@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @PostMapping("/valider/{idAnnonce}")
    public ResponseEntity<String> validerAnnonce(@PathVariable Long idAnnonce) {
        try {
            statusService.validerAnnonce(idAnnonce);
            return new ResponseEntity<>("Annonce validée avec succès", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la validation de l'annonce", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

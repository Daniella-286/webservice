package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.V_annonceStatus;
import com.example.demo.service.V_annonceService;

@RestController
public class V_annonceControl {
   @Autowired
    private final V_annonceService annonceService;
    @Autowired
    public V_annonceControl(V_annonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping("/annonceValider")
    public ResponseEntity<List<V_annonceStatus>> getAllAnnonce() {
        System.out.println("********fa aona");
        return annonceService.getAllAnnonceValider(5);
    }

    @GetMapping("/historique")
    public ResponseEntity<List<V_annonceStatus>> getHistoriquePerso(@RequestParam int id) {
        System.out.println("********fa aona");
        return annonceService.historique(id);
    }

    

    @GetMapping("/filtrePrice")
    public ResponseEntity<List<V_annonceStatus>> getPrixBetween(@RequestParam double prix1,double prix2) {
        System.out.println("********fa aona");
        return annonceService.filtrePrix(prix1,prix2);
    }

    @GetMapping("/filtreMarque")
    public ResponseEntity<List<V_annonceStatus>> getMarque(@RequestParam String marque) {
        System.out.println("********fa aona");
        return annonceService.filtreParnom(marque);
    }

    @GetMapping("/filtreMarqueprice")
    public ResponseEntity<List<V_annonceStatus>> getMarqueprice(@RequestParam String marque,double prix1,double prix2) {
        System.out.println("********fa aona");
        return annonceService.filtreParnomPrix(marque, prix1, prix2);
    }

}

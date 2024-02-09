package com.example.demo.Controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Annonce;
import com.example.demo.model.TestRepository;
import com.example.demo.service.AnnonceService;

@RestController
public class AnnonceControle {
    @Autowired
    private AnnonceService annonceService;

    public AnnonceControle(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping("/publier")
    public ResponseEntity<Annonce> saveAnnonce(@RequestParam int id_user,int marque,int categorie,int model,String detail,String defaut,double prix) {
        Annonce an = new Annonce();
        an.setId_user(id_user);
        an.setId_marque(marque);
        an.setId_categorie(categorie);
        an.setId_model(model);
        an.setDetail(detail);
        an.setDefauts(defaut);
        an.setPrix(prix);
        LocalDate localDate = LocalDate.now();
        Date utilDate = java.sql.Date.valueOf(localDate);
        an.setDateAnnonce(utilDate);
        return annonceService.saveAnnonce(an);
    }
}

package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Favoris;
import com.example.demo.model.V_annonceStatus;
import com.example.demo.service.FavorisService;
import com.example.demo.service.V_annonceService;

@RestController
public class FavorisControl {
    private final FavorisService favservice;
    private final V_annonceService annonceService;
    
    public FavorisControl(FavorisService favservice, V_annonceService annonceService) {
        this.favservice = favservice;
        this.annonceService = annonceService;
    }
    @GetMapping("/ajoutfavoris")
    public ResponseEntity<Favoris> ajoutFavoris(@RequestParam int id_annonce,int id_user) {
        Favoris f = new Favoris();
        f.setId_annonce(id_annonce);
        f.setId_user(id_user);
        return favservice.saveAnnonce(f);
    }
    @GetMapping("/voirfavoris")
    public ResponseEntity<List<V_annonceStatus>> listeFavoris(@RequestParam int id){
        return annonceService.getAnnonceFavoris(id);
    }
    
}

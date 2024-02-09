package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.V_annonceStatus;
import com.example.demo.repository.V_annonceRepository;
@Service
public class V_annonceService {
    private final V_annonceRepository annonceRep;
    @Autowired
    public V_annonceService(V_annonceRepository userRep) {
        this.annonceRep = userRep;
    }    
    public ResponseEntity<List<V_annonceStatus>> getAllAnnonceValider(int statu) {
        System.out.println("******************Ataony");
        return new ResponseEntity<>(annonceRep.findByStatu(statu),HttpStatus.OK);
    }
    public ResponseEntity<List<V_annonceStatus>> getAnnonceFavoris(int user) {
        System.out.println("******************Ataony");
        return new ResponseEntity<>(annonceRep.findListFavoris(user),HttpStatus.OK);
    }

    public ResponseEntity<List<V_annonceStatus>> filtrePrix(double prix1, double prix2) {
        System.out.println("******************Ataony");
        return new ResponseEntity<>(annonceRep.findPrice(prix1,prix2),HttpStatus.OK);
    }

    public ResponseEntity<List<V_annonceStatus>> filtreParnom(String marque) {
        System.out.println("******************Ataony");
        return new ResponseEntity<>(annonceRep.findMarque(marque),HttpStatus.OK);
    }

    public ResponseEntity<List<V_annonceStatus>> filtreParnomPrix(String marque,double prix1,double prix2) {
        System.out.println("******************Ataony");
        return new ResponseEntity<>(annonceRep.findMarquePrix(marque,prix1,prix2),HttpStatus.OK);
    }

    public ResponseEntity<List<V_annonceStatus>> historique(int id) {
        System.out.println("******************Ataony");
        return new ResponseEntity<>(annonceRep.findHistorique(id),HttpStatus.OK);
    }
}

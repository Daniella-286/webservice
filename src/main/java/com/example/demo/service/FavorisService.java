package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Favoris;
import com.example.demo.repository.FavorisRepository;

@Service
public class FavorisService {
    private final FavorisRepository favRep;
    @Autowired
    public FavorisService(FavorisRepository favRep) {
        this.favRep = favRep;
    }
    public ResponseEntity<Favoris> saveAnnonce(Favoris fav) {
        return new ResponseEntity<>(favRep.save(fav),HttpStatus.OK);
    }
    

}

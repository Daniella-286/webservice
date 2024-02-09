package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Annonce;
import com.example.demo.repository.AnnonceRepository;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRep;
    @Autowired
    public AnnonceService(AnnonceRepository userRep) {
        this.annonceRep = userRep;
    }

    public ResponseEntity<List<Annonce>> getAllAnnonce() {
        return new ResponseEntity<>(annonceRep.findAll(),HttpStatus.OK);
    }

    public  ResponseEntity<Annonce> getAnnonceById(int id) {
        return new ResponseEntity<>(annonceRep.findById(id).orElse(null), HttpStatus.OK);
    }

    public ResponseEntity<Annonce> saveAnnonce(Annonce user) {
        return new ResponseEntity<>(annonceRep.save(user),HttpStatus.OK);
    }
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
    private final UtilisateurRepository userRep;
    @Autowired
    public UtilisateurService(UtilisateurRepository userRep) {
        this.userRep = userRep;
    }

    public ResponseEntity<List<Utilisateur>> getAllUsers() {
        return new ResponseEntity<>(userRep.findAll(),HttpStatus.OK);
    }

    public  ResponseEntity<Utilisateur> getUserById(int id) {
        return new ResponseEntity<>(userRep.findById(id).orElse(null), HttpStatus.OK);
    }

    public ResponseEntity<Utilisateur> saveUser(Utilisateur user) {
        return new ResponseEntity<>(userRep.save(user),HttpStatus.OK);
    }

    public ResponseEntity<Utilisateur> validationParEmailEtMdp(String email, String mdp) {
        return new ResponseEntity<>(userRep.findByEmailAndMdp(email, mdp),HttpStatus.OK);
    }
   
}

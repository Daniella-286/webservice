package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TypedQuery;

import org.springframework.http.ResponseEntity;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_user;
    String nom;
    String prenom;
    Date dtn;
    String email;
    String telephone;
    String adresse;
    String mdp;
    Date dte;
    public Utilisateur(int id_user, String nom, String prenom, Date dtn, String email, String telephone, String adresse,
            String mdp, Date dte) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.dtn = dtn;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.mdp = mdp;
        this.dte = dte;
    }
    public Date getDte() {
        return dte;
    }
    public void setDte(Date dte) {
        this.dte = dte;
    }
    public Utilisateur(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Date getDtn() {
        return dtn;
    }
    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public Utilisateur(int id_user, String nom, String prenom, Date dtn, String email, String telephone, String adresse,
            String mdp) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.dtn = dtn;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.mdp = mdp;
    }

    public Utilisateur(){}
    
}

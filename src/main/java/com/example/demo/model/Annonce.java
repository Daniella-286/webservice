package com.example.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_annonce;
    int id_user;
    int id_marque;
    int id_categorie;
    int id_model;
    String detail;
    String defauts;
    double prix;
    Date dateannonce;
    public int getId_annonce() {
        return id_annonce;
    }
    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public int getId_marque() {
        return id_marque;
    }
    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }
    public int getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public int getId_model() {
        return id_model;
    }
    public void setId_model(int id_model) {
        this.id_model = id_model;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getDefauts() {
        return defauts;
    }
    public void setDefauts(String defauts) {
        this.defauts = defauts;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public Date getDateAnnonce() {
        return dateannonce;
    }
    public void setDateAnnonce(Date dateAnnonce) {
        this.dateannonce = dateAnnonce;
    }
    public Annonce() {
    }
    public Annonce(int id_annonce, int id_user, int id_marque, int id_categorie, int id_model, String detail,
            String defauts, double prix, Date dateAnnonce) {
        this.id_annonce = id_annonce;
        this.id_user = id_user;
        this.id_marque = id_marque;
        this.id_categorie = id_categorie;
        this.id_model = id_model;
        this.detail = detail;
        this.defauts = defauts;
        this.prix = prix;
        this.dateannonce = dateAnnonce;
    }
    
    

}

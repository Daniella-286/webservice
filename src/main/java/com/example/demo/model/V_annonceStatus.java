package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "v_annoncestatus")
public class V_annonceStatus {
    @Id
    int id_annonce;
    int id_user;
    String marque;
    String categorie;
    String model;
    String detail;
    String defauts;
    double prix;
    Date dateannonce;
    int states;
    
    public V_annonceStatus(int id_annonce, int id_user, String marque, String categorie, String model, String detail,
            String defauts, double prix, Date dateannonce, int states) {
        this.id_annonce = id_annonce;
        this.id_user = id_user;
        this.marque = marque;
        this.categorie = categorie;
        this.model = model;
        this.detail = detail;
        this.defauts = defauts;
        this.prix = prix;
        this.dateannonce = dateannonce;
        this.states = states;
    }

    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
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
    public int getStatu() {
        return states;
    }
    public void setStatu(int statu) {
        this.states = statu;
    }
    public V_annonceStatus() {
    }
  
    

}

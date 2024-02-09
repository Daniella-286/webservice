package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Favoris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_favoris;
    int id_annonce;
    int id_user;
    public Favoris(int id_favoris, int id_annonce, int id_user) {
        this.id_favoris = id_favoris;
        this.id_annonce = id_annonce;
        this.id_user = id_user;
    }
    public Favoris(int id_annonce, int id_user) {
        this.id_annonce = id_annonce;
        this.id_user = id_user;
    }
    public Favoris() {
    }
    public int getId_favoris() {
        return id_favoris;
    }
    public void setId_favoris(int id_favoris) {
        this.id_favoris = id_favoris;
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

}

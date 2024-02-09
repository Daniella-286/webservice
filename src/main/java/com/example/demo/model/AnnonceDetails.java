package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "annonce_details")
public class AnnonceDetails {
    @Id
    @Column(name = "id_annonce")
    private Long idAnnonce;

    @Column(name = "statu")
    private Long statu;
    @Column(name = "nom")
    private String nom;

    @Column(name = "nom_marque")
    private String nomMarque;

    @Column(name = "nom_categorie")
    private String nomCategorie;

    @Column(name = "nom_model")
    private String nomModel;

    @Column(name = "detail")
    private String detail;

    @Column(name = "defauts")
    private String defauts;

    public Long getStatu() {
        return statu;
    }

    public void setStatu(Long statu) {
        this.statu = statu;
    }

    @Column(name = "prix")
    private double prix;

    @Column(name = "dateannonce")
    private LocalDateTime dateAnnonce;

    public Long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getNomModel() {
        return nomModel;
    }

    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
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

    public LocalDateTime getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(LocalDateTime dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }
}

package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "statistiques_annonces") // Utilisez le nom de la vue
public class StatistiqueAnnonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_marque")
    private Long idMarque;

    @Column(name = "nom_marque")
    private String nomMarque;

    @Column(name = "total_annonces_vendues")
    private Long totalAnnoncesVendues;

    public StatistiqueAnnonce() {
    }

    public StatistiqueAnnonce(Long idMarque, String nomMarque, Long totalAnnoncesVendues) {
        this.idMarque = idMarque;
        this.nomMarque = nomMarque;
        this.totalAnnoncesVendues = totalAnnoncesVendues;
    }

    public Long getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Long idMarque) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public Long getTotalAnnoncesVendues() {
        return totalAnnoncesVendues;
    }

    public void setTotalAnnoncesVendues(Long totalAnnoncesVendues) {
        this.totalAnnoncesVendues = totalAnnoncesVendues;
    }
}

package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "user_registration") // Utilisation de la vue SQL
public class UserStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "mois_abrege")
    private String monthAbbreviated;

    @Column(name = "annee")
    private int year;

    @Column(name = "nombre_inscriptions")
    private long numberOfRegistrations;

    public UserStat() {
    }

    // Constructeur avec tous les champs
    public UserStat(String monthAbbreviated, int year, long numberOfRegistrations) {
        this.monthAbbreviated = monthAbbreviated;
        this.year = year;
        this.numberOfRegistrations = numberOfRegistrations;
    }


    public String getMonthAbbreviated() {
        return monthAbbreviated;
    }

    public void setMonthAbbreviated(String monthAbbreviated) {
        this.monthAbbreviated = monthAbbreviated;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getNumberOfRegistrations() {
        return numberOfRegistrations;
    }

    public void setNumberOfRegistrations(long numberOfRegistrations) {
        this.numberOfRegistrations = numberOfRegistrations;
    }
}
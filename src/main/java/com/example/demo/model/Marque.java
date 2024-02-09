package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "marque")
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marque")
    private Long id;

    @Column(name = "marque")
    private String marqueName;

    public Marque() {
    }

    public Marque(String marqueName) {
        this.marqueName = marqueName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarqueName() {
        return marqueName;
    }

    public void setMarqueName(String marqueName) {
        this.marqueName = marqueName;
    }
}

package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_photo;
    int id_annonce;
    String photo;
    public int getId_photo() {
        return id_photo;
    }
    public void setId_photo(int id_photo) {
        this.id_photo = id_photo;
    }
    public int getId_annonce() {
        return id_annonce;
    }
    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Photo(int id_photo, int id_annonce, String photo) {
        this.id_photo = id_photo;
        this.id_annonce = id_annonce;
        this.photo = photo;
    }
    public Photo() {
    }

}

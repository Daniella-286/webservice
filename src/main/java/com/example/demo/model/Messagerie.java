package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Messagerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_message;
    int emetteur;
    int recepteur;
    String messages;
    Date datemessage;
    public int getId_message() {
        return id_message;
    }
    public void setId_message(int id_message) {
        this.id_message = id_message;
    }
    public int getEmetteur() {
        return emetteur;
    }
    public void setEmetteur(int emetteur) {
        this.emetteur = emetteur;
    }
    public int getRecepteur() {
        return recepteur;
    }
    public void setRecepteur(int recepteur) {
        this.recepteur = recepteur;
    }
    public String getMessages() {
        return messages;
    }
    public void setMessages(String messages) {
        this.messages = messages;
    }
    public Date getDateMessage() {
        return datemessage;
    }
    public void setDateMessage(Date dateMessage) {
        this.datemessage = dateMessage;
    }
    public Messagerie() {
    }
    public Messagerie(int id_message, int emetteur, int recepteur, String messages, Date dateMessage) {
        this.id_message = id_message;
        this.emetteur = emetteur;
        this.recepteur = recepteur;
        this.messages = messages;
        this.datemessage = dateMessage;
    }
    

}

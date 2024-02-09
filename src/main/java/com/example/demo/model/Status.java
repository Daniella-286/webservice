package com.example.demo.model;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long idStatus;

    @Column(name = "id_annonce")
    private Long idAnnonce;

    @Column(name = "date_Status")
    private Timestamp  dateStatus;

    @Column(name = "statu")
    private int statu;

    public Long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Long idStatus) {
        this.idStatus = idStatus;
    }

    public Long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Timestamp getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(Timestamp dateStatus) {
        this.dateStatus = dateStatus;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }
}

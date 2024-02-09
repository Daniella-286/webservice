package com.example.demo.service;

import com.example.demo.model.AnnonceDetails;
import com.example.demo.model.CommissionReport;
import com.example.demo.repository.AnnonceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceDetailsService {
    private final AnnonceDetailsRepository repository;

    @Autowired
    public AnnonceDetailsService(AnnonceDetailsRepository repository) {
        this.repository = repository;
    }

    public List<AnnonceDetails> getAllAnnonces() {
        return repository.findAll();
    }



    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public List<AnnonceDetails> getValidation() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String sql = "select * from annonce_details where statu = 0";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();

        List<AnnonceDetails> reports = new ArrayList<>();
        for (Object[] result : results) {
            AnnonceDetails report = new AnnonceDetails();

            report.setIdAnnonce(Long.valueOf(result[0].toString()));
            System.out.println("fdfdfdxvd");
            report.setNom((String) result[1]);
            System.out.println("fdfdfdxvd");
            report.setNomMarque((String) result[2]);
            report.setNomCategorie((String) result[3]);
            report.setNomModel((String) result[4]);
            report.setDetail((String) result[5]);
            report.setDefauts((String) result[6]);
            report.setPrix(Double.valueOf(result[7].toString()));
            java.sql.Timestamp timestamp = (java.sql.Timestamp) result[8];
            report.setDateAnnonce(timestamp.toLocalDateTime());
            report.setStatu(Long.valueOf(result[9].toString()));
            reports.add(report);
        }
        return reports;
    }
    public Optional<AnnonceDetails> getAnnonceById(Long id) {
        return repository.findById(id);
    }
}

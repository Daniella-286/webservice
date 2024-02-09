package com.example.demo.service;

import com.example.demo.model.Commission;
import com.example.demo.model.CommissionReport;
import com.example.demo.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import java.util.Optional;

@Service
public class CommissionService {
    private final CommissionRepository commissionRepository;

    @Autowired
    public CommissionService(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    // Méthode pour créer une nouvelle commission
    public Commission createCommission(Commission commission) {
        return commissionRepository.save(commission);
    }

    // Méthode pour récupérer toutes les commissions
    public List<Commission> getAllCommissions() {
        return commissionRepository.findAll();
    }

    // Méthode pour récupérer une commission par son ID
    public Optional<Commission> getCommissionById(String id) {
        return commissionRepository.findById(id);
    }

    // Méthode pour mettre à jour une commission
    public Commission updateCommission(String id, Commission newCommission) {
        newCommission.setId(id);
        return commissionRepository.save(newCommission);
    }

    // Méthode pour supprimer une commission par son ID
    public void deleteCommission(String id) {
        commissionRepository.deleteById(id);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public List<CommissionReport> getMonthlyCommissionReport() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String sql = "SELECT TO_CHAR(a.dateannonce, 'Mon') AS month, " +
                "EXTRACT(YEAR FROM a.dateannonce) AS year, " +
                "SUM(a.prix * 0.20) AS commissionAmount " +
                "FROM annonce a " +
                "JOIN status s ON a.id_annonce = s.id_annonce " +
                "WHERE s.statu = 10 " +
                "GROUP BY TO_CHAR(a.dateannonce, 'Mon'), EXTRACT(YEAR FROM a.dateannonce)";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();

        List<CommissionReport> reports = new ArrayList<>();
        for (Object[] result : results) {
            CommissionReport report = new CommissionReport();
            report.setMonth((String) result[0]);
            report.setYear(((Number) result[1]).intValue());
            report.setCommissionAmount((Double) result[2]);
            reports.add(report);
        }
        return reports;
    }


}
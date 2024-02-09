package com.example.demo.service;

import com.example.demo.model.StatistiqueAnnonce;
import com.example.demo.repository.StatistiqueAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatistiqueAnnonceService {

    @Autowired
    private StatistiqueAnnonceRepository statistiqueAnnonceRepository;

    public List<StatistiqueAnnonce> getAllStatistiquesAnnonces() {
        return statistiqueAnnonceRepository.findAll();
    }

    public StatistiqueAnnonce saveStatistiqueAnnonce(StatistiqueAnnonce statistiqueAnnonce) {
        return statistiqueAnnonceRepository.save(statistiqueAnnonce);
    }
}

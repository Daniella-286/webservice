package com.example.demo.service;

import com.example.demo.model.Marque;
import com.example.demo.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }

    public Optional<Marque> getMarqueById(Long id) {
        return marqueRepository.findById(id);
    }

    public Marque createMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public void updateMarque(Long id, Marque updatedMarque) {
        Optional<Marque> existingMarque = marqueRepository.findById(id);
        existingMarque.ifPresent(m -> {
            m.setMarqueName(updatedMarque.getMarqueName());
            marqueRepository.save(m);
        });
    }

    public void deleteMarque(Long id) {
        marqueRepository.deleteById(id);
    }
}

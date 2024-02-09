package com.example.demo.model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TestService {
    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository etudiantRepository) {
        this.testRepository = etudiantRepository;
    }

    public Test sauvegarderEtudiant(Test etudiant) {
        return testRepository.save(etudiant);
    }

    public List<Test> afficheEtudiant() {
        return testRepository.findAll();
    }
}


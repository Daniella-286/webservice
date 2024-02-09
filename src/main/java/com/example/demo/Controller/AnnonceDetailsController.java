package com.example.demo.Controller;

import com.example.demo.model.AnnonceDetails;
import com.example.demo.service.AnnonceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/annoncesDetails")
public class AnnonceDetailsController {
    private final AnnonceDetailsService service;

    @Autowired
    public AnnonceDetailsController(AnnonceDetailsService service) {
        this.service = service;
    }

    @GetMapping
    public List<AnnonceDetails> getAllAnnoncesNonValider() {
        return service.getValidation();
    }

    @GetMapping("/{id}")   public Optional<AnnonceDetails> getAnnonceById(@PathVariable Long id) {
        return service.getAnnonceById(id);
    }
}

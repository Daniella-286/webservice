package com.example.demo.Controller;

import com.example.demo.model.Marque;
import com.example.demo.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marques")
public class MarqueController {

    @Autowired
    private MarqueService marqueService;

    @GetMapping
    public List<Marque> getAllMarques() {
        return marqueService.getAllMarques();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marque> getMarqueById(@PathVariable Long id) {
        Optional<Marque> marque = marqueService.getMarqueById(id);
        return marque.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Marque> createMarque(@RequestBody Marque marque) {
        Marque createdMarque = marqueService.createMarque(marque);
        return new ResponseEntity<>(createdMarque, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMarque(@PathVariable Long id, @RequestBody Marque updatedMarque) {
        marqueService.updateMarque(id, updatedMarque);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarque(@PathVariable Long id) {
        marqueService.deleteMarque(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

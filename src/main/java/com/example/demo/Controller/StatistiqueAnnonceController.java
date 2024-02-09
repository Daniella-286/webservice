package com.example.demo.Controller;

import com.example.demo.model.StatistiqueAnnonce;
import com.example.demo.service.StatistiqueAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistiquesannonces")
public class StatistiqueAnnonceController {

    @Autowired
    private StatistiqueAnnonceService statistiqueAnnonceService;

    @GetMapping
    public List<StatistiqueAnnonce> getAllStatistiquesAnnonces() {
        return statistiqueAnnonceService.getAllStatistiquesAnnonces();
    }

    @PostMapping
    public StatistiqueAnnonce createStatistiqueAnnonce(@RequestBody StatistiqueAnnonce statistiqueAnnonce) {
        return statistiqueAnnonceService.saveStatistiqueAnnonce(statistiqueAnnonce);
    }
}

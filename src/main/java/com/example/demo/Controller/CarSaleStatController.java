package com.example.demo.Controller;

import com.example.demo.model.CarSaleStat;
import com.example.demo.service.CarSaleStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carsalestats")
public class CarSaleStatController {
    private final CarSaleStatService carSaleStatService;

    @Autowired
    public CarSaleStatController(CarSaleStatService carSaleStatService) {
        this.carSaleStatService = carSaleStatService;
    }

    @GetMapping
    public List<CarSaleStat> getAllCarSaleStats() {
        return carSaleStatService.getAllCarSaleStats();
    }
}

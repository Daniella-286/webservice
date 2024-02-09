package com.example.demo.service;

import com.example.demo.model.CarSaleStat;
import com.example.demo.repository.CarSaleStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarSaleStatService {
    private final CarSaleStatRepository carSaleStatRepository;

    @Autowired
    public CarSaleStatService(CarSaleStatRepository carSaleStatRepository) {
        this.carSaleStatRepository = carSaleStatRepository;
    }

    public List<CarSaleStat> getAllCarSaleStats() {
        return carSaleStatRepository.findAll();
    }
}

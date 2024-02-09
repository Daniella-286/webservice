package com.example.demo.repository;

import com.example.demo.model.CarSaleStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarSaleStatRepository extends JpaRepository<CarSaleStat, Long> {
}

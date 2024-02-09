package com.example.demo.repository;

import com.example.demo.model.Commission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommissionRepository extends MongoRepository<Commission, String> {
}

package com.example.demo.model;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface TestRepository extends MongoRepository<Test, String>{
    
}

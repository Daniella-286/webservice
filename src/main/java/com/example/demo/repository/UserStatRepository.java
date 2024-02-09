package com.example.demo.repository;

import com.example.demo.model.UserStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserStatRepository extends JpaRepository<UserStat, Long> {
    List<UserStat> findAll();
}

package com.example.demo.service;

import com.example.demo.model.UserStat;
import com.example.demo.repository.UserStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatService {

    private final UserStatRepository userStatRepository;

    @Autowired
    public UserStatService(UserStatRepository userStatRepository) {
        this.userStatRepository = userStatRepository;
    }

    public List<UserStat> getAllUserStats() {
        return userStatRepository.findAll();
    }
}


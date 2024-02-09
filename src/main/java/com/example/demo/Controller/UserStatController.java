package com.example.demo.Controller;

import com.example.demo.model.UserStat;
import com.example.demo.service.UserStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/userstats")
public class UserStatController {

    private final UserStatService userStatService;

    @Autowired
    public UserStatController(UserStatService userStatService) {
        this.userStatService = userStatService;
    }

    @GetMapping
    public List<UserStat> getAllUserStats() {
        return userStatService.getAllUserStats();
    }
}


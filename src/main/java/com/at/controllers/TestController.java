package com.at.controllers;

import com.at.entity.Test;
import com.at.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @Value("${profile.loaded}")
    private String profileLoaded;

    @GetMapping("/profile/active")
    public String helloTrader() {
        return profileLoaded;
    }

    @GetMapping("/trader/tests")
    public List<Test> tests() {
        return testRepository.findAll();
    }

}

package com.at.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.at.pojo.*;

@RestController
@RequestMapping("/api")
public class RAGController {

    @PostMapping("/rag")
    public ResponseEntity<String> handleRAGQuery(@RequestBody RAGRequest request) {
        String pythonServiceUrl = "http://127.0.0.1:8000/process";
        RestTemplate restTemplate = new RestTemplate();
        RAGResponse response = restTemplate.postForObject(pythonServiceUrl, request, RAGResponse.class);
        return ResponseEntity.ok(response.getResponse());
    }
}


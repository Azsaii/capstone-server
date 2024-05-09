package com.hansung.capstone01.controller;

import com.hansung.capstone01.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ApiController {
    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/articles/{page}")
    public String getArticles(@PathVariable int page) {
        return apiService.getArticles(page);
    }

    @GetMapping("/character/{eid}")
    public String getCharacter(@PathVariable String eid) {
        return apiService.getCharacter(eid);
    }

    @GetMapping("/search/{eid}")
    public String searchArticle(@PathVariable String eid) {
        return apiService.searchArticle(eid);
    }
}

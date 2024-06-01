package com.hansung.capstone01.controller;

import com.hansung.capstone01.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") //로컬에서 동작 시, 포트는 원하는 걸로 변경
//@CrossOrigin(origins = {"http://52.79.56.22", "http://brainbooster.kro.kr"}) 배포용으로 동작시 EC2 서버 주소, 원하는 도메인 주소로 변경 (단 React 배포 서버가 포트 80이어야 함)
@RestController
public class ApiController {
    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/articles/{page}")
    public String getArticles(@PathVariable("page") int page) {
        return apiService.getArticles(page);
    }

    @GetMapping("/character/{eid}")
    public String getCharacter(@PathVariable("eid") String eid) {
        return apiService.getCharacter(eid);
    }

    @GetMapping("/search/{eid}")
    public String searchArticle(@PathVariable("eid") String eid) {
        return apiService.searchArticle(eid);
    }
}

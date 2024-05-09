package com.hansung.capstone01.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ApiService {

    private final RestTemplate restTemplate;

    @Value("${api.accessKey}")
    private String accessKey;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getArticles(int page) {
        log.info("page={}", page);
        String url = "https://suny.aks.ac.kr:5143/api/Article/List/" + page;
        log.info("url={}", url);
        HttpHeaders headers = new HttpHeaders();
        headers.set("accessKey", accessKey);

        log.info("Sending request with accessKey: {}", accessKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getCharacter(String eid) {
        log.info("eid={}", eid);
        String url = "https://suny.aks.ac.kr:5143/api/Article/" + eid;
        HttpHeaders headers = new HttpHeaders();
        headers.set("accessKey", accessKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String searchArticle(String name){
        String url = "https://suny.aks.ac.kr:5143/api/Article/Search/" + name;
        HttpHeaders headers = new HttpHeaders();
        headers.set("accessKey", accessKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}

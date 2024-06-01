package com.hansung.capstone01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:3000") //로컬에서 동작 시, 포트는 원하는 걸로 변경
//@CrossOrigin(origins = {"http://52.79.56.22", "http://brainbooster.kro.kr"}) 배포용으로 동작시 EC2 서버 주소, 원하는 도메인 주소로 변경 (단 React 배포 서버가 포트 80이어야 함)
public class TempController {
    @GetMapping("hello") // 8080/hello로 매핑
    public String hello(Model model){

        model.addAttribute("data", "hello!");
        return "hello";
    }
}
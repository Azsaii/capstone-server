package com.hansung.capstone01;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")

                .allowedOrigins("http://localhost:8080", "http://localhost:8081")// 로컬에서 허용할 출처. 여러 개 추가 가능
                //.allowedOrigins("http://52.79.56.22:8080", "http://52.79.56.22:8081") // 배포용 허용할 출처. 여러 개 추가 가능

                .allowedMethods("GET", "POST", "DELETE") // 허용할 HTTP method
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
    }
}


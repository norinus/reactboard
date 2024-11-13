package com.lab.reactboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * CORS 허용 출처 설정:
     *
     * origins 속성에 { "http://localhost:8080", "http://localhost:3000" } 두 개의 출처를 지정함으로써,
     * 이 서버는 http://localhost:8080과 http://localhost:3000에서 오는 요청을 허용하게 됩니다.
     * 보통 백엔드(Spring 애플리케이션)와 프론트엔드(React나 Vue 등)가 다른 포트에서 개발 서버로 실행될 때 필요합니다.
     * 예를 들어, Spring Boot 백엔드는 8080 포트, React 개발 서버는 3000 포트에서 각각 실행되는 상황입니다.
     * 그리고 허용 메소드 정의로 허용된 메소드만 접근 하도록 함
     *
     * 안전한 리소스 공유:
     * CORS 설정을 통해 지정된 출처에서만 리소스에 접근할 수 있게 함으로써, 불필요한 외부 접근을 차단하고 보안을 강화할 수 있습니다.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해 CORS 허용
                .allowedOrigins("http://localhost:8080", "http://localhost:3000") // 허용할 출처
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowedHeaders("*") // 허용할 헤더
                .allowCredentials(true); // 인증 정보 허용
    }
}
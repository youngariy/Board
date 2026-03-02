package com.mjsec.board.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("게시판 서비스 API 명세서")
                        .description("Spring Boot 3.x 기반의 간단한 CRUD 게시판 API입니다.")
                        .version("v1.0.0"));
    }
}

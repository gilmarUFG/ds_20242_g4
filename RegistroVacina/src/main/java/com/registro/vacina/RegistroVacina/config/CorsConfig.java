package com.registro.vacina.RegistroVacina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**") // Aplica a todos os endpoints
                            .allowedOriginPatterns("*") // Permite todas as origens
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                            .allowedHeaders("*") // Cabeçalhos permitidos
                            .allowCredentials(true); // Permitir credenciais (cookies)
                }
            };
        }

}




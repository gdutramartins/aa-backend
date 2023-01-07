package br.com.aaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AazBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AazBackendApplication.class, args);
	}
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				//.allowedOrigins("https://amigo-azul-front.herokuapp.com")
				.allowedOriginPatterns("https://*.herokuapp.com")				
				.allowedMethods("*")
                .maxAge(3800L)
                .allowedHeaders("*")
                .exposedHeaders("Authorization")
                .allowCredentials(true);
			}
		};
	}

}

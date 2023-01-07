package br.com.aaz;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				// .allowedOrigins("https://amigo-azul-front.herokuapp.com")
				.allowedOriginPatterns("http://localhost").
				allowCredentials(true)
				.allowedMethods("*")
				.maxAge(3600L);
	}
}

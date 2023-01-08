package br.com.aaz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.CorsRegistry; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 * 
 * @Configuration public class CorsConfig implements WebMvcConfigurer {
 * 
 * @Override public void addCorsMappings(CorsRegistry registry) {
 * 
 * registry.addMapping("/**") //
 * .allowedOrigins("https://amigo-azul-front.herokuapp.com")
 * .allowedOriginPatterns("https://amigo-azul-front.herokuapp.com")
 * .allowCredentials(true) .allowedMethods("*") .maxAge(3600L); } }
 */


@Configuration
public class CorsConfig {
    
    private CorsConfiguration buildConfig() {
    
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //corsConfiguration.addAllowedOrigin("*");
        //  Cross domain configuration error , take .allowedOrigins Replace with .allowedOriginPatterns that will do .
        //  Set the domain name that allows cross domain requests 
        corsConfiguration.addAllowedOriginPattern("https://amigo-azul-front.herokuapp.com");
        corsConfiguration.addAllowedHeader("*");
        //  Set allowed methods 
        corsConfiguration.addAllowedMethod("*");
        //  Whether to allow certificates 
        //corsConfiguration.setAllowCredentials(true);
        //  Cross domain allow time 
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }

    @Bean
    CorsFilter corsFilter() {
    
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}
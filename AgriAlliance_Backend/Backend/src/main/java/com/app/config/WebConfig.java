package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebConfig {
	
	
//	private static final String GET = "GET";
//	private static final String POST = "POST";
//	private static final String DELETE = "DELETE";
//	private static final String PUT = "PUT";
//	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
//		configuration.setAllowedMethods(Arrays.asList(GET,POST,DELETE,PUT));
//		configuration.setAllowedHeaders(Arrays.asList("Authorization","Content-Type","Access-Control-Allow-Origin"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
	
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Adjust the path if necessary
                .allowedOriginPatterns("*")
                .allowedOrigins("http://localhost:3000")// Your frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}

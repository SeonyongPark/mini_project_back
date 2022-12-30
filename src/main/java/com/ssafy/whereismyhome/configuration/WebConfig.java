package com.ssafy.whereismyhome.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
                .allowedOrigins("http://localhost:8080", "http://localhost:8081");
//                .exposedHeaders("auth_token")

		// make client read header("jwt-token"); 
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js").addResourceLocations("classpath:/resources/static/js/**");
		registry.addResourceHandler("/css").addResourceLocations("classpath:/resources/static/css/**");
		registry.addResourceHandler("/img").addResourceLocations("classpath:/resources/static/img/**");
//		registry.addResourceHandler("/**")
//        .addResourceLocations("classpath:/templates/", "classpath:/static/");
//		registry.addViewController("/").setViewName("forward:/index.html");
	}

}
 
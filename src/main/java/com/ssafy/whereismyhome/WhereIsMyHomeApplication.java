package com.ssafy.whereismyhome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ssafy"})
public class WhereIsMyHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhereIsMyHomeApplication.class, args);
	}

}

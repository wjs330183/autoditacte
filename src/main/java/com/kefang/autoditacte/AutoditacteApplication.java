package com.kefang.autoditacte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AutoditacteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoditacteApplication.class, args);
	}
}

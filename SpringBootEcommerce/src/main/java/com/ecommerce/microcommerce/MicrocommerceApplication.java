package com.ecommerce.microcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication //équivalent de des annotations @Configuration,@EnableAutoconfiguration,@ComponentScan
@EnableSwagger2 //Permet de rajouter Swagger pour la documentation du microservice API
public class MicrocommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrocommerceApplication.class, args);
	}

}

package org.sid;

import java.util.stream.Stream;


import org.sid.dao.CompanyRepository;
import org.sid.entities.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);

	}

	@Bean // Pour l'éxecution au démarrage
	CommandLineRunner start(CompanyRepository companyRepository) {// L'objet companRepository sera injecté automatiquement
		return args -> {
			Stream.of("A","B","C").forEach(cn ->{
				companyRepository.save(new Company(null,cn,100+Math.random()*900));
			});
			companyRepository.findAll().forEach(System.out::println);
		};
	}
}
/**
 * Note: sur le localhost:8080/companies car Srping met  un "s",c'est à dire le pluriel, Spring data rest c'est qu'on gere les objets
 * contenu dans JpaRepository<Object,Id>
 * 
 * 
 */


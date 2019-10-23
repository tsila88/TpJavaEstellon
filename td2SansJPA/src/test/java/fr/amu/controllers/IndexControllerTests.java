package fr.amu.controllers;

import static org.assertj.core.api.Assertions.assertThat; // Notez l'import en static !! Plus simple

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // web environnement choisi un port au hasard
//parmi ceux disponibles

public class IndexControllerTests {

	@LocalServerPort // prend le port choisi au hasard
	private int port;
	@Autowired
	private IndexController controller;
	@Autowired
	private TestRestTemplate restTemplate; // Permet de faire une requête simple, un accès à une url

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull(); // on vérifie que le controller est bien lancé
	}

	@Test
	public void index() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("homepage");
	}

}

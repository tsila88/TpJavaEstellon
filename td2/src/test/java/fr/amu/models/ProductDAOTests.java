package fr.amu.models;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDAOTests {

	// la base de données est auto remplie grâce à src/main/java/resources/data.sql
	@Autowired
	ProductRepository prdao;

	private static Category category = new Category("category");
	private static Category computer = new Category("computer");
	private static Product product = new Product(category, "productTitle", "img", "description", "date");
	private static Product product2 = new Product(computer, "productTitle2", "img", "a second product", "date");

	@Test // dire que c'est un test (annotation classique de JUnit)
	@Transactional // pour gérer les transactions
	@Rollback(true) // pour remettre la BDD dans son état initial
	public void add() {
		Product p = prdao.save(product);
		List<Product> products = prdao.findAll();
		Assert.assertEquals(p.getId(), Long.valueOf(products.get(products.size() - 1).getId()));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void findAll() {
		prdao.save(product); // soit on save un produit ici, soit on le fait via data.sql (voir td2_correction)
		prdao.save(product2);
		List<Product> products = prdao.findAll();
		Assert.assertTrue(products.size() == 2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void findByCategory() {
		List<Product> computerProducts = prdao.findByCategory("computer"); // comme on a auto remplie la BDD on connait
																			// les categories disponibles
		Assert.assertTrue(computerProducts.size() == 1); // il ne devrait en trouver qu'un seul car un seul a la
															// catégorie 'computer'
	}

	@Test
	@Transactional
	@Rollback(true)
	public void findById() {
		// pour ne pas faire de l'arbitraire, on ajoute un produit pour obtenir son ID
		// et le retrouver. le product en private static est donc utiliie pour éviter la
		// redondance du code
		Product p = prdao.save(product);
		Assert.assertEquals(p.getId(), Long.valueOf(prdao.findById(p.getId()).get().getId()));
	}


	@Test
	@Transactional
	@Rollback(true)
	public void delete() {
		prdao.save(product);
		Product savedProduct = prdao.save(product2);
		prdao.deleteById(savedProduct.getId());
		Assert.assertTrue(prdao.findAll().size() == 1);
	}
}

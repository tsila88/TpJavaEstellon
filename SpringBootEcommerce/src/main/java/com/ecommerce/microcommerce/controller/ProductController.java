package com.ecommerce.microcommerce.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.microcommerce.dao.ProductDAO;
import com.ecommerce.microcommerce.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Gestion des produits")
@RestController
public class ProductController {

	@Autowired
	private ProductDAO ProductDAO;

	// Produits
	@GetMapping(value = "Produits")
	public List<Product> listeProduits() {
		return ProductDAO.findAll();
	}

	// Produits/{id}
	@ApiOperation(value= "Récupère un produit selon son id")
	@GetMapping(value = "Produits/{id}")
	private Optional<Product> showProduct(@PathVariable int id) throws ProduitIntrouvableException {
		Optional<Product> product = ProductDAO.findById(id);
		if (!product.isPresent())
			throw new ProduitIntrouvableException("Le produit avec l'id " + id + " n'existe pas");

		return product;
	}

	@PostMapping(value = "/Produits")
	public ResponseEntity<Void> addProduct(@Valid @RequestBody Product product) {
		Product product1 = ProductDAO.save(product);

		if (product == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product1.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "Produits/prixlimit/{prixLimit}")
	private List<Product> findProductPriceGreaterThan(@PathVariable int prixLimit) {
		return ProductDAO.findByPrixGreaterThan(prixLimit);

	}

	@DeleteMapping(value = "Produits/{id}")
	public void deleteProduct(@PathVariable int id) {
		ProductDAO.deleteById(id);

	}

	@PutMapping(value = "/Produits/{id}")
	public void upDateProduct(@RequestBody Product product) {
		ProductDAO.save(product);

	}
}
package fr.amu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.amu.models.Product;
import fr.amu.models.ProductDAO;

@Service
public class ProductService {
	@Autowired
	ProductDAO pr; // Toujours utiliser l'interface qui sert de proxy

	public ProductService() {

	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		pr.add(product);
	}

	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id);
	}

	public void removeProduct(int id) {
		// TODO Auto-generated method stub
		pr.delete(pr.findById(id));

	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	public List<Product> getCategoryProducts(String category) {
		// TODO Auto-generated method stub
		return pr.findByCategory(category);
	}
}

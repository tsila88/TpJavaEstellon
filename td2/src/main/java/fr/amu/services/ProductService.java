package fr.amu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.amu.models.Product;

import fr.amu.models.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository pr; // Toujours utiliser l'interface qui sert de proxy

	public ProductService() {

	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		pr.save(product);
	}

	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> op = pr.findById(id);
		Product p = op.get(); // et voila votre produit. Vous pouvez vérifier qu'il n'est pas null
		return p;
	}

	public void removeProduct(Long id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);

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

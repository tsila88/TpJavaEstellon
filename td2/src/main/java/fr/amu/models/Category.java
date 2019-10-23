package fr.amu.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name="CATEGORY")
public class Category {

	@Id // indique la clé primaire
	//@Column(name="category_id")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
	private Set<Product> products = new HashSet<Product>();

	public Category() {

	}

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}

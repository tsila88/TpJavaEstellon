package fr.amu.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	// à remplir
	@Id // indique la clé primaire
    @GeneratedValue(strategy=GenerationType.AUTO) // indique la façon dont la clée primaire est auto généré
	private Long id; // id change en Long pour gérer les trés grande id possibles

	private String category;
	private String productTitle;
	private String img;
	private String description;
	private String date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Product(String category, String productTitle, String img, String description, String date) {
		super();
		this.category = category;
		this.productTitle = productTitle;
		this.img = img;
		this.description = description;
		this.date = date;
	}

	public Product() {
	
	}

}

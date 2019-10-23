package fr.amu.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name="PRODUCT")
public class Product {
	// à remplir
	@Id // indique la clé primaire
    @GeneratedValue(strategy=GenerationType.AUTO) // indique la façon dont la clée primaire est auto généré
	private Long id; // id change en Long pour gérer les trés grande id possibles
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name= "category_id",referencedColumnName= "category_id")
	private Category category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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

	public Product(Category category, String productTitle, String img, String description, String date) {
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

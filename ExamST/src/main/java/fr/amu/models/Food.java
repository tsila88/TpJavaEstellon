package fr.amu.models;

public class Food {
	public enum QUALITY {
		EXCELLENT, GOOD, MEDIOCRE, BAD
	};

	public enum TYPE {
		DRINK, MEAT, VEGETABLE
	}

	// (id , name , brand), quality type , favorite BOOLEAN
	private int id;
	private String name;
	private String brand;
	private String quality;
	private String type;
	private boolean favorite;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public Food() {

	}

	public Food(String name, String brand, String quality, String type) {
		super();

		this.name = name;
		this.brand = brand;
		this.quality = quality;
		this.type = type;
		this.favorite = false;
	}

}

package fr.amu.models;

public class Food {
	public enum TAG {
		NONE, EXCELLENT, GOOD, MEDIOCRE, BAD
	};

	// TODO : remplir en fonction de la BDD
	// id INTEGER IDENTITY PRIMARY KEY, name VARCHAR(255), imgurl VARCHAR(255), tag
	// VARCHAR(255), done BOOLEAN

	private int id;
	private String name;
	private String imgurl;
	private String tag;
	private boolean done;

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

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Food(String name, String imgurl) {
		super();
		this.name = name;
		this.imgurl = imgurl;
		this.done = false;
	}

	
	public Food() {
		
	}

}

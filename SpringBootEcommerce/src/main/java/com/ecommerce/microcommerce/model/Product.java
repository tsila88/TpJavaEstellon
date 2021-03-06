package com.ecommerce.microcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value= {"prixAchat","id"})
@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	@Length(min=3,max=20, message = "Message d'erreur ")
	private String nom;
	@Min(value=1)
	private int prix;
	// Ne pas afficher
	//@JsonIgnore
	private int prixAchat;
	
	

	
	public Product(int id, String nom, int prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

	public Product(int id, String nom, int prix, int prixAchat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.prixAchat = prixAchat;
	}

	public int getId() {
		return id;
	}

	public int getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}

	public Product() {

	}

}

package com.mohammad.sales.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Sales {
	@Id
	private int sid;
	private String creationDate;
	private String seller;
	private int quantities;
	private int totalprice;

	@ManyToOne
	private Product product;

	@ManyToOne
	private Clients client;

//Getter && Setter
	public double getId() {
		return sid;
	}

	public void setId(int id) {
		this.sid = id;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

	public int getTotal() {
		return totalprice;
	}

	public void setTotal(int total) {
		this.totalprice = total;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}

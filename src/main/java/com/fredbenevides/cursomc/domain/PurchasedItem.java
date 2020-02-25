package com.fredbenevides.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PurchasedItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PurchasedItemPK id = new PurchasedItemPK();
	private Double discount;
	private Double price;
	private Integer quantity;
	
	
	public PurchasedItem() {
		super();
	}


	public PurchasedItem(Purchase purchase, Product product, Double discount, Double price, Integer quantity) {

		this.id.setPurchase(purchase);
		this.id.setProduct(product);
		this.discount = discount;
		this.price = price;
		this.quantity = quantity;
	}

	public Purchase getPurchase() {
		return id.getPurchase();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}

	public PurchasedItemPK getId() {
		return id;
	}


	public void setId(PurchasedItemPK id) {
		this.id = id;
	}


	public Double getDiscount() {
		return discount;
	}


	public void setDiscount(Double discount) {
		this.discount = discount;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchasedItem other = (PurchasedItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

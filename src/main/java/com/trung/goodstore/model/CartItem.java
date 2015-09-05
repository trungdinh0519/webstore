package com.trung.goodstore.model;

import java.math.BigDecimal;

public class CartItem {
	static final long serialVersionUID = 111111479310115L;

	private Product product;

	private BigDecimal price;

	private int quantity;

	public CartItem() {
		super();
		product = null;
		quantity = 0;
		price = BigDecimal.valueOf(0).setScale(2);
	}

	public CartItem(Product product, BigDecimal price) {
		super();
		this.product = product;
		this.price = price;
		this.quantity = 1;
	}

	public CartItem(Product product, BigDecimal price, Integer quantity) {
		super();
		this.product = product;
		if (quantity <= 0)
			quantity = 1;
		this.quantity = quantity;
		this.price = price.setScale(2);
	}

	public String getIdentify() {
		return String.valueOf(this.hashCode());
	}

	public BigDecimal getPrice() {
		return this.setScale(price);
	}

	public void setPrice(BigDecimal price) {
		this.price = this.setScale(price);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSubTotal() {
		return price.multiply(this.setScale(new BigDecimal(quantity)));

	}

	public void incrementQuantity() {
		quantity += 1;
	}

	public void addQuantity(int i) {
		quantity += i;
	}

	protected BigDecimal setScale(BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((price == null) ? 0 : price.hashCode());
		result = PRIME * result + ((product == null) ? 0 : product.hashCode());
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
		final CartItem other = (CartItem) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}

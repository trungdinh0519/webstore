package com.trung.goodstore.model;

public class OrderItem extends BaseObject {
	public OrderItem() {
	}
	public static final long serialVersionUID = 123456789017L;

	private Long id;

	private Order order;

	private Product product;

	private Long quantity;

	private Double price;

	public Long getId() {
		return id;
	}

	public Order getOrder() {
		return order;
	}

	public Product getProduct() {
		return product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 29;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((order == null) ? 0 : order.hashCode());
		result = PRIME * result + ((price == null) ? 0 : price.hashCode());
		result = PRIME * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		final OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public double getTotalPrice() {

		return (getPrice().doubleValue()) * (quantity.intValue());
	}

	public double getTotalTax() {
		return 0.0;
	}
}
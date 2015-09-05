package com.trung.goodstore.model;

public class ProductComment extends BaseObject {
	public static final long serialVersionUID = 46643555555555558L;
	private Long id;
	private Product product;
	
	private String name;

	private String email;

	private Integer rating;

	private String content;

	public ProductComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.name+" , "+this.rating + "]";
	}

}

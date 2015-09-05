package com.trung.goodstore.model;


/**
 * @author Trung Fullname:Nguyen Dinh Trung  e-mail:trungnd07@gmail.com 
 */
/*
 * @hibernate.class table="ssh_product_vote"
 */
public class ProductVote extends BaseObject {
	public static final long serialVersionUID=123456789049L;
	private Long id;
	private Product product;
	private Byte ranking;
	private Long votes;
	private String lastip;
	public ProductVote() {
		super();
	}
	/**
	 * @hibernate.id column="vote_id" generator-class="increment"
	 * @return
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @hibernate.property column="vote_lastip" length="32"
	 * @return
	 */
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	/**
	 * @hibernate.many-to-one column=vote_product_id" lazy="false"
	 * @return
	 */
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @hibernate.property column="vote_ranking"
	 * @return
	 */
	public Byte getRanking() {
		return ranking;
	}
	public void setRanking(Byte ranking) {
		this.ranking = ranking;
	}
	/**
	 * @hibernate.property column="vote_result"
	 * @return
	 */
	public Long getVotes() {
		return votes;
	}
	public void setVotes(Long votes) {
		this.votes = votes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ProductVote other = (ProductVote) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
}

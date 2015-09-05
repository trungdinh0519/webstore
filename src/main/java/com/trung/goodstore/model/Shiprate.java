package com.trung.goodstore.model;

public class Shiprate extends BaseObject {
	public static final long serialVersionUID = 12345678983250L;

	private Long id;

	private String name;

	private Double from;

	private Double to;

	private Double price;

	private Double levAmout;

	private Double levPrice;
	
	private ShipMethod method;
	
	//private Set<Province> provinces=new HashSet<Province>();

	public Shiprate() {	}

	public Double getFrom() {
		return from;
	}

	public Long getId() {
		return id;
	}

	public Double getLevAmout() {
		return levAmout;
	}

	public Double getLevPrice() {
		return levPrice;
	}

	public ShipMethod getMethod() {
		return method;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	

	public Double getTo() {
		return to;
	}

	public void setFrom(Double from) {
		this.from = from;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLevAmout(Double levAmout) {
		this.levAmout = levAmout;
	}

	public void setLevPrice(Double levPrice) {
		this.levPrice = levPrice;
	}

	public void setMethod(ShipMethod method) {
		this.method = method;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	
	public void setTo(Double to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return this.getName();
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = super.hashCode();
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Shiprate other = (Shiprate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

package com.trung.goodstore.model;

import java.lang.Double;
import java.lang.Long;
import java.lang.String;

import java.text.NumberFormat;
import java.util.Date;


/**
 * @author Trung Fullname:Nguyen Dinh Trung e-mail:trungnd07@gmail.com
 */
public class Product extends BaseObject {
	public static final long serialVersionUID = 123456789018L;

	private Long id;
	private String name;
	private String sort_desc;
	private String desc;
	private String smallImage;
	private String mediumImage;
	private String largeImage;
	private Double height;
	private Double length;
	private Double width;
	private Double weight;
	private String unit;//don vi tinh
	private Double unitPrice;//don gia goc
	private Date cdate;
	private Date mdate;
	//private Currency currency;disable
	private Double discount;	//giam gia
	private Long stock=0L;//so luong trong kho
	private Category category;
	private Manufacturer manufacturer;
	private Boolean active;
	//If false, this product will not appear to customers. 
	private Boolean taxed;//If true, the order item total for this product will be added to the order's taxable subtotal. 
	private Boolean special;//hang dac biet?khong cap nhat truc tiep truong nay. khi dua mot san pham vao danh muc hang dac biet
	//thi truong nay chuyen thanh true. va mat hang nay se dc tinh gia tri theo gia cua hang dac biet.
	//private Tax tax;//thue VAT
	private Long sales;//so luong da ban. chi dung thong tin nay cho tinh toan. thong tin nay ko the sua.

	public Product() {}

	
	/**
	 * @return the cdate
	 */
	public Date getCdate() {
		return cdate;
	}


	/**
	 * @return the mdate
	 */
	public Date getMdate() {
		return mdate;
	}


	/**
	 * @param cdate the cdate to set
	 */
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}


	/**
	 * @param mdate the mdate to set
	 */
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}


	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the largeImage
	 */
	public String getLargeImage() {
		return largeImage;
	}

	/**
	 * @return the length
	 */
	public Double getLength() {
		return length;
	}

	/**
	 * @return the manufacturer
	 */
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	
	/**
	 * @return the mediumImage
	 */
	public String getMediumImage() {
		return mediumImage;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the sales
	 */
	public Long getSales() {
		return sales;
	}

	/**
	 * @return the smallImage
	 */
	public String getSmallImage() {
		return smallImage;
	}

	/**
	 * @return the sort_desc
	 */
	public String getSort_desc() {
		return sort_desc;
	}

	/**
	 * @return the special
	 */
	public Boolean getSpecial() {
		return special;
	}

	/**
	 * @return the stock
	 */
	public Long getStock() {
		return stock;
	}

	/**
	 * @return the taxed
	 */
	public Boolean getTaxed() {
		return taxed;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @return the unitPrice
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param largeImage the largeImage to set
	 */
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Double length) {
		this.length = length;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	
	/**
	 * @param mediumImage the mediumImage to set
	 */
	public void setMediumImage(String mediumImage) {
		this.mediumImage = mediumImage;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param sales the sales to set
	 */
	public void setSales(Long sales) {
		this.sales = sales;
	}

	/**
	 * @param smallImage the smallImage to set
	 */
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	/**
	 * @param sort_desc the sort_desc to set
	 */
	public void setSort_desc(String sort_desc) {
		this.sort_desc = sort_desc;
	}

	/**
	 * @param special the special to set
	 */
	public void setSpecial(Boolean special) {
		this.special = special;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Long stock) {
		this.stock = stock;
	}

	/**
	 * @param taxed the taxed to set
	 */
	public void setTaxed(Boolean taxed) {
		this.taxed = taxed;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}

	/* Override method */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 29;
		
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (getClass() != obj.getClass())
			return false;
		final Product other = (Product) obj;
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

	@Override
	public String toString() {
		return this.getName();
	}

	/* business method
	public void addStock(Long value) {
		if (value <= 0)
			return;
		this.stock += value;
	}

	public Long getBalanceStock() {
		return this.stock - this.sales;
	}

	public Long getInstock() {
		if (this.getBalanceStock() > 0)
			return this.getBalanceStock();
		else
			return new Long(0);
	}
 */
	public Double getPrice() {
		Double price = 0.0;
		price = this.getUnitPrice();
		if(this.discount!=null)
		price=price-(this.discount*price);
		return Double.valueOf(price);
	}

	public String getDisplayPrice() {
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		return format.format(this.getPrice());
	}

}
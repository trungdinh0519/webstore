package com.trung.goodstore.web.form;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

/**
 * 
 * @author trung dinh
 * 
 */
public class ProductForm extends ValidatorForm {
	public static final long serialVersionUID = 12345678944567L;

	private String id;

	private String name;

	private String sort_desc;

	private String desc;

	private String smallImage;

	private String mediumImage;

	private String largeImage;

	private String height;

	private String length;

	private String width;

	private String weight;

	private String unit;// don vi tinh

	private String unitPrice;// don gia goc

	private String discount; // giam gia

	private String stock;// so luong trong kho

	private String category;

	private String manufacturer;

	private Boolean active = true;

	// If false, this product will not appear to customers.
	private Boolean taxed = true;// If true, the order item total for this

	// product will be added to the order's
	// taxable subtotal.

	private FormFile smallFile;

	private FormFile mediumFile;

	private FormFile largeFile;

	public ProductForm() {
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
	public String getCategory() {
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
	public String getDiscount() {
		return discount;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @return the largeFile
	 */
	public FormFile getLargeFile() {
		return largeFile;
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
	public String getLength() {
		return length;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @return the mediumFile
	 */
	public FormFile getMediumFile() {
		return mediumFile;
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
	 * @return the smallFile
	 */
	public FormFile getSmallFile() {
		return smallFile;
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
	 * @return the stock
	 */
	public String getStock() {
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
	public String getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param dateAdded
	 *            the dateAdded to set
	 */

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @param largeFile
	 *            the largeFile to set
	 */
	public void setLargeFile(FormFile largeFile) {
		this.largeFile = largeFile;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param largeImage
	 *            the largeImage to set
	 */
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(String length) {
		this.length = length;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @param mediumFile
	 *            the mediumFile to set
	 */
	public void setMediumFile(FormFile mediumFile) {
		this.mediumFile = mediumFile;
	}

	/**
	 * @param mediumImage
	 *            the mediumImage to set
	 */
	public void setMediumImage(String mediumImage) {
		this.mediumImage = mediumImage;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param smallFile
	 *            the smallFile to set
	 */
	public void setSmallFile(FormFile smallFile) {
		this.smallFile = smallFile;
	}

	/**
	 * @param smallImage
	 *            the smallImage to set
	 */
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	/**
	 * @param sort_desc
	 *            the sort_desc to set
	 */
	public void setSort_desc(String sort_desc) {
		this.sort_desc = sort_desc;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(String stock) {
		this.stock = stock;
	}

	/**
	 * @param taxed
	 *            the taxed to set
	 */
	public void setTaxed(Boolean taxed) {
		this.taxed = taxed;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @param unitPrice
	 *            the unitPrice to set
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);
		if(StringUtils.isNotEmpty(this.sort_desc)&&this.sort_desc.length()>255)this.sort_desc=sort_desc.substring(0,255);
		NumberFormat perf = NumberFormat.getPercentInstance();
		DecimalFormat numbf = new DecimalFormat();
		numbf.setGroupingUsed(false);
		numbf.setMaximumFractionDigits(2);
		

		if (StringUtils.isNotEmpty(this.height.trim())) {
			try {
				double h = numbf.parse(this.height.trim()).doubleValue();
				if (h < 0)
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"errors.notgt.zezo", "Chieu cao"));
			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.not.numberic", "Chieu cao"));
			}
		}
		if (StringUtils.isNotEmpty(this.unitPrice.trim())) {
			try {
				double h = numbf.parse(this.unitPrice.trim()).doubleValue();
				if (h < 0)
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"errors.notgt.zezo", "Don gia"));
			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.not.numberic", "Don gia"));
			}
		}
		if (StringUtils.isNotEmpty(this.weight.trim())) {
			try {
				double h = numbf.parse(this.weight.trim()).doubleValue();
				if (h < 0)
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"errors.notgt.zezo", "Trong luong"));
			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.not.numberic", "Trong luong"));
			}
		}
		if (StringUtils.isNotEmpty(this.discount.trim())) {
			try {
				double x = perf.parse(this.discount.trim()).doubleValue();
				if (x < 0 || x > 1) {
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"errors.product.dcnotGTprice"));
				}
			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.not.percent", "Giam gia"));
			}

		}
		if (StringUtils.isNotEmpty(this.length.trim())) {
			try {
				double h =numbf.parse(this.length.trim()).doubleValue();
				if (h < 0)
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"errors.notgt.zezo", "Chieu dai"));
			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.not.numberic", "Chieu dai"));
			}
		}
		if (StringUtils.isNotEmpty(this.width.trim())) {
			try {
				double h = numbf.parse(this.width.trim()).doubleValue();
				if (h < 0)
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"errors.notgt.zezo", "Chieu rong"));
			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.not.numberic", "Chieu rong"));
			}
		}
		if (StringUtils.isNotEmpty(this.stock.trim())) {
			try {
				long h = numbf.parse(this.stock.trim()).longValue();
				if (h < 0)
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"errors.notgt.zezo", "So luong"));
			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.not.numberic", "So luong"));
			}
		}

		return errors;
	}

}

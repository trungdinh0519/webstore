package com.trung.goodstore.web.form;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class ShiprateForm extends ValidatorForm {
	public static final long serialVersionUID = 3424235423523L;

	private String id;

	private String name;

	private String from;

	private String to;

	private String price;

	private String levAmout;

	private String levPrice;

	private String shipMethod;

	private String[] provinces = new String[0];

	public ShiprateForm() {

	}

	public String getFrom() {
		return from;
	}

	public String getId() {
		return id;
	}

	public String getLevAmout() {
		return levAmout;
	}

	public String getLevPrice() {
		return levPrice;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getTo() {
		return to;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLevAmout(String levAmout) {
		this.levAmout = levAmout;
	}

	public void setLevPrice(String levPrice) {
		this.levPrice = levPrice;
	}

	public String getShipMethod() {
		return shipMethod;
	}

	public void setShipMethod(String shipMethod) {
		this.shipMethod = shipMethod;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String[] getProvinces() {
		return provinces;
	}

	public void setProvinces(String[] provinces) {
		this.provinces = provinces;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);
		DecimalFormat numbf = new DecimalFormat();
		numbf.setGroupingUsed(false);
		numbf.setMaximumFractionDigits(3);
		double f = 0.0, t = 0.0;
		try {
			f = numbf.parse(this.getFrom().trim()).doubleValue();
			t = numbf.parse(this.getTo().trim()).doubleValue();
			if (f >= t) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.shiprate.from_gt_to"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (StringUtils.isNotEmpty(this.levAmout.trim())) {
			try {
				double la = numbf.parse(this.levAmout.trim()).doubleValue();
				if (la < 0)
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"errors.notgt.zezo", "Trong luong moi nac"));
				if ((t - f) > 0.0) {
					double x = t - f;
					if (la >= x)
						errors.add(ActionErrors.GLOBAL_MESSAGE,
								new ActionMessage("errors.shiprate.levAmout"));

				}

			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.not.numberic", "Trong luong moi nac"));
			}
		}
		if (StringUtils.isNotEmpty(this.levPrice.trim())) {
			try {
				double lp = numbf.parse(this.levPrice.trim()).doubleValue();
				if (lp < 0)
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
							"errors.notgt.zezo", "gia cuoc moi nac"));

			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"errors.not.numberic", "gia cuoc moi nac"));
			}
		}
		return errors;
	}

}

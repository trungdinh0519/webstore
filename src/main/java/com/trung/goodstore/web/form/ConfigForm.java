package com.trung.goodstore.web.form;

public class ConfigForm extends BaseForm {
	public static final long serialVersionUID = 4235445654107887L;

	private String moitruong;

	private String businessemail;

	private String tencongty;

	private String diachi;

	private String nguoinhantien;

	private String emailSupport;

	private String usd_vnd;

	public String getUsd_vnd() {
		return usd_vnd;
	}

	public void setUsd_vnd(String usd_vnd) {
		this.usd_vnd = usd_vnd;
	}

	public ConfigForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBusinessemail() {
		return businessemail;
	}

	public String getDiachi() {
		return diachi;
	}

	public String getEmailSupport() {
		return emailSupport;
	}

	public String getMoitruong() {
		return moitruong;
	}

	public String getNguoinhantien() {
		return nguoinhantien;
	}

	public String getTencongty() {
		return tencongty;
	}

	public void setBusinessemail(String businessemail) {
		this.businessemail = businessemail;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public void setEmailSupport(String emailSupport) {
		this.emailSupport = emailSupport;
	}

	public void setMoitruong(String moitruong) {
		this.moitruong = moitruong;
	}

	public void setNguoinhantien(String nguoinhantien) {
		this.nguoinhantien = nguoinhantien;
	}

	public void setTencongty(String tencongty) {
		this.tencongty = tencongty;
	}

}

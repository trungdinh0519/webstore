package com.trung.goodstore.web.action;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.trung.goodstore.service.Config;
import com.trung.goodstore.web.form.ConfigForm;

public class ConfigAction extends BaseDispatchAction {
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Config config = (Config) this.getBean("config");
		ConfigForm cf = new ConfigForm();
		cf.setBusinessemail(config.getInfo().getProperty("business_email"));
		cf.setMoitruong(config.getInfo().getProperty("Environment"));
		cf.setDiachi(config.getInfo().getProperty("diachipos"));
		cf.setEmailSupport(config.getInfo().getProperty("emailpos"));
		cf.setNguoinhantien(config.getInfo().getProperty("nguoinhantienpos"));
		cf.setTencongty(config.getInfo().getProperty("companynamepos"));
		cf.setUsd_vnd(config.getInfo().getProperty("usd_vnd"));
		if ("request".equals(mapping.getScope())) {
			request.setAttribute(mapping.getAttribute(), cf);
		} else {
			request.getSession().setAttribute(mapping.getAttribute(), cf);
		}
		request.setAttribute("configForm", cf);
		request.setAttribute("configs", config.getKeys());
		return mapping.findForward("success");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ConfigForm cf = (ConfigForm) form;
		Config config = (Config) this.getBean("config");
		config.getInfo().put("business_email", cf.getBusinessemail());
		config.getInfo().put("Environment", cf.getMoitruong());
		config.getInfo().put("diachipos", cf.getDiachi());
		config.getInfo().put("emailpos", cf.getEmailSupport());
		config.getInfo().put("nguoinhantienpos", cf.getNguoinhantien());
		config.getInfo().put("companynamepos", cf.getTencongty());
		config.getInfo().put("usd_vnd", cf.getUsd_vnd());
		config.save();
		config.load();
		
		return mapping.findForward("success");
	}

}

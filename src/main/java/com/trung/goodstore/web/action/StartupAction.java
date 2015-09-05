package com.trung.goodstore.web.action;

import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.trung.goodstore.Constants;
import com.trung.goodstore.service.*;
import com.trung.goodstore.model.Cart;
import com.trung.goodstore.model.Country;
import com.trung.goodstore.service.CountryManager;

import com.trung.goodstore.service.ProductManager;
import com.trung.goodstore.util.SpringUtil;

public class StartupAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ProductManager manager = (ProductManager) this
				.getBean("productManager");
		request.getSession().setAttribute("categories", manager.getCategorys());

		HttpSession session = request.getSession();
		CountryManager countryManager = (CountryManager) this
				.getBean("countryManager");
		if (session.getAttribute("map_countries") == null) {
			List countries = (List) countryManager.getCountries();
			Hashtable<String, Country> map_countries = new Hashtable<String, Country>();
			for (int i = 0; i < countries.size(); i++) {
				Country ct = (Country) countries.get(i);
				map_countries.put(ct.getCode2(), ct);
			}
			session.setAttribute("map_countries", map_countries);
			session.setAttribute("countries", countries);
		}
		Cart cart = (Cart) session.getAttribute(Constants.SHOPCART);
		if (cart == null) {
			cart = new Cart();
			session.setAttribute(Constants.SHOPCART, cart);
		}
		Config config = (Config) this.getBean("config");
		// config.load();
		// Config config = (Config) session.getAttribute("configInfo");
		if (session.getAttribute("companynamepos") == null) {
			session.setAttribute("companynamepos", config.getInfo()
					.getProperty("companynamepos"));
			session.setAttribute("diachipos", config.getInfo().getProperty(
					"diachipos"));
			session.setAttribute("nguoinhantienpos", config.getInfo()
					.getProperty("nguoinhantienpos"));
			session.setAttribute("emailpos", config.getInfo().getProperty(
					"emailpos"));
		}
		ProductManager pm = (ProductManager) SpringUtil
				.getBean("productManager");
		List l1 = pm.getProductNew();
		List l2 = pm.getProductDiscount();
		request.setAttribute("productnews", l1);
		request.setAttribute("productdiscounts", l2);
		return mapping.findForward("success");
	}
}

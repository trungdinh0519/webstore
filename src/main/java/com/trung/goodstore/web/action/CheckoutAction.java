package com.trung.goodstore.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.trung.goodstore.Constants;
import com.trung.goodstore.model.Cart;
import com.trung.goodstore.model.CartItem;
import com.trung.goodstore.model.Country;
import com.trung.goodstore.model.LineShiprate;
import com.trung.goodstore.model.ShipMethod;
import com.trung.goodstore.model.User;
import com.trung.goodstore.service.Config;
import com.trung.goodstore.service.CountryManager;
import com.trung.goodstore.service.ShipManager;
import com.trung.goodstore.service.UserManager;
import com.trung.goodstore.web.form.BillingForm;
import com.trung.goodstore.web.form.ChooseMethodForm;
import com.trung.goodstore.web.form.ShippingForm;

public class CheckoutAction extends BaseDispatchAction {
	private void setProvincesToSession(String c_code, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Hashtable<String, Country> map = (Hashtable<String, Country>) session.getAttribute("map_countries");
		if (map != null) {
			Country country = map.get(c_code);
			// ProvinceManager pm = (ProvinceManager) SpringUtil
			// .getBean("provinceManager");
			// List<Province> rgs = pm.getProvinceByCountry(country);
			session.setAttribute("provinces", null);
		}
	}

	public ActionForward fillbill(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		HttpSession session = request.getSession(false);
		UserManager manager = (UserManager) this.getBean("userManager");
		Cart cart = (Cart) session.getAttribute(Constants.SHOPCART);
		if (cart == null) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("Giỏ hàng rỗng"));
		} else
			for (int i = 0; i < cart.getCartItems().size(); i++) {
				CartItem item = cart.getCartItem(i);
				if (item.getProduct().getStock() == null || item.getProduct().getStock() < item.getQuantity()) {
					errors.add(ActionMessages.GLOBAL_MESSAGE,
							new ActionMessage("error.cartItem.quantity.invalid", item.getProduct().getName()));
				}

			}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
		CountryManager countryManager = (CountryManager) this.getBean("countryManager");
		if (session.getAttribute("countries") == null) {
			List countries = (List) countryManager.getCountries();
			Hashtable<String, Country> map_countries = new Hashtable<String, Country>();
			for (int i = 0; i < countries.size(); i++) {
				Country ct = (Country) countries.get(i);
				map_countries.put(ct.getCode2(), ct);
			}
			session.setAttribute("countries", countries);
			session.setAttribute("map_countries", map_countries);
		}
		String c_code = request.getParameter("c_code");
		if (StringUtils.isNotEmpty(c_code)) {
			setProvincesToSession(c_code, request);
			return mapping.findForward("success");
		}
		try {
			if (cart.isEmpty()) {
				throw new IllegalStateException("error.shoppingCart.empty");
			}
			BillingForm billingForm = new BillingForm();

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = "";
			if (auth != null)
				username = auth.getName();

			if (StringUtils.isNotEmpty(username)) {
				User user = manager.getUser(username);
				if (user != null) {
					billingForm.setFirstname(user.getFirstName());
					billingForm.setLastname(user.getLastName());
					billingForm.setEmail(user.getEmail());
					billingForm.setPhone(user.getPhone());
					billingForm.setAddress(user.getAddress().getAddress());
					billingForm.setCity(user.getAddress().getCity());
					billingForm.setProvince(user.getAddress().getProvince());
					billingForm.setCountry(user.getAddress().getCountry());

				}
			}
			if ("request".equals(mapping.getScope())) {
				request.setAttribute(mapping.getAttribute(), billingForm);
			} else {
				request.getSession().setAttribute(mapping.getAttribute(), billingForm);
			}
			setProvincesToSession(billingForm.getCountry(), request);
			return mapping.findForward("success");

		} catch (IllegalStateException ise) {
			log.error(ise);
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.shoppingCart.empty"));
			saveErrors(request, errors);
			return mapping.getInputForward();

		} catch (Exception t) {
			log.error(t);
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.unexpected"));
			saveErrors(request, errors);
			return mapping.getInputForward();
		}

	}

	public ActionForward nextship(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		BillingForm billingForm = (BillingForm) form;
		String cas = billingForm.getChooseAddShip();
		try {
			request.getSession().setAttribute("c_code", null);
			try {
				// ProvinceManager provinceManager = (ProvinceManager) this
				// .getBean("provinceManager");
				CountryManager countryManager = (CountryManager) this.getBean("countryManager");
				billingForm.setCountry_name(
						((Country) countryManager.getCountryByCode2(billingForm.getCountry())).getName());
				// billingForm.setProvince_name(((Province) provinceManager
				// .getProvinceByCode(billingForm.getProvince()))
				// .getName());
				request.getSession().setAttribute("billingForm", billingForm);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (StringUtils.isNotEmpty(cas) && cas.equals("ShipNew")) {
				return mapping.findForward("ship");
			} else {
				ShippingForm shippingForm = new ShippingForm();
				BeanUtils.copyProperties(shippingForm, billingForm);
				System.out.println("########copy thanh cong:" + shippingForm.getFirstname());
				request.getSession().setAttribute("shippingForm", shippingForm);
				return mapping.findForward("choose");
			}
		} catch (IllegalStateException ise) {
			log.error(ise);
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.shoppingCart.empty"));
			saveErrors(request, errors);
			return mapping.getInputForward();

		} catch (Throwable t) {
			log.error(t);
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.unexpected"));
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
	}

	public ActionForward fillshipinfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String c_code = request.getParameter("c_code");
		if (StringUtils.isNotEmpty(c_code)) {
			setProvincesToSession(c_code, request);
			return mapping.findForward("success");
		}
		ShippingForm shippingForm = (ShippingForm) request.getSession().getAttribute("shippingForm");

		if (shippingForm == null) {
			{
				shippingForm = new ShippingForm();
				setProvincesToSession(shippingForm.getCountry(), request);
			}
		}
		if ("request".equals(mapping.getScope())) {
			request.setAttribute(mapping.getAttribute(), shippingForm);
		} else {
			request.getSession().setAttribute(mapping.getAttribute(), shippingForm);
		}
		return mapping.findForward("success");

	}

	public ActionForward savesinfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ShippingForm shippingForm = (ShippingForm) form;
		setProvincesToSession(shippingForm.getCountry(), request);
		request.getSession().setAttribute("shippingForm", shippingForm);
		return mapping.findForward("success");
	}

	public ActionForward cmethod(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ShipManager shipManager = (ShipManager) this.getBean("shipManager");
		List shipMethods = shipManager.getObjects(ShipMethod.class);
		// List<String> payMethods = new ArrayList<String>();
		ShippingForm shippingForm = (ShippingForm) request.getSession().getAttribute("shippingForm");
		Cart cart = (Cart) request.getSession().getAttribute(Constants.SHOPCART);
		if (cart == null || cart.isEmpty()) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.shoppingCart.empty"));
		}
		if (shippingForm == null) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.shipinfo.null"));
		} else {
			if (!shippingForm.getCountry().equalsIgnoreCase("VN")) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.shipinfo.notVn"));

				// return new ActionForward();
			}

		}
		if (!errors.isEmpty()) {
			this.saveErrors(request, errors);
			return mapping.findForward("failure");
		}
		// payMethods.add("Chuyen tien buu dien");
		// payMethods.add("The tin dung");
		List<LineShiprate> lineShiprates = new ArrayList<LineShiprate>();
		System.out.println("**********************************");
		System.out.println("province=" + shippingForm.getProvince());
		System.out.println("cart w=" + cart.getWeight());
		try {
			for (int i = 0; i < shipMethods.size(); i++) {
				System.out.println("ship method=" + shipMethods.get(i));
				BigDecimal rate = shipManager.calculate(shippingForm.getProvince(), (ShipMethod) shipMethods.get(i),
						cart.getWeight());
				LineShiprate ls = new LineShiprate();
				ls.setShipMethod((ShipMethod) shipMethods.get(i));
				ls.setShiprate(rate);
				lineShiprates.add(ls);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("lineships", lineShiprates);
		// request.getSession().setAttribute("payMethods", payMethods);
		return mapping.findForward("success");
	}

	public ActionForward processcm(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("%***************************************%");
		HttpSession session = request.getSession();
		try {

			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";

			Config config = (Config) this.getBean("config");
			BigDecimal usd_vnd = new BigDecimal(config.getInfo().getProperty("usd_vnd")).setScale(2);

			String cancel_Url = basePath + "pages/home.do";
			String return_Url = basePath + "pages/completeOrder.do";
			// if (session.getAttribute("cancel_url") == null) {
			session.setAttribute("cancel_url", cancel_Url);
			// }
			// if (session.getAttribute("return_url") == null) {
			session.setAttribute("return_url", return_Url);
			session.setAttribute("usd_vnd", usd_vnd);
			// }
			System.out.println("%return_url=%" + return_Url);
			System.out.println("%cancel_url=%" + cancel_Url);
			System.out.println("%usd_vnd=%" + usd_vnd);

			ChooseMethodForm cform = (ChooseMethodForm) form;

			System.out.println("shipmethod:" + cform.getShipmethod());
			List<LineShiprate> lineShiprates = (ArrayList<LineShiprate>) request.getSession().getAttribute("lineships");
			if (lineShiprates == null || lineShiprates.size() == 0) {
				return mapping.findForward("failure");
			}
			if (lineShiprates != null) {
				System.out.println("lineShiprates != null");
				System.out.println("lineShiprates.size=" + lineShiprates.size());
			}
			Cart cart = (Cart) request.getSession().getAttribute(Constants.SHOPCART);
			if (cart.isEmpty()) {
				return mapping.findForward("cart");
			}
			for (int i = 0; i < lineShiprates.size(); i++) {
				LineShiprate line = lineShiprates.get(i);
				String idship = line.getShipMethod().getId().toString();
				System.out.println(idship);
				if (idship.equalsIgnoreCase(cform.getShipmethod())) {
					cart.setShipcost(line.getShiprate());
				}
			}
			for (int i = 0; i < cart.getCartItems().size(); i++) {
				System.out.println("%price" + i + "=" + cart.getCartItem(i).getPrice());
				System.out.println(
						"%exchange" + i + "=" + cart.getCartItem(i).getPrice().doubleValue() / usd_vnd.doubleValue());

			}
			System.out.println("%shipcost" + "=" + cart.getShipcost());
			System.out.println(
					"%shipcost/usd_vnd" + "=" + cart.getShipcost().divide(usd_vnd, 2, BigDecimal.ROUND_HALF_UP));
			session.setAttribute("shipcost", cart.getShipcost().divide(usd_vnd, 2, BigDecimal.ROUND_HALF_UP));
			System.out.println("%***************************************%");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Config config = (Config) this.getBean("config");

		session.setAttribute("companynamepos", config.getInfo().getProperty("companynamepos"));
		session.setAttribute("diachipos", config.getInfo().getProperty("diachipos"));
		session.setAttribute("nguoinhantienpos", config.getInfo().getProperty("nguoinhantienpos"));
		session.setAttribute("emailpos", config.getInfo().getProperty("emailpos"));

		return mapping.findForward("success");
	}
}

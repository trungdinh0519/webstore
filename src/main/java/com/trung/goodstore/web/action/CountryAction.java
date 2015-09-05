package com.trung.goodstore.web.action;

import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.trung.goodstore.model.Country;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.CountryManager;
import com.trung.goodstore.util.SpringUtil;
import com.trung.goodstore.web.form.CountryForm;

public class CountryAction extends BaseDispatchAction {
	public ActionForward addnew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("new");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CountryManager manager = (CountryManager) this
				.getBean("countryManager");
		String id = request.getParameter("id");
		try {
			manager.removeObject(Country.class, new Long(id));
		} catch (ObjectNotFoundException onfe) {
			onfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			return new ActionForward("/common/403.jsp");
		}
		return mapping.findForward("listdo");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		CountryManager manager = (CountryManager) this
				.getBean("countryManager");
		Country country = new Country();
		CountryForm cform = (CountryForm) form;
		country.setName(cform.getName());
		country.setCode2(cform.getCode2());
		country.setCode3(cform.getCode3());
		if (manager.isExistCode2(country.getCode2())) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.country.code2.exist", cform.getCode2()));
			this.saveErrors(request, errors);
			return mapping.getInputForward();
		}
		if (manager.isExistCode3(country.getCode3())) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.country.code3.exist", cform.getCode3()));
			this.saveErrors(request, errors);
			return mapping.getInputForward();
		}
		if (manager.isExistName(country.getName())) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.country.name.exist", cform.getName()));
			this.saveErrors(request, errors);
			return mapping.getInputForward();
		}
		try {
			manager.saveObject(country);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", cform.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database " + cform.getName());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		CountryManager manager = (CountryManager) this
				.getBean("countryManager");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			try {
				Country country = (Country) manager.getObject(Country.class,
						new Long(id));
				log.debug("[Goodstore debug] getCountry()=" + country);
				CountryForm cform = new CountryForm();

				if (country != null) {
					cform.setId(country.getId().toString());
					cform.setName(country.getName());
					cform.setCode2(country.getCode2());
					cform.setCode3(country.getCode3());
				}
				if ("request".equals(mapping.getScope())) {
					request.setAttribute(mapping.getAttribute(), cform);
				} else {
					request.getSession().setAttribute(mapping.getAttribute(),
							cform);
				}
				return mapping.findForward("edit");
			} catch (ObjectNotFoundException onfe) {
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.getCountry.notfound", id));
				this.saveErrors(request, errors);
				return mapping.findForward("listdo");
			}
		} else {
			return new ActionForward("/common/403.jsp");
		}

	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		CountryManager manager = (CountryManager) this
				.getBean("countryManager");
		CountryForm cform = (CountryForm) form;
		Country country = (Country) manager.getObject(Country.class, new Long(
				cform.getId()));
		country.setName(cform.getName());
		country.setCode2(cform.getCode2());
		country.setCode3(cform.getCode3());

		try {
			manager.saveObject(country);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", cform.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database " + cform.getName());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CountryManager manager = (CountryManager) this
				.getBean("countryManager");
		List countries = manager.getObjects(Country.class);
		request.setAttribute("countries", countries);
		return mapping.findForward("list");
	}

	public ActionForward choose(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String returnUrl = request.getParameter("returnUrl");
		String c_code = request.getParameter("country");
		HttpSession session = request.getSession();
		if (session.getAttribute("countries") == null) {
			CountryManager countryManager = (CountryManager) this
					.getBean("countryManager");
			List countries = (List) countryManager.getCountries();
			Hashtable<String, Country> map_countries = new Hashtable<String, Country>();
			for (int i = 0; i < countries.size(); i++) {
				Country ct = (Country) countries.get(i);
				map_countries.put(ct.getCode2(), ct);
			}
			session.setAttribute("countries", countries);
			session.setAttribute("map_countries", map_countries);
		}
		if (!StringUtils.isEmpty(c_code)) {
			Hashtable<String, Country> map = (Hashtable<String, Country>) session
					.getAttribute("map_countries");
			Country country = map.get(c_code);
		//	ProvinceManager pm = (ProvinceManager) SpringUtil
		//			.getBean("provinceManager");
			//List<Province> rgs = pm.getProvinceByCountry(country);
			session.setAttribute("provinces", null);
			request.getSession().setAttribute("c_code", c_code);
		}
		return new ActionForward("success", returnUrl, true);
	}

}

package com.trung.goodstore.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.trung.goodstore.model.Country;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.CountryManager;
import com.trung.goodstore.web.form.ProvinceForm;

public class ProvinceAction extends BaseDispatchAction {
	public ActionForward addnew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CountryManager manager = (CountryManager) this
				.getBean("countryManager");
		List<Country> countries = manager.getCountries();
		//System.out.println("Size0f countries%%%%%%%%%%%%%%%%%%%%%:"+countries.size());
		request.getSession().setAttribute("countries", countries);
		return mapping.findForward("new");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ProvinceManager manager = (ProvinceManager) this
		//		.getBean("provinceManager");
		String id = request.getParameter("id");
		try {
		//	manager.removeObject(Province.class, new Long(id));
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
		//ProvinceManager manager = (ProvinceManager) this
		//		.getBean("provinceManager");
		CountryManager countryManager = (CountryManager) this
				.getBean("countryManager");
		//Province province = new Province();
		ProvinceForm pform = (ProvinceForm) form;
		//province.setName(pform.getName());
		//province.setCode(pform.getCode());
		try {
			Country country = countryManager.getCountryByCode2(pform
					.getCountry());
		//	province.setCountry(country);
		} catch (ObjectNotFoundException onfe) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.country.not.found", pform.getCountry()));
			this.saveErrors(request, errors);
			onfe.printStackTrace();
			return mapping.getInputForward();
		}
		try {
		//	manager.saveObject(province);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", pform.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database " + pform.getName());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		//ProvinceManager manager = (ProvinceManager) this
			//	.getBean("provinceManager");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			try {
		//		Province province = (Province) manager.getObject(
		//				Province.class, new Long(id));
			//	log.debug("[Goodstore debug] getProvince()=" + province);
				ProvinceForm pform = new ProvinceForm();

			//	if (province != null) {
			//		pform.setId(province.getId().toString());
			//		pform.setCode(province.getCode());
			//		pform.setName(province.getName());
			//		pform.setCountry(province.getCountry().getCode2());
			//	}
				if ("request".equals(mapping.getScope())) {
					request.setAttribute(mapping.getAttribute(), pform);
				} else {
					request.getSession().setAttribute(mapping.getAttribute(),
							pform);
				}
				CountryManager countrymanager = (CountryManager) this
						.getBean("countryManager");
				List<Country> countries = countrymanager.getCountries();
				request.getSession().setAttribute("countries", countries);
				return mapping.findForward("edit");
			} catch (ObjectNotFoundException onfe) {
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.getObject.notfound", id));
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
		//ProvinceManager manager = (ProvinceManager) this
		//		.getBean("provinceManager");
		ProvinceForm pform = (ProvinceForm) form;
		//Province province = (Province) manager.getObject(Province.class,
		//		new Long(pform.getId()));
		CountryManager countryManager = (CountryManager) this
				.getBean("countryManager");
		//province.setName(pform.getName());
		//province.setCode(pform.getCode());
		try {
			Country country = countryManager.getCountryByCode2(pform
					.getCountry());
		//	province.setCountry(country);
		} catch (ObjectNotFoundException onfe) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.country.not.found", pform.getCountry()));
			this.saveErrors(request, errors);
			onfe.printStackTrace();
			return mapping.getInputForward();
		}
		try {
		//	manager.saveObject(province);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", pform.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database " + pform.getName());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ProvinceManager manager = (ProvinceManager) this
		//		.getBean("provinceManager");
		//List provinces = manager.getObjects(Province.class);
		//request.setAttribute("provinces", provinces);
		return mapping.findForward("list");
	}

}

package com.trung.goodstore.web.action;

import java.text.DecimalFormat;
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
import com.trung.goodstore.model.ShipMethod;
import com.trung.goodstore.model.Shiprate;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.CountryManager;
import com.trung.goodstore.service.ShipManager;
import com.trung.goodstore.web.form.ShiprateForm;

public class ShiprateAction extends BaseDispatchAction {
	public ActionForward addnew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShipManager manager = (ShipManager) this.getBean("shipManager");
		//ProvinceManager provinceManager = (ProvinceManager) this
		//		.getBean("provinceManager");
		CountryManager countryManager = (CountryManager) this
				.getBean("countryManager");
		Country country = countryManager.getCountryByCode2("vn");
		List methods = manager.getObjects(ShipMethod.class);
		//List provinces = provinceManager.getProvinceByCountry(country);
		//request.getSession().setAttribute("provinces", provinces);
		request.getSession().setAttribute("methods", methods);
		return mapping.findForward("new");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShipManager manager = (ShipManager) this.getBean("shipManager");
		String id = request.getParameter("id");
		try {
			manager.removeShiprate(id);
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
		ShipManager manager = (ShipManager) this.getBean("shipManager");
		//ProvinceManager provinceManager = (ProvinceManager) this
		//		.getBean("provinceManager");
		Shiprate rate = new Shiprate();
		ShiprateForm sform = (ShiprateForm) form;
		// System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%:"
		// + sform.getProvinces().length);
		rate.setFrom(new Double(sform.getFrom()));
		rate.setTo(new Double(sform.getTo()));
		if (StringUtils.isNotEmpty(sform.getPrice()))
			rate.setPrice(new Double(sform.getPrice()));
		if (StringUtils.isNotEmpty(sform.getLevAmout()))
			rate.setLevAmout(new Double(sform.getLevAmout()));
		if (StringUtils.isNotEmpty(sform.getLevPrice()))
			rate.setLevPrice(new Double(sform.getLevPrice()));
		rate.setName(sform.getName());
		try {
			ShipMethod method = (ShipMethod) manager.getObject(
					ShipMethod.class, new Long(sform.getShipMethod()));
			if (method != null)
				rate.setMethod(method);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] ps = sform.getProvinces();
		// System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%:" + ps);
		for (int i = 0; i < ps.length; i++) {
			// System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%:" +
			// ps[i]);
			try {
				if (StringUtils.isNotEmpty(ps[i])) {
			//		Province p = provinceManager.getProvinceByCode(ps[i]);
				//	if (p != null)
				//		rate.getProvinces().add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			manager.saveShiprate(rate);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", sform.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database " + sform.getName());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		ShipManager manager = (ShipManager) this.getBean("shipManager");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			try {
				Shiprate rate = (Shiprate) manager.getObject(Shiprate.class,
						new Long(id));
				ShiprateForm cform = new ShiprateForm();
				DecimalFormat numbf = new DecimalFormat();
				numbf.setGroupingUsed(false);
				numbf.setMaximumFractionDigits(3);
				if (rate != null) {
					cform.setId(rate.getId().toString());
					cform.setName(rate.getName());
					if (rate.getFrom() != null)
						cform.setFrom(numbf.format(rate.getFrom()));
					if (rate.getTo() != null)
						cform.setTo(numbf.format(rate.getTo()));
					if (rate.getPrice() != null)
						cform.setPrice(numbf.format(rate.getPrice()));
					if (rate.getLevAmout() != null)
						cform.setLevAmout(numbf.format(rate.getLevAmout()));
					if (rate.getLevPrice() != null)
						cform.setLevPrice(numbf.format(rate.getLevPrice()));
					if (rate.getMethod() != null)
						cform
								.setShipMethod(rate.getMethod().getId()
										.toString());
				//	List ps = manager.getProvincesByShiprate(rate);
				//	String[] pstr = new String[ps.size()];
				//	for (int i = 0; i < ps.size(); i++) {
					//	Province p = (Province) ps.get(i);
					//	pstr[i] = p.getCode();
					}
					//cform.setProvinces(pstr);

				//}
				if ("request".equals(mapping.getScope())) {
					request.setAttribute(mapping.getAttribute(), cform);
				} else {
					request.getSession().setAttribute(mapping.getAttribute(),
							cform);
				}
			//	ProvinceManager provinceManager = (ProvinceManager) this
			//			.getBean("provinceManager");
				CountryManager countryManager = (CountryManager) this
						.getBean("countryManager");
				Country country = countryManager.getCountryByCode2("vn");
				List methods = manager.getObjects(ShipMethod.class);
				//List provinces = provinceManager.getProvinceByCountry(country);
				//request.getSession().setAttribute("provinces", provinces);
				request.getSession().setAttribute("methods", methods);
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
		ShipManager manager = (ShipManager) this.getBean("shipManager");
		//ProvinceManager provinceManager = (ProvinceManager) this
		//		.getBean("provinceManager");

		ShiprateForm sform = (ShiprateForm) form;
		Shiprate rate = (Shiprate) manager.getShiprate(sform.getId());

		rate.setFrom(new Double(sform.getFrom()));
		rate.setTo(new Double(sform.getTo()));
		if (StringUtils.isNotEmpty(sform.getPrice()))
			rate.setPrice(new Double(sform.getPrice()));
		if (StringUtils.isNotEmpty(sform.getLevAmout()))
			rate.setLevAmout(new Double(sform.getLevAmout()));
		if (StringUtils.isNotEmpty(sform.getLevPrice()))
			rate.setLevPrice(new Double(sform.getLevPrice()));
		rate.setName(sform.getName());
		try {
			ShipMethod method = (ShipMethod) manager.getObject(
					ShipMethod.class, new Long(sform.getShipMethod()));
			if (method != null)
				rate.setMethod(method);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] ps = sform.getProvinces();
		//List<Province> listP = new ArrayList<Province>();
		// System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%:" + ps);
		for (int i = 0; i < ps.length; i++) {
			// System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%:" +
			// ps[i]);
			try {
				if (StringUtils.isNotEmpty(ps[i])) {
			//		Province p = provinceManager.getProvinceByCode(ps[i]);
			//		if (p != null)
			//			listP.add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
		//	manager.updateShiprate(rate, listP);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", sform.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database " + sform.getName());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");

	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShipManager manager = (ShipManager) this.getBean("shipManager");
		List shiprates = manager.getShiprates();
		List methods = manager.getObjects(ShipMethod.class);
		request.getSession().setAttribute("methods", methods);
		request.setAttribute("shiprates", shiprates);
		return mapping.findForward("list");
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String smId = request.getParameter("smId");
		ShipManager manager = (ShipManager) this.getBean("shipManager");
		if (StringUtils.isNotEmpty(smId) && StringUtils.isNumeric(smId)) {
			ShipMethod sm = (ShipMethod) manager.getObject(ShipMethod.class,
					new Long(smId));
			List shiprates = manager.getShiprateByMethod(sm);
			List methods = manager.getObjects(ShipMethod.class);
			request.getSession().setAttribute("methods", methods);
			request.setAttribute("shiprates", shiprates);
			return mapping.findForward("list");
		} else {
			return new ActionForward("/admin/shiprate.do?method=list");
		}
	}
}

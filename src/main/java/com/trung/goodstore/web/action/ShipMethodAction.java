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


import com.trung.goodstore.model.ShipMethod;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;

import com.trung.goodstore.service.Manager;

import com.trung.goodstore.web.form.ShipMethodForm;

public class ShipMethodAction extends BaseDispatchAction {
	public ActionForward addnew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("new");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Manager manager = (Manager) this.getBean("manager");
		String id = request.getParameter("id");
		try {
			manager.removeObject(ShipMethod.class,new Long(id));
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
		Manager manager = (Manager) this.getBean("manager");
		ShipMethod method = new ShipMethod();
		ShipMethodForm cform = (ShipMethodForm) form;
		method.setDesc(cform.getDesc());
		method.setName(cform.getName());
		try {
			manager.saveObject(method);
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
		Manager manager = (Manager) this.getBean("manager");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			try {
				ShipMethod method= (ShipMethod) manager.getObject(
						ShipMethod.class, new Long(id));
				log.debug("[Goodstore debug] getCountry()=" + method);
				ShipMethodForm cform = new ShipMethodForm();

				if (method != null) {
					cform.setId(method.getId().toString());
					cform.setName(method.getName());
					cform.setDesc(method.getDesc());
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
		Manager manager = (Manager) this.getBean("manager");
		
		ShipMethodForm cform = (ShipMethodForm) form;
		ShipMethod method = (ShipMethod) manager.getObject(ShipMethod.class,
				new Long(cform.getId()));
		method.setDesc(cform.getDesc());
		method.setName(cform.getName());
		try {
			manager.saveObject(method);
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
		Manager manager = (Manager) this.getBean("manager");
		List methods = manager.getObjects(ShipMethod.class);
		request.setAttribute("shipMethods", methods);
		return mapping.findForward("list");
	}
}

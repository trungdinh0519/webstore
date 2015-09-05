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

import com.trung.goodstore.model.Manufacturer;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;

import com.trung.goodstore.service.MfManager;
import com.trung.goodstore.web.form.ManufacturerForm;

public class ManufacturerAction extends BaseDispatchAction {
	public ActionForward addnew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("new");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MfManager manager = (MfManager) this.getBean("mfManager");
		String id = request.getParameter("id");
		try {
			manager.delete(id);
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
		MfManager manager = (MfManager) this.getBean("mfManager");
		Manufacturer mf = new Manufacturer();
		ManufacturerForm mfForm = (ManufacturerForm) form;
		mf.setName(mfForm.getName());
		mf.setDesc(mfForm.getDesc());
		mf.setEmail(mfForm.getEmail());
		mf.setUrl(mfForm.getUrl());

		try {
			manager.saveObject(mf);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.savemf.failure", mfForm.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] Name " + mfForm.getName()
					+ " existed! please fill the other name.");
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return new ActionForward(mapping.findForward("success").getPath());
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		MfManager manager = (MfManager) this.getBean("mfManager");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			try {
				Manufacturer mf = (Manufacturer) manager.getObject(
						Manufacturer.class, new Long(id));
				log.debug("[Goodstore debug] getManufacturer()=" + mf);
				ManufacturerForm mfForm = new ManufacturerForm();

				if (mf != null) {
					mfForm.setId(mf.getId().toString());
					mfForm.setDesc(mf.getDesc());
					mfForm.setName(mf.getName());
					mfForm.setUrl(mf.getUrl());
					mfForm.setEmail(mf.getEmail());
				}
				if ("request".equals(mapping.getScope())) {
					request.setAttribute(mapping.getAttribute(), mfForm);
				} else {
					request.getSession().setAttribute(mapping.getAttribute(),
							mfForm);
				}
				return mapping.findForward("edit");
			} catch (ObjectNotFoundException onfe) {
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.getManufacturer.notfound", id));
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
		MfManager manager = (MfManager) this.getBean("mfManager");
		ManufacturerForm mfForm = (ManufacturerForm) form;
		Manufacturer mf = (Manufacturer) manager.getObject(Manufacturer.class,
				new Long(mfForm.getId()));
		mf.setName(mfForm.getName());
		mf.setDesc(mfForm.getDesc());
		mf.setEmail(mfForm.getEmail());
		mf.setUrl(mfForm.getUrl());
		try {
			manager.saveObject(mf);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.savemf.failure", mfForm.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] Name " + mfForm.getName()
					+ " existed! please fill the other name.");
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MfManager manager = (MfManager) this.getBean("mfManager");
		List mfs = manager.getObjects(Manufacturer.class);
		request.setAttribute("manufacturers", mfs);
		return mapping.findForward("list");
	}
}

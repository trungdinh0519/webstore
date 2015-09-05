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

import com.trung.goodstore.model.Category;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.Manager;
import com.trung.goodstore.service.ProductManager;

import com.trung.goodstore.web.form.CategoryForm;

public class CategoryAction extends BaseDispatchAction {
	public ActionForward addnew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("addnew");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Manager manager = (Manager) this.getBean("manager");
		String id = request.getParameter("id");
		try {
			manager.removeObject(Category.class, new Long(id));
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
		Category category = new Category();
		CategoryForm cform = (CategoryForm) form;
		category.setName(cform.getName().trim());
		category.setDesc(cform.getDesc().trim());
		try {
			manager.saveObject(category);
			ProductManager pMrg = (ProductManager) this
					.getBean("productManager");
			List categories = pMrg.getCategorys();
			request.getSession().setAttribute("categories", categories);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.category.existName", cform.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] Name " + cform.getName()
					+ " existed! please fill the other name.");
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
				Category category = (Category) manager.getObject(
						Category.class, new Long(id));
				log.debug("[Goodstore debug] getCategory()=" + category);
				CategoryForm cform = new CategoryForm();

				if (category != null) {
					cform.setId(category.getId().toString());
					cform.setName(category.getName());
					cform.setDesc(category.getDesc());
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
						"errors.getCategory.notfound", id));
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
		ProductManager pMrg = (ProductManager) this.getBean("productManager");
		CategoryForm cform = (CategoryForm) form;
		Category category = (Category) manager.getObject(Category.class,
				new Long(cform.getId()));
		category.setDesc(cform.getDesc().trim());
		category.setName(cform.getName().trim());
		try {
			manager.saveObject(category);
			List categories = pMrg.getCategorys();
			request.getSession().setAttribute("categories", categories);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.category.existName", cform.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] Name " + cform.getName()
					+ " existed! please fill the other name.");
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProductManager pMrg = (ProductManager) this.getBean("productManager");
		//if (request.getSession().getAttribute("categories") == null) {
			List categories = pMrg.getCategorys();
			request.setAttribute("categories", categories);
		//}
		return mapping.findForward("list");
	}
}

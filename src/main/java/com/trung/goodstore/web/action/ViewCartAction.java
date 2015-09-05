package com.trung.goodstore.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


import com.trung.goodstore.Constants;
import com.trung.goodstore.model.Cart;
import com.trung.goodstore.web.form.ShoppingCartForm;

public class ViewCartAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession(false);
		Cart cart = (Cart) session.getAttribute(Constants.SHOPCART);
		try {

			if (cart == null) {
				cart = new Cart();
				session.setAttribute(Constants.SHOPCART, cart);
			}

			ShoppingCartForm cartForm = new ShoppingCartForm(cart
					.getCartItems());
			if ("request".equals(mapping.getScope())) {
				request.setAttribute(mapping.getAttribute(), cartForm);
			} else {
				request.getSession().setAttribute(mapping.getAttribute(),
						cartForm);
			}

		} catch (Exception e) {
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpected"));

		}
		this.saveMessages(request, errors);

		return mapping.findForward("success");

	}

}

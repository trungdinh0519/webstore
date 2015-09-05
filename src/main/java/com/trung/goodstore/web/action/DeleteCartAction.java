package com.trung.goodstore.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.trung.goodstore.Constants;
import com.trung.goodstore.model.Cart;
import com.trung.goodstore.web.form.ShoppingCartForm;

public class DeleteCartAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages errors = new ActionMessages();
		HttpSession session = request.getSession(false);
		Cart cart = (Cart) session.getAttribute(Constants.SHOPCART);
		String index = request.getParameter("index");
		try {

			if (cart != null) {
				cart.remove(Integer.parseInt(index));
			} else {
				cart = new Cart();
			}
			session.setAttribute(Constants.SHOPCART, cart);
			ShoppingCartForm cartForm = new ShoppingCartForm(cart
					.getCartItems());
			if ("request".equals(mapping.getScope())) {
				request.setAttribute(mapping.getAttribute(), cartForm);
			} else {
				request.getSession().setAttribute(mapping.getAttribute(),
						cartForm);
			}
			return mapping.findForward("success");
		} catch (Exception t) {
			log.error(t);
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpected"));
		}

		//saveErrors(request, errors);
		return mapping.findForward("success");
	}

}

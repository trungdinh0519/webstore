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

public class EmptyCartAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages errors = new ActionMessages();
		HttpSession session = request.getSession(false);
		Cart cart = (Cart) session.getAttribute(Constants.SHOPCART);
		try {
			if (cart == null) {
				cart = new Cart();
			} else
				cart.empty();
			session.setAttribute(Constants.SHOPCART, cart);

		} catch (Throwable t) {
			log.error(t);
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpected"));
		}

		saveErrors(request, errors);
		return mapping.findForward("success");

	}

}

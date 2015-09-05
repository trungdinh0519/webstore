package com.trung.goodstore.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.LabelValueBean;

import com.trung.goodstore.Constants;
import com.trung.goodstore.model.Cart;
import com.trung.goodstore.web.form.ShoppingCartForm;

public class UpdateCartAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages errors = new ActionMessages();
		HttpSession session = request.getSession(false);
		ShoppingCartForm cartForm = (ShoppingCartForm) form;
		Cart cart = (Cart) session.getAttribute(Constants.SHOPCART);
		try {
			log.info("Updating cart");
			System.out.println("so luong :"
					+ cartForm.getLabelValueBeans().size());
			List<LabelValueBean> list = cartForm.getLabelValueBeans();
			List<String> dellist=new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				LabelValueBean lvbean = (LabelValueBean) list.get(i);
				if (lvbean != null) {
					if (Integer.parseInt(lvbean.getValue()) > 0)
						cart.update(Integer.parseInt(lvbean.getLabel()),
								Integer.parseInt(lvbean.getValue()));
					else dellist.add(cart.getCartItem(Integer.parseInt(lvbean.getLabel())).getIdentify());

				}

			}
			if(dellist.size()>0){
				for(int i=0;i<dellist.size();i++){
					cart.removeItem(cart.getItemMap().get(dellist.get(i)));
				}
			}

			session.setAttribute(Constants.SHOPCART, cart);
			cartForm = new ShoppingCartForm(cart.getCartItems());
			if ("request".equals(mapping.getScope())) {
				request.setAttribute(mapping.getAttribute(), cartForm);
			} else {
				request.getSession().setAttribute(mapping.getAttribute(),
						cartForm);
			}

		} catch (Exception t) {
			log.error(t);
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpected"));
		}
		this.saveErrors(request, errors);

		return mapping.findForward("success");
	}
}

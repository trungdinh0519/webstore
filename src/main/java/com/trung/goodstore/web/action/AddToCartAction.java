package com.trung.goodstore.web.action;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.trung.goodstore.web.exception.IllegalArgumentException;
import com.trung.goodstore.web.form.ShoppingCartForm;
import com.trung.goodstore.Constants;
import com.trung.goodstore.model.Cart;
import com.trung.goodstore.model.CartItem;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.service.ProductManager;

public class AddToCartAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String productId = request.getParameter("productId");
		String quantityStr = request.getParameter("quantity");
		String urlReturn = request.getParameter("urlreturn");
		int quantity = 1;
		try {
			quantity = new Integer(quantityStr);
		} catch (Exception e) {
			log.debug(e);
		}
		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession();
		session.setAttribute("returnShopUrl", urlReturn);
		Cart cart = (Cart) session.getAttribute(Constants.SHOPCART);
		try {
			ProductManager manager = (ProductManager) this
					.getBean("productManager");
			Product p = manager.getProduct(productId);
			if (p == null) {
				throw new IllegalArgumentException(
						"Illegal argument value for productID: " + productId);
			}
			if (cart == null) {
				cart = new Cart();
			}
			CartItem item = new CartItem(p, new BigDecimal(p.getPrice()),
					quantity);
			cart.addItem(item);
			session.setAttribute(Constants.SHOPCART, cart);
			ShoppingCartForm cartForm = new ShoppingCartForm(cart
					.getCartItems());
			request.getSession().setAttribute("cartForm", cartForm);

		} catch (Exception e) {
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpected"));
		}
		this.saveMessages(request, errors);
		return mapping.findForward("success");
	}
}

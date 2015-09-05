package com.trung.goodstore.web.action;

import java.util.Calendar;

import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.trung.goodstore.Constants;
import com.trung.goodstore.model.Cart;
import com.trung.goodstore.model.CartItem;
import com.trung.goodstore.model.Order;
import com.trung.goodstore.model.OrderItem;
import com.trung.goodstore.model.OrderStatus;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.service.OrderManager;
import com.trung.goodstore.service.ProductManager;

import com.trung.goodstore.web.form.BillingForm;
import com.trung.goodstore.web.form.ShippingForm;

public class CompleteOrderAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String mtpay = request.getParameter("mtpay");
		String txn_id = request.getParameter("txn_id");
		String receiver_id = request.getParameter("receiver_id");
		// luu vao don hang
		if (txn_id != null && receiver_id != null) {

			if (this.saveOrder(request, response, 5L)) {
				request.getSession().setAttribute(Constants.SHOPCART, null);
				request.getSession().setAttribute("shippingForm", null);
				request.getSession().setAttribute("billingForm", null);
				request.getSession().setAttribute("successpay", Boolean.TRUE);
				return mapping.findForward("success");
			} else {
				request.getSession().setAttribute("successpay", Boolean.FALSE);
			}

		} else if (mtpay.equals("pos")) {
			if (this.saveOrder(request, response, 4L)) {

				request.getSession().setAttribute(Constants.SHOPCART, null);
				request.getSession().setAttribute("shippingForm", null);
				request.getSession().setAttribute("billingForm", null);
				request.getSession().setAttribute("successpay", Boolean.TRUE);
				return mapping.findForward("success");
			} else {
				request.getSession().setAttribute("successpay", Boolean.FALSE);
			}

		}

		request.getSession().setAttribute("successpay", Boolean.FALSE);
		return mapping.findForward("failure");

	}

	private boolean saveOrder(HttpServletRequest request,
			HttpServletResponse response, Long ostatusId) {

		OrderManager orderManager = (OrderManager) this.getBean("orderManager");
		ProductManager pm = (ProductManager) this.getBean("productManager");
		Order order = new Order();
		Cart cart = (Cart) request.getSession()
				.getAttribute(Constants.SHOPCART);
		ShippingForm shipTo = (ShippingForm) request.getSession().getAttribute(
				"shippingForm");
		BillingForm billTo = (BillingForm) request.getSession().getAttribute(
				"billingForm");
		if (cart == null || cart.isEmpty())
			return false;
		if (billTo == null || shipTo == null)
			return false;
		order.setBillToAddress(billTo.getAddress());
		order.setBillToCity(billTo.getCity());
		order.setBillToCountry(billTo.getCountry());
		order.setBillToEmail(billTo.getEmail());
		order.setBillToFirstName(billTo.getFirstname());
		order.setBillToLastName(billTo.getLastname());
		order.setBillToPhone(billTo.getPhone());
		order.setBillToPostalCode(billTo.getPostalCode());
		order.setBillToProvince(billTo.getProvince());

		order.setShipToAddress(shipTo.getAddress());
		order.setShipToCity(shipTo.getCity());
		order.setShipToCountry(shipTo.getCountry());
		order.setShipToEmail(shipTo.getEmail());
		order.setShipToFirstName(shipTo.getFirstname());
		order.setShipToLastName(shipTo.getLastname());
		order.setShipToPhone(shipTo.getPhone());
		order.setShipToPostalCode(shipTo.getPostalCode());
		order.setShipToProvince(shipTo.getProvince());
		Calendar cal = new GregorianCalendar();// .getInstance();
		order.setOrderDate(cal.getTime());
		order.setOrderSubTotal(cart.getSubTotal().doubleValue());
		order.setShipPrice(cart.getShipcost().doubleValue());
		order.setOrderTotal(cart.getTotal().doubleValue());
		OrderStatus status = (OrderStatus) orderManager.getObject(
				OrderStatus.class, ostatusId);
		order.setStatus(status);
		try{
			orderManager.saveObject(order);
		}catch(Exception e){
			e.printStackTrace();
		}
	
			
			for (int i = 0; i < cart.getItems().size(); i++) {
				CartItem item = cart.getCartItems().get(i);
				System.out.println("$$$$$$$$$$$$$$$$$$$$"+i+"="+item.getQuantity());
				OrderItem oi = new OrderItem();
				oi.setOrder(order);
				Product p=(Product)pm.getProduct(item.getProduct().getId()
						.toString());
				oi.setProduct(p);
				oi.setPrice(item.getPrice().doubleValue());
				oi.setQuantity(item.getQuantity().longValue());
			//	order.add(oi);
				System.out.println("$$$$$$$$$$$$$$$$$$$$"+i+"="+p);
				//try{
					System.out.println("$$$$$$$$$$$$$$$$$$$$"+i+"="+oi.getQuantity());
				orderManager.saveOrderItem(oi);
				//}catch(Exception e){
				//	e.printStackTrace();
				//}
			}
		
		return true;
	}
}

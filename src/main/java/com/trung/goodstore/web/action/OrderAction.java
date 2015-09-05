package com.trung.goodstore.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.dao.DataAccessException;

import com.trung.goodstore.model.Country;
import com.trung.goodstore.model.Order;
import com.trung.goodstore.model.OrderStatus;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.CountryManager;
import com.trung.goodstore.service.OrderManager;
import com.trung.goodstore.service.exception.FailureException;
import com.trung.goodstore.web.form.OrderForm;

public class OrderAction extends BaseDispatchAction {
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderManager manager = (OrderManager) this.getBean("orderManager");
		String id = request.getParameter("id");
		try {
			manager.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ActionForward("/common/404.jsp");
		}
		return mapping.findForward("listdo");
	}

	public ActionForward updateStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		String statusId = request.getParameter("statusId");
		String returnUrl = request.getParameter("return");
		if (returnUrl == null && returnUrl.equals(""))
			returnUrl = "listdo";
		String oldStatusid = request.getParameter("oldStatusid");
		if (oldStatusid.equals(statusId))
			return mapping.findForward(returnUrl);
		ActionMessages errors = new ActionMessages();
		OrderManager manager = (OrderManager) this.getBean("orderManager");
		try {
			manager.updateStatus(id, statusId);
		} catch (FailureException e) {
			log.error(e);
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.updateStatus.failure"));

		}
		this.saveErrors(request, errors);
		return mapping.findForward(returnUrl);
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		ActionMessages errors = new ActionMessages();
		OrderManager manager = (OrderManager) this.getBean("orderManager");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			try {
				log.debug("************GetID()=" + id);
				Order order = (Order) manager.getObject(Order.class, new Long(
						id));
				log.debug("************GetOrder()=" + order.getId());
				OrderForm orderForm = new OrderForm();
				if (order != null) {

					try {
						orderForm.setBillToAddress(order.getBillToAddress());
						orderForm.setBillToAddress2(order.getBillToAddress2());
						orderForm.setBillToCity(order.getBillToCity());
						orderForm.setBillToCountry(order.getBillToCountry());
						orderForm.setBillToEmail(order.getBillToEmail());
						orderForm
								.setBillToFirstName(order.getBillToFirstName());
						orderForm.setBillToLastName(order.getBillToLastName());
						orderForm.setBillToPhone(order.getBillToPhone());
						orderForm.setBillToPostalCode(order
								.getBillToPostalCode());
						orderForm.setBillToProvince(order.getBillToProvince());

						orderForm.setShipToAddress(order.getShipToAddress());
						orderForm.setShipToAddress2(order.getShipToAddress2());
						orderForm.setShipToCity(order.getShipToCity());
						orderForm.setShipToCountry(order.getShipToCountry());
						orderForm.setShipToEmail(order.getShipToEmail());
						orderForm
								.setShipToFirstName(order.getShipToFirstName());
						orderForm.setShipToLastName(order.getShipToLastName());
						orderForm.setShipToPhone(order.getShipToPhone());
						orderForm.setShipToPostalCode(order
								.getShipToPostalCode());
						orderForm.setShipToProvince(order.getShipToProvince());

						orderForm.setId(order.getId());
						orderForm.setNote(order.getNote());
						orderForm.setNumber(order.getNumber());
						orderForm.setOrderDate(order.getOrderDate());
						orderForm.setOrderSubTotal(order.getOrderSubTotal());
						orderForm.setOrderTax(order.getOrderTax());
						orderForm.setOrderTotal(order.getOrderTotal());
						if (order.getStatus() != null)
							orderForm.setStatus(order.getStatus().getId()
									.toString());
						// if (order.getUser() != null)
						// orderForm.setUser(order.getUser().getUsername());

						List ods = manager.getObjects(OrderStatus.class);
						String[] strs = new String[ods.size()];
						for (int i = 0; i < ods.size(); i++) {
							OrderStatus s = (OrderStatus) ods.get(i);
							strs[i] = s.getId().toString();
						}
						orderForm.setOrderStatus(strs);
						request.setAttribute("orderStatus", ods);
					} catch (Exception e) {
						log.debug("*******loi copy********");
						e.printStackTrace();
					}
				}
				if ("request".equals(mapping.getScope())) {
					request.setAttribute(mapping.getAttribute(), orderForm);
				} else {
					request.getSession().setAttribute(mapping.getAttribute(),
							orderForm);
				}

				return mapping.findForward("edit");
			} catch (ObjectNotFoundException onfe) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.getObject.notfound", id));
				this.saveErrors(request, errors);
				return mapping.findForward("listdo");
			}
		} else {
			return new ActionForward("/common/404.jsp");
		}

	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		ActionMessages errors = new ActionMessages();
		OrderManager manager = (OrderManager) this.getBean("orderManager");
		OrderForm oForm = (OrderForm) form;
		Order order = new Order();
		try {
			order = (Order) manager.getObject(Order.class, oForm.getId());
			OrderStatus status = (OrderStatus) manager.getObject(
					OrderStatus.class, new Long(oForm.getStatus()));
			order.setStatus(status);
		} catch (Exception e) {
			e.printStackTrace();
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpected"));
			this.saveMessages(request, errors);
			return mapping.getInputForward();
		}

		try {
			manager.saveObject(order);
		} catch (DataAccessException daoE) {

			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.databaseaccess.failure"));
			this.saveErrors(request, errors);
			log.debug("Database access error");
			daoE.printStackTrace();
			return mapping.getInputForward();
		}

		return mapping.findForward("success");
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String keyword = request.getParameter("keyword");
		String OsId = request.getParameter("osId");
		String oldStatus = (String) request.getSession().getAttribute(
				"OldOrderStatusId");
		if (OsId == null)
			OsId = "";
		if (keyword == null)
			keyword = "";
		if (oldStatus == null)
			oldStatus = "";
		if (!oldStatus.equalsIgnoreCase(OsId)) {
			oldStatus = OsId;
			request.getSession().setAttribute("OldOrderStatusId", oldStatus);
		}
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		Date startDate = null;
		Date endDate = null;
		try {
			DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			startDate = f.parse(startDateStr);
			endDate = f.parse(endDateStr);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		OrderManager manager = (OrderManager) this.getBean("orderManager");
		Integer pageSize = 20;
		int pos = 0;
		String id = request.getParameter(new ParamEncoder("row")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE));
		if (StringUtils.isNotEmpty(id)) {
			System.out.println("ID page=" + id);
			pos = (Integer.valueOf(id) - 1) * pageSize;
		}
		List<org.hibernate.criterion.Order> listOrder = new ArrayList<org.hibernate.criterion.Order>();
		listOrder.add(org.hibernate.criterion.Order.asc("id"));
		listOrder.add(org.hibernate.criterion.Order.asc("orderDate"));
		List orders = manager.searchOrder(keyword, oldStatus, pos, pageSize,
				listOrder, startDate, endDate);
		Integer resultSize = manager.getNumberOrderSearch(keyword, oldStatus,
				startDate, endDate);
		request.setAttribute("resultSize", resultSize);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("orders", orders);
		List orderStatus = manager.getObjects(OrderStatus.class);
		request.getSession().setAttribute("orderStatus", orderStatus);

		return mapping.findForward("list");

	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderManager manager = (OrderManager) this.getBean("orderManager");
		String OsId = request.getParameter("osId");
		Integer pageSize = 20;
		int pos = 0;
		Integer resultSize = (int) manager.getNumberOrderByStatus(OsId);
		List<org.hibernate.criterion.Order> listOrder = new ArrayList<org.hibernate.criterion.Order>();
		listOrder.add(org.hibernate.criterion.Order.asc("id"));
		listOrder.add(org.hibernate.criterion.Order.asc("orderDate"));
		List orders = manager.getOrders(OsId, pos, pageSize, listOrder);
		String id = request.getParameter(new ParamEncoder("row")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE));
		if (StringUtils.isNotEmpty(id)) {
			System.out.println("ID page=" + id);
			pos = (Integer.valueOf(id) - 1) * pageSize;
		}

		request.setAttribute("resultSize", resultSize);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("orders", orders);
		List orderStatus = manager.getObjects(OrderStatus.class);
		request.getSession().setAttribute("orderStatus", orderStatus);
		return mapping.findForward("list");
	}

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		ActionMessages errors = new ActionMessages();
		OrderManager manager = (OrderManager) this.getBean("orderManager");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			try {
				Order order = (Order) manager.getObject(Order.class, new Long(
						id));

				List orderStatus = (List) request.getSession().getAttribute(
						"orderStatus");
				if (orderStatus == null)
					orderStatus = manager.getObjects(OrderStatus.class);
			//	Province Bp = new Province();
				//Province Sp = new Province();
				Country Bc = new Country();
				Country Sc = new Country();
				//ProvinceManager pm = (ProvinceManager) this
				//		.getBean("provinceManager");
				CountryManager cm = (CountryManager) this
						.getBean("countryManager");
				try {
					//Bp = pm.getProvinceByCode(order.getBillToProvince());
					//Sp = pm.getProvinceByCode(order.getShipToProvince());
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					Bc = cm.getCountryByCode2(order.getBillToCountry());
					Sc = cm.getCountryByCode2(order.getShipToCountry());
				} catch (Exception e) {
					e.printStackTrace();
				}
				//if (Bp != null) {
				//	request.setAttribute("BilltoProvince", Bp.getName());
				//} else {
				//	request.setAttribute("BilltoProvince", order
				//			.getBillToProvince());
				//}
				//if (Sp != null) {
					//request.setAttribute("ShiptoProvince", Sp.getName());
				//} else {
					//request.setAttribute("ShiptoProvince", order
					//		.getShipToProvince());
				//}
				if (Bc != null) {
					request.setAttribute("BilltoCountry", Bc.getName());
				} else {
					request.setAttribute("BilltoCountry", order
							.getBillToCountry());
				}
				if (Sc != null) {
					request.setAttribute("ShiptoCountry", Sc.getName());
				} else {
					request.setAttribute("ShiptoCountry", order
							.getShipToCountry());
				}
				request.getSession().setAttribute("orderStatus", orderStatus);
				request.getSession().setAttribute("order", order);
				request.getSession().setAttribute("orderItem",
						manager.getOrderItem(order));
				return mapping.findForward("view");
			} catch (ObjectNotFoundException onfe) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.getObject.notfound", id));
				this.saveErrors(request, errors);
				return mapping.findForward("listdo");
			}
		} else {
			return new ActionForward("/common/404.jsp");
		}

	}
}

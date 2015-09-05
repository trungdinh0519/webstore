package com.trung.goodstore.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import com.trung.goodstore.model.Country;
import com.trung.goodstore.model.Order;
import com.trung.goodstore.model.OrderStatus;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.CountryManager;
import com.trung.goodstore.service.OrderManager;

public class UserOrderAction extends BaseDispatchAction {
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
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
			//e.printStackTrace();
			log.error(e);
		}
		System.out.println("buoc 1");
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
		Integer resultSize = manager.getNumberOrderSearch2(keyword, auth
				.getName(), oldStatus, startDate, endDate);
		List orders = manager.searchOrder(keyword, auth.getName(), oldStatus,
				pos, pageSize, listOrder, startDate, endDate);
		
		// .getNumberOrderSearch(keyword,auth;
		System.out.println("so ket qua=" + resultSize);
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
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		// UserDetails userdetail = (UserDetails) auth.getDetails();
		System.out.println(auth.getName());
		OrderManager manager = (OrderManager) this.getBean("orderManager");
		String OsId = request.getParameter("osId");
		Integer pageSize = 20;
		int pos = 0;
		Integer resultSize = (int) manager.getNumberOrderByUser(auth.getName());
		System.out.println("so order=" + resultSize);
		List<org.hibernate.criterion.Order> listOrder = new ArrayList<org.hibernate.criterion.Order>();
		listOrder.add(org.hibernate.criterion.Order.asc("id"));
		listOrder.add(org.hibernate.criterion.Order.asc("orderDate"));
		List orders = manager.getOrders(auth.getName(), OsId, pos, pageSize,
				listOrder);
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
			//	Province Sp = new Province();
				Country Bc = new Country();
				Country Sc = new Country();
			//	ProvinceManager pm = (ProvinceManager) this
			//			.getBean("provinceManager");
				CountryManager cm = (CountryManager) this
						.getBean("countryManager");
				try {
				//	Bp = pm.getProvinceByCode(order.getBillToProvince());
				//	Sp = pm.getProvinceByCode(order.getShipToProvince());
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					Bc = cm.getCountryByCode2(order.getBillToCountry());
					Sc = cm.getCountryByCode2(order.getShipToCountry());
				} catch (Exception e) {
					e.printStackTrace();
				}
				/*if (Bp != null) {
					request.setAttribute("BilltoProvince", Bp.getName());
				} else {
					request.setAttribute("BilltoProvince", order
							.getBillToProvince());
				}
				if (Sp != null) {
					request.setAttribute("ShiptoProvince", Sp.getName());
				} else {
					request.setAttribute("ShiptoProvince", order
							.getShipToProvince());
				}*/
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

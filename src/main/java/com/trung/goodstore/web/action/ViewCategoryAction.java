package com.trung.goodstore.web.action;

import java.util.ArrayList;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.hibernate.criterion.Order;

import com.trung.goodstore.Constants;
import com.trung.goodstore.model.Category;

import com.trung.goodstore.service.Manager;
import com.trung.goodstore.service.ProductManager;
import com.trung.goodstore.util.ParamUrl;

public class ViewCategoryAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String keyword = request.getParameter("keyword");
		String cateId = request.getParameter("categoryId");
		String method = request.getParameter("method");
		/** get parameter list and set to returnUrl */
		// Map paramsMap = request.getParameterMap();
		ArrayList<ParamUrl> params = new ArrayList<ParamUrl>();
		for (Enumeration pname = request.getParameterNames(); pname
				.hasMoreElements();) {
			String name = (String) pname.nextElement();
			String value = request.getParameter(name);
			params.add(new ParamUrl(name, value));
		}
		request.getSession().setAttribute(Constants.PARAMCONTINUESHOPS, params);

		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.asc("name"));
		ProductManager pmrg = (ProductManager) this.getBean("productManager");
		Integer pageSize = 10;
		int pos = 0;
		String id = request.getParameter(new ParamEncoder("row")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE));
		if (StringUtils.isNotEmpty(id)) {
			System.out.println("ID page=" + id);
			pos = (Integer.valueOf(id) - 1) * pageSize;
		}
		List products = new ArrayList();
		Integer resultSize = 0;
		if (StringUtils.equals(method, "search")) {
			products = pmrg.search2(keyword, cateId, pos, pageSize);
			resultSize = pmrg.getTotalSearch2(keyword, cateId);
		} else {
			if (StringUtils.isNotEmpty(cateId)) {
				if (StringUtils.equals(cateId, "all")) {
					products = pmrg.getProduct2(pos, pageSize);
					resultSize = (int) pmrg.getNumberProduct2();
				} else {
					Category category = (Category) pmrg.getObject(
							Category.class, new Long(cateId));
					products = pmrg.getProductByCatalog2(category, pos,
							pageSize, orders);
					resultSize = (int) pmrg
							.getNumberProductByCatalog2(category);
				}
			} else {
				products = pmrg.getProduct2(pos, pageSize);
				resultSize = (int) pmrg.getNumberProduct2();
			}
		}
		request.setAttribute("resultSize", resultSize);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("products", products);
		if (request.getSession().getAttribute("categories") == null) {
			List categories = pmrg.getCategorys();
			request.getSession().setAttribute("categories", categories);
		}
		return mapping.findForward("success");
	}

}

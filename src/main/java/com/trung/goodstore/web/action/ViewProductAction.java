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
import org.hibernate.ObjectNotFoundException;

import com.trung.goodstore.Constants;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.persistence.exception.DaoException;
import com.trung.goodstore.service.Config;
import com.trung.goodstore.service.PCommentManager;
import com.trung.goodstore.service.ProductManager;
import com.trung.goodstore.util.ParamUrl;

public class ViewProductAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String id = request.getParameter("productId");
		ProductManager manager = (ProductManager) this
				.getBean("productManager");
		PCommentManager pcManager = (PCommentManager) this.getBean("pcManager");
		ActionMessages errors = new ActionMessages();
		HttpSession session = request.getSession();
		Config config = (Config) this.getBean("config");
		session.setAttribute("environment", config.getInfo().getProperty(
				"Environment"));
		session.setAttribute("SandboxEndpoint", config.getInfo().getProperty(
				"SandboxEndpoint"));
		session.setAttribute("LiveEndpoint", config.getInfo().getProperty(
				"LiveEndpoint"));
		session.setAttribute("business_email", config.getInfo().getProperty(
				"business_email"));
		String path = request.getContextPath();
		System.out.println("[*******]path=" + path);

		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		System.out.println("[*******]basepath=" + basePath);
		session.setAttribute("returnURL", basePath + "/pages/completeOrder.do");
		session.setAttribute("cancel_returnURL", basePath + "/pages/home.do");
		session
				.setAttribute("notify_url", basePath
						+ "/pages/completeOrder.do");

		ArrayList<ParamUrl> params = (ArrayList<ParamUrl>) session
				.getAttribute(Constants.PARAMCONTINUESHOPS);
		String returnUrl = (String) session.getAttribute("returnShopUrl");
		try {
			System.out.println("*********");
			List comments = pcManager.getComments(id);
			session.setAttribute("comments", comments);
			System.out.println("********* c.size="+comments.size());
			Product p = manager.getProduct(id);
			System.out.println("*********");
			if (p != null) {
				session.setAttribute("product", p);
				return mapping.findForward("success");
			} else {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.product.Notfound", p.getName()));
				saveErrors(request, errors);
				if (!returnUrl.equals("")) {
					for (int i = 0; i < params.size(); i++) {
						ParamUrl param = params.get(i);
						if (i == 0)
							returnUrl += "?" + param.getName() + "="
									+ param.getValue();
						else
							returnUrl += "&" + param.getName() + "="
									+ param.getValue();
					}
					ActionForward fw = new ActionForward();
					fw.setPath(returnUrl);
					fw.setRedirect(true);
					return fw;
				}
			}
			
		} catch (ObjectNotFoundException onfe) {
			onfe.printStackTrace();
		} catch (DaoException daoE) {
			daoE.printStackTrace();
		} catch (Exception e) {

		}
		return mapping.findForward("failure");
	}

}

package com.trung.goodstore.web.action;

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

import com.trung.goodstore.model.Product;
import com.trung.goodstore.model.ProductComment;
import com.trung.goodstore.model.User;
import com.trung.goodstore.service.PCommentManager;
import com.trung.goodstore.service.ProductManager;
import com.trung.goodstore.service.UserManager;

public class CommentAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String comment = request.getParameter("comment");
		String productId = request.getParameter("productId");
		if (comment == null || comment.length() < 10) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"Lời bình quá ngắn"));
			request.setAttribute("error_val","Lời bình quá ngắn");
			return mapping.getInputForward();
		}else request.getSession().setAttribute("error_val","");
		if (StringUtils.isEmpty(productId) || !StringUtils.isNumeric(productId))
			return mapping.getInputForward();
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserManager manager = (UserManager) this.getBean("userManager");
		PCommentManager pcmanager = (PCommentManager) this.getBean("pcManager");
		ProductManager pmanager = (ProductManager) this
				.getBean("productManager");
		Product product = pmanager.getProduct(productId);
		ProductComment pcomment = new ProductComment();
		try {
			User user = manager.getUser(auth.getName());
			System.out.println("get user complete");
			pcomment.setContent(comment);
			pcomment.setName(user.getUsername());
			pcomment.setEmail(user.getEmail());
			pcomment.setProduct(product);
			System.out.println("set comment complete");
			pcmanager.saveObject(pcomment);
			System.out.println("save comment complete");
			List comments = pcmanager.getComments(productId);
			if (comments != null) {
				request.getSession().setAttribute("comments", comments);
			}
		} catch (Exception e) {
			log.error("loi truy cap database");
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"loi truy cap database"));
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

}

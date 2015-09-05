package com.trung.goodstore.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.trung.goodstore.model.ProductComment;
import com.trung.goodstore.service.Manager;
import com.trung.goodstore.service.PCommentManager;

public class DelCommentAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		String pid=request.getParameter("pid");
		PCommentManager pcmanager = (PCommentManager) this.getBean("pcManager");
		if (id != null && StringUtils.isNumeric(id)) {
			Manager mgr = (Manager) this.getBean("manager");
			try {
				mgr.removeObject(ProductComment.class, new Long(id));
				List comments = pcmanager.getComments(pid);
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
		}
		return mapping.findForward("success");
	}

}

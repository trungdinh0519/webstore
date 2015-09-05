package com.trung.goodstore.web.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.trung.goodstore.Constants;
import com.trung.goodstore.util.ParamUrl;

public class ContinueShoppingAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ActionMessages errors = new ActionMessages();
		HttpSession session = request.getSession();
		System.out
				.println("**************[ContinueShop]*******************bat dau");
		try {
			ArrayList<ParamUrl> params = (ArrayList<ParamUrl>) session
					.getAttribute(Constants.PARAMCONTINUESHOPS);
			String returnUrl = (String) session.getAttribute("returnShopUrl");
			if (returnUrl == null)
				returnUrl = "/pages/home.do";
			System.out.println("[ContinueShopUrl]=" + returnUrl);
			if (params != null)
				for (int i = 0; i < params.size(); i++) {
					ParamUrl param = params.get(i);
					if (i == 0)
						returnUrl += "?" + param.getName() + "="
								+ param.getValue();
					else
						returnUrl += "&" + param.getName() + "="
								+ param.getValue();
				}
			System.out.println("[ContinueShopUrl]=" + returnUrl);
			System.out
					.println("**************[ContinueShop]*******************moc1");
			ActionForward fw = new ActionForward();
			fw.setPath(returnUrl);
			fw.setRedirect(true);
			return fw;
		} catch (Exception t) {
			log.error(t);
			t.printStackTrace();
			// errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
			// "error.unexpected"));
		}
		System.out
				.println("**************[ContinueShop]*******************moc2");
		// saveErrors(request, errors);
		ActionForward forward = mapping.findForward("home");

		System.out
				.println("**************[ContinueShop]*******************moc3");
		return forward;
	}

}

package com.trung.goodstore.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BaseAction extends Action {
	protected Log log = LogFactory.getLog(this.getClass());

	protected ApplicationContext ctx;
	public ApplicationContext getApplicationContext() {
		if(ctx==null)
			ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
		
		return ctx;
	}
	public Object getBean(String name){
		if(ctx==null)
		ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
		return ctx.getBean(name);
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.execute(mapping, form, request,response);
	}
	
}

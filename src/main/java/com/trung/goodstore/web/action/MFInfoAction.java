package com.trung.goodstore.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.trung.goodstore.model.Manufacturer;
import com.trung.goodstore.service.ProductManager;

public class MFInfoAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductManager manager=(ProductManager)this.getBean("productManager");
		String id=request.getParameter("id");
		try{
		Manufacturer mf=(Manufacturer)manager.getObject(Manufacturer.class, new Long(id));
		request.setAttribute("manufacturer",mf);
		}catch(Exception e){
			log.error(e);
		}
		return mapping.findForward("success");
	}

}

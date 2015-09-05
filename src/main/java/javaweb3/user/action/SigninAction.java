package javaweb3.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javaweb3.action.BaseAction;
import javaweb3.user.bo.UserBo;

public class SigninAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("signin action process ");
		
		UserBo userBo = (UserBo) getWebApplicationContext().getBean("userBo");

		//CustomerForm customerForm = (CustomerForm) form;
		//Customer customer = new Customer();

		
		// copy customerform to model
		//BeanUtils.copyProperties(customer, customerForm);

		// save it
		//customerBo.addCustomer(customer);

		return mapping.findForward("success");

	}
}

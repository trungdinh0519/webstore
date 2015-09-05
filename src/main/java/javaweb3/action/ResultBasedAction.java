/**
 * 
 */
package javaweb3.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.sql.Result;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

/**
 * @author admin
 *
 */
@SuppressWarnings("deprecation")
public abstract class ResultBasedAction extends ActionSupport {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IResult result = (IResult) execute(mapping, form, request);
		if (result == null) {
			throw new Exception("Result expected.");
		}

		result.applyResult(request, response);
		// Finally, we don't want Struts to execute the forward
		return null;
	}

	public abstract Result execute(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception;
}
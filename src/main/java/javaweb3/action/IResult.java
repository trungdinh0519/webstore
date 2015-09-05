package javaweb3.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IResult {
	public void applyResult(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

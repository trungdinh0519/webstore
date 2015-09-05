package javaweb3.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public class JsonResult implements IResult {
	private JSONObject json;

	public JsonResult(JSONObject json) {
		this.json = json;
	}

	public void applyResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Type", "application/json");
		response.getOutputStream().write(json.toString().getBytes("UTF-8"));
		response.getOutputStream().flush();
	}

}

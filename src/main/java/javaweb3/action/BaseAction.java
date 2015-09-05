package javaweb3.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.struts.ActionSupport;

@SuppressWarnings("deprecation")
public class BaseAction extends ActionSupport {
	protected Logger logger = LoggerFactory.getLogger(getClass());
}

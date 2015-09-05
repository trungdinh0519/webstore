package com.trung.goodstore.web.action;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.ProviderManager;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.mail.SimpleMailMessage;

import com.trung.goodstore.Constants;
import com.trung.goodstore.model.Country;
import com.trung.goodstore.model.Role;
import com.trung.goodstore.model.User;
import com.trung.goodstore.persistence.exception.AccountNotFoundException;
import com.trung.goodstore.persistence.exception.DaoException;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.CountryManager;
import com.trung.goodstore.service.RoleManager;
import com.trung.goodstore.service.UserManager;
import com.trung.goodstore.service.util.MailEngine;
import com.trung.goodstore.util.SpringUtil;
import com.trung.goodstore.util.StringUtil;
import com.trung.goodstore.web.form.LossPassForm;
import com.trung.goodstore.web.form.PassForm;
import com.trung.goodstore.web.form.UserForm;

public class UserAction extends BaseDispatchAction {

	public ActionForward registry(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String url = (String) request.getAttribute("returnUrl");
		String c_code = request.getParameter("c_code");
		if (!StringUtils.isEmpty(c_code)) {
			setProvincesToSession(c_code, request);
			if (url != null) {
				request.setAttribute("returnUrl", url);
			}
			return mapping.findForward("success");
		}
		HttpSession session = request.getSession();
		if (session.getAttribute("countries") == null) {
			CountryManager countryManager = (CountryManager) this
					.getBean("countryManager");
			List countries = (List) countryManager.getCountries();
			Hashtable<String, Country> map_countries = new Hashtable<String, Country>();
			for (int i = 0; i < countries.size(); i++) {
				Country ct = (Country) countries.get(i);
				map_countries.put(ct.getCode2(), ct);
			}

			session.setAttribute("countries", countries);
			session.setAttribute("map_countries", map_countries);
		}
		if (url != null) {
			request.setAttribute("returnUrl", url);
		}
		return mapping.findForward("success");
	}

	public ActionForward upPf(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		UserManager manager = (UserManager) this.getBean("userManager");
		UserForm uform = (UserForm) form;
		User user = (User) manager.getObject(User.class, uform.getUsername());
		this.copyFormTo(uform, user);
		try {
			manager.saveObject(user);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", uform.getUsername()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database "
					+ uform.getUsername());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");

	}

	public ActionForward uppass(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserManager manager = (UserManager) this.getBean("userManager");
		PassForm uform = (PassForm) form;
		User user = (User) manager.getObject(User.class, auth.getName());
		if (!StringUtils.equals(StringUtil.encodePassword(uform.getOlePass(),
				"SHA"), user.getPassword())) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.uppass.getuser.failure", auth.getName()));
			this.saveErrors(request, errors);
			return mapping.getInputForward();
		}
		user.setPassword(StringUtil.encodePassword(uform.getNewPass(), "SHA"));
		user.setConfirmPassword(StringUtil.encodePassword(uform.getCfPass(),
				"SHA"));
		try {
			manager.saveObject(user);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", auth.getName()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database "
					+ uform.getUsername());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");

	}

	public ActionForward losspass(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionMessages errors = new ActionMessages();
		ActionMessages mesages = new ActionMessages();
		String email = ((LossPassForm) form).getEmail();
		String username = ((LossPassForm) form).getUsername();
		UserManager mg = (UserManager) this.getBean("userManager");
		User user;
		try {
			user = (User) mg.loadAccountByname(username);
		} catch (AccountNotFoundException e) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.user.notFound"));
			this.saveMessages(request, errors);
			return mapping.getInputForward();
		}
		if (!user.getEmail().equals(email)) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.email.unmatch"));
			this.saveMessages(request, errors);
			return mapping.getInputForward();
		}
		long x = (long) (1000000 * Math.random());
		if (x < 100000)
			x += 100000;
		user.setPassword(StringUtil.encodePassword(String.valueOf(x), "SHA"));
		Map config = (Map) servlet.getServletContext().getAttribute(
				Constants.CONFIG);
			SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom((String) config.get(Constants.admin_email));
		msg.setSubject("lost password");
		msg.setTo(email);
		Map model = new HashMap();
		model.put("pass", String.valueOf(x));
		model.put("url", (String) config.get(Constants.web_url));
		MailEngine mailEngine = (MailEngine) this.getBean("mailEngine");
		if (mailEngine != null) {
			try {
				mailEngine.send(msg, "maillosspass.vm", model);
				mg.saveObject(user);
				mesages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"Ban hay kiem tra lai email de nhan mat khau moi"));
				this.saveMessages(request, mesages);
			} catch (DaoException de) {
				if (log.isErrorEnabled()) {
					log.error("Can't save user..." + user);
				}
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.saveuser.failure", user.getUsername(), de));
				this.saveErrors(request, errors);
				return mapping.getInputForward();
			}
			catch (Exception e) {
				log.error(e);
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"Thay doi that bai"));
				this.saveErrors(request, errors);
				return mapping.getInputForward();
			}
		}

		return mapping.findForward("success");
	}

	public ActionForward signup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (this.isCancelled(request)) {
			log.warn("Cancel is pressed!");
			return mapping.findForward("cancel");
		}
		ActionMessages errors = new ActionMessages();
		User user = new User();
		this.copyFormTo((UserForm) form, user);
		UserManager mgr = (UserManager) this.getBean("userManager");
		RoleManager roleMgr = (RoleManager) this.getBean("roleManager");
		if (log.isDebugEnabled()) {
			log.debug("registering user...");
		}
		if (mgr.isExists(user.getUsername())) {
			log.error(user.getUsername() + " Da ton tai...");
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.nameExisted", user.getUsername()));
			this.saveErrors(request, errors);
			return mapping.findForward("failure");
		}
		if (mgr.isEmailExists(user.getEmail())) {
			log.error("Email " + user.getEmail() + " Da ton tai...");
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.email.Existed", user.getEmail()));
			this.saveErrors(request, errors);
			return mapping.findForward("failure");
		}
		//
		user.addRole(roleMgr.getRole(Constants.USER_ROLE));
		if (log.isDebugEnabled()) {
			log.debug("User adding Role...");
		}

		try {
			mgr.saveObject(user);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Can't save user..." + user);
			}
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.saveuser.failure", user.getUsername(), e));
			this.saveErrors(request, errors);
			return mapping.findForward("failure");
		}
		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"user.registered", user.getUsername()));
		request.getSession().setAttribute(Constants.REGISTERED, Boolean.TRUE);
		Authentication auth = new UsernamePasswordAuthenticationToken(user
				.getUsername(), ((UserForm) form).getConfirmPassword());
		try {
			ProviderManager authenticationManager = (ProviderManager) getBean("authenticationManager");
			SecurityContextHolder.getContext().setAuthentication(
					authenticationManager.doAuthentication(auth));
		} catch (org.springframework.beans.factory.NoSuchBeanDefinitionException n) {
		}
		/* gui mail thong bao */
		Map config = (Map) servlet.getServletContext().getAttribute(
				Constants.CONFIG);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom((String) config.get(Constants.admin_email));
		msg.setSubject("Registration at ["
				+ (String) config.get(Constants.app_name) + "]");
		msg.setTo(user.getEmail());
		Map model = new HashMap();
		model.put("user", user);
		model.put("password", ((UserForm) form).getPassword());
		model.put("url", (String) config.get(Constants.web_url));
		MailEngine mailEngine = (MailEngine) this.getBean("mailEngine");
		mailEngine.send(msg, "mailRegistered.vm", model);
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"mail.comfirm"));
		this.saveMessages(request.getSession(), messages);
		/**/
		String url = (String) request.getAttribute("returnUrl");
		if (url != null) {
			return new ActionForward(url);
		} else
			return mapping.findForward("success");
	}

	private void copyFormTo(UserForm form, User user) {
		user.setUsername(form.getUsername());// form.

		if (StringUtils.isNotEmpty(form.getPassword()))
			user.setPassword(StringUtil.encodePassword(form.getPassword(),
					"SHA"));
		if (StringUtils.isNotEmpty(form.getConfirmPassword()))
			user.setConfirmPassword(StringUtil.encodePassword(form
					.getConfirmPassword(), "SHA"));

		user.setAddress(form.getAddress());
		user.setEmail(form.getEmail());
		user.setPhone(form.getPhone());
		user.setFirstName(form.getFirstname());
		user.setLastName(form.getLastname());
		user.setWebsite(form.getWebsite());
		user.setVersion(form.getVersion());
		user.setCredentialsExpired(false);
		user.setEnabled(true);
		user.setAccountLocked(false);
		user.setAccountExpired(false);
	}

	private void copyUserTo(User user, UserForm form) {
		form.setAccountExpired(user.isAccountExpired());
		form.setAccountLocked(user.isAccountLocked());
		if (user.getAddress() != null)
			form.setAddress(user.getAddress());
		form.setCredentialsExpired(user.isCredentialsExpired());
		form.setEmail(user.getEmail());
		form.setEnabled(user.isEnabled());
		form.setFirstname(user.getFirstName());
		form.setLastname(user.getLastName());
		form.setPhone(user.getPhone());
		form.setUsername(user.getUsername());
		// System.out.println("#####website:"+user.getWebsite());
		form.setWebsite(user.getWebsite());
		String[] rstr = new String[user.getRoles().size()];
		int i = 0;
		for (Iterator ite = user.getRoles().iterator(); ite.hasNext();) {
			Role r = (Role) ite.next();
			rstr[i] = r.getId().toString();
			i++;
		}
		form.setRoles(rstr);
	}

	private void setProvincesToSession(String c_code, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Hashtable<String, Country> map = (Hashtable<String, Country>) session
				.getAttribute("map_countries");
		Country country = map.get(c_code);
		//ProvinceManager pm = (ProvinceManager) SpringUtil
		//		.getBean("provinceManager");
		//List<Province> rgs = pm.getProvinceByCountry(country);
		//session.setAttribute("provinces", rgs);
	}

	public ActionForward addnew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserManager manager = (UserManager) this.getBean("userManager");
		String c_code = request.getParameter("c_code");
		HttpSession session = request.getSession();
		if (session.getAttribute("countries") == null) {
			List countries = (List) manager.getObjects(Country.class);
			Hashtable<String, Country> map_countries = new Hashtable<String, Country>();
			for (int i = 0; i < countries.size(); i++) {
				Country ct = (Country) countries.get(i);
				map_countries.put(ct.getCode2(), ct);
			}
			session.setAttribute("countries", countries);
			session.setAttribute("map_countries", map_countries);
		}
		if (!StringUtils.isEmpty(c_code)) {
			setProvincesToSession(c_code, request);
			return mapping.findForward("new");
		}
		List roles = manager.getObjects(Role.class);
		request.getSession().setAttribute("roles", roles);
		return mapping.findForward("new");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserManager manager = (UserManager) this.getBean("userManager");
		String id = request.getParameter("id");
		try {
			manager.removeObject(User.class, id);
		} catch (ObjectNotFoundException onfe) {
			onfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			return new ActionForward("/common/403.jsp");
		}
		return mapping.findForward("listdo");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		UserManager manager = (UserManager) this.getBean("userManager");
		User user = new User();
		UserForm uform = (UserForm) form;
		this.copyFormTo(uform, user);
		String[] roles = uform.getRoles();
		for (int i = 0; i < roles.length; i++) {
			try {
				if (StringUtils.isNotEmpty(roles[i])) {
					Role r = (Role) manager.getObject(Role.class, new Long(
							roles[i]));
					if (r != null)
						user.getRoles().add(r);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			manager.saveObject(user);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", uform.getUsername()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database "
					+ uform.getUsername());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserManager manager = (UserManager) this.getBean("userManager");
		List roles = manager.getObjects(Role.class);
		request.getSession().setAttribute("roles", roles);
		String id = request.getParameter("id");
		String c_code = request.getParameter("c_code");
		HttpSession session = request.getSession();
		if (session.getAttribute("countries") == null) {
			CountryManager countryManager = (CountryManager) this
					.getBean("countryManager");
			List countries = (List) countryManager.getCountries();
			Hashtable<String, Country> map_countries = new Hashtable<String, Country>();
			for (int i = 0; i < countries.size(); i++) {
				Country ct = (Country) countries.get(i);
				map_countries.put(ct.getCode2(), ct);
			}
			session.setAttribute("countries", countries);
			session.setAttribute("map_countries", map_countries);
		}
		if (!StringUtils.isEmpty(c_code)) {
			setProvincesToSession(c_code, request);
			return mapping.findForward("edit");
		}
		if (StringUtils.isNotEmpty(id)) {
			try {
				User user = (User) manager.getObject(User.class, id);
				UserForm uform = new UserForm();
				if (user != null) {
					this.copyUserTo(user, uform);
				}
				if ("request".equals(mapping.getScope())) {
					request.setAttribute(mapping.getAttribute(), uform);
				} else {
					request.getSession().setAttribute(mapping.getAttribute(),
							uform);
				}
				return mapping.findForward("edit");
			} catch (ObjectNotFoundException onfe) {
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.getObject.notfound", id));
				this.saveErrors(request, errors);
				return mapping.findForward("failure");
			}
		} else {
			return new ActionForward("/common/403.jsp");
		}

	}

	public ActionForward privileges(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserManager manager = (UserManager) this.getBean("userManager");
		List roles = manager.getObjects(Role.class);
		request.getSession().setAttribute("roles", roles);
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			try {
				User user = (User) manager.getObject(User.class, id);
				UserForm uform = new UserForm();
				if (user != null) {
					this.copyUserTo(user, uform);
				}
				if ("request".equals(mapping.getScope())) {
					request.setAttribute("userG", uform);
				} else {
					request.getSession().setAttribute("userG", uform);
				}
				return mapping.findForward("grant");
			} catch (ObjectNotFoundException onfe) {
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.getObject.notfound", id));
				this.saveErrors(request, errors);
				return mapping.findForward("failure");
			}
		} else {
			return new ActionForward("/common/403.jsp");
		}

	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		UserManager manager = (UserManager) this.getBean("userManager");
		UserForm uform = (UserForm) form;
		User user = (User) manager.getObject(User.class, uform.getUsername());
		this.copyFormTo(uform, user);
		String[] roles = uform.getRoles();
		user.getRoles().clear();
		for (int i = 0; i < roles.length; i++) {
			try {
				if (StringUtils.isNotEmpty(roles[i])) {
					Role r = (Role) manager.getObject(Role.class, new Long(
							roles[i]));
					if (r != null)
						user.getRoles().add(r);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			manager.saveObject(user);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", uform.getUsername()));
			this.saveErrors(request, errors);
			log.debug("[Goodstore] loi truy cap database "
					+ uform.getUsername());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");

	}

	public ActionForward grant(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		UserManager manager = (UserManager) this.getBean("userManager");
		UserForm uform = (UserForm) form;
		User user = (User) manager.getObject(User.class, uform.getUsername());
		// this.copyFormTo(uform, user);
		user.setAccountExpired(uform.isAccountExpired());
		user.setAccountLocked(uform.isAccountLocked());
		user.setCredentialsExpired(uform.isCredentialsExpired());
		user.setEnabled(uform.isEnabled());
		String[] roles = uform.getRoles();
		user.getRoles().clear();
		for (int i = 0; i < roles.length; i++) {
			try {
				if (StringUtils.isNotEmpty(roles[i])) {
					Role r = (Role) manager.getObject(Role.class, new Long(
							roles[i]));
					if (r != null)
						user.getRoles().add(r);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			manager.saveObject(user);
		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.save.failure", uform.getUsername()));
			this.saveErrors(request, errors);
			log.debug("loi truy cap database " + uform.getUsername());
			e.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");

	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserManager manager = (UserManager) this.getBean("userManager");
		Integer resultSize = manager.getNumberUser().intValue();
		Integer pageSize = 30;
		int pos = 0;
		String id = request.getParameter(new ParamEncoder("row")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE));
		if (StringUtils.isNotEmpty(id)) {
			pos = (Integer.valueOf(id) - 1) * pageSize;
		}
		List<User> users = manager.getUsers(pos, pageSize);
		request.setAttribute("resultSize", resultSize);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("users", users);
		return mapping.findForward("list");
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String keyword = request.getParameter("keyword");
		UserManager manager = (UserManager) this.getBean("userManager");
		Integer pageSize = 30;
		int pos = 0;
		String id = request.getParameter(new ParamEncoder("row")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE));
		if (StringUtils.isNotEmpty(id)) {
			pos = (Integer.valueOf(id) - 1) * pageSize;
		}
		List<User> users = manager.search(keyword, pos, pageSize);
		Integer resultSize = manager.getTotalSearch(keyword);
		request.setAttribute("resultSize", resultSize);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("users", users);
		return mapping.findForward("list");
	}
}

package com.trung.goodstore.web.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.ProviderManager;
import org.acegisecurity.providers.encoding.Md5PasswordEncoder;
import org.acegisecurity.providers.rememberme.RememberMeAuthenticationProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.trung.goodstore.Constants;
import com.trung.goodstore.service.Config;
import com.trung.goodstore.service.LookupManager;

public class StartupListener extends ContextLoaderListener implements
		ServletContextListener {

	private static final Log log = LogFactory.getLog(StartupListener.class);

	public void contextInitialized(ServletContextEvent event) {
		if (log.isDebugEnabled()) {
			log.debug("initializing context...");
		}
		super.contextInitialized(event);
		ServletContext context = event.getServletContext();
		Map config = (HashMap) context.getAttribute(Constants.CONFIG);
		if (config == null) {
			config = new HashMap();
		}
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		boolean encryptPassword = false;
		try {
			ProviderManager provider = (ProviderManager) ctx
					.getBean("authenticationManager");
			for (Iterator it = provider.getProviders().iterator(); it.hasNext();) {
				AuthenticationProvider p = (AuthenticationProvider) it.next();
				if (p instanceof RememberMeAuthenticationProvider) {
					config.put("rememberMeEnabled", Boolean.TRUE);
				}
			}
			if (ctx.containsBean("passwordEncoder")) {
				encryptPassword = true;
				config.put(Constants.ENCRYPT_PASSWORD, Boolean.TRUE);
				String algorithm = "SHA";
				if (ctx.getBean("passwordEncoder") instanceof Md5PasswordEncoder) {
					algorithm = "MD5";
				}
				config.put(Constants.ENC_ALGORITHM, algorithm);
			}
		} catch (NoSuchBeanDefinitionException n) {
			// ignore, should only happen when testing
		}
		config.put(Constants.app_name, "JShopExample");
		config.put(Constants.admin_email, "trung@localhost");
		config.put(Constants.web_url, "www.jshop.com.vn");
		context.setAttribute(Constants.CONFIG, config);

		// output the retrieved values for the Init and Context Parameters
		if (log.isDebugEnabled()) {
			log
					.debug("Remember Me Enabled? "
							+ config.get("rememberMeEnabled"));
			log.debug("Encrypt Passwords? " + encryptPassword);
			if (encryptPassword) {
				log.debug("Encryption Algorithm: "
						+ config.get(Constants.ENC_ALGORITHM));
			}
			log.debug("Populating drop-downs...");
		}

		setupContext(context);
		settupConfig(context);
		Constants constants = new Constants();
		context.setAttribute("Constants", constants);
	}

	public static void setupContext(ServletContext context) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		LookupManager mgr = (LookupManager) ctx.getBean("lookupManager");
		// get list of possible roles
		context.setAttribute(Constants.AVAILABLE_ROLES, mgr.getAllRoles());
		if (log.isDebugEnabled()) {
			log.debug("Drop-down initialization complete [OK]");
		}
	}

	public static void settupConfig(ServletContext context) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		Config config = (Config) ctx.getBean("config");

		config.load();
		context.setAttribute("business_email", config.getInfo().getProperty(
				"business_email"));
		String endpoint = "";
		//if (config.getInfo().getProperty("Environment").equals("sandbox"))
		//	endpoint = config.getInfo().getProperty("SandboxEndpoint");
		//else endpoint = config.getInfo().getProperty("LiveEndpoint");
		
		context.setAttribute("paygate_endpoint", endpoint);
	}
}

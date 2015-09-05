package com.trung.goodstore.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ConfigFilter implements javax.servlet.Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			chain.doFilter(request,response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}

package com.maxegg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UTF8Filter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		String encoding = "UTF-8";
		servletRequest.setCharacterEncoding(encoding);
		servletResponse.setCharacterEncoding(encoding);
//		
//		HttpServletResponse response = (HttpServletResponse)servletResponse;		
//		ServletResponseWrapper wrapper=new ServletResponseWrapper(response);
//
//		System.out.println("status = " + status);
		
		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

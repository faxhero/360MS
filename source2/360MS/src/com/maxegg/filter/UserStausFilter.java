package com.maxegg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class UserStausFilter implements Filter {

	private HttpServletRequest request;
    private HttpServletResponse response;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		request = (HttpServletRequest)servletRequest;
		response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();
		String userStaus = (String)session.getAttribute("userStaus");
		if(userStaus==null||!userStaus.equals("active")){
			response.sendRedirect("/login.jsp");
		}else{
			chain.doFilter(request, response);
		}
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

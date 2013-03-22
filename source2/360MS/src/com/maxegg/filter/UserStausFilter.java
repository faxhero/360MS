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
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();		
		String userStaus = (String)session.getAttribute("userStaus");
		String url = request.getRequestURL().toString();
		System.out.println(123123);		
		if(!url.contains("/html/common")
			 &&(userStaus==null||!userStaus.equals("active"))
			&&!url.contains("login.do")){			
			response.sendRedirect(request.getContextPath()+"/html/common/login.jsp");
		}else{
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

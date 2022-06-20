package org.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckUserExistFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if(((HttpServletRequest)request).getSession().getAttribute("Login") == null) {
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/login.jsp");
			System.out.println("CheckUserExistFilter:拦截到试图非登录操作！");
			return;
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != "" && password != ""){
			
//			System.out.println("CheckUserExistFilter:login完整，放行");
			chain.doFilter(request, response);
		}else {
			System.out.println("CheckUserExistFilter:无完整login,已拦截！");
			request.setAttribute("msg", "loginError");
			request.getRequestDispatcher(((HttpServletRequest)request).getContextPath() + "/login.jsp").forward(request, response);
			return;
		}
	}

	@Override
	public void destroy() {
		
	}

}

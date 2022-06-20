package org.blog.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.blog.entity.Picture;

public class CheckPictureExistFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("CheckPictureExistFilter:拦截request");
		
		List<Picture> pictures = (List<Picture>)((HttpServletRequest)request).getSession().getAttribute("Picture");
		
		
		if(pictures == null) {
			request.getRequestDispatcher(((HttpServletRequest)request).getContextPath() + "/Servlet/DownloadServlet");
			System.out.println(((HttpServletRequest)request).getContextPath());
			System.out.println("CheckPictureExistFilter:拦截到不存在用户数据库传来的图片");
			return;
		}
		
		System.out.println(pictures);
		
		System.out.println("CheckPictureExistFilter:对picturemanager.jsp放行");
		
		chain.doFilter(request, response);
		
	}
	
	@Override
	public void destroy() {
	
	}


	
}

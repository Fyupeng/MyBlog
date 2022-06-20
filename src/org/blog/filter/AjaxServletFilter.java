package org.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class AjaxServletFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 HttpServletResponse  httpServletResponse = (HttpServletResponse) response;
         httpServletResponse.setHeader( "Access-Control-Allow-Origin" ,  "*" );
         httpServletResponse.setHeader( "Access-Control-Allow-Headers" ,  "accept,content-type" ); 
         httpServletResponse.setHeader( "Access-Control-Allow-Methods" ,  "OPTIONS,GET,POST,DELETE,PUT" ); 
        
         System.out.println("AjaxServletFilter:过滤");
         
         chain.doFilter(request, httpServletResponse); 
		
	}

}

package org.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.blog.Util.UserUtil;
import org.blog.entity.Login;

public class CheckRegisterFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String username = request.getParameter("register_username");
		String password1 = request.getParameter("register_password1");
		String password2 = request.getParameter("register_password2");
		String nickname = request.getParameter("register_nickname");
		String motto = request.getParameter("register_motto");
		
		
		if(username == "" || password1 == "" || password2 == "" || nickname == "" || motto == "") {
//			chain.doFilter(request, response);
			request.setAttribute("msg", "error:exist_information_is_empty");//error1：输入了无效值或无输入
			
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
			
		}else if(!password1.equals(password2)){
			
			request.setAttribute("msg", "error:the_two_passwords_are_inconsistent");//error2：输入两次密码不一致
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
			return;
		
		}else if(username != ""){
			
			UserUtil userUtil = new UserUtil();
			
			boolean result = userUtil.queryUserIsExistByUsername(username);
			
			if(result) {
				request.setAttribute("msg", "error:user_has_register");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
		}	
		
			request.setAttribute("msg", "success");//success:检验通过
			chain.doFilter(request, response);
			
	}

	@Override
	public void destroy() {
		
	}

}

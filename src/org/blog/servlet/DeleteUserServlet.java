package org.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.UserUtil;

/**
 * Servlet implementation class DeleUserServlet
 */
@WebServlet("/Servlet/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	public static UserUtil userUtil = new UserUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		userUtil.deleteUserByUserid(userid);
		
		response.sendRedirect(request.getContextPath() + "/Servlet/QueryAllUserInfoServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package org.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.RemarkUtil;
import org.blog.entity.Login;
import org.blog.entity.Remark;
import org.blog.entity.UserInfo;


/**
 * Servlet implementation class QueryAllRemarksServlet
 */
@WebServlet("/Servlet/QueryAllRemarksServlet")
public class QueryAllRemarksServlet extends HttpServlet {
	public static RemarkUtil remarkUtil = new RemarkUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = (String)request.getAttribute("msg");
		List<Remark> remarks = null;
		
		if("error:you_are_not_allow_into".equals(msg)) 
			response.sendRedirect(request.getContextPath() + "/view/remarkmanager.jsp");
		else if("success:you_are_permit_into_have_all_power".equals(msg)) {
			remarks = remarkUtil.queryAllRemarks();
			request.setAttribute("Remarks", remarks); 
			
			request.getRequestDispatcher("/view/remarkmanager.jsp").forward(request, response);
			
		}else if("success:you_are_permit_into_have_normal_power".equals(msg)) {
			String username = ((Login)request.getSession().getAttribute("Login")).getUsername();
			remarks = remarkUtil.queryAllRemarksByUsername(username);
			request.setAttribute("Remarks", remarks); 
			
			request.getRequestDispatcher("/view/remarkmanager.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/view/remarkmanager.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

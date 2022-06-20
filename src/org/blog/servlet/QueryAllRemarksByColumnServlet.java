package org.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.RemarkUtil;
import org.blog.Util.UserUtil;
import org.blog.entity.Login;
import org.blog.entity.Remark;
import org.blog.entity.UserInfo;

/**
 * Servlet implementation class QueryAllRemarksByColumnServlet
 */
@WebServlet("/Servlet/QueryAllRemarksByColumnServlet")
public class QueryAllRemarksByColumnServlet extends HttpServlet {
	public static UserUtil userUtil = new UserUtil();
	public static RemarkUtil remarkUtil = new RemarkUtil();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String column = request.getParameter("column");
		String column_value = request.getParameter("column_value");
		
		Login login = (Login) request.getSession().getAttribute("Login");
		
		List<Remark> remarks = null;
		if("remarkusername".equals(column)) {
			remarks = remarkUtil.queryAllRemarksByUsername(column_value);
		}else if("blogid".equals(column)) {
			
			char[] args = column_value.toCharArray();
			
			for(char ch : args) {
				if(!(ch - '0' >= 0 && '9' - ch >= 0)) {
					request.setAttribute("msg", "error:you_input_non_digital");
					request.getRequestDispatcher("/view/remarkmanager.jsp").forward(request, response);
					return;
				}
			}
			int value = Integer.parseInt(column_value);
			remarks = remarkUtil.queryAllRemarksByBlogid(value);
			
		}else if("all".equals(column)) {
			if(login.getUsername().equals("admin")) {
				remarks = remarkUtil.queryAllRemarks();
			}else {
				remarks = remarkUtil.queryAllRemarksByUsername(login.getUsername());
			}
		}else {

		}
		
		if(remarks != null) {
			request.setAttribute("Remarks", remarks);	
		}
		
		request.getRequestDispatcher("/view/remarkmanager.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

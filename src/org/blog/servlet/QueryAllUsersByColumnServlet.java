package org.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.FriendUtil;
import org.blog.Util.UserUtil;
import org.blog.entity.Friend;
import org.blog.entity.Login;
import org.blog.entity.UserInfo;

/**
 * Servlet implementation class QueryAllFriendsByColumnServlet
 */
@WebServlet("/Servlet/QueryAllUsersByColumnServlet")
public class QueryAllUsersByColumnServlet extends HttpServlet {
	public static UserUtil userUtil = new UserUtil();
	public static FriendUtil friendUtil = new FriendUtil();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String column =  request.getParameter("column");
		String column_value = request.getParameter("column_value");
		
		List<UserInfo> userInfos = null;
		UserInfo userInfo = null;
		if("id".equals(column)) {
			
			char[] args = column_value.toCharArray();
			
			for(char ch : args) {
				if(!(ch - '0' >= 0 && '9' - ch >= 0)) {
					request.setAttribute("msg", "error:you_input_non_digital");
					request.getRequestDispatcher("/view/addfriend.jsp").forward(request, response);
					return;
				}
				int value = Integer.parseInt(column_value);
				userInfo = userUtil.queryUserById(value);
			}
		}else if("username".equals(column)) {
			userInfo = userUtil.queryUserInfoByUsername(column_value);
		}else if("nickname".equals(column)) {
			userInfos = (List<UserInfo>) userUtil.queryAllUserInfosByNickname(column_value);
		}else {
			
		}
		
		if(userInfo != null)
			request.setAttribute("UserInfo", userInfo);
		if(userInfos != null)
			request.setAttribute("UserInfos", userInfos);
		
		Login login = (Login) request.getSession().getAttribute("Login");
		List<Friend> friends = friendUtil.queryAllFriendsByUserid(login.getUserid());
		request.setAttribute("Friends", friends);
		
		request.getRequestDispatcher("/view/addfriend.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

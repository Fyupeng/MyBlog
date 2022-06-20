package org.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.PictureUtil;
import org.blog.Util.RouteUtil;
import org.blog.entity.Login;
import org.blog.entity.Picture;


/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/Servlet/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	public static PictureUtil pictureUtil = new PictureUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login login = (Login)request.getSession().getAttribute("Login");
		
		List<Picture> pictures = pictureUtil.queryPictureByUserid(login.getUserid());
		
		
		request.getSession().setAttribute("Picture", pictures);
		
		System.out.println("DownloadServlet:session增加属性：Picture");
		
		request.getRequestDispatcher("/view/picturemanager.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

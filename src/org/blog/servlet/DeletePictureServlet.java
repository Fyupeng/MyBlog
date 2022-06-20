package org.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.PictureUtil;
import org.blog.entity.Login;

/**
 * Servlet implementation class DeletePictureServlet
 */
@WebServlet("/Servlet/DeletePictureServlet")
public class DeletePictureServlet extends HttpServlet {
	public static PictureUtil pictureUtil = new PictureUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String picturename = request.getParameter("picturename");
		
		boolean result = pictureUtil.queryPictureIsExistByPicturename(picturename);
		
		if(result == false) {
			request.setAttribute("msg", "error:picture_name_is_not_exist");
			request.getRequestDispatcher("/Servlet/DownloadServlet").forward(request, response);
		}
		
		Login login = (Login)request.getSession().getAttribute("Login");
		int userid = login.getUserid();
		pictureUtil.deletePictureByPircturenameWithUserid(picturename, userid);
		response.sendRedirect(request.getContextPath() + "/Servlet/DownloadServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

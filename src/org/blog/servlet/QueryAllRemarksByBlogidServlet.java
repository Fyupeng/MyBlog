package org.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.blog.Util.RemarkUtil;
import org.blog.Util.TimeAgoUtils;
import org.blog.entity.Remark;
import org.blog.entity.vo.RemarkVO;

import net.sf.json.JSONArray;


/**
 * Servlet implementation class QueryAllRemarksByBlogidServlet
 */
@WebServlet("/Servlet/QueryAllRemarksByBlogidServlet")
public class QueryAllRemarksByBlogidServlet extends HttpServlet {
	public static RemarkUtil remarkUtil = new RemarkUtil();
	
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blogid = Integer.parseInt(request.getParameter("blogid")) ;
		
		List<Remark> remarks =  remarkUtil.queryAllRemarksByBlogid(blogid);
		Collections.sort(remarks);
		
		List<RemarkVO> remarkVOs = new ArrayList<>();
		
		for(Remark  r : remarks) {
			System.out.println(r.getremarkdate());
			try {
				RemarkVO remarkVO = new RemarkVO();
				BeanUtils.copyProperties(remarkVO, r);
				remarkVO.setDatetimeago(TimeAgoUtils.format(r.getremarkdate())); 
				System.out.println(remarkVO);
				remarkVOs.add(remarkVO);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		PrintWriter out = response.getWriter();
		
		JSONArray js = JSONArray.fromObject(remarkVOs);
		
		out.print(js.toString());
		out.flush();
		
	
		out.close();
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

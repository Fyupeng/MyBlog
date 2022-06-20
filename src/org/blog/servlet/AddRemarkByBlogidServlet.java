package org.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
 * Servlet implementation class AddRemarkByBlogidServlet
 */
@WebServlet("/Servlet/AddRemarkByBlogidServlet")
public class AddRemarkByBlogidServlet extends HttpServlet {
	public static RemarkUtil remarkUtil = new RemarkUtil();
	
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blogid = Integer.parseInt(request.getParameter("blogid")) ;
		int userid = Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("name");
		String message = request.getParameter("message");
	
			
		Random random = new Random();
		
		boolean result = true;
		int rn;
		
		do {
			
			rn = random.nextInt(900000) + 100000;
			
			result = remarkUtil.queryRemarkIsExistById(rn);//false即id没有重复可以跳出循环保存进数据库
			
			
		}while(result == true);
		
		Date remarkdate = new Date();
		
		System.out.println(remarkdate);
		
		remarkUtil.addRemarkByBlogid(rn, userid, blogid, name, message, remarkdate);
		
		List<Remark> remarks = remarkUtil.queryAllRemarksByBlogid(blogid);
		
		
		Collections.sort(remarks);
		
		List<RemarkVO> remarkVOs = new ArrayList<>();
		
		for(Remark  r : remarks) {
			System.out.println(r.getremarkdate());
			try {
				RemarkVO remarkVO = new RemarkVO();
				BeanUtils.copyProperties(remarkVO, r);
				remarkVO.setDatetimeago(TimeAgoUtils.format(r.getremarkdate())); 
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
/*		String data = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
*/		
//		JSONObject jsonObject = new JSONObject();
			
/*			for(Remark remark : remarks) {
				String remarkName = remark.getName();
				String remarkMessage = remark.getMessage();
				Date dateRemarkdate = remark.getremarkdate();
				String stringRemarkDate = formatter.format(dateRemarkdate);
				data = data + remarkName + "&nbsp;&nbsp;:&nbsp;&nbsp;" + remarkMessage + "&nbsp;&#09;发表时间：" + stringRemarkDate + "<br>" ;
			}
			
			response.getWriter().println(data);
		out.close();
*/		
//		int i = 0;
//		for(Remark remark : remarks) {
//			jsonObject.put("Remark"+i, jsonObject);
//			System.out.println("send:" + remark);
//		}
//		out.print(jsonObject);
//		out.flush();
		
		
		JSONArray js = JSONArray.fromObject(remarkVOs);
		
		
		out.print(js.toString());
		out.flush();
		
	
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

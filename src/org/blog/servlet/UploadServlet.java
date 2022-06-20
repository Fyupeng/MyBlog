package org.blog.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.blog.Util.PictureUtil;
import org.blog.Util.RouteUtil;
import org.blog.entity.Login;


/**
 * Servlet implementation class uploadServlet
 */
@WebServlet("/Servlet/UploadServlet")
public class UploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		factory.setSizeThreshold(1024*500);
		factory.setRepository(new File(RouteUtil.FILE_SPACE + "/" + "uploadtemp"));
		upload.setSizeMax(1024*1024*5);
		
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
			if(isMultipart) {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem item = iter.next();
//					String itemName = item.getFieldName();
					
					if(item.isFormField()) {
//						if(itemName.equals("sno")) {
//							sno = Integer.parseInt(item.getString("UTF-8"));
//						}else if(itemName.equals("sname")){
//							
//						}else{
//							System.out.println("其他...");
//						}
					}else {
						
						
						String fileName = item.getName();
						fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
						
						String ext = fileName.substring( fileName.indexOf(".") + 1 );
						
						if(!(ext.equals("png") || ext.equals("jpg"))) {
							System.out.println("UploadServlet:文件类型错误");
							request.setAttribute("msg", "error:file_upload_form_error");
							request.getRequestDispatcher("/view/picturemanager.jsp").forward(request, response);
					
						}else {
							
							Login login = (Login)request.getSession().getAttribute("Login");
							int userid = login.getUserid();
							
//							String path = request.getSession().getServletContext().getRealPath("picture");
							//图片路径的位置
							String relativeDirPath = "/" + "myblog_data" + "/" + "picture"+ "/" + String.valueOf(userid);
							String relativePath = relativeDirPath + "/" + fileName;
							//图片的完整路径
							String absoluteDirPath = RouteUtil.FILE_SPACE + "/" + relativeDirPath;
							String absolutePath = RouteUtil.FILE_SPACE + "/" + relativePath;
							
							//本地数据流
							File file = new File(absoluteDirPath, fileName);
							item.write(file);
							//实现远程数据流传送
							
							PictureUtil pictureUtil = new PictureUtil();
							
							Random random = new Random();
							
							boolean result = true;
							int rn;
							
							do {
								
								rn = random.nextInt(900000) + 100000;
								
								result = pictureUtil.queryPictureIsExistByPictureid(rn);//false即id没有重复可以跳出循环保存进数据库
								
								
							}while(result == true);
							
							pictureUtil.addPictureByUserid(rn, fileName, relativePath, userid);
							
							System.out.println("UploadServlet:" + fileName + "上传成功");
							
							Thread.sleep(100);
							
							response.sendRedirect(request.getContextPath() + "/Servlet/DownloadServlet");
							
							
							
						}
					}
				}
			}
		}catch(FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
		}catch(FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private static byte[] getStreamToBytes(InputStream fin) throws IOException {
		byte[] bybuf = new byte[1024];
		String str = "";
		int r;
		while((r = (fin.read(bybuf))) != -1) {
			str += new String(bybuf, 0, r);
		}
		
		return str.getBytes();
	}
	

}

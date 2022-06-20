<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="org.blog.entity.*"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>博客管理</title>
<style>
 
	body{
		background-image: url("../img/10.jpg");
		background-repeat: no-repeat;
		background-size: 100%;
	}
	
	div {border: 1px solid #000;margin:5px;}
	
	#page_container {
	   border:0;
		width:90%;
		height:100%;
		margin:0 auto;
		text-align:left;
	}
	  
	    
	#banner {
		border-color:blue;
		height:7%; 	
	}
	#left {
		width:18%;
		height:90%;
		float:left;
	}
	#center {
		width:80%;
		height:90%;
		float:left;
		background:#EEEEEE;
	
		overflow:auto;
	
	}
	
	#header-table{
	 	background:#04B4AE;
	 	align-content: "center";
	 	width:100% ;
	 	height:100%;
	 }
	
	 #img-sex1,#img-sex0{
		width: 220px;
		height: 220px;
	}
	
	.welcome-user-color, .blog-createdate-color{
		color: blue;
	}
	
	.welcome-user-font, .blog-content-font, .blog-headline-font{
		font-family: cursive;
	}
	
	
	.btn{
		width:100%;
		padding:2px;
	    position: relative;
	    display: inline-block;
	    background: #D0EEFF;
	    border: 1px solid #99D3F5;
	    border-radius: 4px;
	    overflow: hidden;
	    color: #1E88C7;
	    text-decoration: none;
	    text-indent: 0;
	    line-height: 20px;
	}
	.return:hover,.submit:hover {
	    background: #AADFFD;
	    border-color: #78C3F3;
	    color: #004974;
	    text-decoration: none;
	}
	
	#textheadline{
		resize:none;
		overflow:auto;
		width: 99%;
		height: 35px;
		font-size: xx-large;
	}
	#textcontent{
		resize:none;
		overflow:auto;
		width: 99%;
		height: 650px;
		font-size: x-large;
	}
	
 
</style>
</head>
<body>

	<%	
		Blog blog = (Blog)request.getAttribute("Blog");
		Login login = (Login)request.getSession().getAttribute("Login");
	%>
	
	
	<div id="index" style="border:0px;height: 1000px" >
	  	<div id="head" style="border:0px; height:3%; color: #0B2F3A;">
	  		
	  		<table style="width: 80%; border: 0 " >
	  			<tr>
	  				<td align="left" valign="middle">
	  					<%
	  					Date date = new Date(); 
	  					String[] days = {"日","一","二","三","四","五","六"};
	  					%>
	  					今天是:<%=date.getYear()+1900%>年<%=date.getMonth()+1%>月<%=date.getDate()%>日&nbsp;星期<%=days[date.getDay()]%>
	  				</td>
	  				
	  				<td align="right" valign="middle">
	  					<a href="${pageContext.request.contextPath}/view/index.jsp"><span style="color:white;" >首页</span></a>
	  					<a href="${pageContext.request.contextPath}/Servlet/QueryBlogTomyblogServlet" id="myblog"><span style="color:white;" >我的博客</span></a>
	  					<c:if test="${!empty sessionScope.Login.username}">
	  					<a href="${pageContext.request.contextPath}/view/addfriend.jsp" id="addblog"><span style="color:white;" >添加博客</span></a>
	  					</c:if>
	  					<a href="${pageContext.request.contextPath}/Servlet/QueryAllRemarksServlet" id="remarkblog"><span style="color:white;">评论管理</span></a>
	  					<a href="${pageContext.request.contextPath}/ExitServlet"><span style="color:white;">退出</span></a>
	  				</td>
	  			</tr>
	  		</table>
	  	</div>
	  	
	  	<div id="content" style="height: 90%;">
	  		
	  		<div id="page_container">
				<div id="banner">
					
					<table id="header-table" style=" border:1px ; cellpadding:0; cellspacing:0;">
						<tr align="center">
							<td><a href="${pageContext.request.contextPath}/view/writeessay.jsp" ><span style="font-family: cursive; font-size: x-large; " >写文章</span></a></td>
							<td><a href="${pageContext.request.contextPath}/Servlet/DownloadServlet"><span style="font-family: cursive; font-size: x-large; " >相册管理</span></a></td>
							<td><a href="${pageContext.request.contextPath}/view/friendsmanager.jsp"><span style="font-family: cursive; font-size: x-large; " >好友管理</span></a></td>
							<td><a href="${pageContext.request.contextPath}/view/usermanager.jsp"><span style="font-family: cursive; font-size: x-large; " >账户管理</span></a></td>
						</tr>
					</table>
					
				</div>
					
					<div id="left">
						<div>
							
							<a href="${pageContext.request.contextPath}/Servlet/QueryBlogToblogmanagerServlet">
								<input type="submit" class="return btn" value="返回"/>
							</a>
						</div>
						
					</div>
					
					<div id="center">
						
						
						<div style="height: 100%">
								<form action="${pageContext.request.contextPath}/Servlet/UpdateBlogServlet?blogid=<%=blog.getBlogid()%>" method="post">
									<table border="1px" cellpadding="0"; cellspacing="0" width="100%"; style="table-layout: fixed;">
									<tr align="center">
										<th>标题</th>
									</tr>	
									<tr align="center">
										<td>
											<textarea id="textheadline" class="textheadline_color" name="headline"><%=blog.getHeadline()%></textarea>
										</td>
									</tr>
									
									<tr align="center">
										<th>正文</th>
									</tr>
									
									<tr align="center">
										<td>
											<textarea id="textcontent" class="textcontent_color" name="content"><%=blog.getContent()%></textarea>
										</td>
									</tr>
								</table>
								
								<div align="center">
									<input type="submit" class="submit btn" value="更新" style="height:50px;width: 100%" ></input>
								</div>
								
								</form>
								
						</div>
						
					</div>
					

			</div>
	  		
	  		
	  	</div>
	
  	
  	<div id="bottom" style="border:0px; height: 4%" >
    	Copyright &copy; 2013 <a href="mailto:yp010311@163.com">Finally_m@163.com</a> Inc. All Rights Reserved. Finally_m 版权所有
    	<br/><br/>
  	</div>
  	
  </div>
	


</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="org.blog.entity.*"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#myblog-span").css("color","red");
	});
</script>


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
		background:#F2F2F2;
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
	
	
	#textheadline{
		resize:none;
		width: 100%;
		height: 20%;
		font-size: xx-large;
	}
	
	#textcontent{
		resize:none;
		width: 100%;
		height: 80%;
		font-size: x-large;
	}
	
	.headline-td,.content-td{
		overflow: hidden;
		text-overflow:ellipsis;
		white-space: nowrap;
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
	.return:hover {
	    background: #AADFFD;
	    border-color: #78C3F3;
	    color: #004974;
	    text-decoration: none;
	}
 
</style>
</head>
<body>

	<%	
		List<Blog> blogs = (List<Blog>) request.getAttribute("Blog");
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
					</table>
					
				</div>
					
					<div id="left">
						<div>
							<a href="${pageContext.request.contextPath}/Servlet/QueryBlogTomyblogServlet">
								<input type="submit" class="return btn" value="返回"/>
							</a>
						</div>
						
					</div>
					
					<div id="center">
						
						
						<div style="height: 100%">
								<table border="1px" cellpadding="0"; cellspacing="0" width="100%" style="table-layout: fixed;">
									<tr align="center">
										<th>标题</th>
										<th>正文</th>
										<th>操作</th>
									</tr>
									
									
									<%
										for(Blog blog : blogs){
									%>
									<tr align="center">
										<td class="headline-td"><a href="${pageContext.request.contextPath}/Servlet/QueryBlogByIdServlet?blogid=<%=blog.getBlogid()%>"><%=blog.getHeadline()%></a></td>
										<td class="content-td"><a><%=blog.getContent()%></a></td>
										<td><a href="${pageContext.request.contextPath}/Servlet/DeleteBlogServlet?blogid=<%=blog.getBlogid()%>">删除</a></td>
									</tr>
									
									<%
										}
									%>
									
								</table>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="org.blog.entity.Login" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#index-span").css("color","red");
	});
</script>	

<head>
<title>博客首页</title>
    
	<style>
 
 		div {border: 1px solid #000;margin:5px;}    
 		
 		body{
 			background-image: url("../img/10.jpg");
 			background-repeat: no-repeat;
 			background-size: 100%;
 		}
 		
 		
 	</style>
    
  </head>
  <body>
  

  <div id="index" style="border:0px;height: 1000px;" >
  
  	<div id="head" style="border:0; color:#0B2F3A; height: 3%">
  		
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
	  					<a href="${pageContext.request.contextPath}/view/index.jsp"><span id="index-span" style="color:black;" >首页</span></a>
	  					<a href="${pageContext.request.contextPath}/Servlet/QueryBlogTomyblogServlet" id="myblog"><span style="color:black;" >我的博客</span></a>
	  					<c:if test="${!empty sessionScope.Login.username}">
	  					<a href="${pageContext.request.contextPath}/view/addfriend.jsp" id="addblog"><span style="color:black;" >添加博客</span></a>
	  					</c:if>
	  					<a href="${pageContext.request.contextPath}/Servlet/QueryAllRemarksServlet" id="remarkblog"><span style="color:black;">评论管理</span></a>
	  					<a href="${pageContext.request.contextPath}/ExitServlet"><span style="color:black;">退出</span></a>
  				</td>
  			</tr>
  		</table>
  	</div>
  
  	<div id="content" style="height: 90%" >
  		<div id="left" style="border: 0px">
   			<table style="border:0; width: 95%"  >
    				<tr>
    					<td>
    						<c:if test="${!empty sessionScope.Login.username}">
    							欢迎用户：<span style="border:0px; color: white;">${sessionScope.Login.username}</span>
    						</c:if>
    					</td>
    				</tr>
   			</table>
   		</div>
  	</div>
  	
	 <div id="bottom" style="background-color: captiontext;">
	 	<div style="border:0px;" >
	    	<span style="color:white">Copyright &copy; 2021 </span><a href="mailto:yp010311@163.com">Finally_m@163.com</a><span style="color:white"> Inc. All Rights Reserved. Finally_m 版权所有</span>
		</div>
	 	 <div style="border:0px;" align="center">
		<a  href="http://beian.miit.gov.cn/"><span style="color: white" >粤ICP备2021110923号</span></a>  	
	 	 </div>
  	</div>
  	
  	
  </div>
  
 
  
  
  
  </body>
  
</html>
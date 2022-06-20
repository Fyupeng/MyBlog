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
		$("#user-span").css("color","red");
	});
	
	function msgbox(n){
		document.getElementById("inputbox").style.display=n?"block":"none";     /* 点击按钮打开/关闭 对话框 */
	}
	
	function changeType(obj){
		$(obj).val("");
	}
	
	
	
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账户管理</title>
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
	
	 .btn{
	 	margin-bottom:2px;
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
	
	.return:hover,.check:hover,.submit:hover{
	    background: #AADFFD;
	    border-color: #78C3F3;
	    color: #004974;
	    text-decoration: none;
	}
	
	.box-div{
		
       	background-size:100%;
	}
		
	.box{
		position:realtive;
		background: url(../img/6.gif);
      	background-repeat:no-repeat;
		border-bottom-style:outset;
		border-width:3px;
		position:absolute;
		padding:60px;
		display:none;            /* 默认对话框隐藏 */
		top:30%;left:50%;
		margin-left:-150px;
		width:300px;
		height:164px;
	}
	
	.box.show{display:block;} 
	.box .x{font-size:18px; text-align:right; display:block;}
	.box input{width:80%; font-size:18px; margin-top:18px;}
	
	
 
</style>
</head>
<body>

	<%	
		List<Blog> blogs = (List<Blog>)request.getAttribute("Blog");
		Login login = (Login)request.getSession().getAttribute("Login");
		List<UserInfo> userInfos = (List<UserInfo>)request.getAttribute("UserInfos");
				
	%>
	
	
	<!-- 隐藏验证超级管理员对话框  -->
	<div style="border: 0px;" class="box-div">
		<div id='inputbox' class="box">
	       <a class="x" href="" onclick="msgbox(0); return false;">【关闭】</a>
	       键入以验证身份：<br/>
	       <form action="${pageContext.request.contextPath}/Servlet/QueryAdminIdentityToUsermanagerServlet" method="post">
		       <input type="password" name="adminPwd" autocomplete="off" placeholder="verify the identity permissions" onfocus="changeType(this)"/>
		       <input type="submit" class="submit btn" value="确定"/>
	       </form>
	    </div>
	</div>
	
	
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
	  					<a href="${pageContext.request.contextPath}/Servlet/QueryBlogTomyblogServlet" id="myblog"><span id="myblog-span" style="color:white;" >我的博客</span></a>
	  					<c:if test="${!empty sessionScope.Login.username}">
	  					<a href="${pageContext.request.contextPath}/view/addfriend.jsp" id="addblog"><span style="color:white;" >添加博客</span></a>
	  					</c:if>
	  					<a href="${pageContext.request.contextPath}/Servlet/QueryAllRemarksServlet" id="remarkblog"><span style="color:white;">评论管理</span></a>
	  					<a href="${pageContext.request.contextPath}/ExitServlet"><span style="color:white;">退出</span></a>
	  				</td>
	  			</tr>
	  		</table>
	  	</div>
	  	
	  	<div id="content" style="height: 90%">
	  		
	  		<div id="page_container">
				<div id="banner">
					
					<table id="header-table" style=" border:1px ; cellpadding:0; cellspacing:0;">
						<tr align="center">
							<td><a href="${pageContext.request.contextPath}/view/writeessay.jsp"><span style="font-family: cursive; font-size: x-large; " >写文章</span></a></td>
							<td><a href="${pageContext.request.contextPath}/Servlet/DownloadServlet"><span style="font-family: cursive; font-size: x-large; " >相册管理</span></a></td>
							<td><a href="${pageContext.request.contextPath}/Servlet/QueryAllFriendsServlet"><span style="font-family: cursive; font-size: x-large; ">好友管理</span></a></td>
							<td><a href="${pageContext.request.contextPath}/Servlet/QueryAllUserInfoServlet"><span id="user-span" style="font-family: cursive; font-size: x-large; ">账户管理</span></a></td>
						</tr>
					</table>
					
				</div>
					
					<div id="left">
						<div>
							<a href="${pageContext.request.contextPath}/Servlet/QueryBlogTomyblogServlet">
								<input type="submit" class="return btn" value="返回"/>
							</a>
							
							<input type="button" class="check btn" onclick="msgbox(1)" value="验证身份"/>
						</div>	
						
						
					</div>
					
					<div id="center">
						
						<table style="width: 100%" border="1px">
							<%request.setAttribute("UserInfos", userInfos);%>
							<c:if test="${!empty UserInfos}">
							<tr align="center">
								<th>id</th>
								<th>用户名</th>
								<th>性别</th>
								<th>操作</th>
							</tr>
							</c:if>
							<%
								if(userInfos != null)
								for(UserInfo userInfo : userInfos){
									if(userInfo.getuserid() != login.getUserid() && !userInfo.getUsername().equals("admin")){
							%>
							
										<tr align="center">
											<td><a href="${pageContext.request.contextPath}/Servlet/QueryUserServlet?userid=<%=userInfo.getuserid()%>"><%=userInfo.getuserid() %></a></td>
											<td><a><%=userInfo.getUsername()%></a></td>
											<td>
												<%request.setAttribute("UserInfo", userInfo); %>
												<c:if test="${UserInfo.sex == 1}">
													<c:out value="男"></c:out>
												</c:if>
												<c:if test="${UserInfo.sex == 0}">
													<c:out value="女"></c:out>
												</c:if>
											</td>
											<td><a href="${pageContext.request.contextPath}/Servlet/DeleteUserServlet?userid=<%=userInfo.getuserid()%>">删除</a></td>
										</tr>
							
							<%		}else if(userInfo.getUsername().equals("admin")){
								
								%>
								<tr align="center">
									<td><a><%=userInfo.getuserid() %></a></td>
									<td><a><%=userInfo.getUsername()%></a></td>
									<td>
										<%request.setAttribute("UserInfo", userInfo); %>
										<c:if test="${UserInfo.sex == 1}">
											<c:out value="男"></c:out>
										</c:if>
										<c:if test="${UserInfo.sex == 0}">
											<c:out value="女"></c:out>
										</c:if>
									</td>
									<td><a>删除</a></td>
								</tr>
					<%
								
							
							}else{
							%>
										<tr align="center">
											<td><a href="${pageContext.request.contextPath}/Servlet/QueryUserServlet?userid=<%=userInfo.getuserid()%>"><%=userInfo.getuserid() %></a></td>
											<td><a><%=userInfo.getUsername()%></a></td>
											<td>
												<%request.setAttribute("UserInfo", userInfo); %>
												<c:if test="${UserInfo.sex == 1}">
													<c:out value="男"></c:out>
												</c:if>
												<c:if test="${UserInfo.sex == 0}">
													<c:out value="女"></c:out>
												</c:if>
											</td>
											<td><a>删除</a></td>
										</tr>
							<%
							}
								}
							%>
							
						</table>
					
					</div>
					
					
			</div>
	  		
	  		
	  	</div>
	
  	
  	<div id="bottom" style="border:0px; height: 4%" >
    	Copyright &copy; 2021 <a href="mailto:yp010311@163.com">Finally_m@163.com</a> Inc. All Rights Reserved. Finally_m 版权所有
    	<br/><br/>
  	</div>
  	
  </div>
	


</body>
</html>

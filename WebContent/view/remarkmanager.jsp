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
		$("#remarkblog-span").css("color","red");
	});
	
	function hiddenSearchText(){
		
		var options=$("#search-box-select option:selected");  //获取选中的项
		if("all" == options.val() ){
			$("#search-box-input").css("visibility","hidden");
		}else{
			$("#search-box-input").css("visibility","visible");
		}
	}
	
	function msgbox(n){
		document.getElementById("inputbox").style.display=n?"block":"none";     /* 点击按钮打开/关闭 对话框 */
	}
	
	function changeType(obj){
		$(obj).val("");
	}
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>评论管理</title>
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
	
	.search-box{
		border:0;
		margin-left: 20%;
		width: 50%;
	}
	
	.search-box-select{
		float:top;
		height: 35px;
		width: 120px;
		font-size: large;
	}
	
	.search-box-input{
		visibility:hidden;
		float:top;
		height: 32px;
		width: 120px;
		font-size: large;
	}
	.search-button{
		vertical-align:-10px;
		height: 34px; 
		width:34px;
		left: 900px;
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
	
	.submit:hover,.check:hover{
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
	.box .x{ font-size:18px; text-align:right; display:block;}
	.box input{width:80%; font-size:18px; margin-top:18px;}
	
	
 
</style>
</head>
<body>

	<%	
		List<Blog> blogs = (List<Blog>)request.getAttribute("Blog");
		Login login = (Login)request.getSession().getAttribute("Login");
		List<Remark> remarks = (List<Remark>) request.getAttribute("Remarks");
		String msg = (String) request.getAttribute("msg");
		
		if("error:you_input_non_digital".equals(msg)){
	%>
					<script>alert("id不允许输入字符！")</script>
	<%		
				}
	%>
	
	<!-- 隐藏验证超级管理员对话框  -->
	<div style="border: 0px;" class="box-div">
		<div id='inputbox' class="box">
	       <a class="x" href="" onclick="msgbox(0); return false;">【关闭】</a>
	       键入以验证身份：<br/>
	       <form action="${pageContext.request.contextPath}/Servlet/QueryAdminIdentityToRemarkmanagerServlet" method="post">
		       <input type="password" name="adminPwd" autocomplete="off" placeholder="verify the identity permissions" onfocus="changeType(this)"/>
		       <input type="submit" class="submit btn" value="确定"/>
	       </form>
	    </div>
	</div>

	
	<div id="index" style="height: 1000px" >
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
  					<a href="${pageContext.request.contextPath}/Servlet/QueryAllRemarksServlet" id="remarkblog"><span id="remarkblog-span" style="color:white;">评论管理</span></a>
  					<a href="${pageContext.request.contextPath}/ExitServlet"><span style="color:white;">退出</span></a>
  				</td>
	  			</tr>
	  		</table>
	  	</div>
	  	
	  	<div id="content" style="height: 90%">
	  		
	  		<div id="page_container">
				<div id="banner">
					
					<table id="header-table" style=" border:1px ; cellpadding:0; cellspacing:0;">
					</table>
					
				</div>
					
					<div id="left">
						<input type="button" class="check btn" onclick="msgbox(1)" value="验证身份"/>
					</div>
					
					<div id="center">
						<%request.setAttribute("Remarks", remarks); %>
						<c:if test="${!empty Remarks}">
							<div class="search-box" align="center">
								<form action="${pageContext.request.contextPath}/Servlet/QueryAllRemarksByColumnServlet" method="post">
									<div>
										<font> 查询方式：</font> 
										<select id="search-box-select" class="search-box-select" name="column" onchange="hiddenSearchText()">
											<option>all</option>
											<option>remarkusername</option>
											<option>blogid</option>
										</select>
										<input id='search-box-input' class="search-box-input" name="column_value" />
										<input class="search-button" type="image" src="../img/7.png"/>
									</div>
								</form>
							</div>
						</c:if>
							
						
						
						<table style="width: 100%" border="1px">
							<c:if test="${!empty Remarks}">
								<tr align="center">
									<th>评论id</th>
									<th>评论用户名</th>
									<th>评论</th>
									<th>评论时间</th>
									<th>博主id</th>
									<th>操作</th>
								</tr>
							</c:if>	
							<%
								if(remarks != null)
								for(Remark remark : remarks){
									if(remark.getName().equals("admin") && !login.getUsername().equals("admin")){
										
									%>
									
									<tr align="center">
										<td><%=remark.getCommentid() %></td>
										<td><%=remark.getName() %></td>
										<td><%=remark.getMessage() %></td>
										<td><%=remark.getremarkdate() %></td>
										<td><a><%=remark.getBlogid()%></a></td>
										<td><a>删除</a></td>
									</tr>
									
									<%
									}else{	
							%>
							
							
							
							<tr align="center">
								<td><%=remark.getCommentid() %></td>
								<td><%=remark.getName() %></td>
								<td><%=remark.getMessage() %></td>
								<td><%=remark.getremarkdate() %></td>
								<td><a href="${pageContext.request.contextPath}/Servlet/QueryBlogByIdServlet?blogid=<%=remark.getBlogid()%>"><%=remark.getBlogid()%></a></td>
								<td><a href="${pageContext.request.contextPath}/Servlet/DeleteRemarkByIdServlet?commentid=<%=remark.getCommentid()%>">删除</a></td>
							</tr>
							
							<%		}
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

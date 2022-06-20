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
		$("#picture-span").css("color","red");
	});
	
	
	function msgbox(n){
		document.getElementById("inputbox").style.display=n?"block":"none";     /* 点击按钮打开/关闭 对话框 */
		}
	
</script>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>相册管理</title>

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
	
	   
	.file {
		margin-bottom:2px;
		width:99%;
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
	
	
	.file input {
	    position: absolute;
	    font-size: 100px;
	    right: 0;
	    top: 0;
	    opacity: 0;
	}
	.file:hover,.submit:hover,.delete:hover,.return:hover {
	    background: #AADFFD;
	    border-color: #78C3F3;
	    color: #004974;
	    text-decoration: none;
	}
	
	.img-size{
	 	width: 190px;
	 	height: 190px;
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
	
	<!-- 隐藏输入删除图片对话框  -->
	<div style="border: 0px;" class="box-div">
		<div id='inputbox' class="box">
	       <a class="x" href="" onclick="msgbox(0); return false;">【关闭】</a>
	       请输入图片名：<br/>
	       <form action="${pageContext.request.contextPath}/Servlet/DeletePictureServlet" method="post">
		       <input type="text" name="picturename" class="picturename"/>
		       <input type="submit" class="submit btn" value="确定"/>
	       </form>
	    </div>
	</div>
	
	
	<%	
		String msg = (String)request.getAttribute("msg");
		if("error:file_upload_form_error".equals(msg)){
	%>
			<script>alert("格式上传错误！[msg:格式必须为.jpg或.png]")</script>
	<%
		}else if("error:picture_name_is_not_exist".equals(msg)){
	%>
			<script>alert("删除失败！[msg:格式必须为.jpg或.png]")</script>
	<%
		}else{
			
		}
		
		List<Blog> blogs = (List<Blog>)request.getAttribute("Blog");
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
							<td><a href="${pageContext.request.contextPath}/Servlet/DownloadServlet"><span id="picture-span" style="font-family: cursive; font-size: x-large; " >相册管理</span></a></td>
							<td><a href="${pageContext.request.contextPath}/Servlet/QueryAllFriendsServlet"><span style="font-family: cursive; font-size: x-large; " >好友管理</span></a></td>
							<td><a href="${pageContext.request.contextPath}/Servlet/QueryAllUserInfoServlet"><span style="font-family: cursive; font-size: x-large; " >账户管理</span></a></td>
						</tr>
					</table>
					
				</div>
					
					<div id="left" align="center">
						
						<div>
						<form action="${pageContext.request.contextPath}/Servlet/UploadServlet" method="post" enctype="multipart/form-data">
							<a class="file">选择照片
						   		<input type="file" name="spicture"/>
							</a>
							
							<input type="submit" class="submit btn" value="确认上传"/>
							
					   		<input type="button" class="delete btn" onclick="msgbox(1)" value="删除"/>
							
						</form>
						
						<a href="${pageContext.request.contextPath}/Servlet/QueryBlogTomyblogServlet">
							<input type="submit" class="return btn" value="返回"/>
						</a>
							
						</div>
						
							 
						
					</div>
						 	
							
					
					
					<div id="center" align="center" >
					
						
					<%
							List<Picture> pictures = (List<Picture>)request.getSession().getAttribute("Picture");
							request.setAttribute("picturesSize", pictures.size());
							int p = 0;
					%>
						
						<table border="1px">
							<tr>
							
							<c:if test="${ picturesSize >= 1}"><th>1</th></c:if>
							<c:if test="${ picturesSize >= 2}"><th>2</th></c:if>	
							<c:if test="${ picturesSize >= 3}"><th>3</th></c:if>	
							<c:if test="${ picturesSize >= 4}"><th>4</th></c:if>	
							<c:if test="${ picturesSize >= 5}"><th>5</th></c:if>	
							</tr>
								
							<!-- 先除整把所有图片排放pictures.size()/5 -->	
					<%		
							int count = pictures.size();
							if(pictures.size() >= 5){	
								for(int i = 0; i < pictures.size()/5 ; i++){
									
									
								
					%>				
										
											<tr>
					<% 
											for(int j = 0; j < 5; j++){
					%>	
												<td valign="top">
													<img src="http://47.107.63.171:8080/<%=pictures.get(p).getPictureroute()%>" class="img-size" alt="<%=pictures.get(p).getPicturename() %>" border="5px" align="top" />
													<%=pictures.get(p).getPicturename()%>
												</td>
					<%
											p += 1;
											}
					%>
											</tr>
					<%			
								}
							}
					%>
					
					<!-- 剩下的用除余的方法，把剩余的几张图片排放 -->
					
		  					<tr>
					<%				
								if(pictures.size()%5 != 0){  //图片超过6张需要另一行，则p要-6
									for(int k = 0; k < pictures.size()%5; k++){
										
					%>
										<td valign="top" >
											<img src="http://47.107.63.171:8080/<%=pictures.get(p).getPictureroute()%>" class="img-size" alt="<%=pictures.get(p).getPicturename() %>" border="5px" />
											<br/><%=pictures.get(p).getPicturename()%>
										</td>
					<%
										p += 1;
									}
								}
					%>	
								</tr>
					
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

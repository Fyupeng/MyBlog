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
			$("#friend-span").css("color","red");
		});
			

		
		
	
		function hiddenSearchText(){
			
			var options=$("#search-box-select option:selected");  //获取选中的项
			if("all" == options.val() ){
				$("#search-box-input").css("visibility","hidden");
			}else{
				$("#search-box-input").css("visibility","visible");
			}
		}
		
		function changeLikesColor(obj){
			var url1 = "../img/8.png";
			var url2 = "../img/8-1.png";
			var ImgURL = "img/8.png";
			var blogid = $(obj).val();
			if((obj.src).substring((obj.src).indexOf("img/8")) == ImgURL) {
				obj.src = url2;
				/*$.ajax({
					url:"http://localhost:8888/MyBlog2/Servlet/QueryLikesByAjaxWhenLikeServlet",
		  			method:"post",
		  			data:"blogid="+ blogid,
					success:function(data)
					{
						var span = $(obj).parent().next().children("span");
						$(span).html(data);
												
						
					},
					error:function(xhr,errorMessage,e)
					{
						alert("change:xhr:" + xhr + ",errorMessage:" + errorMessage +",e:" + e);
						//alert("系统异常！");
					}
				});*/
				$.getJSON(
						"/MyBlog/Servlet/QueryLikesByAjaxWhenLikeServlet",
						{"blogid":blogid},
						function(data)
						{
							var span = $(obj).parent().next().children("span");
							$.each(data, function(i, field){
								$(span).html(field);
							});
						}
					);
			}else{
				obj.src = url1;
			/*	$.ajax({
					url:"http://localhost:8888/MyBlog2/Servlet/QueryLikesByAjaxWhenDislikeServlet",
		  			method:"post",
		  			data:"blogid="+ blogid,
					success:function(data)
					{
						var span = $(obj).parent().next().children("span");
						$(span).html(data);
					},
					error:function(xhr,errorMessage,e)
					{
						alert(",change else:xhr:" + xhr + ",errorMessage:" + errorMessage +",e:" + e);
						//alert("系统异常！");
					}
				});*/
				$.getJSON(
						"/MyBlog/Servlet/QueryLikesByAjaxWhenDislikeServlet",
						{"blogid":blogid},
						function(data)
						{
							var span = $(obj).parent().next().children("span");
							$.each(data, function(i, field){
								$(span).html(field);
							});
						}
				);
			}
		}
		
		function openRemarkBox(obj){
			var inputText =  $(obj).next();
			var controlHidden = $(obj).parent().parent().next();
			var blogid = $(obj).next().next().val();
			if($(inputText).val() == 0){
				$(inputText).val(1);
				controlHidden.slideDown();
				/*$.ajax({
					url:"/MyBlog2/Servlet/QueryAllRemarksByBlogidServlet",
		  			method:"post",
		  			data:"blogid="+ $blogid ,
					success:function(data)
					{
						
						var message = $(obj).parent().parent().next().children("p");
						$(message).html(data);
					},
					error:function(xhr,errorMessage,e)
					{
						alert("open:xhr:" + xhr + ",errorMessage:" + errorMessage +",e:" + e);
						//alert("系统异常！");
					}
				});*/
				$.getJSON(
						"/MyBlog/Servlet/QueryAllRemarksByBlogidServlet",
						{"blogid":blogid},
						function(data)
						{
							var message = $(obj).parent().parent().next().children("p");
							$(message).html("");
							$.each(data, function(i, field){
								$(message).append("@" + field.name + ": " + field.message + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + " 发送于 " + field.remarkdate +  "<br/><br/>");
							});
						}
				);
			}else{
				$(inputText).val(0);
				controlHidden.slideUp();
			}
		}
		
		function sendMessage(obj){
			var blogid = $(obj).next().val();
			var userid = $(obj).next().next().val();
			var name = $(obj).next().next().next().val();
			var message = $(obj).parent().next().children("input").val().replace(/^\s*|\s*$/g,"");
			$(obj).parent().next().children("input").val("");
			//alert($name+","+$message+","+$blogid);
/*			$.ajax({
				url:"/MyBlog2/Servlet/AddRemarkByBlogidServlet",
	  			method:"post",
	  			data:"blogid="+ $blogid + "&name=" + $name + "&message=" + $message  ,
				success:function(data)
				{
					var message = $(obj).parent().parent().parent().prev();
					$(message).html(data);
					
				},
				error:function(xhr,errorMessage,e)
				{
					alert("send:xhr:" + xhr + ",errorMessage:" + errorMessage +",e:" + e);
					//alert("系统异常！");
				}
			});
*/				
			$.getJSON(
					"/MyBlog/Servlet/AddRemarkByBlogidServlet",
					{"userid":userid,"blogid":blogid,"name":name,"message":message},
					function(data)
					{
						var message = $(obj).parent().parent().parent().prev();
						$(message).html("");
						$.each(data, function(i, field){
							$(message).append("@" + field.name + "&nbsp;&nbsp;:&nbsp;&nbsp;" + field.message + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "发送于 " + field.datetimeago +  "<br/><br/>");
						});
					}
			);	
			//查询比插入操作要快，导致查询到旧信息，未更新，需要再次查询
			$.getJSON(
					"/MyBlog/Servlet/QueryAllRemarksByBlogidServlet",
					{"blogid":blogid},
					function(data)
					{
						var message = $(obj).parent().parent().next().children("p");
						$(message).html("");
						 $.each(data, function(i, field){
							$(message).append("@" + field.name + ": " + field.message + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + " 发送于 " +  field.datetimeago +  "<br/><br/>"); 
						}); 
					}
			);
		}	
		
		function OnTextChanged(obj) {
		      if (event.keyCode == 13) {//判断是否为回车键，Event是window对象的一个属性，是全局的。
		          event.keyCode = 0;//屏蔽回车键
		          event.returnValue = false;
		          $(obj).parent().prev().children("input").eq(1).click();
		          $(obj).val("");
		      }
		  }
		
		
		
		
	</script>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>好友管理</title>
<style>
 
	 body{
		background-image: url("../img/10.jpg");
		bakground-repeat: no-repeat;
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
	 	overflow-x:hidden;
	 }
	 
	 #header-table{
	 	background:#04B4AE;
	 	align-content: "center";
	 	width:100% ;
	 	height:100%;
	 }
	 
	 .file {
		margin-bottom:2px;
		width:98%;
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
	.file:hover,.submit:hover,.reset:hover,.return:hover,.getRemark:hover {
	    background: #AADFFD;
	    border-color: #78C3F3;
	    color: #004974;
	    text-decoration: none;
	}
	
	
	.blog-headline{
		font-size: xx-large;
	}
	
	.blog-content{
		font-size:x-large;
		padding: 20px;
	}
	
	.blog-createdate-color,.blog-updatedate-color{
		color: blue;
	}
	
	 .blog-content-font, .blog-headline-font{
		font-family: cursive;
	}
	
	.likesAndRemark-box{
		height:50px;
	}
	
	.likes-box{
		padding:2px;
		float:left;
		height: 30px;
		width: 2%;
	}
	.remark-box{
		padding:2px;
		float:left;
		margin-left:85%;
		height: 30px;
		width: 2%;
	}
	
	.likes{
		margin-top:4px;
		height: 20px;
		width: 20px;
	}
	.remark{
		margin-top:5px;
		height: 20px;
		width: 20px;
	}
	
	
	.remark-text{
		display: none;
	}
	
	
	
	
	 
 
</style>
</head>
<body>

	<%	
		List<Blog> friendBlogs = (List<Blog>) request.getAttribute("FriendBlogs");
		Login login = (Login) request.getSession().getAttribute("Login");
		List<Friend> friends = (List<Friend>) request.getAttribute("Friends");
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
	  	
	  	<div id="content" style="height: 90%;">
	  		
	  		<div id="page_container">
				<div id="banner">
					
					<table id="header-table" style=" border:1px ; cellpadding:0; cellspacing:0;">
						<tr align="center">
							<td><a href="${pageContext.request.contextPath}/view/writeessay.jsp"><span style="font-family: cursive; font-size: x-large; " >写文章</span></a></td>
							<td><a href="${pageContext.request.contextPath}/Servlet/DownloadServlet"><span style="font-family: cursive; font-size: x-large; " >相册管理</span></a></td>
							<td><a href="${pageContext.request.contextPath}/Servlet/QueryAllFriendsServlet"><span id="friend-span" style="font-family: cursive; font-size: x-large; " >好友管理</span></a></td>
							<td><a href="${pageContext.request.contextPath}/Servlet/QueryAllUserInfoServlet"><span style="font-family: cursive; font-size: x-large; " >账户管理</span></a></td>
						</tr>
					</table>
					
				</div>
					
				<div id="left">
					<div>
						<a href="${pageContext.request.contextPath}/Servlet/QueryAllFriendsServlet">
							<input type="submit" class="return btn" value="返回"/>
						</a>
						
						
						
					</div>
				</div>
				
				
				<div id="center">最新文章
				<%
				if(friendBlogs != null)
					for(Blog friendBlog : friendBlogs){
				%>
						<div style="overflow:auto;">
							<h2 class="blog-headline blog-headline-font" align="center"><%=friendBlog.getHeadline() %></h2>
							<p id="blog-content" class="blog-content blog-content-font"><%=friendBlog.getContent() %></p><br/>
								<div class="likesAndRemark-box" style="border: 0;">
									<div class="remark-box" style="border: 0;">
										<input id="remark" class="remark" type="image" src="../img/9.png" alt="jpg" onclick="openRemarkBox(this)"/>
										<input type="hidden" value="1" /><!-- 1表示显示 -->
										<input type="hidden" value="<%=friendBlog.getBlogid()%>"></input>
									</div>
									
									<div class="likes-box" style="border: 0px;">
										<input id="likes" class="likes" type="image" src="../img/8.png" alt="jpg" value="<%=friendBlog.getBlogid()%>" onclick="changeLikesColor(this)"/>
									</div>
									
									<div style=" border:0px; height:34px;  float: left">
										<span style="vertical-align:-25px;"><%=friendBlog.getLikes()%></span>
									</div>
									
									
									
								</div>
								
								
								
								<div class="remark-text">
									
									<p></p>
									
									
									<div align="right" style="border: 0px;">
											<form>
												<div style="border:0px; width: 10%" align="center">
													<input type="reset" class="reset btn" value="清空"></input>
													<input type="button" class="submit btn" value="发送" onclick="sendMessage(this)"></input>
													<input type="hidden" value="<%=friendBlog.getBlogid()%>"></input>
													<input type="hidden" value="<%=login.getUserid()%>"></input>
													<input type="hidden" value="<%=login.getUsername()%>"></input>
												</div>
												
												<div align="center">
													<input type="text" name="remark" style=" width: 99.65%"  onkeydown="OnTextChanged(this)" />
												</div>
												
											</form>
										
										
											
									</div>
								
									
								</div>
								
								发布时间：
								<span class="blog-createdate-color"><%=friendBlog.getCreatedate()%></span>
								更新时间：
								<span class="blog-updatedate-color"><%=friendBlog.getUpdatedate()==null ? "" : friendBlog.getUpdatedate()%></span>
								
								
							
							
								
						</div>
						<br/><br/>		
					<%} %>
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

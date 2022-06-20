<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/cssstyle.css">

<script type="text/javascript" src="js/jquery-1.10.2.js"></script>

<style>
		
		body{
 			background-image: url("img/3.jpg");
 			background-repeat: no-repeat;
 			background-size: 100%;
 		}
		
        .bxs-row {
            margin-bottom:12px;
        }
        .register-box {
        	background: url(img/12.png);
            width:404px;
            margin:120px auto;
            border:1px solid #e5e5e5;
            border-radius:4px;
            box-shadow:0 4px 18px rgba(0,0,0,0.2);
            position:relative;
            overflow:hidden;
            height:560px;
        }
        .register {
            position:absolute;
            width:320px;left:0;
            top:0;
            padding: 42px 42px 36px;
            transition:all 0.8s;
        }
        .register_username,.register_password1, .register_sex,.register_password2,.register_nickname,.register_motto,.register_submit_btn {
            height: 44px;
            width: 100%;
            padding: 0 10px;
            border: 1px solid #9da3a6;
            background: #fff;
            text-overflow: ellipsis;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            -khtml-border-radius: 4px;
            border-radius: 4px;
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
            color: #000;
            font-size: 1em;
            font-family: Helvetica,Arial,sans-serif;
            font-weight: 400;
            direction: ltr;
            font-size:13px;
        }
        .register_submit {
            background-color: #0070ba;
            color:#fff;
            border:1px solid #0070ba;
        }
        .register_submit:hover {
            background-color:#005ea6;
        }
        
</style>

</head>
<body>


	<%
		String msg = (String)request.getAttribute("msg");//由RegisterServlet处理注册页面信息，并返回值判断注册是否成功
		if("error:exist_information_is_empty".equals(msg)){
	%>
			<script>alert("请完善其他信息")</script>
	<% 
		}else if("error:the_two_passwords_are_inconsistent".equals(msg)){
	%>
			<script>alert("两次密码不一致")</script>
	<% 
		}else if("error:user_has_register".equals(msg)){
	%>
			<script>alert("用户已注册，请更换用户名！")</script>
	<% 
		}else if("success".equals(msg)){
	%>
			<script>alert("恭喜你，注册成功！")</script>
	<% 
		}else{
			
	
		}
		
		
	%>
	

<div class="register-box">
	<div class="register" style="">
		
		<div class="bxs-row" style="text-align:center;">
			<span class="tips" style="color:white ;font-size:xx-large;">MyBlog注册</span>
		</div>
		
		<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
		
			<div class="bxs-row">
				<input type="text" name="register_username" class="register_username" placeholder="请输入用户名" >
			</div>
			
			<div class="bxs-row">
				<input type="password" name="register_password1" class="register_password1" placeholder="密码">
			</div>
			
			<div class="bxs-row">
				<input type="password" name="register_password2" class="register_password2" placeholder="请再次输入密码">
			</div>
			
			<div class="bxs-row">
				<select name="register_sex" class="register_sex">
					<option value="1">男</option>
					<option value="0">女</option>
				</select>
				
			</div>
			
			<div class="bxs-row">
				<input type="text" name="register_nickname" class="register_nickname" placeholder="别名">
			</div>
			
			<div class="bxs-row">
				<input type="text" name="register_motto" class="register_motto" placeholder="座右铭">
			</div>
			
			<div class="bxs-row">
				<input type="submit" name="register_submit" class="register_submit register_submit_btn" value="注册">
			</div>
			<ol>
				<li style="text-align: right; list-style: none; ">
					<a style="color:white" href="login.jsp" >已有用户？</a>
				</li>
				
				<li style="text-align: right; list-style: none; ">
					<a style="color:white" href="feedback.jsp" >信息反馈</a>
				</li>
			</ol>
			
			
		</form>
			
			
	
	
	
	
	</div>
</div>


</body>
</html>
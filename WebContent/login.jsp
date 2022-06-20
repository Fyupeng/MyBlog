<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/cssstyle.css"/>

<script src="js/jquery-1.10.2.js"></script>

<style>
		
		body{
 			background-image: url("img/3.jpg");
 			background-repeat: no-repeat;
 			background-size: 100%;
 		}
		
        .bxs-row {
            margin-bottom:12px;
        }
        
        .logo-box {
        	background: url(img/4.gif);
        	background-repeat:no-repeat;
        	background-size:100%;
        	background-color:white;
            width:404px;
            margin-top:15%;
            margin-left:40%;
            border:1px solid #e5e5e5;
            border-radius:4px;
            box-shadow:0 4px 18px rgba(0,0,0,0.2);
            position:relative;
            overflow:hidden;
            height:330px;
        }
        .login {
            position:absolute;
            width:320px;left:0;
            top:0;
            padding: 42px 42px 36px;
            transition:all 0.8s;
        }
        .username,.password,.btn {
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
        .submit {
            background-color: #0070ba;
            color:#fff;
            border:1px solid #0070ba;
        }
        .submit:hover {
            background-color:#005ea6;
        }
        
</style>

</head>
<body>

			<%if( "loginError".equals(request.getAttribute("msg") ) ){%>
				<script>alert("账号或密码错误！")</script>
			<%} %>	

	<div class="logo-box">
		<div class="login">
			<div class="bxs-row" style="text-align:center;">
				<span class="tips" style="color:black;font-size:xx-large;">MyBlog</span>
			</div>
			
			<form action="${pageContext.request.contextPath}/LoginServlet" method="get">
			
				<div class="bxs-row">
					<input type="text" name="username" class="username" placeholder="用户名" value="admin">
				</div>
				
				<div class="bxs-row">
					<input type="password" name="password" class="password" placeholder="密码">
				</div>
				
				<div class="bxs-row">
					<input type="submit" class="submit btn" value="登录">
				</div>
				<ol>
					<li style="text-align: right; list-style: none; ">
						<a style="color:black" href="register.jsp" >未注册？点击注册</a>
					</li>
					
					<li style="text-align: right; list-style: none;">
						<a style="color:black" href="" >忘记账号或密码？</a>
					</li>
				</ol>
				
			</form>
		
		</div>
	</div>



</body>
</html>
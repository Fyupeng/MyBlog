<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
	
	body{
 			background-image: url("img/11.jpg");
 			background-repeat: no-repeat;
 			background-size: 100%;
 		}
	
	.btn{
		width:100%;
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
	
	.submit:hover{
	    background: #AADFFD;
	    border-color: #78C3F3;
	    color: #004974;
	    text-decoration: none;
	}
	.faceBacktext{
		width:97%;、
		font-size:xx-large;
		resize:none;
		border:2px solid blue;
		margin-top: 45%
	}

</style>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String msg = (String)request.getAttribute("msg");
		if("msg:thank_you_for_faceback".equals(msg)){
	%>		<script>alert("您的反馈我们已经收到,感谢参与反馈！")</script>
	<%
		}
	%>
	
	<div  align="center">
		<form action="${pageContext.request.contextPath}/AddFeedBackServlet" method="get">
			<div style="width:40%; height:900px;" >
				<textarea class="faceBacktext" rows="10px" cols="50px" name="message" placeholder="如果你体验过程中有不满意的，请给我们留言...."></textarea>
				<input type="submit" value="提交反馈" class="submit btn"/>
			</div>
		</form>
		
	</div>
	
	
	

</body>
</html>
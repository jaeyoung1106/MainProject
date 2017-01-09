<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="/style/resources/css/common.css">
<link rel="stylesheet" href="/style/resources/css/layout.css">
<link rel="stylesheet" href="/style/resources/css/sub.css">

<script>
    	function login(){
    		if(document.getElementById("id").value==""){
    			alert("아이디를 입력하세요.");
    			return false;
    		}
    		if(document.getElementById("password").value==""){
    			alert("비밀번호를 입력하세요");
    			return false;
    		}
    		var f = document.getElementById("loginForm");
    		f.submit();
    	}
    	
    	function register(){
    		
    	}
    </script>
</head>
<body>
	<div id="wrap" class="cf">


		<%--HEADER --%>
		<%@include file="/WEB-INF/views/pagePiece/header.jspf"%>

		<%--SECTION --%>
		<div id="section" class="cf">
			<div class="login_area cf">
				<h2>LOGIN</h2>
				<div class="login_box cf">
					<div class="left_cont">
						<form id="loginForm" action="login.do" method="post">
							<table class="tg_login">
								<tr>
									<th class="login-tg">ID</th>
									<td class="login-tg"><input type="text" id="id" name="id"></td>
								</tr>
								<tr>
									<th class="login-tg">PASSWROD</th>
									<td class="login-tg"><input type="password" id="password"
										name="password"></td>
								</tr>
							</table>
						</form>
						<div class="login_btn cf">
							<div class="btn01">
								<input type="image" src="" onclick="login()"> <input
									type="image" src="" onclick="register()">
								<div class="btn_lost">
									<a href="#l"><img src="" alt="ID찾기" class="fl"></a>
									<a href="#l"><img src="" alt="PW찾기" class="fr"></a>
								</div>
							</div>
						</div>
					</div>
					<div class="right_cont cf">
						<img src="" alt="로그인 배너">
					</div>
				</div>
			</div>
		</div>
	</div>


	<%--FOOTER --%>
	<div id="footer"></div>
	</div>

</body>
</html>
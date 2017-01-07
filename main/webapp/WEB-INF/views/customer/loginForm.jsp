<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<div id="article">
	<form id="loginForm" action="login.do" method="post">	
		아이디 : <input type="text" size="10" id="id" name="id"/>
		<br/>
		비밀번호 : <input type="password" size="10" id="pass" name="password"/>
		<br/>
		<input type="submit" value="로그인" id="login" />
		<input type="button" value="회원가입" id="register" onclick="window.location='registerForm.do'"/>
		<br/>
		<input type="button" value="아이디찾기" id="findID"/>
		<input type="button" value="비밀번호찾기" id="findPASS"/>
	</form>

</div>

</body>
</html>
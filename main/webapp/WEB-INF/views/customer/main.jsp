<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${loginCheck }">
			<h3>로그인 성공 여기는 메인페이지 입니다.</h3>
			<h3>받은파라미터 값(키값 : id 값 : ${id })</h3>
		</c:when>
		<c:otherwise>
			<h3>로그인 실패</h3>
			<h3>다시 로그인페이지로 이동합니다.</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>
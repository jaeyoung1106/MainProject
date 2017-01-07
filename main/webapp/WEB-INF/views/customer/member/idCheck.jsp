<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복확인</title>
</head>
<body>
	<div id="article">
		<table>
			<c:choose>
				<c:when test="${idCheck }">
					<tr>
					<th colspan="2">사용가능한 아이디입니다.</th>
					<tr>
					<td>${checkId }
					<td><input type="button" value="사용하기" onclick="javascript:self.close()"/>
				</c:when>
				<c:otherwise>
					<tr>
					<th>이미 사용중인 아이디입니다.</th>
					<tr>
					<td><input type="button" value="닫기" onclick="javascript:self.close()"/>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>
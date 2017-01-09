<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>

<link rel="stylesheet" href="/style/resources/css/common.css">
<link rel="stylesheet" href="/style/resources/css/layout.css">
<link rel="stylesheet" href="/style/resources/css/style.css">
</head>
<body>
	<div id="wrap" class="cf">

		<%--HEADER --%>
		<%@include file="/WEB-INF/views/pagePiece/header.jspf" %>

		<%--SECTION --%>
		<div id="section" class="cf">
			<div class="main_visual"></div>
			<div class="article cf">
				<div class="text_box">
					<p class="p01">FREE SHIPPING WORLWIDE</p>
					<h2>YEAR ROUND</h2>
					<div class="br"></div>
					<p class="p02">FREE SHIPPING WORLWIDE</p>
				</div>
				<div class="cont_area cf">
					<div class="cont_sub cont01"></div>
					<div class="cont_sub cont02"></div>
					<div class="cont_sub cont03"></div>
				</div>
			</div>
		</div>
		
		
		<%--FOOTER --%>
		<div id="footer"></div>
	</div>
</body>
</html>
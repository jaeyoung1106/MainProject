<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<div id="article">
		<form id="registerForm" action="WEB-INF/views/customer/test.jsp" method="post">
			<table>
				<tr>
				<td>아이디<td><input type="text" size="10" name="id">
							<input type="button" value="아이디중복확인"  onclick=""/>
				<tr>
				<td>비밀번호<td><input type="password" size="10" name="pass" >
				<tr>
				<td>비밀번호질문
				<td>
					 <input list="pass_quests" name="pass_quest"/>
						  <datalist id="pass_quests">
						    <option value="기억에 남는 추억의 장소는?">
						    <option value="자신의 인생 좌우명은?">
						    <option value="자신의 보물 제1호는?">
						    <option value="가장 기억에 남는 선생님 성함은?">
						    <option value="타인이 모르는 자신만의 신체비밀이 있다면?">
						    <option value="추억하고 싶은 날짜가 있다면?">
						    <option value="받았던 선물 중 기억에 남는 독특한 선물은?">
						    <option value="유년시절 가장 생각나는 친구 이름은?">
						    <option value="인상 깊게 읽은 책 이름은?">
						  </datalist>
				<tr>
				<td>비밀번호답변<td><input type="text" size="15" name="pass_answer" />
				<tr>
				<td>이름<td><input type="text" size="10" name="name" />
				<tr>
				<td>우편번호<td><input type="text" size="10" name="zipcode" >
							<input type="button" value="우편번호검색" onclick=""/>
				<tr>
				<td>주소<td><input type="text" size="20" name="address1" />
				<tr>
				<td>상세주소<td><input type="text" size="20" name="address2" />
				<tr>
				<td>이메일<td><input type="text" size="15" name="email" />
						<td><input type="button" value="이메일 인증" onclick=""/>
						<!-- 인증버튼 클릭하면 text/ 시간표시 요소/ 인증확인 버튼 추가 -->
				<tr>
				<td>생일<td><input type="text" name="birth"/>
				<tr>
				<td>체형<td><input type="radio" name="body" value="마른" checked>마른&nbsp;<input type="radio" name="body" value="뚱뚱">뚱뚱
				<tr>
				<td>키<td><input type="text" name="height" value="160" size="3"/> CM
				<tr>
				<td>성별<td><input type="radio" name="gender" value="1" checked>남자&nbsp;
							<input type="radio" name="gender" value="2" >여자
						
				<tr><td><input type="submit" value="회원가입"/><td><input type="button" value="취소" onclick="window.history.go(-1)"/>		
			</table>
		</form>
	</div>
</body>
</html>
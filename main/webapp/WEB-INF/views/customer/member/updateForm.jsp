<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 비밀번호 재확인</title>
<script>
	function deleteMember(){
		if(document.getElementById("password").value==""){
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		window.location="/style/deleteMember.do";
	}
</script>
</head>
<body>
	<div id="article">
		<c:choose>
			<%--비밀번호 재확인 미인증상태 --%>
			<c:when test="${repassCheck}">
				<form id="updateForm" action="updateForm.do" method="post">
					<input type="hidden" name="repassCheck" value="0" />
					<!-- 같은 페이지 내부 인증상태표시 -->
					<table>
						<tr>
							<td>아이디
							<td><input type="text" size="10" name="id" value="${member.id }" readonly> <input
								type="button" value="아이디중복확인" onclick="" />
						<tr>
							<td>비밀번호
							<td><input type="password" id="password" size="10" name="password" required/>
						<tr>
							<td>비밀번호질문
							<td><select name="pass_quest">
									<option selected>-----------선택----------------</option>
									<option value="기억에 남는 추억의 장소는?">기억에 남는 추억의 장소는?</option>
									<option value="자신의 인생 좌우명은?">자신의 인생 좌우명은?</option>
									<option value="자신의 보물 제1호는?">자신의 보물 제1호는?</option>
									<option value="가장 기억에 남는 선생님 성함은?">가장 기억에 남는 선생님 성함은?</option>
									<option value="타인이 모르는 자신만의 신체비밀이 있다면?">타인이 모르는 자신만의
										신체비밀이 있다면?</option>
									<option value="추억하고 싶은 날짜가 있다면?">추억하고 싶은 날짜가 있다면?</option>
									<option value="받았던 선물 중 기억에 남는 독특한 선물은?">받았던 선물 중 기억에
										남는 독특한 선물은?</option>
									<option value="유년시절 가장 생각나는 친구 이름은?">유년시절 가장 생각나는 친구
										이름은?</option>
									<option value="인상 깊게 읽은 책 이름은?">인상 깊게 읽은 책 이름은?</option>
							</select>
						<tr>
							<td>비밀번호답변
							<td><input type="text" size="15" name="pass_answer" value="${member.pass_answer }" />
						<tr>
							<td>이름
							<td><input type="text" size="10" name="name" value="${member.name }" readonly/>
						<tr>
							<td>우편번호
							<td><input type="text" size="10" name="zipcode" value="${member.zipcode }" > <input
								type="button" value="우편번호검색" onclick="" />
						<tr>
							<td>주소
							<td><input type="text" size="20" name="address1" value="${member.address1 }"/>
						<tr>
							<td>상세주소
							<td><input type="text" size="20" name="address2" value="${member.address2 }"/>
						<tr>
							<td>이메일
							<td><input type="email" size="15" name="email" value="${member.email }" readonly/>
							<td><input type="button" value="이메일 인증" onclick="" /> <!-- 인증버튼 클릭하면 text/ 시간표시 요소/ 인증확인 버튼 추가 -->
						<tr>
							<td>생일
							<td><input type="date" name="birth"/>
						<tr>
							<td>체형
							<td><input type="radio" name="body" value="마른" checked>마른&nbsp;
								<input type="radio" name="body" value="뚱뚱">뚱뚱
						<tr>
							<td>키
							<td><input type="text" name="height" value="160" size="3" value="${member.height }" readonly/>
								CM
						<tr>
							<td>성별
							<td><input type="radio" name="gender" value="1" checked>남자&nbsp;
								<input type="radio" name="gender" value="2">여자
						<tr>
							<td><input type="submit" value="정보수정" />
							<td><input type="button" value="취소"
								onclick="window.history.go(-1)" />
						<tr>
						<td colspan="2"><input type="button" value="회원탈퇴" onclick="deleteMember()"/> 
					</table>
				</form>
			</c:when>

			<%--비밀번호 재확인 인증상태 --%>
			<c:otherwise>
				<form id="memberCheck" action="updateForm.do" method="post">
					<input type="hidden" name="repassCheck" value="1" />
					<!-- 같은 페이지 내부 비밀번호 재확인 미인증상태표시 -->
					<table>
						<tr>
							<th colspan="2">비밀번호 재확인
						<tr>
							<td>비밀번호 :
							<td><input type="password" name="repassword" size="10"
								required />
						<tr>
							<td><input type="submit" value="확인" />
							<td><input type="button" value="뒤로가기"
								onclick="window.history.go(-1)" />
					</table>
				</form>

			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
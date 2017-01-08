<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function idCheck(id) {
		var url = "idCheck.do?id=" + id;
		window.open(url, "post", "width=300,height=150");
	}

	function openDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('address1').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('address2').focus();
					}
				}).open();
	}
</script>
</head>
<body>
	<div id="article">
		<form id="registerForm" action="register.do" method="post">
			<table>
				<tr>
					<td>아이디
					<td><input type="text" size="10" name="id"> <input
						type="button" value="아이디중복확인"
						onclick="idCheck(this.form.id.value)" />
				<tr>
					<td>비밀번호
					<td><input type="password" size="10" name="password">
				<tr>
					<td>비밀번호질문
					<td><select name="pass_quest">
							<option selected>-----------선택----------------</option>
							<option value="기억에 남는 추억의 장소는?">기억에 남는 추억의 장소는?</option>
							<option value="자신의 인생 좌우명은?">자신의 인생 좌우명은?</option>
							<option value="자신의 보물 제1호는?">자신의 보물 제1호는?</option>
							<option value="가장 기억에 남는 선생님 성함은?">가장 기억에 남는 선생님 성함은?</option>
							<option value="타인이 모르는 자신만의 신체비밀이 있다면?">타인이 모르는 자신만의 신체비밀이 있다면?</option>
							<option value="추억하고 싶은 날짜가 있다면?">추억하고 싶은 날짜가 있다면?</option>
							<option value="받았던 선물 중 기억에 남는 독특한 선물은?">받았던 선물 중 기억에 남는 독특한 선물은?</option>
							<option value="유년시절 가장 생각나는 친구 이름은?">유년시절 가장 생각나는 친구 이름은?</option>
							<option value="인상 깊게 읽은 책 이름은?">인상 깊게 읽은 책 이름은?</option>
					</select>
				<tr>
					<td>비밀번호답변
					<td><input type="text" size="15" name="pass_answer" />
				<tr>
					<td>이름
					<td><input type="text" size="10" name="name" />
				<tr>
					<td>우편번호
					<td><input type="text" size="10" id="zipcode" name="zipcode">
					<input type="button" value="우편번호검색" onclick="openDaumPostcode()" />
				<tr>
					<td>주소
					<td><input type="text" size="20" id="address1" name="address1" />
				<tr>
					<td>상세주소
					<td><input type="text" size="20" id="address2" name="address2" />
				<tr>
					<td>이메일
					<td><input type="email" size="15" name="email" />
					<td><input type="button" value="이메일 인증" onclick="" /> <!-- 인증버튼 클릭하면 text/ 시간표시 요소/ 인증확인 버튼 추가 -->
				<tr>
					<td>생일
					<td><input type="date" name="birth" />
				<tr>
					<td>체형
					<td><input type="radio" name="body" value="마른" checked>마른&nbsp;
						<input type="radio" name="body" value="뚱뚱">뚱뚱
				<tr>
					<td>키
					<td><input type="text" name="height" value="160" size="3" />
						CM
				<tr>
					<td>성별
					<td><input type="radio" name="gender" value="1" checked>남자&nbsp;
						<input type="radio" name="gender" value="2">여자
				<tr>
					<td><input type="submit" value="회원가입" />
					<td><input type="button" value="취소"
						onclick="window.history.go(-1)" />
			</table>
		</form>
	</div>
</body>
</html>
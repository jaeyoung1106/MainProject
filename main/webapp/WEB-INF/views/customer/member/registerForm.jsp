<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="/style/resources/css/common.css">
<link rel="stylesheet" href="/style/resources/css/layout.css">
<link rel="stylesheet" href="/style/resources/css/sub.css">
<script>

	function addMember(){
	
		var f=document.getElementById("registerForm");
		
		if(f.id.value==""){
			alert("아이디를 입력하세요");	f.id.focus();
			return false;
		}
		if(f.password.value==""){
			alert("비밀번호를 입력하세요"); f.password.focus();
			return false;
		}
		if(f.repassword.value==""){
			alert("비밀번호확인을 입력하세요"); f.repassword.focus();
			return false;
		}
		if(f.password.value!=f.repassword.value){
			alert("비밀번호 확인 실패!"); f.repassword.focus();
			return false;
		}
		if(f.pass_quest.value=="."){
			alert("비밀번호질문을 선택하세요"); f.pass_quest.focus();
			return false;
		}
		if(f.pass_answer.value==""){
			alert("비밀번호답변을 입력하세요"); f.pass_answer.focus();
			return false;
		}
		if(f.name.value==""){
			alert("이름을 입력하세요"); f.name.focus();
			return false;
		}
		if(f.email.value==""){
			alert("이메일을 입력하세요"); f.email.focus();
			return false;
		}
		if(f.gender.value=="."){
			alert("성별을 선택하세요"); f.pass_quest.focus();
			return false;
		}
		if(f.birth.value==""){
			alert("생일을 선택하세요");	f.birth.focus();
			return false;
		}
		f.submit();
	}

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
	<div id="wrap" class="cf">


		<%--HEADER --%>
		<%@include file="/WEB-INF/views/pagePiece/header.jspf"%>

		<%--SECTION --%>
		<div id="section" class="cf">
			<div class="sub_visual"></div>
			<div class="join_area cf">
				<h2>JOIN</h2>
				<div id="join_main" class="cf">
					<h3>기본정보</h3>
					<div id="join_input1" class="cf">
						<form id="emailForm" action="emailCheck.do" method="post">
						<input type="email" name="email" alt="이메일" class="text_email1"/>
										<input type="submit" value="이메일인증"/>
						</form>
						<form id="registerForm" action="register.do" method="post">
							<table>
								<tr>
									<td class="join_td1 fl"><span>*</span> 아이디</td>
									<td class="join_td2">
										<input type="text" name="id" alt="아이디" class="text_id" />
										<input type="button" name="id_BTN" alt="중복확인" value="중복확인" onclick="idCheck(this.form.id.value)" class="id_btn" /></td>
								</tr>
								<tr>
									<td class="join_td1_pwd fl"><span>*</span> 비밀번호</td>
									<td class="join_td2_pwd"><input type="password" name="password" alt="비밀번호" class="text_pwd" /></td>
								</tr>
								<tr>
									<td class="join_td1 fl"><span>*</span> 비밀번호 확인</td>
									<td class="join_td2"><input type="password" name="repassword" alt="비밀번호" class="text_pwd" /></td>
								</tr>
								<tr>
									<td class="join_td1 fl"><span>*</span> 비밀번호 질문</td>
									<td class="join_td2">
										<select name="pass_quest">
												<option value="." selected>-----------선택----------------</option>
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
									</td>
								</tr>
								<tr>
									<td class="join_td1 fl"><span>*</span> 비밀번호 답변</td>
									<td class="join_td2"><input type="text" name="pass_answer">
									</td>
								</tr>

								<tr>
									<td class="join_td1 fl"><span>*</span> 이름</td>
									<td class="join_td2"><input type="text" name="name" alt="이름" class="text_name" /></td>
								</tr>
								<tr>
									<td class="join_td1_add fl"><span>*</span> 주소</td>
									<td class="join_td2_add">
										<input type="text" id="zipcode" name="zipcode" alt="주소" class="text_add" />
										<input type="button" name="add_BTN" alt="우편번호 찾기" value="우편번호 찾기" onclick="openDaumPostcode()" class="add_btn" />
										<input type="text" id="address1" name="address1" alt="주소" class="text_add2" />
										<input type="text" id="address2" name="address2" alt="주소" class="text_add2" />
									</td>
								</tr>
								<tr>
									<td class="join_td1 fl"><span>*</span> 이메일</td>
									<td class="join_td2">
										<input type="email" name="email" alt="이메일" class="text_email1"/>
										<input type="button" value="이메일인증" onclick=""/>
								</tr>
								<tr>
									<td class="join_td1 fl"><span>*</span> 성별</td>
									<td class="join_td2">
										<select name="gender" alt="성별" class="select_sex">
												<option value=".">선택</option>
												<option value="1">남자</option>
												<option value="0">여자</option>
										</select>
									</td>
								</tr>
								<tr>
									<td class="join_td1 fl"><span>*</span> 생년월일</td>
									<td class="join_td2"><input type="date" name="birth" /></td>
								</tr>
								<tr>
									<td class="join_td1 fl"><span>*</span> 체형
									<td class="join_td2">
										<input type="radio" name="body" value="마른" checked>마른&nbsp;
										<input type="radio" name="body" value="뚱뚱">뚱뚱</td>
								<tr>
									<td class="join_td1 fl"><span>*</span> 키
									<td class="join_td2" style="width=700px;"><input type="number" name="height" min="150" max="210" value="160" size="3" /> CM
							</table>
						</form>
					</div>
					<!-- id="join_input1" -->
					<div class="join_btn">
						<input type="button" alt="회원가입" value="회원가입" onclick="addMember()" class="add_btn">
						<input type="button" alt="취소" value="취소" onclick="window.history.go(-1)" class="add_btn">
					</div>
				</div>
				<!--  id="join_main" -->

			</div>
		</div>
	</div>


	<%--SECTION --%>
	<div id="footer"></div>
</body>
</html>
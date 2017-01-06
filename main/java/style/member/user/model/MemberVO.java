package style.member.user.model;

import java.sql.Date;

public class MemberVO {
	private String id;//회원아이디
	private String password;//회원 비밀번호
	private String pass_quest;//비밀번호 질문
	private String pass_answer;//비밀번호 답변
	private String name;//회원 이름
	private char zipcode;//우편번호
	private String address1;//주소1
	private String address2;//상세주소
	private String email;//이메일
	private Date birth;//생년월일
	private String body;//체형
	private int height;//키
	private int gender;//성별
	private int point;//보유 포인트
	private Date regdate;//등록날짜
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPass_quest() {
		return pass_quest;
	}
	public void setPass_quest(String pass_quest) {
		this.pass_quest = pass_quest;
	}
	public String getPass_answer() {
		return pass_answer;
	}
	public void setPass_answer(String pass_answer) {
		this.pass_answer = pass_answer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getZipcode() {
		return zipcode;
	}
	public void setZipcode(char zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}

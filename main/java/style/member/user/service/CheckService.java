package style.member.user.service;

public interface CheckService {
	Integer idCheck(String id);//아이디 중복체크
	Integer checkEmail(String to);//이메일 중복체크
	String sendEmail(String to);//이메일 보내기
}

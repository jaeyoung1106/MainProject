package style.member.user.dao;

public interface CheckDao {
	int idCheck(String id);//아이디 중복체크
	int checkEmail(String to);//이메일 중복체크
}

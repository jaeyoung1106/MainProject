package style.member.user.service;

public interface CheckService {
	Integer idCheck(String id);//���̵� �ߺ�üũ
	Integer checkEmail(String to);//�̸��� �ߺ�üũ
	String sendEmail(String to);//�̸��� ������
}

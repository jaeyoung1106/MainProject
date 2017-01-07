package style.member.user.service;

import style.member.user.model.MemberVO;

public interface UpdateService {
	String checkMember(String id);
	Integer updateUserInfo(MemberVO member);
}

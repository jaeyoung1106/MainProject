package style.member.user.service;

import style.member.user.model.MemberVO;

public interface LoginService {
	MemberVO getUserInfo(String id);
}

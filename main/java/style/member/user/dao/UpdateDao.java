package style.member.user.dao;

import style.member.user.model.MemberVO;

public interface UpdateDao {
	String checkMember(String id);
	int updateUserInfo(MemberVO member);
}

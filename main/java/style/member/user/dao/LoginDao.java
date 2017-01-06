package style.member.user.dao;

import style.member.user.model.MemberVO;

public interface LoginDao {
	MemberVO getUserInfo(String id);
}

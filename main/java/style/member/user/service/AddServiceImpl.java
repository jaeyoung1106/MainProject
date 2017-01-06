package style.member.user.service;

import style.member.user.dao.AddDao;
import style.member.user.model.MemberVO;

public class AddServiceImpl implements AddService {
	//Dao 선언
	private AddDao addDao;
	//Dao 주입
	public void setAddDao(AddDao addDao) {
		this.addDao = addDao;
	}
	@Override
	public Integer addUserInfo(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return addDao.addUserInfo(memberVo);
	}
	
}

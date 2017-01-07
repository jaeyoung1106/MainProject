package style.member.user.service;

import style.member.user.dao.UpdateDao;
import style.member.user.model.MemberVO;

public class UpdateServiceImpl implements UpdateService {
	//Dao 선언
	private UpdateDao updateDao;
	//Dao 주입
	public void setUpdateDao(UpdateDao updateDao) {
		this.updateDao = updateDao;
	}
	
	@Override
	public String checkMember(String id) {
		// TODO Auto-generated method stub
		System.out.println("Service 접");
		return updateDao.checkMember(id);
	}

	@Override
	public Integer updateUserInfo(MemberVO member) {
		// TODO Auto-generated method stub
		System.out.println("Service 접");
		return updateDao.updateUserInfo(member);
	}


}

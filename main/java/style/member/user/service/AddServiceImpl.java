package style.member.user.service;


import style.member.user.dao.AddDao;
import style.member.user.model.MemberVO;

public class AddServiceImpl implements AddService {
	//Dao ����
	private AddDao addDao;
	//Dao ����
	public void setAddDao(AddDao addDao) {
		this.addDao = addDao;
	}
	@Override
	public Integer addUserInfo(MemberVO memberVo) {
		// TODO Auto-generated method stub
		System.out.println("Service ��");
		return addDao.addUserInfo(memberVo);
	}
	
}

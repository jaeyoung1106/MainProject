package style.member.user.service;

import style.member.user.dao.LoginDao;
import style.member.user.model.MemberVO;

public class LoginServiceImpl implements LoginService {
	//Dao 선언
	private LoginDao loginDao;
	//Dao 주입
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public MemberVO getUserInfo(String id) {
		// TODO Auto-generated method stub
		return loginDao.getUserInfo(id); 
	}




}

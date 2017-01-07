package style.member.user.service;

import style.member.user.dao.CheckDao;

public class CheckServiceImpl implements CheckService {
	//Dao선언
	private CheckDao checkDao;
	//Dao주입
	public void setCheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}

	@Override
	public Integer idCheck(String id) {
		// TODO Auto-generated method stub
		System.out.println("Service 접");
		return checkDao.idCheck(id);
	}

}

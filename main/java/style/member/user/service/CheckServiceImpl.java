package style.member.user.service;

import style.member.user.dao.CheckDao;

public class CheckServiceImpl implements CheckService {
	//Dao����
	private CheckDao checkDao;
	//Dao����
	public void setCheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}

	@Override
	public Integer idCheck(String id) {
		// TODO Auto-generated method stub
		System.out.println("Service ��");
		return checkDao.idCheck(id);
	}

}

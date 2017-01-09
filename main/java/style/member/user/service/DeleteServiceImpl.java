package style.member.user.service;

import style.member.user.dao.DeleteDao;

public class DeleteServiceImpl implements DeleteService{
	//Dao 선언
	private DeleteDao deleteDao;
	//Dao 주입
	public void setDeleteDao(DeleteDao deleteDao) {
		this.deleteDao = deleteDao;
	}
	
	@Override
	public Integer deleteMember(String id) {
		// TODO Auto-generated method stub
		System.out.println("Service 접");
		return deleteDao.deleteMember(id);
	}




}

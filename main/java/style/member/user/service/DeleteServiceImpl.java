package style.member.user.service;

import style.member.user.dao.DeleteDao;

public class DeleteServiceImpl implements DeleteService{
	//Dao ����
	private DeleteDao deleteDao;
	//Dao ����
	public void setDeleteDao(DeleteDao deleteDao) {
		this.deleteDao = deleteDao;
	}
	
	@Override
	public Integer deleteMember(String id) {
		// TODO Auto-generated method stub
		System.out.println("Service ��");
		return deleteDao.deleteMember(id);
	}




}

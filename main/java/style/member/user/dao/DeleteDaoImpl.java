package style.member.user.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class DeleteDaoImpl implements DeleteDao {
	//sqlSessionTemplate ����
	private SqlSessionTemplate sqlSession;
	//sqlSessionTemplate ����
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//���ӽ����̽� ����
	String namespace = "style.member.user.dao.userMember.";
	
	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		System.out.println("Dao ��");
		return sqlSession.delete(namespace+"deleteUserInfo",id);
	}

}

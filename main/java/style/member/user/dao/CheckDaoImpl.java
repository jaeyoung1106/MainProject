package style.member.user.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class CheckDaoImpl implements CheckDao {
	//SqlSessionTemplate ����
	private SqlSessionTemplate sqlSession;
	//SqlSessionTemplate ����
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//���ӽ����̽� ����
	String namespace="style.member.user.dao.userMember.";
	
	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		System.out.println("Dao ��");
		
		return sqlSession.selectOne(namespace+"idCheck",id);
	}


	

}

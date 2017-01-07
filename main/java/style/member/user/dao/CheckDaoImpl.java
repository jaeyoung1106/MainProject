package style.member.user.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class CheckDaoImpl implements CheckDao {
	//SqlSessionTemplate 선언
	private SqlSessionTemplate sqlSession;
	//SqlSessionTemplate 주입
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//네임스페이스 선언
	String namespace="style.member.user.dao.userMember.";
	
	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		System.out.println("Dao 접");
		
		return sqlSession.selectOne(namespace+"idCheck",id);
	}


	

}

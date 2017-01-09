package style.member.user.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class DeleteDaoImpl implements DeleteDao {
	//sqlSessionTemplate 선언
	private SqlSessionTemplate sqlSession;
	//sqlSessionTemplate 주입
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//네임스페이스 선언
	String namespace = "style.member.user.dao.userMember.";
	
	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		System.out.println("Dao 접");
		return sqlSession.delete(namespace+"deleteUserInfo",id);
	}

}

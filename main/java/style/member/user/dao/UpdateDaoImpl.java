package style.member.user.dao;

import org.mybatis.spring.SqlSessionTemplate;

import style.member.user.model.MemberVO;

public class UpdateDaoImpl implements UpdateDao {
	//sqlSessionTemplate 선언
	private SqlSessionTemplate sqlSession;
	//sqlSessionTmeplate 주입
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	//네임스페이스 선언
	String namespace = "style.member.user.dao.userMember.";
	
	@Override
	public String checkMember(String id) {
		// TODO Auto-generated method stub
		System.out.println("Dao 접");
		return sqlSession.selectOne(namespace+"checkMember",id);
	}

	@Override
	public int updateUserInfo(MemberVO member) {
		// TODO Auto-generated method stub
		System.out.println("Dao 접");
		return sqlSession.update(namespace+"updateUserInfo",member);
	}

}

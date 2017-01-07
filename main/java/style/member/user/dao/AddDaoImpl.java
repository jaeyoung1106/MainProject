package style.member.user.dao;


import org.mybatis.spring.SqlSessionTemplate;

import style.member.user.model.MemberVO;

public class AddDaoImpl implements AddDao {
	//SqlSession 선언
	private SqlSessionTemplate sqlSession;
	//SqlSesson 주입
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//네임스페이스 선언
	String namespace="style.member.user.dao.userMember.";
	
	@Override
	public int addUserInfo(MemberVO memberVo) {
		// TODO Auto-generated method stub
		System.out.println("Dao 접");

		return sqlSession.insert(namespace+"insertMemberInfo",memberVo);
	
	}
	




}

package style.member.user.dao;

import org.mybatis.spring.SqlSessionTemplate;

import style.member.user.model.MemberVO;

public class AddDaoImpl implements AddDao {
	//SqlSession ����
	private SqlSessionTemplate sqlSession;
	//SqlSesson ����
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	String namespace="style.member.user.dao.userMember.";
	
	@Override
	public int addUserInfo(MemberVO memberVo) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert(namespace+"insertMemberInfo",memberVo);
	
	}
	




}

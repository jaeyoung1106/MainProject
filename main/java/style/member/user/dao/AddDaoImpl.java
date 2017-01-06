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
	
	
	@Override
	public int addUserInfo(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return 0;
		//퀴리문 작성 파일작성하기 
	
	}
	




}

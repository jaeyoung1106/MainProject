package style.member.user.dao;

import org.mybatis.spring.SqlSessionTemplate;

import style.member.user.model.MemberVO;

public class UpdateDaoImpl implements UpdateDao {
	//sqlSessionTemplate ����
	private SqlSessionTemplate sqlSession;
	//sqlSessionTmeplate ����
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	//���ӽ����̽� ����
	String namespace = "style.member.user.dao.userMember.";
	
	@Override
	public String checkMember(String id) {
		// TODO Auto-generated method stub
		System.out.println("Dao ��");
		return sqlSession.selectOne(namespace+"checkMember",id);
	}

	@Override
	public int updateUserInfo(MemberVO member) {
		// TODO Auto-generated method stub
		System.out.println("Dao ��");
		return sqlSession.update(namespace+"updateUserInfo",member);
	}

}

package org.kyunam.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kyunam.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kyunam.mapper.MemberMapper";
	
	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertMember", vo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getAllMember");
	}

}

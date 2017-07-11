package org.kyunam.dao;

import java.util.List;

import org.kyunam.domain.MemberVO;

public interface MemberDAO {
	public void insertMember(MemberVO vo);
	public List<MemberVO> getAllMember();
}

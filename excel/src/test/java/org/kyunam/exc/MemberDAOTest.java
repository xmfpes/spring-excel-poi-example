package org.kyunam.exc;

import java.sql.Connection;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kyunam.dao.MemberDAO;
import org.kyunam.domain.MemberVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO dao;

	@Test
	public void testInsertMember() throws Exception{
		
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		vo.setEmail("user00@aaa.com");
		
		dao.insertMember(vo);
	}
}
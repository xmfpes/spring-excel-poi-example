package org.kyunam.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.kyunam.dao.MemberDAO;
import org.kyunam.domain.MemberVO;
import org.kyunam.util.ExcelRead;
import org.kyunam.util.ExcelReadOption;
import org.kyunam.util.ExportExcel;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public void insertMemberExcel(File destFile) throws Exception {
		// TODO Auto-generated method stub
		
		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		excelReadOption.setOutputColumns("A","B","C","D");
		excelReadOption.setStartRow(2);
		
		List<Map<String, String>>excelContent =ExcelRead.read(excelReadOption);

		for(Map<String, String> article: excelContent){
			MemberVO vo = new MemberVO();
			vo.setUserid(article.get("A"));
			vo.setUserpw(article.get("B"));
			vo.setUsername(article.get("C"));
			vo.setEmail(article.get("D"));
			dao.insertMember(vo);
		}
		
	}

	@Override
	public XSSFWorkbook getAllMemberExcel() throws Exception {
		// TODO Auto-generated method stub
		List<MemberVO> memberlist = dao.getAllMember();
		return ExportExcel.createExcel(memberlist, "memberList");
		
	}

}

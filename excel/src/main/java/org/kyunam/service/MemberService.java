package org.kyunam.service;

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface MemberService {
	public void insertMemberExcel(File destFile) throws Exception;
	public XSSFWorkbook getAllMemberExcel() throws Exception;
}

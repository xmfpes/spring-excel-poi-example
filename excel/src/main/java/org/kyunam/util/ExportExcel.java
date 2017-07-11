package org.kyunam.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.kyunam.domain.MemberVO;

public class ExportExcel {
	public static XSSFWorkbook createExcel(List<MemberVO> memberlist, String excelName) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet worksheet = null;
		XSSFRow row = null;
		if(excelName.equals("memberList")){
			worksheet = workbook.createSheet("haha WorkSheet");

			row = worksheet.createRow(0);
			row.createCell(0).setCellValue("userid");
			row.createCell(1).setCellValue("userpw");
			row.createCell(2).setCellValue("username");
			row.createCell(3).setCellValue("email");
			
			for(int i=1; i<memberlist.size()+1; i++){
				row = worksheet.createRow(i);
				row.createCell(0).setCellValue(memberlist.get(i-1).getUserid());
				row.createCell(1).setCellValue(memberlist.get(i-1).getUserpw());
				row.createCell(2).setCellValue(memberlist.get(i-1).getUsername());
				row.createCell(3).setCellValue(memberlist.get(i-1).getEmail());
			}
		}

		return workbook;
	}
}

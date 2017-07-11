package org.kyunam.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileType {
	//엑셀 파일을 읽어 xls, xlsx 확장자를 구분해주는 코드
	public static Workbook getWorkbook(String filePath) {

		//FileInputStream을 통해 해당 경로의 파일을 가져옴
		//파일이 없으면 Exception 발생
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Workbook wb = null;

		/*
		 * 파일의 확장자를 체크해서 .XLS 라면 HSSFWorkbook에
		 * .XLSX라면 XSSFWorkbook에 각각 초기화 한다.
		 */
		if(filePath.toUpperCase().endsWith(".XLS")) {
			try {
				wb = new HSSFWorkbook(fis);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		else if(filePath.toUpperCase().endsWith(".XLSX")) {
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}

		return wb;

	}
}

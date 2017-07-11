package org.kyunam.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelRead {
	public static List<Map<String, String>> read(ExcelReadOption excelReadOption) {
		//엑셀 파일 자체
		//엑셀파일을 읽어 들인다.
		//FileType.getWorkbook() <-- 파일의 확장자에 따라서 적절하게 가져온다.
		Workbook wb = ExcelFileType.getWorkbook(excelReadOption.getFilePath());

		int sheetNum = wb.getNumberOfSheets(); //시트의 수를 가져오기 위한 변수 
		int numOfCells = 0;

		Row row = null;
		Cell cell = null;

		String cellName = "";

		//Row(한 행)의 값을 저장할 Map 객체
		Map<String, String> map = null;

		//List에는 한 Row씩 저장한다. (행이 3개인 경우 3개의 Map 저장)
		List<Map<String, String>> result = new ArrayList<Map<String, String>>(); 
		
		//엑셀의 시트수에 따라 반복문 연산 sheet 1만 존재 = 1번 
		for(int i =0; i<sheetNum; i++){
			System.out.println("Sheet 이름: "+ wb.getSheetName(i));
			//i번째에 해당하는 시트를 가져와 sheet에 저장
			Sheet sheet = wb.getSheetAt(i);
			//시트의 행의 수를 가져온다.
			int numOfRows = sheet.getPhysicalNumberOfRows();
			//행의 갯수만큼 반복문을 돌려 한 행씩 받아온다.
			//StartRow 값을 이용해 시작 행 지정(제목이 1행인 경우 2행부터 데이터를 가져올 수 있음)
			for(int rowIndex = excelReadOption.getStartRow() - 1; rowIndex < numOfRows; rowIndex++) {
				//시트에서 rowIndex의 Row값을 가져온다. 여러개의 cell 값을 가짐
				row = sheet.getRow(rowIndex);
				if(row != null) {
					//Row의 셀 개수 연산
					numOfCells = row.getLastCellNum();
					//Row의 값을 담을 맵 객체 초기화
					map = new HashMap<String, String>();
					//담긴 cell의 개수만큼 반복
					for(int cellIndex = 0; cellIndex < numOfCells; cellIndex++) {
						//row의 각 셀값을 하나씩 가져온다.
						cell = row.getCell(cellIndex);
						//현재 셀의 컬럼 이름 확인 Ex) A, B, C, D 현재 A B C D 4개의 행을 추출하기 위해 옵션값을 준 상태
						cellName = ExcelCellRef.getName(cell, cellIndex);
						//추출 대상 컬럼이 아닌 경우 map 객체에 데이터를 담지 않고 해당 셀은 생략한다.
						if( !excelReadOption.getOutputColumns().contains(cellName) ) {
							continue;
						}
						//cell의 이름을 키 값으로 데이터를 담는다.
						map.put(cellName, ExcelCellRef.getValue(cell));
					}
					//만들어진 한 행의 값을 가진 Map 객체를 List에 삽입한다.
					result.add(map);   
				}
			}
		}
		return result;       
	}      

}

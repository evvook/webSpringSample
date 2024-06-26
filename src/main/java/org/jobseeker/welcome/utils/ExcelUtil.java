package org.jobseeker.welcome.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

//https://sowon-dev.github.io/2021/08/09/210810Spring-excel/
public class ExcelUtil {
	
	// 각 셀의 데이터타입에 맞게 값 가져오기
	public String getCellValue(XSSFCell cell) {

		String value = "";
		
		if(cell == null){
			return value;
		}

		switch (cell.getCellType()) {
			case STRING:
				value = cell.getStringCellValue();
				break;
			case NUMERIC:
				if(isInteger(cell.getNumericCellValue())) {
					value = (long)cell.getNumericCellValue()+"";
				}else {
					value = cell.getNumericCellValue()+"";
				}
				break;
			default:
				break;
		}
		return value;
	}
	
	public boolean isInteger(double num) {
		return num % 1 == 0.0;
	}

	// 엑셀파일의 데이터 목록 가져오기 (파라미터들은 위에서 설명함)
	public List<Map<String, Object>> getListData(MultipartFile file, int startRowNum, int columnLength) {

		List<Map<String, Object>> excelList = new ArrayList<Map<String,Object>>();
		
		try {
			OPCPackage opcPackage = OPCPackage.open(file.getInputStream());

			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);

			// 첫번째 시트
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowIndex = 0;
			int columnIndex = 0;

			// 첫번째 행(0)은 컬럼 명이기 때문에 두번째 행(1) 부터 검색
			for (rowIndex = startRowNum; rowIndex < sheet.getLastRowNum() + 1; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);

				// 빈 행은 Skip
				if (row.getCell(0) != null && !row.getCell(0).toString().isBlank()) {

					Map<String, Object> map = new HashMap<String, Object>();

					int cells = columnLength;

					for (columnIndex = 0; columnIndex <= cells; columnIndex++) {
						XSSFCell cell = row.getCell(columnIndex);
						map.put(String.valueOf(columnIndex), getCellValue(cell));
						//System.out.println(rowIndex + " 행 : " + columnIndex+ " 열 = " + getCellValue(cell));
					}
					
					excelList.add(map);
				}
			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return excelList;
	}
}

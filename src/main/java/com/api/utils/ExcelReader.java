package com.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * ExcelReader class helps to read data from exteral source i.e from excel.
 *
 * @author Ashok
 *
 */
public class ExcelReader {
	private static XSSFSheet excelSheet;
	private static XSSFWorkbook excelWorkbook;
	private static XSSFCell cell;
	private static String sheetPath = PropertiesFile.getProperty("test.data.path")
			+ PropertiesFile.getProperty("excel.name");
	private static String sheetName = PropertiesFile.getProperty("sheet.name");
	private static final Logger LOG = LogManager.getLogger(ExcelReader.class);
	private static Object res;

	private static void setExcelFile() throws IOException {
		LOG.info("Getting sheets from the workbook.");
		FileInputStream excelFile = new FileInputStream(new File(sheetPath).getAbsolutePath());
		excelWorkbook = new XSSFWorkbook(excelFile);
		excelSheet = excelWorkbook.getSheet(sheetName);
	}

	private static int getDataRow(String dataKey, int dataColumn) {
		int rowCount = excelSheet.getLastRowNum();
		for (int row = 0; row <= rowCount; row++) {
			if (ExcelReader.getCellData(row, dataColumn).equalsIgnoreCase(dataKey)) {
				return row;
			}
		}
		return 0;
	}

	private static String getCellData(int rowNumb, int colNumb) {
		cell = excelSheet.getRow(rowNumb).getCell(colNumb);
		// LOG.info("Getting cell data.");
		if (cell.getCellType() == CellType.NUMERIC) {
			cell.setCellType(CellType.STRING);
		}
		String cellData = cell.getStringCellValue();
		return cellData;
	}

	@SuppressWarnings("unchecked")
	public static Object getData(String dataKey) throws Exception {
		Map dataMap = new HashMap<String, String>();
		setExcelFile();
		int dataRow = getDataRow(dataKey.trim(), 0);
		LOG.info("Test Data Found in Row: " + dataRow);
		if (dataRow == 0) {
			throw new Exception("NO DATA FOUND for dataKey: " + dataKey);
		}
		int columnCount = excelSheet.getRow(dataRow).getLastCellNum();
		for (int i = 0; i < columnCount; i++) {
			cell = excelSheet.getRow(dataRow).getCell(i);
			String cellData = null;
			if (cell != null) {
				if (cell.getCellType() == CellType.NUMERIC) {
					cell.setCellType(CellType.STRING);
				}
				cellData = cell.getStringCellValue();
			}
			dataMap.put(excelSheet.getRow(0).getCell(i).getStringCellValue(), cellData);
			res = dataMap.get("endPoints");
		}
		return res;
	}

}

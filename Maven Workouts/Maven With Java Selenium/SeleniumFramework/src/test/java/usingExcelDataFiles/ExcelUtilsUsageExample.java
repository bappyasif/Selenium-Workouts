package usingExcelDataFiles;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsUsageExample {

	static XSSFWorkbook work_book;
	static XSSFSheet excel_sheet;
	
	static String project_path;

	//static String project_path = System.getProperty("user.dir");


	public ExcelUtilsUsageExample(String excelPath, String sheetName) {

		//project_path = System.getProperty("user.dir");
		
		try {
			
			// Create WorkBook
			work_book = new XSSFWorkbook(excelPath);
			
			// Access Excel Page Sheet
			excel_sheet = work_book.getSheet(sheetName);
			
		} catch (IOException ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();	
		}

	}


	public static void main(String[] args) {

		getSheetRowCount();
		accessExcelStringValue();

		accessExcelNumericalData();
		
		accessSheetStringData(0, 1);
		accessSheetNumericalData(1, 1);
		

	}


	public static void getSheetRowCount() {
		try {
//
//			// Create WorkBook
//			work_book = new XSSFWorkbook(project_path+"\\Excel Files\\Test Data.xlsx");
//
//			// Access Excel Page Sheet
//			excel_sheet = work_book.getSheet("Sheet1");

			// Get Sheet Row Count
			int row_count = excel_sheet.getPhysicalNumberOfRows();
			System.out.println("Row Count : "+row_count);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();			
		}
	}


	public static void accessExcelStringValue() {
		try {

//			// Access Excel Page Sheet
//			work_book = new XSSFWorkbook(project_path+"\\Excel Files\\Test Data.xlsx");
//
//			// Get Sheet Row Count
//			excel_sheet = work_book.getSheet("Sheet1");
//
			// Access Rows Data Value
			String cell_data = excel_sheet.getRow(0).getCell(0).getStringCellValue();
			//String cell_data = excel_sheet.getRow(1).getCell(1).getStringCellValue();
			System.out.println("Row Cell Data Value : "+cell_data);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();
		}
	}


	public static void accessExcelNumericalData() {
		try {

//			// Access Excel Page Sheet
//			work_book = new XSSFWorkbook(project_path+"\\Excel Files\\Test Data.xlsx");
//
//			// Get Sheet Row Count
//			excel_sheet = work_book.getSheet("Sheet1");

			// Access Rows Data Value
			double cell_data = excel_sheet.getRow(1).getCell(1).getNumericCellValue();
			//String cell_data = excel_sheet.getRow(1).getCell(1).getStringCellValue();
			System.out.println("Row Cell Data Value : "+cell_data);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();
		}
	}


	public static void accessSheetStringData(int rowNum, int colNum) {
		try {

//			// Access Excel Page Sheet
//			work_book = new XSSFWorkbook(project_path+"\\Excel Files\\Test Data.xlsx");
//
//			// Get Sheet Row Count
//			excel_sheet = work_book.getSheet("Sheet1");

			// Access Rows Data Value
			String cell_data = excel_sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//String cell_data = excel_sheet.getRow(1).getCell(1).getStringCellValue();
			System.out.println("Row Cell Data Value : "+cell_data);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();
		}
	}


	public static void accessSheetNumericalData(int rowNum, int colNum) {
		try {

//			// Access Excel Page Sheet
//			work_book = new XSSFWorkbook(project_path+"\\Excel Files\\Test Data.xlsx");
//
//			// Get Sheet Row Count
//			excel_sheet = work_book.getSheet("Sheet1");

			// Access Rows Data Value
			double cell_data = excel_sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//String cell_data = excel_sheet.getRow(1).getCell(1).getStringCellValue();
			System.out.println("Row Cell Data Value : "+cell_data);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();
		}
	}

}

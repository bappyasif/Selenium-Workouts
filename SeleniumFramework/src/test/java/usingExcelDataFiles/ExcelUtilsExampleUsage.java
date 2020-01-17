package usingExcelDataFiles;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsExampleUsage {

	static XSSFWorkbook work_book;
	static XSSFSheet excel_sheet;
	
	static String project_path;

	public ExcelUtilsExampleUsage(String excelPath, String sheetName) {
		
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
		
		getSheetCollumnCount();
		
		accessExcelStringValue();

		accessExcelNumericalData();
		
//		accessSheetStringData(0, 1);
//		accessSheetNumericalData(1, 1);
		

	}


	public static int getSheetRowCount() {
		
		int row_count = 0;
		
		try {

			// Get Sheet Row Count
			row_count = excel_sheet.getPhysicalNumberOfRows();
			System.out.println("Row Count : "+row_count);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();			
		}
		
		return row_count;
	}
	
	
	public static int getSheetCollumnCount() {
		
		int col_count = 0;
		
		try {

			// Get Sheet Row Count
			col_count = excel_sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Collumn Count : "+col_count);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();			
		}
		
		return col_count;
	}


	public static String accessExcelStringValue() {
		
		String cell_data = "";
		
		try {

			// Access Rows Data Value
			cell_data = excel_sheet.getRow(0).getCell(0).getStringCellValue();
			//String cell_data = excel_sheet.getRow(1).getCell(1).getStringCellValue();
			//System.out.println("Row Cell Data Value : "+cell_data);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();
		}
		
		return cell_data;
	}


	public static double accessExcelNumericalData() {
		
		double cell_data = 0.0;
		
		try {

			// Access Rows Data Value
			cell_data = excel_sheet.getRow(1).getCell(1).getNumericCellValue();
			//String cell_data = excel_sheet.getRow(1).getCell(1).getStringCellValue();
			//System.out.println("Row Cell Data Value : "+cell_data);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();
		}
		
		return cell_data;
	}


	public static String accessSheetStringData(int rowNum, int colNum) {
		
		String cell_data = "";
		
		try {

			// Access Rows Data Value
			cell_data = excel_sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//String cell_data = excel_sheet.getRow(1).getCell(1).getStringCellValue();
			//System.out.println("Row Cell Data Value : "+cell_data);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();
		}
		
		return cell_data;
	}


	public static double accessSheetNumericalData(int rowNum, int colNum) {
		
		double cell_data = 0.0;
		
		try {

			// Access Rows Data Value
			cell_data = excel_sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//String cell_data = excel_sheet.getRow(1).getCell(1).getStringCellValue();
			//System.out.println("Row Cell Data Value : "+cell_data);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Caught Excepytion...");
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.getStackTrace();
		}
		
		return cell_data;
	}

}

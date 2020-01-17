package usingExcelDataFiles;

import freemarker.core.ReturnInstruction.Return;

public class UsingExcelDataProvider {
	
	static String project_path = System.getProperty("user.dir");
	
	static String excel_path = project_path+"\\Excel Files\\Test Data.xlsx";
	
	static String sheet_name = "Sheet1";
	
	public static void main(String[] args) {
		
		testData(excel_path, sheet_name);
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtilsExampleUsage excel_object = new ExcelUtilsExampleUsage(excelPath, sheetName);
		
		int row_count = excel_object.getSheetRowCount();
		//System.out.println(row_count);
		
		int col_count = excel_object.getSheetCollumnCount();
		//System.out.println(col_count);
		
		//String cell_data = excel_object.accessSheetStringData(0, 0);
		//System.out.println(cell_data);
		
//		double cell_value = excel_object.accessSheetNumericalData(1, 1);
//		System.out.println(cell_value);
		
//		for(int row_counter = 0; row_counter<row_count; row_counter++ ) {
//			for(int col_counter = 1; col_counter<col_count; col_counter++) {
//				//excel_object.accessSheetNumericalData(row_counter, col_counter);
//				String string_data = excel_object.accessSheetStringData(row_counter, col_counter);
//				System.out.println(string_data+" | ");
//				//double string_data = excel_object.accessSheetNumericalData(row_counter, row_counter);
//				//System.out.println(string_data+" | ");
//			}
//		}
		
		Object excelData[][] = new Object[row_count-1][col_count];
		
		for(int i= 1; i< row_count; i++) {
			for(int j=0; j<col_count; j++) {
				String cellValue = excel_object.accessSheetStringData(i, j);
				//System.out.println(" | "+cellValue+" | ");
				
				// Writing Data
				excelData[i-1][j] = cellValue;
			}
			System.out.println();
		}
		return excelData;
	}

}

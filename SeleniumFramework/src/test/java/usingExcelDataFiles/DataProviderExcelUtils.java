package usingExcelDataFiles;

public class DataProviderExcelUtils {

	static String project_path = System.getProperty("user.dir");
	static String excel_path = project_path+"\\Excel Files\\Data Sheet.xls";

	static String sheet_name = "Sheet1";
	
	public static void main(String[] args) {
		
		dataProviderTestData(excel_path, sheet_name);
		
		dataProviderExcelSheet(excel_path, sheet_name);
	}
	
	public static void dataProviderTestData(String excelPath, String sheetName) {
		//  Creating An ExcelUtils Object
		ExcelUtilsExampleUsage excel_utils = new ExcelUtilsExampleUsage(excelPath, sheetName);
		
		// Calling Methods From Excel Utils
		int row_count = excel_utils.getSheetRowCount();
		int col_count = excel_utils.getSheetCollumnCount();
		
		//Loop Through Data Sheet
		for(int rowCounter = 1; rowCounter<row_count; rowCounter++) {
			for(int colCounter = 0; colCounter<col_count; colCounter++) {
				String cell_value = excel_utils.accessSheetStringData(rowCounter, colCounter);
				//String next_value = excel_utils.accessSheetStringData(rowCounter, colCounter);
				System.out.println(" | "+cell_value+" | ");
			}
			System.out.println("");
		}
	}
	
	
	public static Object[][] dataProviderExcelSheet(String excelPath, String sheetName) {
		//  Creating An ExcelUtils Object
		ExcelUtilsExampleUsage excel_utils = new ExcelUtilsExampleUsage(excelPath, sheetName);
		
		// Calling Methods From Excel Utils
		int row_count = excel_utils.getSheetRowCount();
		int col_count = excel_utils.getSheetCollumnCount();
		
		// Creating Object Type Array
		Object[][] excel_sheet = new Object[row_count][col_count]; 
		
		//Loop Through Data Sheet
		for(int rowCounter = 1; rowCounter<row_count; rowCounter++) {
			for(int colCounter = 0; colCounter<col_count; colCounter++) {
				String cell_value = excel_utils.accessSheetStringData(rowCounter, colCounter);
				//String next_value = excel_utils.accessSheetStringData(rowCounter, colCounter);
				System.out.println(" | "+cell_value+" | ");
				
				// Writing Data
				excel_sheet[ rowCounter-1 ][ colCounter ] = cell_value;
			}
			System.out.println("");
		}
		return excel_sheet;
	}
	
}

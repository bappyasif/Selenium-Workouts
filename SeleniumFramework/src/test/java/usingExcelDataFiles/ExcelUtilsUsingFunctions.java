package usingExcelDataFiles;

public class ExcelUtilsUsingFunctions {
	
	static String project_path = System.getProperty("user.dir");
	
	static String excelPath = project_path+"\\Excel Files\\Test Data.xlsx";
	
	static String sheetName = "Sheet1";
	
	public static void main(String[] args) {
		
		// Create Object For Class
		ExcelUtilsUsageExample excel_object = new ExcelUtilsUsageExample(excelPath, sheetName);
		
		// Using Functions From ExcelUtilsUsageExample
		excel_object.getSheetRowCount();
		excel_object.accessExcelStringValue();
		excel_object.accessExcelNumericalData();
		excel_object.accessSheetStringData(0, 1);
		excel_object.accessSheetNumericalData(1, 1);
		
		
	}

}

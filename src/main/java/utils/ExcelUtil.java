package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static XSSFWorkbook workbook;
	private static XSSFSheet worksheet;
	private static FileInputStream fileInputStream;

	public ExcelUtil(String path){
		try {
			fileInputStream = new FileInputStream(new File(path));
			workbook=new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to open excel",e);
		}
	}
	
	public static int getrowcount(String sheet)
	{
		worksheet=workbook.getSheet(sheet);
		int lastrow=worksheet.getLastRowNum();
		return lastrow;
	}
	
	public static int getcolcount(String sheet)
	{
		worksheet=workbook.getSheet(sheet);
		int colcount=worksheet.getRow(0).getPhysicalNumberOfCells();
		return colcount;
	}

	public static String getrowData(String sheet, int rownum, int colnum)
	{
		worksheet=workbook.getSheet(sheet);
		String data=worksheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return data;
	}

	public static void closeExcel()
	{
		try {
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to close excel File");
		}	
	}	

}

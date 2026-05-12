package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	
	static FileInputStream f;  //read excel file
	static XSSFWorkbook w;    //represent entire workbook 
	static XSSFSheet sh;      //represent sheet of the excel file

	public static String readStringData(int row, int col,String sheet) throws IOException {
		f = new FileInputStream(Constant.TESTDATA); //open the excel file from the given location
		w = new XSSFWorkbook(f);//load the excel file in the memory using Apache POI
		sh = w.getSheet(sheet);//select the sheet named sheet1 from the workbook.
		XSSFRow r = sh.getRow(row);//gets the row based on the row number passed as an argument
		XSSFCell c = r.getCell(col);//gets the cell in that row based on the column number
		return c.getStringCellValue();//return the text or string from that cell

	}

	public static String readIntegerData(int row, int col,String sheet) throws IOException {
		f = new FileInputStream(Constant.TESTDATA);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val =   (int) c.getNumericCellValue();  //convert double to int using typecasting
		return String.valueOf(val);   //convert int to string using valueOf() method
		
	
	}

}

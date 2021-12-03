package practise;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ApachePoi {
public static void main(String[] args) {
	WebDriver driver = null;
	FileInputStream file;
	DataFormatter df = new DataFormatter();
	Workbook wb = null;
	try {
		file = new FileInputStream("C:\\Users\\91814\\Desktop\\operatorPage.xls");
		wb = WorkbookFactory.create(file);
	} catch (Exception e) {
		e.printStackTrace();
	}
	Sheet sh =  wb.getSheetAt(0);
	int rows =  sh.getLastRowNum();
	int cols = sh.getRow(rows).getLastCellNum();
	String[][] data = new String[rows][cols];
	for (int i = 0; i < 2; i++) {
		int col = sh.getRow(i).getLastCellNum();
		for (int j = 0; j < col; j++) {
			Cell c = sh.getRow(2).getCell(2);
			String value = df.formatCellValue(c);
			//System.out.println(value);
			//String value = df.formatCellValue(c);
			data[i][j] = value;
		System.out.println(value);
		}
	}
}
}





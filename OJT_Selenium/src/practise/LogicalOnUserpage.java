package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LogicalOnUserpage {
	static WebDriver driver = null;
	FileInputStream fis;
	Workbook wb;
	Sheet sheet;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/pages/examples/users.html");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void checkUserListTiltle() throws IOException, BiffException {
		WebElement table = driver.findElement(By.xpath("//div[@class='col-xs-12']"));
		List<WebElement> rowsList = table.findElements(By.xpath("//div[@class='box']"));
		List<WebElement> columnsList = null;
		for (WebElement row : rowsList) {
			System.out.println();
			columnsList = row.findElements(By.tagName("th"));
			ArrayList<String> actCourses = new ArrayList<String>();
			for (WebElement column : columnsList) {
				String text = column.getText();
				actCourses.add(text);
			}
			fis = new FileInputStream(new File("C:\\Users\\91814\\Desktop\\userdata.xls"));
			wb = Workbook.getWorkbook(fis);
			sheet = wb.getSheet(0);
			int row1 = sheet.getRows();
			int column = sheet.getColumns();
			System.out.println("row" + row1);
			System.out.println("column" + column);

			ArrayList<String> expcourses = new ArrayList<>();
			for (int i = 0; i < 1; i++) {// row
				for (int j = 0; j < column; j++) {// column
					Cell cell = sheet.getCell(j, i);// column ,row
					String val = cell.getContents();
					expcourses.add(val);
				}
			}
			System.out.println(actCourses);
			System.out.println(expcourses);
			Assert.assertEquals(actCourses, expcourses);

		}
	}

	@Test(priority = 2)
	public void checkEmail() throws IOException, BiffException {
		List<WebElement> email = driver.findElements(By.xpath("//td[contains(text(),'@gmail')]"));
		ArrayList<String> actmail = new ArrayList<>();
		for (WebElement string : email) {
			String text = string.getText();
			if (text.contains("@gmail.com")) {
				actmail.add(text);
			} else {
				System.out.println("check your email");
			}
		}
		System.out.println(actmail);
		fis = new FileInputStream(new File("C:\\Users\\91814\\Desktop\\userdata.xls"));
		wb = Workbook.getWorkbook(fis);
		sheet = wb.getSheet(0);
		int row2 = sheet.getRows();
		int column = sheet.getColumns();
		System.out.println("row" + row2);
		System.out.println("column" + column);

		ArrayList<String> expmail = new ArrayList<>();
		for (int i = 1; i < 5; i++) {// row
			for (int j = 2; j < 3; j++) {// column
				Cell cell = sheet.getCell(j, i);// column ,row
				String val = cell.getContents();
				expmail.add(val);
			}
		}
		System.out.println(actmail);
		System.out.println(expmail);
		Assert.assertEquals(actmail, expmail);
	}
}

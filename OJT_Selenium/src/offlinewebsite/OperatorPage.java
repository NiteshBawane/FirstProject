package offlinewebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class OperatorPage {
	WebDriver driver = null;
	FileInputStream fis;
	Workbook wb;
	Sheet sheet;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/pages/examples/operators.html");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 0)
	public void checkOperatorTable() throws Exception {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='col-xs-12']"));
		ArrayList<String> actlist = new ArrayList<>();
		for (WebElement string : list) {
			String wl = string.getText();
			actlist.add(wl + "\t\t\t");
		}
		fis = new FileInputStream(new File("C:\\Users\\91814\\Desktop\\operatorPage.xls"));
		wb = Workbook.getWorkbook(fis);
		sheet = wb.getSheet(0);
		int row1 = sheet.getRows();
		int column = sheet.getColumns();
		System.out.println("row" + row1);
		System.out.println("column" + column);

		ArrayList<String> explist = new ArrayList<>();
		for (int i = 0; i < row1; i++) {// row
			for (int j = 0; j < column; j++) {// column
				Cell cell = sheet.getCell(j, i);// column ,row
				String val = cell.getContents();
				System.out.println();
				explist.add(val);
			}
		}
		System.out.println(actlist);
		System.out.println(explist);
		Assert.assertEquals(actlist, explist);
	}

	@Test(priority = 1)
	public void checkTechnicalPerson() {
		for (int i = 2; i < 7; i++) {
			List<WebElement> skill = driver.findElements(By.xpath("//tr[" + i + "]//td[3]"));
			List<WebElement> name = driver.findElements(By.xpath("//tr[" + i + "]//td[2]"));
			for (WebElement lable : skill) {
				String text = lable.getText();
				if (text.contains("Technical")) {
					for (WebElement person : name) {
						String string = person.getText();
						System.out.print(string + " is from " + text);
						System.out.println();
					}
				} else if (!text.contains("Technical")) {
					for (WebElement person : name) {
						String string = person.getText();
						System.out.print(string + " is from " + text);
						System.out.println();
					}
				}
			}
		}
	}

	@Test(priority = 2)
	public void checkTiming() {
		for (int i = 2; i < 7; i++) {
			List<WebElement> timings = driver.findElements(By.xpath("//tr[" + i + "]//td[6]"));
			List<WebElement> name = driver.findElements(By.xpath("//tr[" + i + "]//td[2]"));
			for (WebElement lable : timings) {
				String text = lable.getText();
				if (text.contains("09:00 AM")) {
					for (WebElement person : name) {
						String string = person.getText();
						System.out.print(string + " is available from " + text);
						System.out.println();
					}
				/*} else if (!text.contains("09:00 AM")) {
					for (WebElement person : name) {
						String string = person.getText();
						System.out.print(string + " is available from " + text);
						System.out.println();
					}*/
				}
			}
		}
	}
	@Test (priority = 3)
	public void checkOperatorOnWhatsapp(){
		for (int i = 2; i < 7; i++) {
			List<WebElement> connect = driver.findElements(By.xpath("//tr[" + i + "]//td[4]"));
			List<WebElement> name = driver.findElements(By.xpath("//tr[" + i + "]//td[2]"));
			for (WebElement lable : connect) {
				String text = lable.getText();
				if (text.contains("Whats App Only")) {
					for (WebElement person : name) {
						String string = person.getText();
						System.out.print(string + " is available on " + text);
						System.out.println();
					}
				/*} else if (!text.contains("Whats App Only")) {
					for (WebElement person : name) {
						String string = person.getText();
						System.out.print(string + " is available on " + text);
						System.out.println();
					}*/
				}
			}
		}
	}
	@Test(priority=4)
	public void test() throws Exception{
		List<WebElement> person = driver.findElements(By.xpath("//tr[2]"));
		ArrayList<String> details=new ArrayList<>();
		for (WebElement web : person) {
			String text=web.getText();
            details.add(text);
		}
		fis = new FileInputStream(new File("C:\\Users\\91814\\Desktop\\operatorPage.xls"));
		wb = Workbook.getWorkbook(fis);
		sheet = wb.getSheet(0);
		int row1 = sheet.getRows();
		int column = sheet.getColumns();
		System.out.println("row" + row1);
		System.out.println("column" + column);

		ArrayList<String> explist = new ArrayList<>();
		for (int i = 2; i < 3; i++) {// row
			for (int j = 0; j < column; j++) {// column
				Cell cell = sheet.getCell(j, i);// column ,row
				String val = cell.getContents();
				explist.add(val);
			}
		}
	System.out.println(details);
		System.out.println(explist);
		//Assert.assertEquals(details, explist);


	}
	}

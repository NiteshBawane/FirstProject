package practise;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class OperatorPage {
	WebDriver driver = null;
	FileInputStream fis;
	Workbook wb;
	Sheet sheet;
public  OperatorPage(WebDriver driver){
this.driver=driver;
PageFactory.initElements(driver, this);
}
	
	public void checkOperatorTable() throws Exception {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='col-xs-12']"));
		ArrayList<String> actlist = new ArrayList<String>();
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

		ArrayList<String> explist = new ArrayList<String>();
		for (int i = 0; i < row1; i++) {// row
			for (int j = 0; j < column; j++) {// column
				Cell cell = sheet.getCell(j, i);// column ,row
				String val = cell.getContents();
				explist.add(val);
			}
		}
		System.out.println(actlist);
		System.out.println(explist);
		Assert.assertEquals(actlist, explist);
	}

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
				} else if (!text.contains("09:00 AM")) {
					for (WebElement person : name) {
						String string = person.getText();
						System.out.print(string + " is available from " + text);
						System.out.println();
					}
				}
			}
		}
	}
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
				} else if (!text.contains("Whats App Only")) {
					for (WebElement person : name) {
						String string = person.getText();
						System.out.print(string + " is available on " + text);
						System.out.println();
					}
				}
			}
		}
	}
	}


/*	public static void main(String[] args) {
		WebDriver driver = null;
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/pages/examples/operators.html");
		for (int i = 2; i < 7; i++) {
			List<WebElement> skill = driver.findElements(By.xpath("//tr//td[3]"));
			List<WebElement> name = driver.findElements(By.xpath("//tr//td[2]"));
			ArrayList<String> askill = new ArrayList<>();
			ArrayList<String> aname = new ArrayList<>();

			for (WebElement lable : skill) {
				String text = lable.getText();
				askill.add(text);
				if (askill.contains("Technical")) {
					for (WebElement person : name) {
						String string = person.getText();
						aname.add(string);
						System.out.print(string + " is from " + text);
						System.out.println();
					}
				} else if (!askill.contains("Technical")) {
					for (WebElement person : name) {
						String string = person.getText();
						aname.add(string);
						System.out.print(string + " is from " + text);
						System.out.println();
					}
				}
			}
			System.out.println(askill);
			System.out.println(aname);
		}
		DataFormatter df = new DataFormatter();
		try {
			file = new FileInputStream(filepath);
			wb = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheetname);
		int rows = sh.getLastRowNum();
		int cols = sh.getRow(rows).getLastCellNum();
		String[][] data = new String[rows][parameter];
		for (int i = 0; i < rows; i++) {
			int col = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < rows; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String value = df.formatCellValue(c);
				data[i][j] = value;
				System.out.println(value);
			}
		}
	}

	}
}
*/
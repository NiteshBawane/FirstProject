package offlinewebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DashboradPage {
	WebDriver driver = null;
	LoginPage lp = null;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void VerifyTitle() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	@Test(priority = 1)
	public void verifyCourses() {
		List<WebElement> Courses = driver.findElements(By.tagName("h3"));
		ArrayList<String> actCourses = new ArrayList<String>();
		for (WebElement course : Courses) {
			String text = course.getText();
			actCourses.add(text);
		}
		ArrayList<String> expCourses = new ArrayList<String>();
		expCourses.add("Selenium");
		expCourses.add("Java / J2EE");
		expCourses.add("Python");
		expCourses.add("Php");
		System.out.println(actCourses);
		Assert.assertEquals(actCourses, expCourses);
	}

	@Test(priority = 2)
	public void verifySubCourses() {
		List<WebElement> subCourses = driver.findElements(By.xpath("//h3//following::p"));
		ArrayList<String> actsubCourses = new ArrayList<String>();
		for (WebElement course : subCourses) {
			String text = course.getText();
			actsubCourses.add(text);
		}
		ArrayList<String> expsubCourses = new ArrayList<String>();
		expsubCourses.add("Automation Testing");
		expsubCourses.add("Software Development");
		expsubCourses.add("Data Science");
		expsubCourses.add("Web Development");

		Assert.assertEquals(actsubCourses, expsubCourses);
	}

	@Test(priority = 3)
	public void checkFooter() {
		String act = driver.findElement(By.xpath("//footer")).getText();
		String exp = "Design for Selenium Automation Test V 2.3.0\nCopyright © 2005-2019 JavaByKiran. All rights reserved.";
		Assert.assertEquals(act, exp);
	}

	@Test(priority = 4)
	public void verifyCoursesUsingExcel() throws Exception {
		List<WebElement> Courses = driver.findElements(By.tagName("h3"));
		ArrayList<String> actCourses = new ArrayList<String>();
		for (WebElement course : Courses) {
			String text = course.getText();
			actCourses.add(text);
		}
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\91814\\Desktop\\Courses.xls"));
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sheet = wb.getSheet(0);
		int row = sheet.getRows();
		int column = sheet.getColumns();
		System.out.println("row" + row);
		System.out.println("column" + column);

		ArrayList<String> expcourses = new ArrayList<>();
		for (int i = 0; i < row; i++) {// row
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

	@Test(priority = 5)
	public void checkDownloadsLink() {
		driver.findElement(By.partialLinkText("Downloads")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Downloads");
	}

	@Test(priority = 6)
	public void checkUsersLink() {
		driver.findElement(By.linkText("Users")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
	}

	@Test(priority = 7)
	public void checkOperatorsLink() {
		driver.findElement(By.linkText("Operators")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Operators");
	}

	@Test(priority = 8)
	public void checkUsefulLink() {
		driver.findElement(By.partialLinkText("Useful")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Useful Links");
	}

	@Test(priority=9)
	public void checkinfoLink() throws Exception {
		String mainwin = driver.getWindowHandle();
		WebElement info = driver.findElement(By.xpath("//section[@class='content']"));
		List<WebElement> moreinfo = info.findElements(By.xpath("//a[text()='More info ']"));
		for (WebElement webElement : moreinfo) {
			Thread.sleep(2000);
			webElement.click();
		}
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			if (!win.equals(mainwin)) {
				driver.switchTo().window(win);
				System.out.println(driver.getCurrentUrl());
				Thread.sleep(1000);
				driver.close();
			}
		}
		int act = moreinfo.size();
		int exp = 4;
		Assert.assertEquals(act, exp);
	}

}

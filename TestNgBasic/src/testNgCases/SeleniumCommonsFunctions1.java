package testNgCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCommonsFunctions1 {
	public static WebDriver openBroweser(String brname){
		System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	public static void openUrl(WebDriver driver,String UrltoOpen){
		driver.get(UrltoOpen);
	}
	public static void enterText(WebDriver driver,String locvalue,String locname,String dataToEnter){
		if ("id".equals(locname)) {
			driver.findElement(By.id(locvalue)).sendKeys(dataToEnter);
		}
		if ("xpath".equals(locname)) {
			driver.findElement(By.id(locvalue)).sendKeys(dataToEnter);
		}
	}
}



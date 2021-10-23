package testNgCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverTest {

	public static void openBroweser(String brname){
WebDriver  driver=null;
if ("chrome".equals(brname)) {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver=new ChromeDriver();
}
if ("Msedged".equals(brname)) {
	System.setProperty("webdriver.msedge.driver", "msedgedriver.exe");

}
}
}
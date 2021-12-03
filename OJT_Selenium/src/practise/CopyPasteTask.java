package practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyPasteTask {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html#");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//button")).click();

		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.id("email_error"))).click().contextClick().build().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		act.contextClick(driver.findElement(By.id("email"))).perform();
		Thread.sleep(2000);
		for (int i = 0; i < 2; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(5000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
	}
}

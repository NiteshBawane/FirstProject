package testNgCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FiveTestwithSelenium {
@Test
public void checkTestOne(){
	System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
String lableHeading=driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
driver.close();
Assert.assertEquals(lableHeading, "Java By Kiran");
}
@Test
public void checkTestTwo(){
	System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
	String act=driver.findElement(By.xpath("/html/body/div/div[1]/a/h4")).getText();
	String exp="JAVA | SELENIUM | PYTHON";
	driver.close();
	Assert.assertEquals(act, exp);
}
@Test
public void checkTestThree(){
	System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
	String act=driver.getTitle();
	String exp="JavaByKiran | Log in";
	driver.close();
	Assert.assertEquals(act, exp);

}
@Test
public void checkTestFour(){
	System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
boolean flag=driver.findElement(By.xpath("/html/body/div/center/img")).isDisplayed();
driver.close();
Assert.assertEquals(flag, true);
}
@Test
public void checkTestFive() throws InterruptedException{
	System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
String act=driver.getTitle();
driver.close();
Assert.assertEquals(act, "JavaByKiran | Dashboard");
	
}}
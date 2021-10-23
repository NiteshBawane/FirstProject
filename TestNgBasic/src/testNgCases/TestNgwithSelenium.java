package testNgCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgwithSelenium {
@Test
	public void checkSignin(){
		WebDriver driver=new ChromeDriver();
		System.setProperty("webdiver.chrome.diver", "chromedriver.exe");
		driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		String act=driver.getTitle();
		String exp="JavaByKiran | Dashboard";
		driver.close();
		Assert.assertEquals(act, exp);
	}
@Test
public void checkUserForm(){
	WebDriver driver=new ChromeDriver();
	System.setProperty("webdiver.chrome.diver", "chromedriver.exe");
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/pages/examples/users.html");
	driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.id("username")).sendKeys("Nitesh Bawane");
	driver.findElement(By.id("mobile")).sendKeys("9090909090");
	driver.findElement(By.id("email")).sendKeys("nitesh@gmail.com");
	driver.findElement(By.id("course")).sendKeys("Selenium");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.id("Male")).click();
	driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select/option[2]")).click();
	driver.findElement(By.id("submit")).click();
	String act=driver.switchTo().alert().getText();
	String exp="User Added Successfully. You can not see added user.";
	//driver.close();
	Assert.assertEquals(act, exp);
}
@Test
public void checplaceholderofEmail(){
	WebDriver driver=new ChromeDriver();
	System.setProperty("webdiver.chrome.diver", "chromedriver.exe");
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
WebElement we=driver.findElement(By.xpath("//*[@id=\"email\"]"));
String actual=we.getAttribute("placeholder");
driver.close();
Assert.assertEquals(actual, "Email"); 
}
@Test
public void checplaceholderofPassword(){
	WebDriver driver=new ChromeDriver();
	System.setProperty("webdiver.chrome.diver", "chromedriver.exe");
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
WebElement we=driver.findElement(By.xpath("//*[@id=\"password\"]"));
String actual=we.getAttribute("placeholder");
driver.close();
Assert.assertEquals(actual, "Password");
}}

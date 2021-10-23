package testNgCases;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Framework {
	@Test
	public void checkPageHeading(){
		System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
	String lableHeading=driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
	driver.close();
	Assert.assertEquals(lableHeading, "Java By Kiran");
	}
	@Test
	public void checkPageText(){
		System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
		String act=driver.findElement(By.xpath("/html/body/div/div[1]/a/h4")).getText();
		String exp="JAVA | SELENIUM | PYTHON";
		driver.close();
		Assert.assertEquals(act, exp);
	}
	@Test
	public void checkLoginText(){
		System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
		String act=driver.getTitle();
		String exp="JavaByKiran | Log in";
		driver.close();
		Assert.assertEquals(act, exp);

	}
	@Test
	public void checkPageLogo(){
		System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
	boolean flag=driver.findElement(By.xpath("/html/body/div/center/img")).isDisplayed();
	driver.close();
	Assert.assertEquals(flag, true);
	}
	@Test
	public void checkLoginDetails() throws InterruptedException{
		System.setProperty("webdriber.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	String act=driver.getTitle();
	driver.close();
	Assert.assertEquals(act, "JavaByKiran | Dashboard");
		
	}
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
@Test(priority= 10)
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
//	driver.close();
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
}
@Test
public void newMembership(){
	WebDriver driver=new ChromeDriver();
	System.setProperty("webdiver.chrome.diver", "chromedriver.exe");
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.linkText("Register a new membership")).click();
	String act=driver.getTitle();
	String exp="JavaByKiran | Registration Page";
	driver.close();
	Assert.assertEquals(act, exp);
}
@Test(priority=11)
public void checkMembershipDetails(){
	WebDriver driver=new ChromeDriver();
	System.setProperty("webdiver.chrome.diver", "chromedriver.exe");
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/pages/examples/register.html");
    driver.findElement(By.id("name")).sendKeys("Nitesh");
    driver.findElement(By.id("email")).sendKeys("bawane51@gmail.com");
    driver.findElement(By.id("mobile")).sendKeys("8888888888");
    driver.findElement(By.id("password")).sendKeys("123456");
driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();
String act=driver.switchTo().alert().getText();
String exp="User registered successfully.";
Assert.assertEquals(act, exp);
}
@Test(priority=12)
public void checkErrrorINMembershipDetails(){
	WebDriver driver=new ChromeDriver();
	System.setProperty("webdiver.chrome.diver", "chromedriver.exe");
	driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html");
    driver.findElement(By.id("email")).sendKeys(" ");
    driver.findElement(By.id("password")).sendKeys(" ");
driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
String error=driver.findElement(By.id("email_error")).getText();
String experror="Please enter email as kiran@gmail.com";
Assert.assertEquals(error, experror);
}
}




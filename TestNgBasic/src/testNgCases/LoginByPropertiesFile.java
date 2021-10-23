package testNgCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginByPropertiesFile {
	@Test
	public void verifyLogin() throws Exception {
		FileInputStream fis = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String brType = properties.getProperty("browser");
		String url = properties.getProperty("url");

		WebDriver driver = SeleniumCommonsFunctions1.openBroweser(brType);
		SeleniumCommonsFunctions1.openUrl(driver, url);
		
		SeleniumCommonsFunctions1.enterText(driver, "id",properties.getProperty("login_email") , properties.getProperty("useremail"));
	//	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		SeleniumCommonsFunctions1.enterText(driver, "id", properties.getProperty("login_password"), properties.getProperty("useremail"));
	//	driver.findElement(By.id("password")).sendKeys("123456");
	
		driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
		String act = driver.getTitle();
		driver.close();
		Assert.assertEquals(act, "JavaByKiran | Log in");

		// String error=driver.findElement(By.id("email_error")).getText();
		// String experror="Please enter email as kiran@gmail.com";

		// driver.close();
		// Assert.assertEquals(error, experror);
	}
}

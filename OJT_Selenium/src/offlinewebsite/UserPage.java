package offlinewebsite;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserPage {
	WebDriver driver = null;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/pages/examples/users.html");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void userForm() throws Exception {
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.id("username")).sendKeys("Nitesh");
		driver.findElement(By.id("mobile")).sendKeys("88888888888");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("course")).sendKeys("Selenium");
		driver.findElement(By.id("Male")).click();
		driver.findElement(By.xpath("//option[2]")).click();
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		Alert alert = driver.switchTo().alert();
		String actalertMsg = alert.getText();
		String expalertMag = "User Added Successfully. You can not see added user.";
		Thread.sleep(2000);
		alert.accept();
		Assert.assertEquals(actalertMsg, expalertMag);
	}

	@Test(priority = 3)
	public void deletUser1() throws Exception {
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.linkText("Delete")).click();
		Alert alert = driver.switchTo().alert();
		String actalertMsg = alert.getText();
		String expalertMag = "You can not delete Default User";
		Thread.sleep(2000);
		alert.accept();
		Assert.assertEquals(actalertMsg, expalertMag);
	}

	@Test(priority = 4)
	public void deletUser2() throws Exception {
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.xpath("//*[@id=\"tr_2\"]/td[8]/a/span")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String actalertMsg = alert.getText();
		String expalertMag = "User deleted successfully.";
		Thread.sleep(2000);
		alert.accept();
		Assert.assertEquals(actalertMsg, expalertMag);

	}

	@Test(priority = 1	)
	public void checkUserListTiltle(){
		WebElement table= driver.findElement(By.xpath("//div[@class='col-xs-12']"));
		List<WebElement> rowsList = table.findElements(By.tagName("tr"));
		List<WebElement> columnsList = null;
        for (WebElement row : rowsList) {
                System.out.println();
                columnsList = row.findElements(By.tagName("td"));
         for (WebElement column : columnsList) {
               System.out.print(column.getText() + ", ");
         }
       }
	}
	@Test(priority = 5)
	public void checkContext() {
Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Users')]")).getText(), "Users");
	}
}

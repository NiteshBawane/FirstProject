package offlinewebsite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	WebDriver driver = null;
	SoftAssert sa=new SoftAssert();

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/91814/Desktop/selenium/Offline%20Website/Offline%20Website/index.html#");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void VerifyTitle() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}

	@Test(priority = 1)
	public void checkLogo() {
		boolean logo = driver.findElement(By.tagName("img")).isDisplayed();
		Assert.assertEquals(true, logo);
	}

	@Test(priority = 3)
	public void inValidLogin() {
		driver.findElement(By.id("email")).sendKeys("abcd");
		driver.findElement(By.id("password")).sendKeys("212323");
		driver.findElement(By.xpath("//button")).click();
		String expmail = "Please enter email as kiran@gmail.com";
		String actmail = driver.findElement(By.id("email_error")).getText();
		String exppass = "Please enter password 123456";
		String actpass = driver.findElement(By.id("password_error")).getText();
		sa.assertEquals(actmail, expmail);
		sa.assertEquals(actpass, exppass);
		sa.assertAll();
	}

	@Test(priority = 4)
	public void validLogin() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	@Test(priority = 5)
	public void verifyLogout() {
		driver.findElement(By.linkText("LOGOUT")).click();
		String act = driver.findElement(By.xpath("//p[2]")).getText();
		String exp = "Logout successfully";
		Assert.assertEquals(act, exp);
	}

	@Test(priority = 6)
	public void checkTextOnLink1() {
		String act = driver.findElement(By.tagName("b")).getText();
		String exp = "Java By Kiran";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 7)
	public void checkTextOnLink2() {
		String act = driver.findElement(By.tagName("h4")).getText();
		String exp = "JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(act, exp);
	}

	@Test(priority = 8)
	public void checkRegistrationLink() {
		driver.findElement(By.partialLinkText("Register")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Registration Page");
	}

	@Test(priority = 9)
	public void registerNewMember() throws Exception {
		driver.findElement(By.id("name")).sendKeys("nitesh");
		driver.findElement(By.id("mobile")).sendKeys("999999999");
		driver.findElement(By.id("email")).sendKeys("nitesh@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		Alert al = driver.switchTo().alert();
		String act = al.getText();
		String exp = "User registered successfully.";
		Thread.sleep(2000);
		al.accept();
		Assert.assertEquals(act, exp);
	}

}
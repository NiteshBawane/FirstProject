package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.jbk.pages.LoginPage;

public class TestBase {

	public static WebDriver driver = null;
	FileInputStream fis = null;

	public String readProperty(String key) {
		System.out.println("reading a property from property file");
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("value found in the property file for the" + key);
		return prop.getProperty(key);
	}

	public void launchBrowser() {
		System.out.println("launching an browser");
		driver.get(readProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public WebDriver intitialization(){
		log.info("intitialising a browser with name"+readProperty("browser"));
		if(readProperty("browser").equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		launchBrowser();
		log.info("chrome browser intialised");
		return driver;
		}else{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
			launchBrowser();
			return driver;
		}
	}
		public void reportInit() {
			spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/Reports/ExtentReport.html");
			report = new ExtentReports();
			report.setSystemInfo("Host Name"," Nitesh-JBK");
			report.setSystemInfo("Platform","Windows");
			report.setSystemInfo("Enviornment","Test Automation");
			report.attachReporter(spark);
		}
		public String takeScreenShot(String name) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
			try {
				FileUtils.copyFile(src, new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return path;
		}
	
	public LoginPage loadpage() {
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
}

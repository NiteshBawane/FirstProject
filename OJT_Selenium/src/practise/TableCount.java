package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableCount {
static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://elvery.net/demo/responsive-tables/");
	        driver.manage().window().maximize();

	         WebElement table = driver.findElement(By.xpath("//table[contains(@class,’table-bordered’)]"));
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
}



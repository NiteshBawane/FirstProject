package testNgCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReading {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis);
String val=properties.getProperty("browser");
System.out.println("val>>"+val);
	}

}

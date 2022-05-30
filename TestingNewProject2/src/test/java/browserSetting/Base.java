package browserSetting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AKASH\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
		
	}
//	public static WebDriver openFirefoxBrowser() {
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\AKASH\\Desktop\\geckodriver-v0.31.0-win64.zip");
//		WebDriver driver = new FirefoxDriver();
//		return driver;
//	}
    public static WebDriver openMicrosoftBrowser() {
    	System.setProperty("webdriver.edge.driver","C:\\Users\\AKASH\\Desktop\\msedgedriver.exe");
    	WebDriver driver = new EdgeDriver();
    	return driver;
    }
}

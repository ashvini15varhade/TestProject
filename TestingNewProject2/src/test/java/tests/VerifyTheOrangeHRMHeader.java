package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomPack.HomePage;
import pomPack.LoginPage;

public class VerifyTheOrangeHRMHeader {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AKASH\\Desktop\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		  LoginPage loginPage = new LoginPage(driver);
		    loginPage.sendUserName();
	        loginPage.sendPasswordName();
	        loginPage.clickOnLogin();
	        
	        //  OR
	        //loginPage.loginToOrangeHRM();
	        
	        HomePage homePage = new HomePage(driver);
	        Thread.sleep(2000);
	        homePage.clickOnAdmin();
	        
	        String url = driver.getCurrentUrl();
	        String title = driver.getTitle();
	        
	        System.out.println(url);
	        System.out.println(title);
	        
	        if(url.equals("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers") && title.equals("OrangeHRM"))
	        {
	            System.out.println("PASS");
	        }
	        
	        else
	        {
	            System.out.println("FAIL");
	        }
	        homePage.clickOnWelcome();
	        homePage.clickOnLogout();
	        
	}
}

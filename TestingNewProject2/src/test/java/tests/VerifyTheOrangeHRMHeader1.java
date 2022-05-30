package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomPack.HomePage;
import pomPack.LoginPage;
//HomePage homePage = new HomePage(driver);
public class VerifyTheOrangeHRMHeader1 {
	WebDriver driver;
	HomePage homePage;
	
	@BeforeClass
	public void launchBrowser()
	{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\AKASH\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
	}
	@BeforeMethod
	public void loginToOrangeHRM() throws InterruptedException
	{
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		//https://opensource-demo.orangehrmlive.com/
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		LoginPage loginPage = new LoginPage(driver);
		
	    loginPage.sendUserName();
        loginPage.sendPasswordName();
        loginPage.clickOnLogin();
        homePage = new HomePage(driver);
	}
	@Test
	public void verifyAdmin()
	{
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
	}
	@Test
	public void verifyRecruitmentTab()
	{
		homePage.clickOnRecruitment();
        
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        
        System.out.println(url);
        System.out.println(title);
                if(url.equals("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates") && title.equals("OrangeHRM"))

        {
            System.out.println("PASS");
        }
        
        else
        {
            System.out.println("FAIL");
        }
	}
	
	
	@AfterMethod()
	public void logoutFromOrangeHRM()
	{
		homePage.clickOnWelcome();
		homePage.clickOnLogout();

	}
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}
	
}

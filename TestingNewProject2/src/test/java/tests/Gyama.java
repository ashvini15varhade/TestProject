package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserSetting.Base;
import pomPack.HomePage;
import pomPack.LoginPage;

public class Gyama extends Base{

	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browser)
	{
      if(browser.equals("ChromeBrowser"))
      {
    	  driver=openChromeBrowser();
      }
//      if(browser.equals("FirefoxBrowser"))
//      {
//    	  
//    	  driver=openFirefoxBrowser();
//      }
      if(browser.equals("MicrosoftBrowser"))
      {
    	  
    	  driver=openMicrosoftBrowser();
      }
      driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	@BeforeClass 
	public void LaunchBrowser() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	@BeforeMethod
	public void loginToOrangeHRM()
	{
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		driver.get("https://opensource-demo.orangehrmlive.com/");
	    loginPage.sendUserName();
        loginPage.sendPasswordName();
        loginPage.clickOnLogin();
      //https://opensource-demo.orangehrmlive.com/
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
	public void clearPOMobject()
	{
		loginPage=null;
		homePage=null;
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();  // Garbage Collector
		
	}

}

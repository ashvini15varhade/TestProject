package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath = "//b[text()='Admin']")
    private WebElement admin ;
	
    @FindBy (xpath = "//b[text()='Time']")
    private WebElement time ;
    
    @FindBy (xpath = "//b[text()='Recruitment']")
    private WebElement recruitment ;
    
    @FindBy (xpath = "//b[text()='Maintenance']")
    private WebElement maintenance ;
    
    @FindBy (xpath = "//a[@id='welcome']")
    private WebElement welcome ;
    
    @FindBy (xpath = "//a[text()='Logout']")
    private WebElement logout ;
    
    
	
	 public HomePage(WebDriver driver)  // driver2 = driver = new ChromeDriver()
		{
			PageFactory.initElements(driver, this);
		}
	    
	    public void clickOnAdmin() {
	    	admin.click();
	    }
	    public void clickOnTime() {
	    	time.click();
	    }
	    public void clickOnRecruitment() {
	    	recruitment.click();
	    }
	    public void clickOnMaintenance() {
	    	maintenance.click();
	    }
	    public void clickOnWelcome() {
	    	welcome.click();
	    }
	    public void clickOnLogout() {
	    	logout.click();
	    }
	
}



package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (xpath = "//input[@name='txtUsername']")
    private WebElement userName ;
    
	@FindBy (xpath = "//input[@name='txtPassword']")
    private WebElement password ;
	
	@FindBy (xpath = "//input[@value='LOGIN']")
    private WebElement loginButton ;
	
	public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    	
    }
    
    public void sendUserName() {
    	userName.sendKeys("Admin");
    }
    public void sendPasswordName() {
    	password.sendKeys("admin123");
    }
   
    public void clickOnLogin() {
    	loginButton.click();
    }
    
    //OR
    
//    public void loginToOrangeHRM() {
//    	userName.sendKeys("Admin");
//    	password.sendKeys("admin123");
//    	loginButton.click();
    
}


	



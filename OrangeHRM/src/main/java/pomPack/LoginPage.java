package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(xpath="//input[@name='txtUsername']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='Submit']")
	private WebElement loginButton ;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName()
	{
		username.sendKeys("Admin");
	}
	public void sendPassword()
	{
		password.sendKeys("admin123");
	}
	public void clickOnLogin()
	{
		loginButton.click();
	}
	
	//OR
	
//	public void loginToFacebook() {
//		username.sendKeys("Adesh");
//		password.sendKeys("12345");
//		loginButton.click();	
//	}
	
	


}

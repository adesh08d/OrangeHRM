package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMheader{


	@FindBy(xpath="//b[text()='Admin']")
	private WebElement admin ;
	
	@FindBy(xpath="//b[text()='Time']")
	private WebElement time ;
	
	@FindBy(xpath="//b[text()='Recruitment']")
	private WebElement recruitment ;
	
	@FindBy(xpath="//b[text()='Maintenance']")
	private WebElement maintenance ;
	
	@FindBy(xpath="//a[@class='panelTrigger']")
	private WebElement welcome ;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout ;
	
	public OrangeHRMheader(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonAdmin() {
		admin.click();
	}
	
	public void clickonTime() {
		time.click();
	}
	
	public void clickonRecruirement() {
		recruitment.click();
	}
	
	public void clickonMaintenance() {
		maintenance.click();
	}
	
	public void clickonWelcome() {
		welcome.click();
	}
	
	public void clickonLogout() {
		logout.click();
	}

	
	
  
}

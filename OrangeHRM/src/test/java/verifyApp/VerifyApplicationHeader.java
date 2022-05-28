package verifyApp;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browserSetting.BaseClass;
import pomPack.LoginPage;
import pomPack.OrangeHRMheader;
import utils.Utility;

public class VerifyApplicationHeader extends BaseClass{



	WebDriver driver;
	OrangeHRMheader orangeHRMHeader;
	LoginPage loginpage;
	int testCaseID;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browser) {
		if(browser.equals("ChromeBrowser"))
		{
			driver=openChromeBrowser();
		}
		if(browser.equals("FirefoxBrowser"))
		{
			driver=openFirefoxBrowser();
		}
		
//		if(browser.equals("OperaBrowser"))
//		{
//			driver=openOperaBrowser();
//		}
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
	}
	
	@BeforeClass
	public void launchbrowser() {
		 loginpage = new LoginPage(driver);
		orangeHRMHeader = new OrangeHRMheader(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() {
    driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		loginpage.sendUserName();
		loginpage.sendPassword();
		loginpage.clickOnLogin();
	   

	}
	
	@Test
	public void verifyAdminTab() {
		testCaseID =2201;
	orangeHRMHeader.clickonAdmin();
		
		String url = driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		SoftAssert m=new SoftAssert();	
		m.assertEquals(url,"https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		m.assertAll();
		
//		if(url.equals("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers") && title.equals("OrangeHRM"))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
	}
	@Test
	public void verifyTimeTab() {
		testCaseID =2202;

    orangeHRMHeader.clickonTime();
		
		String url = driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		SoftAssert s=new SoftAssert();	
		s.assertEquals(url,"abchttps://opensource-demo.orangehrmlive.com/index.php/time/viewEmployeeTimesheet");
		s.assertAll();
		
//		if(url.equals("https://opensource-demo.orangehrmlive.com/index.php/time/viewEmployeeTimesheet") && title.equals("OrangeHRM"))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
	}
	
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(testCaseID, driver);
		}
		orangeHRMHeader.clickonWelcome();
		orangeHRMHeader.clickonLogout();
	}
	
	@AfterClass
	public void clearPOMobjects() {
		
		loginpage=null;
		orangeHRMHeader=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();//garbage collector
	}
	
   




}

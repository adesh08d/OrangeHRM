package browserSetting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseClass {


	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\chrome path for selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "F:\\FirefoxPath\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
//	public static WebDriver openOperaBrowser() {
//		System.setProperty("webdriver.opera.driver", "E:\\operadriver_win64\\operadriver.exe");
//		WebDriver driver = new OperaDriver();
//		return driver;
//	}

}

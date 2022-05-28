package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
public static void captureScreenshot(int testID,WebDriver driver) throws IOException, InterruptedException {
	TakesScreenshot s=(TakesScreenshot) driver;
	File source = s.getScreenshotAs(OutputType.FILE); 
	DateTimeFormatter dtf =DateTimeFormatter.ofPattern("dd_MM_YYYY");
	
	LocalDateTime now =LocalDateTime.now();
	File dest = new File("test-output\\Screenshot\\TestCase-2202" +dtf.format(now) + ".jpeg");
	FileHandler.copy(source, dest);
	Thread.sleep(2000);
	Calendar Cal = Calendar.getInstance();
	java.util.Date time = Cal.getTime();
	String timelamp = time.toString().replace(":", "").replace(" ", "  ");
	
}	
}

package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils
{

	public WebDriver initWebDriver()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		return driver;
	}

	public static String captureScreenshot(WebDriver driver, String screenshotName)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			String screenshotPath = "./screenshots/" + screenshotName + ".png";
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(screenshotPath));
			System.out.println("Screenshot captured: " + screenshotPath);
			return screenshotPath;
		}
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot: " + e.getMessage());
			return null;
		}
	}
}
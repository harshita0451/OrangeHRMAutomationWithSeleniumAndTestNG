package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ExtentReportHandler;
import utilities.Utils;

public class BaseTest
{
	protected WebDriver driver;
	Utils objUtils = new Utils();
	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();

	@BeforeClass
	public void initiliaze()
	{
		objExtentReportHandler.getInstance();
		try
		{
			driver = objUtils.initWebDriver();
		}
		catch (Exception e)
		{
			System.out.println("Error in Initializing driver and Opening browser");
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
	}

	@AfterClass
	public void close()
	{
		try
		{
			if (driver != null)
			{
				driver.quit();
				objExtentReportHandler.getInstance().flush();
			}
			else
			{
				System.out.println("No driver to close...");
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
	}
}

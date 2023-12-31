package tests.pim;

import java.io.File;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import runner.BaseTest;
import ui.pageactions.dashboard.DashboardPageActions;
import ui.pageactions.login.LoginPageActions;
import ui.pageactions.pim.PIMPageActions;
import utilities.ExtentReportHandler;
import utilities.Utils;

public class PIMSearchRecordTest extends BaseTest
{
	Boolean isLoginSuccess = false;
	Boolean isNavigatedToAdmin = false;
	Actions a = new Actions(driver);
	PIMPageActions objPIMPageActions = new PIMPageActions();
	DashboardPageActions objDashboardPageActions = new DashboardPageActions();
	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();
	ExtentTest test = objExtentReportHandler.getInstance().createTest("PIMSearchRecord");
	String screenshotPath = null;

	@BeforeClass
	public void navigateToPIM()
	{
		try
		{
			LoginPageActions objLoginPageActions = new LoginPageActions();
			objLoginPageActions.doLogin(driver, test);

			objDashboardPageActions.clickOnPageButton(driver, "PIM", test);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void searchRecordUsingAllAttributes()
	{
		try
		{
			objPIMPageActions.searchOperation(driver, test);
			test.pass("Successfully Searched With All Atributes");
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			screenshotPath = Utils.captureScreenshot(driver, "searchRecordTest1");
			if (screenshotPath != null)
			{
				String absolutePath = new File(screenshotPath).getAbsolutePath();
				test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "searchRecordTest1").build());
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

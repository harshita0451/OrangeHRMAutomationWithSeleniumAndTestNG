package tests.admin;

import java.io.File;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import runner.BaseTest;
import ui.pageactions.admin.AdminAddPageActions;
import ui.pageactions.admin.AdminPageActions;
import ui.pageactions.dashboard.DashboardPageActions;
import ui.pageactions.login.LoginPageActions;
import utilities.ExtentReportHandler;
import utilities.Utils;

public class AdminSearchRecordTest extends BaseTest
{
	LoginPageActions objLoginPageActions = new LoginPageActions();
	AdminPageActions objAdminPageActions = new AdminPageActions();
	DashboardPageActions objDashboardPageActions = new DashboardPageActions();
	AdminAddPageActions objAdminAddPageActions = new AdminAddPageActions();
	Actions a = new Actions(driver);
	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();
	ExtentTest test = objExtentReportHandler.getInstance().createTest("AdminSearchRecord Using All Records");
	Boolean isLoginSuccess = false;
	Boolean isNavigatedToAdmin = false;
	String screenshotPath = null;

	@BeforeClass
	private void navigateToAdmin()
	{

		try
		{
			isLoginSuccess = objLoginPageActions.doLogin(driver, test);
			if (isLoginSuccess)
			{
				isNavigatedToAdmin = objDashboardPageActions.clickOnPageButton(driver, "Admin", test);
				if (isNavigatedToAdmin)
				{
					System.out.println("Navigation Successful");
				}
				else
				{
					driver.quit();
					System.exit(1);
				}
			}
			else
			{
				driver.quit();
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

	@Test(priority = 1)
	public void searchRecordUsingAllAttributes()
	{
		try
		{
			objAdminPageActions.clickResetButton(driver, test);
			objAdminPageActions.searchOperation(driver, test);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			screenshotPath = Utils.captureScreenshot(driver, "searchRecordUsingAllAttributes");
			if (screenshotPath != null)
			{
				String absolutePath = new File(screenshotPath).getAbsolutePath();
				test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "searchRecordUsingAllAttributes").build());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void searchRecordUsingUserName()
	{
		try
		{
			objAdminPageActions.clickResetButton(driver, test);
			objAdminPageActions.enterDataUserName(driver, test);
			objAdminPageActions.clickSearchButton(driver, test);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			screenshotPath = Utils.captureScreenshot(driver, "searchRecordUsingUserName");
			if (screenshotPath != null)
			{
				String absolutePath = new File(screenshotPath).getAbsolutePath();
				test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "searchRecordUsingUserName").build());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void searchRecordUsingUserRole()
	{
		try
		{
			objAdminPageActions.clickResetButton(driver, test);
			objAdminPageActions.clickUserRoleDropDown(driver, test);
			objAdminPageActions.selectValueForUserRole(driver, test);
			objAdminPageActions.clickSearchButton(driver, test);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			screenshotPath = Utils.captureScreenshot(driver, "searchRecordUsingUserRole");
			if (screenshotPath != null)
			{
				String absolutePath = new File(screenshotPath).getAbsolutePath();
				test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "searchRecordUsingUserRole").build());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void searchRecordUsingEmployeeName()
	{
		try
		{
			objAdminPageActions.clickResetButton(driver, test);
			objAdminPageActions.enterDataEmployeeName(driver, test);
			objAdminPageActions.selectEmployeeNameFromList(driver, test);
			objAdminPageActions.clickSearchButton(driver, test);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			screenshotPath = Utils.captureScreenshot(driver, "searchRecordUsingEmployeeName");
			if (screenshotPath != null)
			{
				String absolutePath = new File(screenshotPath).getAbsolutePath();
				test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "searchRecordUsingEmployeeName").build());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
package tests.pim;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import runner.BaseTest;
import ui.pageactions.dashboard.DashboardPageActions;
import ui.pageactions.login.LoginPageActions;
import ui.pageactions.pim.PIMPageActions;
import utilities.ExtentReportHandler;

public class PIMDeleteRecordTest extends BaseTest
{
	Boolean isLoginSuccess = false;
	Boolean isNavigatedToAdmin = false;
	LoginPageActions objLoginPageActions = new LoginPageActions();
	PIMPageActions objPimPageActions = new PIMPageActions();
	DashboardPageActions objDashboardPageActions = new DashboardPageActions();
	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();
	ExtentTest test = objExtentReportHandler.getInstance().createTest("AdminDeleteRecord");
	String screenshotPath = null;

	@BeforeClass
	private void navigateToAdmin()
	{
		try
		{
			// LOGIN
			objLoginPageActions.doLogin(driver, test);

			// Admin Page Navigation
			objDashboardPageActions.clickOnPageButton(driver, "PIM", test);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void deleteRecordFromAdminPage()
	{
		try
		{
			objPimPageActions.searchOperation(driver, test);
			Thread.sleep(2000);
			objPimPageActions.deleteOperation(driver, test);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

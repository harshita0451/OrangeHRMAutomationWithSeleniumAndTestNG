package tests.admin;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import runner.BaseTest;
import ui.pageactions.admin.AdminAddPageActions;
import ui.pageactions.admin.AdminPageActions;
import ui.pageactions.dashboard.DashboardPageActions;
import ui.pageactions.login.LoginPageActions;
import utilities.ExtentReportHandler;

public class AdminDeleteRecordTest extends BaseTest
{
	Boolean isLoginSuccess = false;
	Boolean isNavigatedToAdmin = false;
	LoginPageActions objLoginPageActions = new LoginPageActions();
	AdminPageActions objAdminPageActions = new AdminPageActions();
	DashboardPageActions objDashboardPageActions = new DashboardPageActions();
	AdminAddPageActions objAdminAddPageActions = new AdminAddPageActions();
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
			objDashboardPageActions.clickOnPageButton(driver, "Admin", test);
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
			objAdminPageActions.searchOperation(driver, test);
			objAdminPageActions.deleteOperation(driver, test);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

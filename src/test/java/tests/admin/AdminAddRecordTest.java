package tests.admin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import runner.BaseTest;
import ui.pageactions.admin.AdminAddPageActions;
import ui.pageactions.admin.AdminPageActions;
import ui.pageactions.dashboard.DashboardPageActions;
import ui.pageactions.login.LoginPageActions;
import utilities.ExtentReportHandler;

public class AdminAddRecordTest extends BaseTest
{
	AdminPageActions objAdminPageActions = new AdminPageActions();
	DashboardPageActions objDashboardPageActions = new DashboardPageActions();
	AdminAddPageActions objAdminAddPageActions = new AdminAddPageActions();
	LoginPageActions objLoginPageActions = new LoginPageActions();
	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();
	ExtentTest test = objExtentReportHandler.getInstance().createTest("AdminAddRecord");

	Boolean isLoginSuccess = false;
	Boolean isNavigatedToAdmin = false;
	Boolean isRecordAdded = false;

	@BeforeMethod
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
		}
	}

	@Test
	public void AddRecordInAdmin()
	{
		try
		{
			objAdminPageActions.clickAddButton(driver, test);
			isRecordAdded = objAdminAddPageActions.addUserInAdmin(driver, test);
//			if (isRecordAdded)
//			{
//				Assert.assertEquals(isRecordAdded, true, "Success");
//			}
//			else
//			{
//				Assert.assertEquals(isRecordAdded, false);
//			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

package tests.pim;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import runner.BaseTest;
import ui.pageactions.dashboard.DashboardPageActions;
import ui.pageactions.login.LoginPageActions;
import ui.pageactions.pim.PIMAddPageActions;
import ui.pageactions.pim.PIMPageActions;
import utilities.ExtentReportHandler;

public class PIMAddRecordTest extends BaseTest
{
	Boolean isLoginSuccess = false;
	Boolean isNavigatedToAdmin = false;

	LoginPageActions objLoginPageActions = new LoginPageActions();
	DashboardPageActions objDashboardPageActions = new DashboardPageActions();
	PIMPageActions objPIMPageActions = new PIMPageActions();
	PIMAddPageActions objPIMAddPageActions = new PIMAddPageActions();

	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();
	ExtentTest test = objExtentReportHandler.getInstance().createTest("PIMAddRecord");

	@BeforeMethod
	private void navigateToPIM()
	{
		try
		{
			isLoginSuccess = objLoginPageActions.doLogin(driver, test);
			if (isLoginSuccess)
			{
				isNavigatedToAdmin = objDashboardPageActions.clickOnPageButton(driver, "PIM", test);
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
	public void AddRecordInPIM()
	{
		try
		{
			objPIMPageActions.clickAddButton(driver, test);
			objPIMAddPageActions.addPIMUser(driver, test);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

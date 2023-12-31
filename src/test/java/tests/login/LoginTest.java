package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import runner.BaseTest;
import ui.pageactions.login.LoginPageActions;
import utilities.ExtentReportHandler;

public class LoginTest extends BaseTest
{
	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();
	ExtentTest test = objExtentReportHandler.getInstance().createTest("getLogin");
	Boolean isLoginSuccess = false;

	@Test(priority = 1)
	public void loginToHRM()
	{
		try
		{
			LoginPageActions objLoginPageActions = new LoginPageActions();
			isLoginSuccess = objLoginPageActions.doLogin(driver, test);

			if (isLoginSuccess)
			{
				Assert.assertEquals(isLoginSuccess, true, "Successfully Logged into the Application");
			}
			else
			{
				Assert.assertEquals(isLoginSuccess, true, "Login Failed");
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
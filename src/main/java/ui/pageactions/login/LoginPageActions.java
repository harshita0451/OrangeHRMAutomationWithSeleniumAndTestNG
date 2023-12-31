package ui.pageactions.login;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ui.datamodels.login.LoginDataModel;
import ui.pageobjects.dashboard.DashboardPageObjects;
import ui.pageobjects.login.LoginPageObjects;
import uicontrollers.UIActions;
import utilities.ExtentReportHandler;
import utilities.Utils;

public class LoginPageActions
{
	UIActions objUIActions = new UIActions();
	LoginPageObjects objLoginPageObjects = new LoginPageObjects();
	LoginDataModel objLoginDataModel = new LoginDataModel();
	DashboardPageObjects objDashboardPageObjects = new DashboardPageObjects();
	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();
	String screenshotPath = null;

	public void setTextToUserName(WebDriver driver, ExtentTest test)
	{
		try
		{
			objUIActions.setText(objLoginPageObjects.usernameElement(driver), objLoginDataModel.usernameData());
			test.log(Status.INFO, "Username Entered");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
	}

	public void setTextToPassWord(WebDriver driver, ExtentTest test)
	{
		try
		{
			objUIActions.setText(objLoginPageObjects.passwordElement(driver), objLoginDataModel.passwordData());
			test.log(Status.INFO, "Password Entered");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
	}

	public void clickOnLoginButton(WebDriver driver, ExtentTest test)
	{
		try
		{
			objUIActions.clickOnElement(objLoginPageObjects.loginButtonElement(driver), driver);
			test.log(Status.INFO, "Clicked Login Button");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
	}

	public Boolean doLogin(WebDriver driver, ExtentTest test)
	{
		Boolean isLoginSuccess = false;
		try
		{
			setTextToUserName(driver, test);
			setTextToPassWord(driver, test);
			clickOnLoginButton(driver, test);
			isLoginSuccess = validateLogin(driver, test);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
		return isLoginSuccess;
	}

	public Boolean validateLogin(WebDriver driver, ExtentTest test)
	{
		Boolean isLoginSuccess = false;
		try
		{
			WebElement dashboardText = objDashboardPageObjects.dashboardElement(driver);
			if (dashboardText != null)
			{
				isLoginSuccess = true;
				System.out.println("Login Successful");
				test.log(Status.PASS, "Valid Credentials Entered");
				screenshotPath = Utils.captureScreenshot(driver, "Login Passed");
				if (screenshotPath != null)
				{
					String absolutePath = new File(screenshotPath).getAbsolutePath();
					test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "Login Passed").build());
				}
			}
			else
			{
				System.out.println("Login Failed.");
				test.log(Status.FAIL, "Invalid Credentials Entered");
				screenshotPath = Utils.captureScreenshot(driver, "Login Failed");
				if (screenshotPath != null)
				{
					String absolutePath = new File(screenshotPath).getAbsolutePath();
					test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "Login Failed").build());
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return isLoginSuccess;
	}
}
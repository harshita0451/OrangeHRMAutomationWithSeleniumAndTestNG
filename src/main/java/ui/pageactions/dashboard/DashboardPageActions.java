package ui.pageactions.dashboard;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ui.pageobjects.admin.AdminPageObjects;
import ui.pageobjects.dashboard.DashboardPageObjects;
import ui.pageobjects.pim.PIMPageObjects;
import uicontrollers.ElementFinder;
import uicontrollers.UIActions;
import utilities.ExtentReportHandler;
import utilities.Utils;

public class DashboardPageActions
{
	UIActions objUIActions = new UIActions();
	DashboardPageObjects objDashboardPageObjects = new DashboardPageObjects();
	AdminPageObjects objAdminPageObjects = new AdminPageObjects();
	PIMPageObjects objPIMPageObjects = new PIMPageObjects();
	ElementFinder objElementFinder = new ElementFinder();
	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();
	String screenshotPath = null;
	Boolean isNavigated = false;

	public Boolean clickOnPageButton(WebDriver driver, String pageName, ExtentTest test)
	{
		try
		{
			switch (pageName)
			{
			case "Admin":
				objUIActions.clickOnElement(objDashboardPageObjects.adminButtonElement(driver), driver);
				break;
			case "PIM":
				objUIActions.clickOnElement(objDashboardPageObjects.pimButtonElement(driver), driver);
				break;
			}
			test.log(Status.INFO, "Clicked On " + pageName + " Button");
			isNavigated = PageValidation(driver, pageName, test);
		}
		catch (Exception e)
		{
			driver.quit();
			System.exit(1);
		}

		return isNavigated;
	}

	public Boolean PageValidation(WebDriver driver, String pageName, ExtentTest test)
	{
		try
		{
			WebElement element = null;
			switch (pageName)
			{
			case "Admin":
				element = objAdminPageObjects.adminPage(driver);
				break;
			case "PIM":
				element = objPIMPageObjects.pimPage(driver);
				break;
			}
			String txt = element.getText();
			if (txt.equalsIgnoreCase(pageName))
			{
				isNavigated = true;
				if (isNavigated)
				{
					System.out.println("Successfully Navigated to " + pageName);
					test.log(Status.PASS, "Navigation to " + pageName + " Successful");
					screenshotPath = Utils.captureScreenshot(driver, "Navigation Successful");
					if (screenshotPath != null)
					{
						String absolutePath = new File(screenshotPath).getAbsolutePath();
						test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "Navigation Successful").build());
					}
				}
				else
				{
					System.out.println("Navigation to " + pageName + " Unsuccessful");
					test.log(Status.FAIL, "Navigation to " + pageName + " Unsuccessful");
					screenshotPath = Utils.captureScreenshot(driver, "Navigation Unsuccessful");
					if (screenshotPath != null)
					{
						String absolutePath = new File(screenshotPath).getAbsolutePath();
						test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "Navigation Unsuccessful").build());
					}
					driver.quit();
					System.exit(1);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Error in Page Validation");
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
		return isNavigated;
	}
}

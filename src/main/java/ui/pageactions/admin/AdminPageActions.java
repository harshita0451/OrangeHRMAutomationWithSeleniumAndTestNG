package ui.pageactions.admin;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ui.datamodels.admin.AdminSearchDataModel;
import ui.pageobjects.admin.AdminPageObjects;
import uicontrollers.ElementFinder;
import uicontrollers.UIActions;
import utilities.ExtentReportHandler;
import utilities.Utils;

public class AdminPageActions
{
	UIActions objUIActions = new UIActions();
	AdminPageObjects objAdminPageObjects = new AdminPageObjects();
	ElementFinder objElementFinder = new ElementFinder();
	AdminSearchDataModel objAdminSearchDataModel = new AdminSearchDataModel();

	ExtentReportHandler objExtentReportHandler = new ExtentReportHandler();
	String screenshotPath = null;

	Boolean isSearch = false;
	Boolean isDeleted = false;

	public void searchOperation(WebDriver driver, ExtentTest test)
	{
		try
		{
			clickResetButton(driver, test);
			enterDataUserName(driver, test);
			clickUserRoleDropDown(driver, test);
			selectValueForUserRole(driver, test);
			enterDataEmployeeName(driver, test);
			selectEmployeeNameFromList(driver, test);
			clickStatusDropDown(driver, test);
			selectStatusFromList(driver, test);
			clickSearchButton(driver, test);
			Thread.sleep(3000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteOperation(WebDriver driver, ExtentTest test)
	{
		try
		{
			clickDeleteCheckBox(driver, test);
			clickDeleteButton(driver, test);
			clickDeleteButtonInPopup(driver, test);
			isDeleted = validateDelete(driver, test);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Boolean validateDelete(WebDriver driver, ExtentTest test)
	{
		try
		{
			isDeleted = objAdminPageObjects.deletePopUP(driver) != null;
			if (isDeleted)
			{
				test.log(Status.PASS, "Successfully Deleted");
			}
			else
			{
				test.log(Status.FAIL, "Unsuccessful Deletion");
			}
			screenshotPath = Utils.captureScreenshot(driver, "deleteRecordTest");
			if (screenshotPath != null)
			{
				String absolutePath = new File(screenshotPath).getAbsolutePath();
				test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "deleteRecordTest").build());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
		return isDeleted;
	}

	public void clickAddButton(WebDriver driver, ExtentTest test)
	{
		try
		{
			objUIActions.clickOnElement(objAdminPageObjects.addButton(driver), driver);
			test.log(Status.INFO, "Clicked On Add Button");
		}
		catch (Exception e)
		{
			test.log(Status.INFO, "Clicked On Add Button Interrupted");
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
	}

	public void enterDataUserName(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objAdminPageObjects.userNameTxtBox(driver), objAdminSearchDataModel.userNameData());
		test.log(Status.INFO, "Username entered in Username Text Field");
	}

	public void clickUserRoleDropDown(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminPageObjects.userRoleDropDownButton(driver), driver);
		test.log(Status.INFO, "Clicked the User Role Drop Down Button");
	}

	public void selectValueForUserRole(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminPageObjects.userRoleDropDownButtonList(driver), driver);
		test.log(Status.INFO, "Clicked on an option From User Role Drop Down");
	}

	public void enterDataEmployeeName(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objAdminPageObjects.employeeNameHints(driver), objAdminSearchDataModel.employeeNameData());
		test.log(Status.INFO, "Enter the Employee Name in the Text Field");
	}

	public void selectEmployeeNameFromList(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminPageObjects.employeeNameHintsList(driver), driver);
		test.log(Status.INFO, "Clicked on an option From the Hints displayed under the Employee Name");
	}

	public void clickStatusDropDown(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminPageObjects.statusDropDownButton(driver), driver);
		test.log(Status.INFO, "Clicked on Status Drop Down Button");
	}

	public void selectStatusFromList(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminPageObjects.statusDropDownButtonList(driver), driver);
		test.log(Status.INFO, "Clicked on an option from the List displayed under the Status");
	}

	public void clickSearchButton(WebDriver driver, ExtentTest test)
	{
		try
		{
			objUIActions.clickOnElement(objAdminPageObjects.searchButton(driver), driver);
			Thread.sleep(1000);

			test.log(Status.INFO, "Clicked on Search Button");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
	}

	public void clickResetButton(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminPageObjects.resetButton(driver), driver);
		test.log(Status.INFO, "Clicked On Reset Button");
	}

	public void clickDeleteCheckBox(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminPageObjects.deleteCheckBox(driver), driver);
		test.log(Status.INFO, "Clicked On checkbox beside the record");
	}

	public void clickDeleteButton(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminPageObjects.deleteButton(driver), driver);
		test.log(Status.INFO, "Clicked On Delete Selected Button");
	}

	public void clickDeleteButtonInPopup(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminPageObjects.popupDeleteButton(driver), driver);
		test.log(Status.INFO, "Clicked On Yes Delete Button in the Pop up");
	}
}

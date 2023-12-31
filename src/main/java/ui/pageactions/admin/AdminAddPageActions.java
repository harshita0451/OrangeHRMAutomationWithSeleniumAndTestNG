package ui.pageactions.admin;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ui.datamodels.admin.AdminAddDataModel;
import ui.pageobjects.admin.AdminPageObjects;
import uicontrollers.UIActions;
import utilities.Utils;

public class AdminAddPageActions
{
	UIActions objUIActions = new UIActions();
	AdminPageObjects objAdminAddPageObjects = new AdminPageObjects();
	AdminPageObjects objAdminPageObjects = new AdminPageObjects();
	AdminAddDataModel objAdminAddDataModel = new AdminAddDataModel();
	String screenshotPath = null;
	Boolean isAddUserPage = false;
	Boolean isAddSucess = false;

	public Boolean addUserInAdmin(WebDriver driver, ExtentTest test)
	{
		try
		{
			isAddUserPage = validateAddUserPage(driver, test);
			if (isAddUserPage)
			{
				clickUserRoleDropDown(driver, test);
				selectOptionFromUserRoleDropDown(driver, test);
				setTextEmployeeName(driver, test);
				selectOptionFromEmployeeNameDropDown(driver, test);
				clickStatusDropDown(driver, test);
				selectOptionFromStatusDropDown(driver, test);
				userNameTxtBox(driver, test);
				passWordTxtBox(driver, test);
				confirmPassWordTxtBox(driver, test);
				clickOnSaveButton(driver, test);
				isAddSucess = popUpValidation(driver, test);
			}
			else
			{
				System.out.println("Not in Add User Page");
				driver.quit();
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return isAddUserPage;
	}

	public Boolean popUpValidation(WebDriver driver, ExtentTest test)
	{
		try
		{
			isAddSucess = objAdminAddPageObjects.savedPopUP(driver) != null;
			if (isAddSucess)
			{
				System.out.println("Record Added Successfully in Admin");
				test.log(Status.PASS, "Record Added Successfully in Admin");
				screenshotPath = Utils.captureScreenshot(driver, "Add Record Passed");
				if (screenshotPath != null)
				{
					String absolutePath = new File(screenshotPath).getAbsolutePath();
					test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "Add Record Passed").build());
				}
			}
			else
			{
				System.out.println("Record Addition Unsuccessful in Admin");
				test.log(Status.FAIL, "Record Addition Unsuccessful in Admin");
				screenshotPath = Utils.captureScreenshot(driver, "Add Record Failed");
				if (screenshotPath != null)
				{
					String absolutePath = new File(screenshotPath).getAbsolutePath();
					test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(absolutePath, "Add Record Failed").build());
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Record Addition in Admin Interrupted");
			e.printStackTrace();
			driver.quit();
			System.exit(1);
		}
		return isAddSucess;
	}

	public Boolean validateAddUserPage(WebDriver driver, ExtentTest test)
	{
		try
		{
			WebElement element = objAdminAddPageObjects.adminAddPage(driver);
			if (element != null)
			{
				isAddUserPage = true;
				test.log(Status.PASS, "User on Add User Page");
			}
			else
			{
				test.log(Status.FAIL, "Navigation to Add User Page Failed");
				driver.quit();
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Navigation to Add User Page Interrupted");
			driver.quit();
			System.exit(1);
		}

		return isAddUserPage;
	}

	public void clickUserRoleDropDown(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminAddPageObjects.userRoleDropDownButton(driver), driver);
		test.log(Status.INFO, "Clicked On User Role Drop Down Button");
	}

	public void selectOptionFromUserRoleDropDown(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminAddPageObjects.userRoleDropDownButtonList(driver), driver);
		test.log(Status.INFO, "Option Selected From User Role Drop Down");
	}

	public void setTextEmployeeName(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objAdminAddPageObjects.employeeNameHints(driver), objAdminAddDataModel.employeeNameData());
		test.log(Status.INFO, "Employee Name entered in the Text Box");
	}

	public void selectOptionFromEmployeeNameDropDown(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminAddPageObjects.employeeNameHintsList(driver), driver);
		test.log(Status.INFO, "Clicked on Employee Name from the List");
	}

	public void clickStatusDropDown(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminAddPageObjects.statusDropDownButton(driver), driver);
		test.log(Status.INFO, "Clicked On Status Drop Down Button");
	}

	public void selectOptionFromStatusDropDown(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminAddPageObjects.statusDropDownButtonList(driver), driver);
		test.log(Status.INFO, "Option Selected From Status Drop Down");
	}

	public void userNameTxtBox(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objAdminAddPageObjects.userNameTxtBox(driver), objAdminAddDataModel.userNameData());
		test.log(Status.INFO, "User Name entered in the Username Text Box");
	}

	public void passWordTxtBox(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objAdminAddPageObjects.passWordTxtBox(driver), objAdminAddDataModel.passWordData());
	}

	public void confirmPassWordTxtBox(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objAdminAddPageObjects.confirmPassWordTxtBox(driver), objAdminAddDataModel.confirmPassWordData());
		test.log(Status.INFO, "Password entered in the Password Text Box");
	}

	public void clickOnSaveButton(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objAdminAddPageObjects.saveButton(driver), driver);
		test.log(Status.INFO, "Password entered in the Confirm Password Text Box");
	}
}

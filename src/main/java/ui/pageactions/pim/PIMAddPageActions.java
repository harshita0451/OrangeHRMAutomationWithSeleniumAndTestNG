package ui.pageactions.pim;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ui.datamodels.pim.PIMAddDataModel;
import ui.pageobjects.pim.PIMPageObjects;
import uicontrollers.UIActions;
import utilities.Utils;

public class PIMAddPageActions
{
	UIActions objUIActions = new UIActions();
	PIMPageObjects objPIMPageObjects = new PIMPageObjects();
	PIMAddDataModel objPimAddDataModel = new PIMAddDataModel();
	Boolean isAddSuccess = false;
	String screenshotPath = null;

	public void addPIMUser(WebDriver driver, ExtentTest test)
	{
		enterFirstName(driver, test);
		enterMiddleName(driver, test);
		enterLastName(driver, test);
		pushEnterLoginDetailsCheckBox(driver, test);
		enterUserName(driver, test);
		selectStatus(driver, test);
		enterPassWord(driver, test);
		enterConfirmPassWord(driver, test);
		clickSaveButton(driver, test);
		pimAddValidation(driver, test);
	}

	public void enterFirstName(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objPIMPageObjects.firstNameTxtBox(driver), objPimAddDataModel.firstNameData());
		test.log(Status.INFO, "Entered First Name in the Text Box");
	}

	public void enterMiddleName(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objPIMPageObjects.middleNameTxtBox(driver), objPimAddDataModel.middleNameData());
		test.log(Status.INFO, "Entered Middle Name in the Text Box");
	}

	public void enterLastName(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objPIMPageObjects.lastNameTxtBox(driver), objPimAddDataModel.lastNameData());
		test.log(Status.INFO, "Entered Last Name in the Text Box");
	}

	public void pushEnterLoginDetailsCheckBox(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objPIMPageObjects.createLoginDetails_PushButton(driver), driver);
		test.log(Status.INFO, "Clicked Enter Login Details Check Box");
	}

	public void enterUserName(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objPIMPageObjects.userNameTxtBox(driver), objPimAddDataModel.userNameData());
		test.log(Status.INFO, "Entered Username in the Username Text Field");
	}

	public void selectStatus(WebDriver driver, ExtentTest test)
	{
		if (objPimAddDataModel.statusData().equalsIgnoreCase("Enabled"))
		{
			objUIActions.clickOnElement(objPIMPageObjects.enabledStatus_RadioButton(driver), driver);
		}
		else
		{
			objUIActions.clickOnElement(objPIMPageObjects.disabledStatus_RadioButton(driver), driver);
		}
		test.log(Status.INFO, "Clicked On Status Option " + objPimAddDataModel.statusData());
	}

	public void enterPassWord(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objPIMPageObjects.passWordTxtBox(driver), objPimAddDataModel.passWordData());
		test.log(Status.INFO, "Entered Password in the Password Text Box");
	}

	public void enterConfirmPassWord(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objPIMPageObjects.confirmPassWordTxtBox(driver), objPimAddDataModel.confirmPassWordData());
		test.log(Status.INFO, "Entered Password in the Confirm Password Text Box");
	}

	public void clickSaveButton(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objPIMPageObjects.saveButton(driver), driver);
		test.log(Status.INFO, "Clicked On Save Button");
	}

	public void pimAddValidation(WebDriver driver, ExtentTest test)
	{
		try
		{
			isAddSuccess = objPIMPageObjects.savedPopUP(driver) != null;
			if (isAddSuccess)
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
			e.printStackTrace();
		}
	}
}

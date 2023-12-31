package ui.pageactions.pim;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ui.datamodels.pim.PIMAddDataModel;
import ui.pageobjects.pim.PIMPageObjects;
import uicontrollers.ElementFinder;
import uicontrollers.UIActions;
import utilities.Utils;

public class PIMPageActions
{
	UIActions objUIActions = new UIActions();
	PIMPageObjects objPIMPageObjects = new PIMPageObjects();
	ElementFinder objElementFinder = new ElementFinder();
	PIMAddDataModel objPIMAddDataModel = new PIMAddDataModel();

	String screenshotPath = null;
	Boolean isDeleted = false;

	public void clickAddButton(WebDriver driver, ExtentTest test)
	{
		try
		{
			objUIActions.clickOnElement(objPIMPageObjects.addButton(driver), driver);
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

	public void searchOperation(WebDriver driver, ExtentTest test)
	{
		try
		{
			enterValueEmployeeName(driver, test);
			clickSearchButton(driver, test);

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

	public void enterValueEmployeeName(WebDriver driver, ExtentTest test)
	{
		objUIActions.setText(objPIMPageObjects.employeeNameHints(driver), objPIMAddDataModel.employeeNameData());
		test.log(Status.INFO, "Entered employee name in Employee Name Text Box");
	}

	public void clickSearchButton(WebDriver driver, ExtentTest test)
	{
		try
		{
			objUIActions.clickOnElement(objPIMPageObjects.search_Button(driver), driver);
			test.log(Status.INFO, "Clicked On Search Button");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void clickDeleteCheckBox(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objPIMPageObjects.deleteCheckBox(driver), driver);
		test.log(Status.INFO, "Clicked On Checkbox beside the Record");
	}

	public void clickDeleteButton(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objPIMPageObjects.deleteButton(driver), driver);
		test.log(Status.INFO, "Clicked On Delete Selected Button");
	}

	public void clickDeleteButtonInPopup(WebDriver driver, ExtentTest test)
	{
		objUIActions.clickOnElement(objPIMPageObjects.popupDeleteButton(driver), driver);
		test.log(Status.INFO, "Clicked On Yes Delete Button");
	}

	public Boolean validateDelete(WebDriver driver, ExtentTest test)
	{
		try
		{
			isDeleted = objPIMPageObjects.deletePopUP(driver) != null;
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
}

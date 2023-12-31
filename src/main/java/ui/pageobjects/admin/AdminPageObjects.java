package ui.pageobjects.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uicontrollers.ElementFinder;
import utilities.JsonHandler;

public class AdminPageObjects
{
	ElementFinder objElementFinder = new ElementFinder();
	JsonHandler objJsonHandler = new JsonHandler();

	String elementfilepath = "C:\\Users\\sarvani.shk\\eclipse-workspace\\testng\\src\\main\\resources\\pagelocators\\admin\\AdminObjects.json";
	String constantfilepath = "C:\\Users\\sarvani.shk\\eclipse-workspace\\testng\\src\\main\\resources\\pagelocators\\admin\\AdminAddData.json";

	public WebElement savedPopUP(WebDriver driver)
	{
		WebElement savedPopup = objJsonHandler.getElementFromJSON(driver, elementfilepath, "AddUserPopUP");
		return savedPopup;
	}

	public WebElement deletePopUP(WebDriver driver)
	{
		WebElement savedPopup = objJsonHandler.getElementFromJSON(driver, elementfilepath, "DeleteUserPopUP");
		return savedPopup;
	}

	public WebElement adminPage(WebDriver driver)
	{
		WebElement adminPage = objJsonHandler.getElementFromJSON(driver, elementfilepath, "AdminPage_Txt");
		return adminPage;
	}

	public WebElement adminAddPage(WebDriver driver)
	{
		WebElement adminAddPage = objJsonHandler.getElementFromJSON(driver, elementfilepath, "AdminAddPage_Txt");
		return adminAddPage;
	}

	public WebElement addButton(WebDriver driver)
	{
		WebElement addButtonElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Add_Button");
		return addButtonElement;
	}

	public WebElement userRoleDropDownButton(WebDriver driver)
	{
		WebElement userRoleDropDownButtonElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "UserRole_dropDown");
		return userRoleDropDownButtonElement;
	}

	public WebElement userRoleDropDownButtonList(WebDriver driver)
	{
		WebElement userRoleELementFromList = objJsonHandler.selectElementFromListJSON(driver, elementfilepath, constantfilepath, "UserRole_dropDownList", "UserRole_txt");
		return userRoleELementFromList;
	}

	public WebElement employeeNameHints(WebDriver driver)
	{
		WebElement employeeNameHintsElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "EmployeeName_hints");
		return employeeNameHintsElement;
	}

	public WebElement employeeNameHintsList(WebDriver driver)
	{
		WebElement employeeNameFromList = objJsonHandler.selectElementFromListJSON(driver, elementfilepath, constantfilepath, "EmployeeName_hintsList", "EmployeeName_txt");
		return employeeNameFromList;
	}

	public WebElement statusDropDownButton(WebDriver driver)
	{
		WebElement statusDropDownButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Status_dropDown");
		return statusDropDownButton;
	}

	public WebElement statusDropDownButtonList(WebDriver driver)
	{
		WebElement statusFromList = objJsonHandler.selectElementFromListJSON(driver, elementfilepath, constantfilepath, "Status_dropDownList", "Status_txt");
		return statusFromList;
	}

	public WebElement userNameTxtBox(WebDriver driver)
	{
		WebElement userNameTxtBoxElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "UserName_txtBox");
		return userNameTxtBoxElement;
	}

	public WebElement passWordTxtBox(WebDriver driver)
	{
		WebElement passWordTxtBoxElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "PassWord_txtBox");
		return passWordTxtBoxElement;
	}

	public WebElement confirmPassWordTxtBox(WebDriver driver)
	{
		WebElement confirmPassWordTxtBoxElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "ConfirmPassword_txtBox");
		return confirmPassWordTxtBoxElement;
	}

	public WebElement saveButton(WebDriver driver)
	{
		WebElement saveButtonElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Save_Button");
		return saveButtonElement;
	}

	public WebElement searchButton(WebDriver driver)
	{
		WebElement searchButtonElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Search_Button");
		return searchButtonElement;
	}

	public WebElement resetButton(WebDriver driver)
	{
		WebElement resetButtonElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Reset_Button");
		return resetButtonElement;
	}

	public WebElement deleteCheckBox(WebDriver driver)
	{
		WebElement deleteCheckBoxElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Delete_chechBox");
		return deleteCheckBoxElement;
	}

	public WebElement deleteButton(WebDriver driver)
	{
		WebElement deleteButtonElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Delete_Button");
		return deleteButtonElement;
	}

	public WebElement popupDeleteButton(WebDriver driver)
	{
		WebElement popupDeleteButtonElement = objJsonHandler.getElementFromJSON(driver, elementfilepath, "PopUPDelete_Button");
		return popupDeleteButtonElement;
	}
}

package ui.pageobjects.pim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uicontrollers.ElementFinder;
import utilities.JsonHandler;

public class PIMPageObjects
{
	ElementFinder objElementFinder = new ElementFinder();
	JsonHandler objJsonHandler = new JsonHandler();
	String elementfilepath = "C:\\Users\\sarvani.shk\\eclipse-workspace\\testng\\src\\main\\resources\\pagelocators\\pim\\PIMObjects.json";
	String constantfilepath = "C:\\Users\\sarvani.shk\\eclipse-workspace\\testng\\src\\main\\resources\\pagelocators\\pim\\PIMAddData.json";

	public WebElement addButton(WebDriver driver)
	{
		WebElement addButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Add_Button");
		return addButton;
	}

	public WebElement employeeNameHints(WebDriver driver)
	{
		WebElement employeeName = objJsonHandler.getElementFromJSON(driver, elementfilepath, "EmployeeName_Hints");
		return employeeName;
	}

	public WebElement employeeNameHintsList(WebDriver driver)
	{
		WebElement employeeFromList = objJsonHandler.selectElementFromListJSON(driver, elementfilepath, constantfilepath, "EmployeeName_HintsList", "EmployeeName_Txt");
		return employeeFromList;
	}

	public WebElement employeeIDTxtBox(WebDriver driver)
	{
		WebElement employeeID = objJsonHandler.getElementFromJSON(driver, elementfilepath, "EmployeeID_TxtBox");
		return employeeID;
	}

	public WebElement employmentStatusDropDownButton(WebDriver driver)
	{
		WebElement employeeStatusDropDown = objJsonHandler.getElementFromJSON(driver, elementfilepath, "EmploymentStatus_DropDown");
		return employeeStatusDropDown;
	}

	public WebElement employmentStatusDropDownButtonList(WebDriver driver)
	{
		WebElement employeeStatusFromList = objJsonHandler.selectElementFromListJSON(driver, elementfilepath, constantfilepath, "EmploymentStatus_DropDownList", "UserRole_txt");
		return employeeStatusFromList;
	}

	public WebElement includeDropDownButton(WebDriver driver)
	{
		WebElement includeDropDown = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Include_DropDown");
		return includeDropDown;
	}

	public WebElement includeDropDownButtonList(WebDriver driver)
	{
		WebElement includeFromList = objJsonHandler.selectElementFromListJSON(driver, elementfilepath, constantfilepath, "Include_DropDownList", "UserRole_txt");
		return includeFromList;
	}

	public WebElement supervisorNameHints(WebDriver driver)
	{
		WebElement supervisorName = objJsonHandler.getElementFromJSON(driver, elementfilepath, "SupervisorName_Hints");
		return supervisorName;
	}

	public WebElement supervisorHintsList(WebDriver driver)
	{
		WebElement supervisorFromList = objJsonHandler.selectElementFromListJSON(driver, elementfilepath, constantfilepath, "SupervisorName_HintsList", "EmployeeName_txt");
		return supervisorFromList;
	}

	public WebElement jobTitleDropDownButton(WebDriver driver)
	{
		WebElement jobTitleDropDown = objJsonHandler.getElementFromJSON(driver, elementfilepath, "JobTitle_DropDown");
		return jobTitleDropDown;
	}

	public WebElement jobTitleDropDownButtonList(WebDriver driver)
	{
		WebElement jobTitleFromList = objJsonHandler.selectElementFromListJSON(driver, elementfilepath, constantfilepath, "JobTitle_DropDownList", "UserRole_txt");
		return jobTitleFromList;
	}

	public WebElement subUnitDropDownButton(WebDriver driver)
	{
		WebElement subUnitDropDown = objJsonHandler.getElementFromJSON(driver, elementfilepath, "SubUnit_DropDown");
		return subUnitDropDown;
	}

	public WebElement subUnitDropDownButtonList(WebDriver driver)
	{
		WebElement subUnitFromList = objJsonHandler.selectElementFromListJSON(driver, elementfilepath, constantfilepath, "SubUnit_DropDownList", "UserRole_txt");
		return subUnitFromList;
	}

	public WebElement search_Button(WebDriver driver)
	{
		WebElement searchButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Search_Button");
		return searchButton;
	}

	public WebElement reset_Button(WebDriver driver)
	{
		WebElement resetButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Reset_Butoon");
		return resetButton;
	}

	public WebElement add_Button(WebDriver driver)
	{
		WebElement addButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Add_Button");
		return addButton;
	}

	public WebElement checkBox_Button(WebDriver driver)
	{
		WebElement chechBoxButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Checkbox_Button");
		return chechBoxButton;
	}

	public WebElement delete_Button(WebDriver driver)
	{
		WebElement deleteButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Delete_Button");
		return deleteButton;
	}

	public WebElement deletePopUp_Button(WebDriver driver)
	{
		WebElement deletePopupButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "DeleteButtonPopup");
		return deletePopupButton;
	}

	public WebElement firstNameTxtBox(WebDriver driver)
	{
		WebElement firstName = objJsonHandler.getElementFromJSON(driver, elementfilepath, "FirstName_TxtBox");
		return firstName;
	}

	public WebElement middleNameTxtBox(WebDriver driver)
	{
		WebElement middleName = objJsonHandler.getElementFromJSON(driver, elementfilepath, "MiddleName_TxtBox");
		return middleName;
	}

	public WebElement lastNameTxtBox(WebDriver driver)
	{
		WebElement lastName = objJsonHandler.getElementFromJSON(driver, elementfilepath, "LastName_TxtBox");
		return lastName;
	}

	public WebElement createLoginDetails_PushButton(WebDriver driver)
	{
		WebElement createLoginDetailsPushButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "CreateLoginDetails_CheckBox");
		return createLoginDetailsPushButton;
	}

	public WebElement userNameTxtBox(WebDriver driver)
	{
		WebElement userName = objJsonHandler.getElementFromJSON(driver, elementfilepath, "UserName_TxtBox");
		return userName;
	}

	public WebElement passWordTxtBox(WebDriver driver)
	{
		WebElement passWord = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Password_TxtBox");
		return passWord;
	}

	public WebElement confirmPassWordTxtBox(WebDriver driver)
	{
		WebElement confirmPassWord = objJsonHandler.getElementFromJSON(driver, elementfilepath, "ConfirmPassword_TxtBox");
		return confirmPassWord;
	}

	public WebElement enabledStatus_RadioButton(WebDriver driver)
	{
		WebElement enabledStatus = objJsonHandler.getElementFromJSON(driver, elementfilepath, "EnabledStatus_RadioButton");
		return enabledStatus;
	}

	public WebElement disabledStatus_RadioButton(WebDriver driver)
	{
		WebElement disabledStatus = objJsonHandler.getElementFromJSON(driver, elementfilepath, "DisabledStatus_RadioButton");
		return disabledStatus;
	}

	public WebElement saveButton(WebDriver driver)
	{
		WebElement saveButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Save_Button");
		return saveButton;
	}

	public WebElement deleteCheckBox(WebDriver driver)
	{
		WebElement deleteCheckBox = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Checkbox_Button");
		return deleteCheckBox;
	}

	public WebElement deleteButton(WebDriver driver)
	{
		WebElement deleteButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "Delete_Button");
		return deleteButton;
	}

	public WebElement popupDeleteButton(WebDriver driver)
	{
		WebElement popupDeleteButton = objJsonHandler.getElementFromJSON(driver, elementfilepath, "DeleteButtonPopup");
		return popupDeleteButton;
	}

	public WebElement pimPage(WebDriver driver)
	{
		WebElement pimPage = objJsonHandler.getElementFromJSON(driver, elementfilepath, "pimPage");
		return pimPage;
	}

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
}

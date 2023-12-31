package ui.pageobjects.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uicontrollers.ElementFinder;
import utilities.JsonHandler;

public class LoginPageObjects
{
	ElementFinder objElementFinder = new ElementFinder();
	JsonHandler objJsonHandler = new JsonHandler();
	String elementFilepath = "C:\\Users\\sarvani.shk\\eclipse-workspace\\testng\\src\\main\\resources\\pagelocators\\login\\LoginPage.json";

	public WebElement usernameElement(WebDriver driver)
	{
		WebElement userName = objJsonHandler.getElementFromJSON(driver, elementFilepath, "UserName_txtBox");
		return userName;
	}

	public WebElement passwordElement(WebDriver driver)
	{
		WebElement passWord = objJsonHandler.getElementFromJSON(driver, elementFilepath, "Password_txtBox");
		return passWord;
	}

	public WebElement loginButtonElement(WebDriver driver)
	{
		WebElement loginButton = objJsonHandler.getElementFromJSON(driver, elementFilepath, "Login_button");
		return loginButton;
	}
}
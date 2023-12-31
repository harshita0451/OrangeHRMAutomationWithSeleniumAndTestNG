package ui.pageobjects.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uicontrollers.ElementFinder;
import utilities.JsonHandler;

public class DashboardPageObjects
{
	ElementFinder objElementFinder = new ElementFinder();
	JsonHandler objJsonHandler = new JsonHandler();
	String elementFilepath = "C:\\Users\\sarvani.shk\\eclipse-workspace\\testng\\src\\main\\resources\\pagelocators\\dashboard\\Dashboard.json";

	public WebElement dashboardElement(WebDriver driver)
	{
		WebElement dashboardElement = objJsonHandler.getElementFromJSON(driver, elementFilepath, "DashboardElement");
		return dashboardElement;
	}

	public WebElement adminButtonElement(WebDriver driver)
	{
		WebElement adminButtonElement = objJsonHandler.getElementFromJSON(driver, elementFilepath, "Admin_button");
		return adminButtonElement;
	}

	public WebElement pimButtonElement(WebDriver driver)
	{
		WebElement pimButtonElement = objJsonHandler.getElementFromJSON(driver, elementFilepath, "PIM_button");
		return pimButtonElement;
	}
}

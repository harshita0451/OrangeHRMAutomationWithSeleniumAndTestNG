package uicontrollers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIActions
{
	ElementFinder objElementFinder = new ElementFinder();

	public void setText(WebElement element, String value)
	{
		try
		{
			if (element != null)
			{
				element.sendKeys(value);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setText(WebDriver driver, String locator, String locatorValue, String value)
	{
		WebElement element = objElementFinder.getElement(null, locator, locatorValue);
		try
		{
			if (element != null)
			{
				element.sendKeys(value);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void clickOnElement(WebElement element, WebDriver driver)
	{
		try
		{
			if (element != null)
			{
				objElementFinder.waitForElementToBeClickable(driver, element);

				element.click();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void clickOnElement(WebDriver driver, String locator, String locatorValue)
	{
		WebElement element = objElementFinder.getElement(driver, locator, locatorValue);
		try
		{
			if (element != null)
			{
				objElementFinder.waitForElementToBeClickable(driver, element);

				element.click();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

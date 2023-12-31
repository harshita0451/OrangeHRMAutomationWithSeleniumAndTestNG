package uicontrollers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ElementHandler;
import utilities.Utils;

public class ElementFinder
{
	Utils objUtils = new Utils();
	ElementHandler objElementHandler = new ElementHandler();

	public WebElement getElement(WebDriver driver, String locatorType, String locatorValue)
	{
		WebElement element = null;
		try
		{
			waitForElementToBePresent(driver, locatorType, locatorValue);
			By locator = objElementHandler.getlocator(locatorType, locatorValue);
			element = driver.findElement(locator);
		}
		catch (Exception e)
		{
			System.out.println(locatorValue);
			System.out.println("Error in locating element. Terminating...");
		}
		return element;
	}

	public WebDriverWait returnWait(WebDriver driver)
	{
		WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return ewait;
	}

	public void waitForElementToBePresent(WebDriver driver, String locatorType, String locatorValue)
	{
		WebDriverWait ewait = returnWait(driver);
		By locator = objElementHandler.getlocator(locatorType, locatorValue);
		ewait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait ewait = returnWait(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void numberOfElementsTobe(WebDriver driver, String path)
	{
		WebDriverWait ewait = returnWait(driver);
		ewait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(path), 1));
	}

	public void numberOfElementsTobeMoreThan(WebDriver driver, String locatorType, String locatorValue)
	{
		WebDriverWait ewait = returnWait(driver);
		ElementHandler objElementHandler = new ElementHandler();
		By locator = objElementHandler.getlocator(locatorType, locatorValue);
		ewait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 1));
	}

	public void waitForTextToBe(WebDriver driver, String locatorType, String locatorValue, String expectedText)
	{
		WebDriverWait ewait = returnWait(driver);
		ElementHandler objElementHandler = new ElementHandler();
		By locator = objElementHandler.getlocator(locatorType, locatorValue);
		ewait.until(ExpectedConditions.textToBe(locator, expectedText));
	}

	public WebElement getElementFromListOfElements(WebDriver driver, String locatorType, String locatorValue, String data)
	{
		WebElement element = null;
		try
		{
			numberOfElementsTobeMoreThan(driver, locatorType, locatorValue);
			ElementHandler objElementHandler = new ElementHandler();
			By locator = objElementHandler.getlocator(locatorType, locatorValue);
			List<WebElement> list_of_elements = driver.findElements(locator);
			if (list_of_elements != null && !list_of_elements.isEmpty())
			{
				for (WebElement ele : list_of_elements)
				{
					String elementText = ele.getText();
					if (elementText != null && elementText.contains(data))
					{
						element = ele;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return element;
	}
}

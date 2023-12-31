package utilities;

import org.openqa.selenium.By;

public class ElementHandler
{
	public By getlocator(String locatorType, String locatorValue)
	{
		By locator = null;
		try
		{
			if (locatorType != null && locatorValue != null)
			{
				switch (locatorType.toLowerCase())
				{
				case "xpath":
					locator = By.xpath(locatorValue);
					break;
				case "id":
					locator = By.id(locatorValue);
					break;
				case "name":
					locator = By.name(locatorValue);
					break;
				case "linktext":
					locator = By.linkText(locatorValue);
					break;
				case "partiallinktext":
					locator = By.partialLinkText(locatorValue);
					break;
				case "classname":
					locator = By.className(locatorValue);
					break;
				case "cssselector":
					locator = By.cssSelector(locatorValue);
					break;
				case "tagname":
					locator = By.tagName(locatorValue);
					break;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return locator;
	}
}

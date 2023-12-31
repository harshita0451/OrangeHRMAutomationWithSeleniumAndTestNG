package utilities;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uicontrollers.ElementFinder;

public class JsonHandler
{
	ElementFinder objElementFinder = new ElementFinder();

	public String valuesFromJson(String filepath, String pKey, String key)
	{
		String value = null;
		try
		{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filepath));
			JSONObject jsonObj = (JSONObject) obj;

			JSONObject objPKey = (JSONObject) jsonObj.get(pKey);

			value = (String) objPKey.get(key);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}

	public WebElement getElementFromJSON(WebDriver driver, String elementfilepath, String child_key)
	{
		String elementLocator = valuesFromJson(elementfilepath, "elements", child_key);
		String[] elementLocatorArray = elementLocator.split("->");
		return objElementFinder.getElement(driver, elementLocatorArray[0], elementLocatorArray[1]);
	}

	public WebElement selectElementFromListJSON(WebDriver driver, String elementfilepath, String constantfilepath, String child_key, String data)
	{
		String elementLocator = valuesFromJson(elementfilepath, "elements", child_key);
		String[] elementLocatorArray = elementLocator.split("->");
		String elementLocatorData = valuesFromJson(constantfilepath, "constants", data);
		return objElementFinder.getElementFromListOfElements(driver, elementLocatorArray[0], elementLocatorArray[1], elementLocatorData);
	}
}
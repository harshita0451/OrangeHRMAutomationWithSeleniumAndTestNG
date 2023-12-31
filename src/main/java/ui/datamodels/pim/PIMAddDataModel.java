package ui.datamodels.pim;

import utilities.JsonHandler;

public class PIMAddDataModel
{
	JsonHandler objJsonHandler = new JsonHandler();
	String filepath = "C:\\Users\\sarvani.shk\\eclipse-workspace\\testng\\src\\main\\resources\\pagelocators\\pim\\PIMAddData.json";

	public String firstNameData()
	{
		String firstNameData = objJsonHandler.valuesFromJson(filepath, "constants", "FirstName_Txt");
		return firstNameData;
	}

	public String middleNameData()
	{
		String middleNameData = objJsonHandler.valuesFromJson(filepath, "constants", "MiddleName_Txt");
		return middleNameData;
	}

	public String lastNameData()
	{
		String lastNameData = objJsonHandler.valuesFromJson(filepath, "constants", "LastName_Txt");
		return lastNameData;
	}

	public String userNameData()
	{
		String userNameData = objJsonHandler.valuesFromJson(filepath, "constants", "UserName_Txt");
		return userNameData;
	}

	public String passWordData()
	{
		String passWordData = objJsonHandler.valuesFromJson(filepath, "constants", "Password_Txt");
		return passWordData;
	}

	public String confirmPassWordData()
	{
		String confirmPassWordData = objJsonHandler.valuesFromJson(filepath, "constants", "ConfirmPassword_Txt");
		return confirmPassWordData;
	}

	public String statusData()
	{
		String statusData = objJsonHandler.valuesFromJson(filepath, "constants", "Status_RadioButton");
		return statusData;
	}

	public String employeeNameData()
	{
		String employeeNameData = objJsonHandler.valuesFromJson(filepath, "constants", "EmployeeName_Txt");
		return employeeNameData;
	}
}

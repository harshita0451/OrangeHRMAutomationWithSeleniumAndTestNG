package ui.datamodels.admin;

import utilities.JsonHandler;

public class AdminSearchDataModel
{
	JsonHandler objJsonHandler = new JsonHandler();
	String filepath = "C:\\Users\\sarvani.shk\\eclipse-workspace\\testng\\src\\main\\resources\\pagelocators\\admin\\AdminAddData.json";

	public String userRoleData()
	{
		String userRoleData = objJsonHandler.valuesFromJson(filepath, "constants", "UserRole_txt");
		return userRoleData;
	}

	public String employeeNameData()
	{
		String employeeNameData = objJsonHandler.valuesFromJson(filepath, "constants", "EmployeeName_txt");
		return employeeNameData;
	}

	public String statusData()
	{
		String statusData = objJsonHandler.valuesFromJson(filepath, "constants", "Status_txt");
		return statusData;
	}

	public String userNameData()
	{
		String userNameData = objJsonHandler.valuesFromJson(filepath, "constants", "UserName_txt");
		return userNameData;
	}
}

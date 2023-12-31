package ui.datamodels.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utilities.JsonHandler;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDataModel
{
	JsonHandler objJsonHandler = new JsonHandler();
	String filepath = "C:\\Users\\sarvani.shk\\eclipse-workspace\\testng\\src\\main\\resources\\pagelocators\\login\\LoginPage.json";

	public String usernameData()
	{
		String userNameData = objJsonHandler.valuesFromJson(filepath, "constants", "UserName_txt");
		return userNameData;
	}

	public String passwordData()
	{
		String passwordData = objJsonHandler.valuesFromJson(filepath, "constants", "PassWord_txt");
		return passwordData;
	}
}

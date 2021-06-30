package StepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import ConfigFileReader.ConfigFileReader;
import PageObjects.Login;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps 
{
	public static WebDriver driver;

	Login login;
	ConfigFileReader fileReader;

	/*@Before
public void setup(cucumber.api.Scenario scenario)
{
//System.out.println(scenario.getId().split(";")[0]);	
}*/

	@Given("^I navigate to the login page$")				
	public void LoginPage() throws Throwable							
	{	
		fileReader = new ConfigFileReader();
		System.setProperty(fileReader.getDriverName(),fileReader.getDriverPath());
		driver = fileReader.getDriver();

		Reporter.addScenarioLog("Scenario Log message goes here");	
		Reporter.addStepLog("This will run");	///////////////// THIS WORKED
		driver.get(fileReader.getpageUrl());
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(fileReader.getimplicitWait(), TimeUnit.SECONDS);
	}	


	@When("^I submit username and password$")				
	public void User_enters_correct_Credentials_to_LogIN_Maps(DataTable usercredentials) throws Throwable 
	{
		login = new Login(driver);	
		List<Map<String,String>> data = usercredentials.asMaps(String.class, String.class); ///used when we have multiple row
		login.EnterUserName(data.get(0).get("user")); 
		login.clickContinue();
		login.EnterPwd(data.get(0).get("pass"));
	}


	@Then("^I should be logged in$")				
	public void LoggedIn() 
	{
		System.out.println("Logged IN Successfully");
		login.clickLogin();
	}

}

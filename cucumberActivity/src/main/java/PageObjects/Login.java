package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	public WebDriver driver;
	
	By submit= By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button");
	By continueButton= By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button");
	By username= By.cssSelector("#usernameOrEmail");
	By password= By.xpath("//*[@id=\"password\"]");

	public Login(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}

	public void EnterUserName(String User) 
	{
		driver.findElement(username).sendKeys(User);
	}	
	
	public void clickContinue() {

		driver.findElement(continueButton).click();

	}

	public void EnterPwd(String Password) 
	{
		driver.findElement(By.cssSelector("#password")).sendKeys(Password);
	}	


	public void clickLogin() {

		driver.findElement(submit).click();

	}


}

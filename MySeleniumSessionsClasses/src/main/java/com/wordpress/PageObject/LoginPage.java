package com.wordpress.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author marieelodie.ineza
 * 
 *
 */

public class LoginPage {
	
	WebDriver driver;
	
	By username= By.cssSelector("#usernameOrEmail");
	By password= By.xpath("//*[@id=\"password\"]");
	By submit= By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button");
	By continueButton= By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button");
	

	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void typeUsername() {
		
		driver.findElement(username).sendKeys("elodiekatsia@gmail.com");
		
	}
	
	public void clickContinue() {
		
			driver.findElement(continueButton).click();
		
	}
	
	public void typePassWord() {
		
		driver.findElement(password).sendKeys("Elodie2001");
		
	}
	public void clickLogin() {
		
		driver.findElement(submit).click();
	
	}
	
	
}

package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.print(driver.getTitle());
		

	}
	
	@Test(priority=2)
	public void Application() {
		System.out.print("Hey this is my first case");
		
	}
	
	@Test(priority=1, description="this test will add items")
	public void testItem() {
		System.out.print("Hey this is my first case");
		
	}
	@Test(priority=3)
	public void checkOut() {
		System.out.print("Hey this is my first case");
		
	}

}

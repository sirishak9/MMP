package com.iit.mmp.mmpproject.tests;

import com.iit.mmp.mmpproject.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	@Test(description="US_001 Validating the Login Page")
	public void login() {
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
		
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		LoginPage lp =new LoginPage(driver);
		lp.login("ria1","Ria12345");
	}
}

package com.iit.mmp.mmpproject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import com.iit.mmp.mmpproject.pages.LoginPage;
import com.iit.mmp.mmpproject.pages.LoginRegPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResgiterPatientTest {
	WebDriver driver;
	@Test(description="US_004 Validating the approve patient")
	public void registerPatientdetails() throws Exception {
		launchBrowser();
//		RegisterPatientPage regobj = new RegisterPatientPage(driver);
		//regobj.register("Riaty","Riaty123");
//		Random rnd = new Random();
//		String username = "testyun"+ (char)(65+rnd.nextInt(26))  + rnd.nextInt(100);
//		String password = "testypd"+(char)(65+rnd.nextInt(26))+  rnd.nextInt(200);
//		//HashMap<String,String> hMap = regPage.register(username, password);
//		HashMap<String,String> hMap = regobj.register(username, password);
//		Set<String> keySetValues = hMap.keySet();
//		for(String key : keySetValues)
//		{
//			System.out.println("Key is ::"   + key);
//			System.out.println("Value is ::" +hMap.get(key));
//		}
//		String expectedMsg = "Thank you for registering with MMP.";
//		String actualMsg = hMap.get("message");
//		Assert.assertEquals(actualMsg.trim(),expectedMsg.trim());
		LoginRegPage lrp = new LoginRegPage(driver);
		//lrp.loginRegPage("Riaty", "Riaty123");
		lrp.loginRegPage("testyunZ10","testypdE112");
	}
	public void launchBrowser() throws Exception {
	
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		//driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Patient Login")).click();
		Thread.sleep(3000);
		//driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.linkText("Login")).click();
	}
}

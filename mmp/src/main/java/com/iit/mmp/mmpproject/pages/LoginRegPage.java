package com.iit.mmp.mmpproject.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//login to registered patient
public class LoginRegPage {
	WebDriver driver;
	public LoginRegPage(WebDriver driver) {
		this.driver=driver;
	}
	public void loginRegPage(String userName,String passWord) throws Exception {
		
		driver.findElement(By.id("username")).sendKeys(userName);
	    driver.findElement(By.id("password")).sendKeys(passWord);
	    driver.findElement(By.name("submit")).click();
	    Thread.sleep(3000);
	    Alert alert = driver.switchTo().alert();
	    String text = alert.getText();
	    System.out.println("The Text displayed on the Alert ----> " + text);
	    alert.accept();
	}
}

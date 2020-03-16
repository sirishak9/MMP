package com.iit.mmp.mmpproject.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage {
	private final WebDriver driver;

	public RegisterPatientPage(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String, String> register(String userName, String password) throws Exception {
		Random rnd = new Random();
		HashMap<String, String> hMap = new HashMap<String, String>();
		//FistName
		WebElement firstNameTxtField = driver.findElement(By.id("firstname"));
		firstNameTxtField.sendKeys("testsyFN" + (char) (65 + rnd.nextInt(26)) + "" + (char) (65 + rnd.nextInt(26)));
		hMap.put("firstname", firstNameTxtField.getAttribute(("value")));
		//LastName
		WebElement lastnameTxtField = driver.findElement(By.id("lastname"));
		lastnameTxtField.sendKeys("testsyLN" + (char) (65 + rnd.nextInt(26)) + "" + (char) (65 + rnd.nextInt(26)));
		hMap.put("lastname", lastnameTxtField.getAttribute(("value")));
		//DOB
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		WebElement datePickerTxtField = driver.findElement(By.id("datepicker"));
		datePickerTxtField.sendKeys(sdf.format(new Date()));
		//License
		WebElement licenseTxtField = driver.findElement(By.id("license"));
		long licenseValue = rnd.nextInt(99999999);
		licenseTxtField.sendKeys("" + licenseValue);
		hMap.put("license", licenseTxtField.getAttribute(("value")));
		licenseTxtField.click();

		Thread.sleep(3000);
		//SSN
		WebElement ssnTxtField = driver.findElement(By.id("ssn"));
		long ssnValue = rnd.nextInt(999999999);
		ssnTxtField.sendKeys("" + ssnValue);
		hMap.put("ssn", ssnTxtField.getAttribute(("value")));
		ssnTxtField.click();
		//state
		WebElement stateTxtField = driver.findElement(By.id("state"));
		stateTxtField.sendKeys("New York");
		hMap.put("state", stateTxtField.getAttribute(("value")));
		//city
		WebElement cityTxtField = driver.findElement(By.id("city"));
		cityTxtField.sendKeys("seattle");
		hMap.put("city", cityTxtField.getAttribute(("value")));
		//address
		WebElement addressTxtField = driver.findElement(By.id("address"));
		addressTxtField.sendKeys("10 Ryn Street");
		hMap.put("address", addressTxtField.getAttribute(("value")));
		//Zipcode
		WebElement zipcodeTxtField = driver.findElement(By.id("zipcode"));
		long zipValue = rnd.nextInt(99999);
		zipcodeTxtField.sendKeys("" + zipValue);
		hMap.put("zipcode", zipcodeTxtField.getAttribute(("value")));
		//age
		WebElement ageTxtField = driver.findElement(By.id("age"));
		long ageValue = rnd.nextInt(90);
		ageTxtField.sendKeys("" + ageValue);
		hMap.put("age", ageTxtField.getAttribute(("value")));
		//height
		WebElement heightTxtField = driver.findElement(By.id("height"));
		long heightValue = rnd.nextInt(90);
		heightTxtField.sendKeys("" + heightValue);
		hMap.put("height", heightTxtField.getAttribute(("value")));
		//weight
		WebElement weightTxtField = driver.findElement(By.id("weight"));
		long weightValue = rnd.nextInt(90);
		weightTxtField.sendKeys("" + weightValue);
		hMap.put("weight", weightTxtField.getAttribute(("value")));
		//email
		WebElement emailTxtField = driver.findElement(By.id("email"));
		emailTxtField.sendKeys(
				"testEmail" + ((char) (65 + rnd.nextInt(26)) + "" + (char) (65 + rnd.nextInt(26))) + "@gmail.com");
		hMap.put("email", emailTxtField.getAttribute(("value")));
		//username
		WebElement usernameTxtField = driver.findElement(By.id("username"));
		usernameTxtField.sendKeys(userName);
		hMap.put("username", usernameTxtField.getAttribute(("value")));
		//password
		WebElement passwordTxtField = driver.findElement(By.id("password"));
		passwordTxtField.sendKeys(password);
		hMap.put("password", passwordTxtField.getAttribute(("value")));
		//confirm password
		WebElement confirmpasswordTxtField = driver.findElement(By.id("confirmpassword"));
		confirmpasswordTxtField.sendKeys(password);
		hMap.put("confirmpassword", confirmpasswordTxtField.getAttribute(("value")));
		//Selecting security question
		new Select(driver.findElement(By.id("security"))).selectByVisibleText("what is your best friend name");
		//answer
		WebElement answerTxtField = driver.findElement(By.id("answer"));
		answerTxtField.sendKeys(userName);
		hMap.put("answer", answerTxtField.getAttribute(("value")));
		
		
		//clicking on save button
	    driver.findElement(By.xpath("//input[@name='register']")).click();
	    Thread.sleep(3000);
		//accessing to js popup
		Alert alert = driver.switchTo().alert();
		String successtext = alert.getText();
		System.out.println("The Text displayed on the Alert ----> " + successtext);
		alert.accept();
		hMap.put("message", successtext);
		return hMap;

	}
}

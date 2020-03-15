package org.iit.mmp.HCMMP_Tests;

import java.util.Calendar;

import org.iit.mmp.HCMMP_Pages.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Yahoo_Project {
	WebDriver driver;
	
	
	 
	@Test
	
		public  void validateSearchResults()
	
	{
		
		/*
		 * 1. Enter the url https://www.yahoo.com/
		 * 2. Enter the text Selenium in the Textbox
		 * 3. Select "Selenium Interview Questions" from the List
		 * 4. Check the search results page is displayed
		 * 5. Expected Result : Validate the Search results contains "Selenuim Interview Questions".
		 * 6. Expected Result : Validate the Search REsults in first 5 pages contains "Selenium Inteview Questions"
		 * 
		 */
		
		SoftAssert sa = new SoftAssert();
		
		long startTime = Calendar.getInstance().getTimeInMillis();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		long endTime = Calendar.getInstance().getTimeInMillis();
		long totaltime = endTime-startTime;
	    System.out.println("Time Taken::" + totaltime );
	    Utility util = new Utility(driver);
	    int size = util.retrieveSearchList("Selenium").size();
	    sa.assertEquals(10, size);
	    
	    boolean result = util.selectRequiredSearchPattern("Selenium", "selenium interview questions");
	    sa.assertTrue(result);
	    
	    result = util.validateLinkText("Questions",5,"selenium interview questions");
	    sa.assertTrue(result);
	    sa.assertAll();
	    
	    
	    
	}
	 
}

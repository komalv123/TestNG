package com.cjc;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTest {
	
	WebDriver driver;
	
  @Test
  public void loginwithValidDetails() 
  {
	  System.out.println("---------welcome--------------");
	  System.out.println("In loginwithValidDetails method under @Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Komal");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  System.out.println("Login Successfully");

  }
  @BeforeMethod
  public void getcookies() 
  {
	  System.out.println("In getcokkies method under @BeforeMethod");
	  Set<Cookie>k=driver.manage().getCookies();
	  for(Cookie coo : k)
	  {
		  System.out.println("Cookies Name: "+coo.getName());
		  System.out.println("Value of cookie"+coo.getValue());
	  }
  }

  @AfterMethod
  public void captureScreenshot () throws IOException 
  {
	  System.out.println("In captureScreenshot method under @AfterMethod");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src, new File("F:\\Selenium Setup\\Screenshot"));
	  System.out.println("screenshot is captured is successfully");
  }

  @BeforeClass
  public void maximumBrowser() 
  {
	  System.out.println("In maximumBrowser method under @BeforeClass");
	  driver.manage().window().maximize();
	  System.out.println("Window maximize successfully");
  }

  @AfterClass
  public void deleteAllCokkies() 
  {
	  System.out.println("In deleteAllCokkies method under @AfterClass");
	  driver.manage().deleteAllCookies();
	  System.out.println("All cokkies are delete successfully");
  }

  @BeforeTest
  public void enterApplUrl() 
  {
	  System.out.println("In enterApplUrl method under @BeforeTest");
	  driver.get("http://newtours.demoaut.com/");
	  System.out.println("New tourse Url open successfully");
  }

  @AfterTest
  public void dbConnection() 
  {
	  System.out.println("In dbConnection method under @AfterTest");
  }

  @BeforeSuite
  public void openBrowser() 
  {
	  System.out.println("In openbrowser method under @BeforeSuite");
	  System.setProperty("webdriver.chrome.driver","F:\\Selenium Setup\\Setup\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  System.out.println("Chrome browser open successfully"); 
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  System.out.println("In closeBrowser method under @AfterSuite");
	  driver.close();
	  System.out.println("Browser closed succefully"); 
  }

}

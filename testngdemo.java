package onetestng;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class testngdemo {
	
	public String burl="https://www.google.com/";
	WebDriver driver;
  @Test
  public void verifyTitle() {
	  
	  System.out.println("launch chrome browser"); 
      System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get(burl);
     
      String expectedTitle = "Google";
      String actualTitle = driver.getTitle();
      System.out.println(actualTitle);
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.close();
  }
}

package learn_selenium1;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;


public class acess_linkdemo {

	public static void main(String[] args) {
		
      String burl = "http://demo.guru99.com/test/newtours/";
    		  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
    		  WebDriver driver= new ChromeDriver();
              driver.manage().window().maximize();    	
              
              //navigate to url
              driver.get(burl);
              
              // implicit wait
				 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		
              
              WebElement keydemo=driver.findElement(By.name("userName"));
              Actions builder=new Actions(driver);
              Action keyaction=builder.moveToElement(keydemo).click().keyDown(keydemo,Keys.SHIFT).sendKeys(keydemo,"Typed").keyUp(keydemo,Keys.SHIFT).doubleClick(keydemo).contextClick().build();
              keyaction.perform();
              
              
             String burl2="http://demo.guru99.com/test/drag_drop.html";
             driver.get(burl2);
             
             // implicit wait
			 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			 
			 
			 //drap and drop             
             WebElement from=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
             WebElement to=driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
             
             //implicit wait
             driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
                builder.dragAndDrop(from,to).build().perform();
              
            	   driver.close();
              
              
      }

}

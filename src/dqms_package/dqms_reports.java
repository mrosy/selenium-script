package dqms_package;


//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox;
import org.openqa.selenium.*;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.google.common.base.Supplier;

import org.openqa.selenium.support.ui.ExpectedConditions;


public class dqms_reports {
	
	

	public static void main(String[] args) {
		try {
		
	    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
			
		
		//	System.setProperty("webdriver.firefox.marionette","D:\\geckodriver.exe" );
					
		//	WebDriver driver=new FirefoxDriver();
			
	      WebDriver driver = new ChromeDriver();
		  WebElement pwd1;
		  WebDriverWait waitForElement;
		  String page_title = "login";
		  String act_title="";
		  
		
			 
		  
		  
		   // Maximize the browser window
	        driver.manage().window().maximize();
	        
	     // Navigate to url
			 driver.get("http://192.168.1.47:9001/login/?loginRole=SQA&loginCode=rosaline");
         
	     // get the title from the URL page
			 act_title=driver.getTitle();
			 
		// compare actual title with the excepted title
			 if(act_title.contentEquals(page_title))
			 {
				 System.out.println("Title excepted matches with the actual title");
				 
			 }
			 else
			 {
				 System.out.println("Title mismatch");
			 }
			 
			 //explicit wait
			 waitForElement = new WebDriverWait(driver,120);
	//			waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
				
				
		// Enter password in the corresponding textfield
			 
			 pwd1=driver.findElement(By.id("password"));
			 //System.out.println(pwd1);
			 pwd1.sendKeys("Musakutty29");
			
			 
		//	 waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
			
		    // Click on the sign in button
			   driver.findElement(By.id("submit")).click();
			
			
		      //Throws interupted Exception
		    	Thread.sleep(500); 
			
              waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Reports")));
						
		// Click on the report option
			driver.findElement(By.linkText("Reports")).click();
			
			Thread.sleep(1000);
			
		// Choose option from the select chart type
		//	driver.findElement(By.id("id_chart_type")).click();
		//	 waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_chart_type")));
			Select chart_type=new Select(driver.findElement(By.id("id_chart_type")));
			
			List <WebElement> chart_list= chart_type.getOptions();
			
		// size of the chart list
			System.out.println(chart_list.size());
			for(WebElement i:chart_list)
			{
				System.out.println(i.getText());
				String chart=i.getText();
				if(chart.equalsIgnoreCase("X-Bar/Range Chart"))
				{
					
					// waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_chart_type")));
					i.click();
					break;
				}
				
			}
			
			
	/*	//Select the 2nd option from the select chart type
			
	        Select x_bar = new Select(driver.findElement(By.name("char_type")));
	        
	        x_bar.selectByIndex(1);  */
			
		    Thread.sleep(500);  
		    
		    
		// Select 'From Date' option
		 /*   waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_from_date\"]")));
		    WebElement from_date=driver.findElement(By.xpath("//*[@id=\"id_from_date\"]"));
		    from_date.click();
		    from_date.clear();
		    System.out.println("fine11");
		    from_date.sendKeys("2018-07-18 00:00");
		    
		     String a=from_date.getText();
		      System.out.println(a); 
		    
		      
		      Thread.sleep(500);  */  
		    
		    WebElement from_date = driver.findElement(By.id("id_from_date"));
	        from_date.click();
		  
		      
	      //Click on the Previous month button  
	            for (int i = 0; i < 2; i++){
	        	
	               
	                    driver.findElement(By.xpath(".//*[@id='report_filter_form']/table/tbody/tr[1]/td[2]/div/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[1]/span")).click();
	
                       
	                }
	
	          //Select the appropriate date from the 'From Date' option
	           
	            driver.findElement(By.xpath(".//*[@id='report_filter_form']/table/tbody/tr[1]/td[2]/div/div/ul/li[1]/div/div[1]/table/tbody/tr[1]/td[3]")).click();
	        
	            
	            
	            Thread.sleep(1000);
	         
	            //Select 'To Date' option
	                WebElement To_Date = driver.findElement(By.id("id_to_date"));
	                 To_Date.click();
	                 
	           // Choose the appropriate date from the 'To Date' option
	                 driver.findElement(By.xpath(".//*[@id='report_filter_form']/table/tbody/tr[1]/td[3]/div/div/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[4]")).click();
	          
	                Thread.sleep(500);
	                 
	                 
	          
	            // Select supplier
	                 WebElement select_supplier = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[1]/td[4]/div/div/button/span[1]"));
	                 select_supplier.click();
	                 
	                 Thread.sleep(500);
	             //  Choose the appropriate supplier from the list
	                 WebElement choose_supplier=driver.findElement(By.name("supplier"));
	                 Select drop_supplier = new Select(choose_supplier);
	                 drop_supplier.selectByIndex(3);
	                 
	              Thread.sleep(1500);
	              
	              
	              //Select part
	                WebElement select_part = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[1]/td[5]/div/div/button/span[1]"));
	                select_part.click();
	                
	                Thread.sleep(1000);
	                
	              //Select the part from the list 
	                WebElement choose_part = driver.findElement(By.name("part"));
	                Select drop_part = new Select(choose_part);
	                drop_part.selectByIndex(2);
	                
	                Thread.sleep(1000);
	                
	              //Select Control plan
	             // waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.name("control_plan")));                
	                WebElement select_cplan = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[2]/td[1]/div/div/button/span[1]"));
	               

	                select_cplan.click();
	                
	                Thread.sleep(1000);
	                
	              // Choose the characteristics from the control plan
	                WebElement choose_cplan = driver.findElement(By.name("control_plan"));
	                Select drop_cplan = new Select(choose_cplan);
	                drop_cplan.selectByIndex(8);
	                
	                                
	                Thread.sleep(1000);
	                
	               //Select operation
	                 WebElement select_operation =driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[2]/td[2]/div/div/button/span[1]"));
	                 select_operation.click();
	                 
	                 Thread.sleep(1000);
		      
	               // Choose the operation from the list
	                  WebElement choose_operation = driver.findElement(By.name("operations"));
	                  Select drop_operation = new Select(choose_operation);
	                  drop_operation.selectByIndex(1);
	                  
	                  Thread.sleep(1000);
	                  
	               //Select characteristics option
	                  WebElement select_characteristics = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[2]/td[3]/div/div/button/span[1]"));
	                  select_characteristics.click();
	                  
	                  Thread.sleep(500);
	               
	               //Choose the appropriate characteristics from the characteristics option
	                  WebElement choose_characteristics = driver.findElement(By.name("characteristics"));
	                  Select drop_characteristics = new Select(choose_characteristics);
	                  drop_characteristics.selectByIndex(1);
	                  
	                  Thread.sleep(500);   
	                  
	                  
	               // Click search
	                  WebElement click_search = driver.findElement(By.xpath("//*[@id=\"go\"]"));
	                   click_search.click();
	                  
	                  Thread.sleep(1500);
	}catch (Exception e)
		{
		   System.out.println(e);
		}
	}

}




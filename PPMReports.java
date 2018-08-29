import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Date;
import org.openqa.selenium.interactions.Actions;

public class PPMReports {
	
		static String PPMChartGraphValue = "";
		static int monthPPM = 0;
		static String chartValue = "";
		static String supplierValue = "";
		static String partValue = "";
		static String controlPlanValue = "";
		static String operationValue = "";
		public WebDriver driver;
		public static JSONTokener jsonTokener = null;
		public static JSONObject jsonObject = null;
		public static JSONObject jsonObjectReport = null;
		Actions act;		
		StringBuffer response = new StringBuffer();
		static String filePath = "";
	 
		private static JSONObject readJsonFile(String filePath) throws Exception
		{
			try 
			{
				jsonTokener = new JSONTokener(new FileReader(filePath));
				jsonObject = new JSONObject(jsonTokener);
			}
			catch(Exception exception) 
			{
				System.out.println(exception.toString());
			}
			
				return jsonObject;
		}  
	
		public void setBaseURL() throws Exception
		{
			try
			{
				filePath = "D:\\dqreports.json";
				jsonObjectReport = this.readJsonFile(filePath).getJSONObject("reports1");
				System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
				driver = new ChromeDriver();
				driver.get(jsonObjectReport.getString("BaseUrl"));
				// Maximize the browser window
				driver.manage().window().maximize();
				Thread.sleep(1000);
			}
			catch(Exception exception)
			{
				 System.out.println(exception.toString());
			}
	 
	 	}
  
		public void loginPage() throws Exception
		{
			try 
			{
				String page_title = "login";
				String act_title = "";
				// get the title from the URL page
				act_title = driver.getTitle();			
				// compare actual title with the excepted title
				if(act_title.contentEquals(page_title))
				 {
					 System.out.println("Title excepted matches with the actual title");
					
				 }
				 else
				 {
					 System.out.println("Title mismatch");
				 }		
				
				 // Enter password in the corresponding textfield
				 driver.findElement(By.id("password")).sendKeys(jsonObjectReport.getString("Password")); 
				 // Click on the sign in button
				 driver.findElement(By.id("submit")).click();
				 Thread.sleep(10000); 

			}
			catch(Exception exception) 
			{
				System.out.println(exception.toString());
			}
			
		} 
			 
		@Test
		public void Report() throws Exception
		{
			try
			{
				this.setBaseURL();
				this.loginPage();
	
				 // Click on the report option
				 WebElement selectReport = driver.findElement(By.id("report-anchor-id"));
				 selectReport.click();
				 Thread.sleep(1000);
				 
				 // Select the chart type
				 Select chartType = new Select(driver.findElement(By.id("id_chart_type")));
				 chartType.selectByVisibleText(jsonObjectReport.getString("SelectChartType"));
				 WebElement option1 = chartType.getFirstSelectedOption();
				 chartValue = option1.getText();
				 System.out.println(chartValue);
				 Thread.sleep(1000);
				
				 //Select from_Date
				 driver.findElement(By.id("id_from_date")).click();
				 //Click on the Previous month button  
	             for (int i = 0; i < 3; i++)
	             {
	        	               
	                    driver.findElement(By.xpath(".//*[@id='report_filter_form']/table/tbody/tr[1]/td[2]/div/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[1]/span")).click();
	
	             }
	            
	             Thread.sleep(1000);
	
	             //Select the appropriate date from the 'From Date' option
	             driver.findElement(By.xpath(".//*[@id='report_filter_form']/table/tbody/tr[1]/td[2]/div/div/ul/li[1]/div/div[1]/table/tbody/tr[1]/td[3]")).click();
				 Thread.sleep(1000);
					
				 //Select the current date from the 'To Date' option
				 Date date = new Date();
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				 System.out.println(formatter.format(date));
				 driver.findElement(By.id("id_to_date")).click();
				 driver.findElement(By.id("id_to_date")).sendKeys(formatter.format(date).toString());
				 driver.findElement(By.id("id_to_date")).click();
				 Thread.sleep(1000);         
					
				 // Select supplier
				 WebElement supplier = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[1]/td[4]/div/div/button"));
				 supplier.click();
				 Thread.sleep(1000);
				 WebElement supplierList = driver.findElement(By.name("supplier"));
				 Select chooseSupplierName = new Select(supplierList);
				 chooseSupplierName.selectByVisibleText(jsonObjectReport.getString("SelectSupplier"));
				 WebElement option2 = chooseSupplierName.getFirstSelectedOption();
				 supplierValue = option2.getText();
				 System.out.println(supplierValue);
				 WebElement doneButtonn = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[1]/td[4]/div/div/button"));
				 doneButtonn.click();
				 Thread.sleep(1000);
					
				 //Select part 
				 WebElement part = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[1]/td[5]/div/div/button/span[1]"));
				 part.click();
				 Thread.sleep(1000);
				 WebElement partList = driver.findElement(By.name("part"));
				 Select choosePartName = new Select(partList);
				 choosePartName.selectByVisibleText(jsonObjectReport.getString("SelectPart"));
				 WebElement option3 = choosePartName.getFirstSelectedOption();
				 partValue = option3.getText();
				 System.out.println(partValue);
				 WebElement doneButton = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[1]/td[5]/div/div/button/span[1]"));
				 doneButton.click();
				 Thread.sleep(1000);
					
				 //Select control plan
				 WebElement controlPlan = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[2]/td[1]/div/div/button/span[1]"));
				 controlPlan.click();
				 Thread.sleep(1000);
				 WebElement controlPlanList = driver.findElement(By.name("control_plan"));
				 Select chooseControlPlanName = new Select(controlPlanList);
				 chooseControlPlanName.selectByVisibleText(jsonObjectReport.getString("SelectControlPlan"));
				 WebElement option4 = chooseControlPlanName.getFirstSelectedOption();
				 controlPlanValue = option4.getText();
				 System.out.println(controlPlanValue);
				 WebElement doneButton1 = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[2]/td[1]/div/div/button/span[1]"));
				 doneButton1.click();
				 Thread.sleep(1000);
	            		
				//Select Operation
	            WebElement operation = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[2]/td[2]/div/div/button"));
	            operation.click();
	            Thread.sleep(1000);
	            WebElement operationList = driver.findElement(By.name("operations"));
	            Select chooseOperationName = new Select(operationList);
	            chooseOperationName.selectByVisibleText(jsonObjectReport.getString("SelectOperation"));
	            WebElement option5 = chooseOperationName.getFirstSelectedOption();
				operationValue = option5.getText();
				System.out.println(controlPlanValue);
	            WebElement doneButton2 = driver.findElement(By.xpath("//*[@id=\"report_filter_form\"]/table/tbody/tr[2]/td[2]/div/div/button"));
	            doneButton2.click();
	            Thread.sleep(1000);
	        		
				// Click search
	            WebElement click_search = driver.findElement(By.xpath("//*[@id=\"go\"]"));
	            click_search.click();
	            Thread.sleep(5000);
					
		        //get the graph value from the browser	
				WebElement graph=driver.findElement(By.cssSelector("#chart1 > svg > g:nth-child(2) > g.c3-chart > g.c3-event-rects.c3-event-rects-single > rect.c3-event-rect.c3-event-rect-2"));
	            graph.click();
	            act = new Actions(driver);
	            act.moveToElement(graph).build().perform();
	            WebElement Webtable = driver.findElement(By.className("c3-tooltip"));
	            List<WebElement> TotalRowCount = Webtable.findElements(By.xpath("//*[@id=\"chart1\"]/div/table/tbody/tr"));
	            System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());
	        	int RowIndex=1;
	        	        	
	        	for(WebElement rowElement:TotalRowCount)
	        	{
	        	      List<WebElement> TotalColumnCount=rowElement.findElements(By.xpath("td"));
	        	      int ColumnIndex = 1;
	        	      
	        	      		for(WebElement colElement:TotalColumnCount)
	        	      		{
	        	      			//System.out.println("Data " + colElement.getText());
	        	      			ColumnIndex=ColumnIndex+1;
	        	      		    PPMChartGraphValue = colElement.getText();
	        	      		          	      			
	        	      		}
	        	      RowIndex = RowIndex+1;
	        	    
	        	}
	        	System.out.println(PPMChartGraphValue);
					
			    //get the graph value from server response
				String url = jsonObjectReport.getString("GetReportURL");
	        	URL obj = new URL(url);
	    		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    		//add request header
	    		con.setRequestMethod("POST");
	    		//con.setRequestProperty("User-Agent", USER_AGENT);
	    		con.setRequestProperty("Cookie","csrftoken=AnlDpFov5ZZ11R9mETFRAm6zmgI43JvG; sessionid=xjg1owl8z8o26yhclknsjzp88x0xliv3");
	    		con.setRequestProperty("Accept", "*/*");
	    		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	    		String urlParameters = "csrfmiddlewaretoken=AnlDpFov5ZZ11R9mETFRAm6zmgI43JvG&chart_type=2&from_date=2018-05-01+15%3A09&to_date=2018-08-29+00%3A00&supplier=3&part=88&control_plan=137&operations=1149&operator=&machine=&batch_no=ashwinms-4-11052018-3-1149-28&batch_no=ashwinms-4-11052018-3-1149-42&batch_no=ashwinms-4-11052018-3-1149-43&batch_no=ashwinms-4-11052018-3-1149-47&batch_no=ashwinms-4-11052018-6-1149-27&batch_no=ashwinms-4-11052018-6-1149-45&batch_no=ashwinms-4-14052018-3-1149-51&batch_no=ashwinms-4-22052018-3-1149-8&batch_no=ashwinms-4-23052018-6-1149-3&batch_no=ashwinms-4-23052018-6-1149-8&batch_no=ashwinms-4-28052018-6-1149-1&batch_no=ashwinms-4-28052018-6-1149-5";
	    		    		
	    		// Send post request
	    		con.setDoOutput(true);
	    		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	    		wr.writeBytes(urlParameters);
	    		wr.flush();
	    		wr.close();
	
	    		int responseCode = con.getResponseCode();
	    		System.out.println("\nSending 'POST' request to URL : " + url);
	    		System.out.println("Post parameters : " + urlParameters);
	    		System.out.println("Response Code : " + responseCode);
	
	    		BufferedReader in = new BufferedReader(
	    		        new InputStreamReader(con.getInputStream()));
	    		String inputLine;
	    		
	    		while ((inputLine = in.readLine()) != null) {
	    			
	    			response.append(inputLine);
	    		}
	    		in.close();
			 	  
			    JSONArray jsonarray = new JSONArray(response.toString());
	    		
				for(int i = 0; i <= jsonarray.length(); i++)
				{
						JSONObject jsonObjectResponse = jsonarray.getJSONObject(i);
						String graphName = jsonarray.getJSONObject(i).toString();
	    			
	    				if(graphName.contains("month_ppm"))
	    				{
	    						System.out.println(jsonObjectResponse.getInt("month_ppm"));
	    						monthPPM = jsonObjectResponse.getInt("month_ppm");
	    						break;    			
	    				}
	    		}
	    		
	    		//compare the graph value from the browser and server response
				Assert.assertEquals(PPMChartGraphValue,Integer.toString(monthPPM));
				Assert.assertEquals(chartValue, jsonObjectReport.getString("SelectChartType"));
				Assert.assertEquals(supplierValue, jsonObjectReport.getString("SelectSupplier"));
				Assert.assertEquals(partValue, jsonObjectReport.getString("SelectPart"));
				Assert.assertEquals(controlPlanValue, jsonObjectReport.getString("SelectControlPlan"));
				Assert.assertEquals(operationValue, jsonObjectReport.getString("SelectOperation"));
			}
			catch(Exception exception) 
			{
				System.out.println(exception.toString());
			}
		}  		
		  
		@AfterTest
		public void quit()
		{
			 // driver.quit();
		}
}

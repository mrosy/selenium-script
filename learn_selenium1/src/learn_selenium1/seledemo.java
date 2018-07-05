package learn_selenium1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.firefox;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class seledemo {

	public static void main(String[] args) {
//		System.setProperty("D:\\chromedriver.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("marionette", true);
//		WebDriver driver =new ChromeDriver(capabilities);
		
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		  WebDriver driver = new ChromeDriver();
		  String tgname="";
		  String page_title = "";
		  driver.manage().window().maximize();
		  
		   
		 // Navigate to url
		 driver.get("http://192.168.1.102:9073/login/");
		 //maximize the window
		 driver.manage().window().maximize();
		// implicit wait
				 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		
		 //enter username
		 driver.findElement(By.id("id_username")).sendKeys("rosaline");
		
		 System.out.println(tgname);
		
		 //enter password
		 driver.findElement(By.id("id_password")).sendKeys("Fiveg2018");
		
		 //click the login button
		 driver.findElement(By.xpath("//*[@id=\"loginbuttons\"]/input[1]")).click();
		 
		 //wait for page to load
		 driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
		 
		 
		 //click on logout button
		 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/a[2]")).click();
		
		 //title of the page
		 
		  page_title=driver.getTitle();
		  System.out.println("The title page is " +page_title);
		 //close the browser
		 
		    driver.close();
		// TODO Auto-generated method stub

	}


}

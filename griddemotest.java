package griddemo;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.MalformedURLException;
import java.net.URL;
 

 	public class griddemotest {

	
		
		 
		public static void main(String[]  args) throws MalformedURLException, InterruptedException{
			 WebDriver driver;
	 		String URL = "http://www.google.com";
	 		String Node = "http://192.168.1.89:4455/wd/hub";
	 		
	 		//System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
	 		// driver=new ChromeDriver();
	 				 
	 				 
	 				 
	 		DesiredCapabilities cap = DesiredCapabilities.chrome();
	 		cap.setBrowserName("chrome");
	 		System.out.println("come");
	       cap.setPlatform(Platform.VISTA);
	       System.out.println("come");
	 		driver = new RemoteWebDriver(new URL(Node),cap);
	 		 System.out.println("go");
	 		driver.navigate().to(URL);
	 		Thread.sleep(5000);
	 		driver.quit();
		
		
	}

}
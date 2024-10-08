package AmazonBrowserTest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonTest {
	WebDriver driver;
	
	 @Parameters({"bname"})
	  @Test
	  public void testParallel(String bname) throws MalformedURLException, InterruptedException, URISyntaxException
	  {
		 URL url=new URI("http://localhost:4444").toURL();
		  if(bname.equals("chrome"))
		  {
			  ChromeOptions cap=new ChromeOptions();
			 
			  driver=new RemoteWebDriver(url,cap);
			  
		  }else if(bname.equals("firefox"))
		  {
			  FirefoxOptions cap=new FirefoxOptions();
			  
			  driver=new RemoteWebDriver(url,cap);
			  
		  }else if(bname.equals("edge"))
		  {
			  EdgeOptions cap=new EdgeOptions();
			  
			  driver=new RemoteWebDriver(url,cap);
		  }
		  Thread.sleep(5000);
		  driver.get("https://www.amazon.com/");
		  System.out.println("Title on "+ bname+ " is: "+driver.getTitle());
		  Thread.sleep(15000);
		  driver.quit();
		  
		  

}
}
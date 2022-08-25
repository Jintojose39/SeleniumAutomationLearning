import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenGoogle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		//here webdriver is an interface
		//ChromeDriver is a class
		//driver is  an  object
		WebDriver driver =new ChromeDriver();
		
		
		//to  launch Fire fox driver
		//we must to install  geckodriver for firefox
		//System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
		
		//WebDriver driver =new FirefoxDriver();
		
		//for microsoft edge 
		
		
		
		//System.setProperty("webdriver.edge.driver","F:\\msedgedriver.exe");
		
		//WebDriver driver =new EdgeDriver();
	     
		
		//Launch website
		//driver.navigate().to("http://www.google.com");
		//to  go back to previous website
		//driver.navigate().back("http://www.google.com");
		//to  refresh page to change the URL
		
		driver.get("http://www.facebook.com");
		
		//to printing the title of the page
		
		System.out.println(driver.getTitle());
		
		
		//to  get URL  of the website
		
		System.out.println(driver.getCurrentUrl());
		
		//driver.get("http://www.gmail.com");
		//to terminate or close one window 
		//entering the user name
		
		driver.findElement(By.id("email")).sendKeys("jinto1235@gamil.com");
		
		//entering the password
		
		driver.findElement(By.id("pass")).sendKeys("pass125");
		//to  login
		
		//driver.findElement(By.className("_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy")).click();
		//xpath =//tagname[@attributes='value']
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//driver.close();
		
		//to closes the all windows which is opened and ending the webdriver section
		//driver.quit();
	}

}

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsSign_in {
	// in void main we see that interruptedException this is due to the presence of thread sleep in the code.
	
	public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
			WebDriver driver =new ChromeDriver();
			
			//here Webdriver consider as interface chromeDriver is consider as class and driver is consider as object.
			//implicit wait  -2 seconds time  out
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.findElement(By.id("inputUsername")).sendKeys("jinto");
			
			//here there is no id so name is another locator
			
			driver.findElement(By.name("inputPassword")).sendKeys("124gfhfgh");
			
			//here for sign-in button we use click
			
			driver.findElement(By.className("signInBtn")).click();
			//here if our information is true the system is go  for sign-in page
			//other wise the  system  displays an error message "Incorrect password or user name"
			//to select any type we use CssSelecter and Xpath 
			//to extract error  message from  the  text
			
			System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
			
			//here we use linkTest  <a it's only  applicable for anger test only
			
			
			driver.findElement(By.linkText("Forgot your password?")).click();
			//here we using xpath helps to  find elements that not  found  by locators such  as id,
			// class ,or name.
			
			
			//to wait for few seconds
			
			//One second means =1000
			//two  second means =2000
			
			
			Thread.sleep(1000);
			
			
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("john");
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jint@454.com");
			
			//to  clear the entered text we use clear().
			//to build customize xpath selector 
			driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
			//to  build customize cssSelector
			
			//here we find the css selector index combination
			
			driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("sdsa@454.com");
			driver.findElement(By.xpath("//form/input[3]")).sendKeys("859292124998");
			driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
			//driver.findElement(By.cssSelector("form p")).getText();//to get messge for invalid message  
			System.out.println(driver.findElement(By.cssSelector("form p")).getText());
			driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
			
			
			//here we using thread for open another page for sign in  option
			//we are putting few seconds for open new sign in page with valid credentials
			
			Thread.sleep(1000);
			
			
			driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
			driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
			driver.findElement(By.id("chkboxOne")).click();
			
			driver.findElement(By.xpath("//button[contains(@class ,'submit ')]")).click();
			
			
			//here we have customized combination of xpath and index combination for finding the exact login location
			//Path for parent to child tag name 
			//
			//div[@class='forgot-pwd-btn-conainer']/button[1]
			
			
			   
			  
			
			
			
			
			
			
	}
	
	
	

}

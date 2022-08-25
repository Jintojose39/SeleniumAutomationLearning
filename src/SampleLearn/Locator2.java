package SampleLearn;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Locator2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("signInBtn")).click();
		
		try {
			String exp ="You are successfully logged in.";
			
			String act =driver.findElement(By.xpath("//p[normalize-space()='']")).getText();
			
			
			if(exp.equals(act)) {
				
				System.out.println(driver.findElement(By.xpath("//p[normalize-space()='']")).getText());
				System.out.println("Test is passed");
				
				
			}else {
				
				System.out.println("Test is  Failed");
			
		}
		
		
		}catch(NoSuchElementException e) {
			
			
			System.out.println("No Such Element Exception");
		}
		
		
		driver.close();
		
		
		
	
	}
	

}
	
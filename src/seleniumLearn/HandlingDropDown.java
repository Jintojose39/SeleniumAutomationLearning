package seleniumLearn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("WebDriver.chromeDriver", "ChromeDriver.exe");
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//here we have two elements and also its dynamic so that we use exact number of that xpath 
		//only two elements
		
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		//driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		
		String exp ="Chennai (MAA)";
		
		//here we write xpath using parent and child format
		///div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		String act =driver.findElement(By.xpath("//a[@value='MAA']")).getText();
		System.out.println(act);
		if(exp.equals(act)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
		
		Thread.sleep(1000);
		driver.close();
		
	}

}

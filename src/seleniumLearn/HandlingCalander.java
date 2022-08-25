package seleniumLearn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCalander {

	public static void main(String[] args)  {
		System.setProperty("WebDriver.chromeDriver", "ChromeDriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		//.ui-state-default.ui-state-highlight // put dot on spaces and this is a class name
			
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-datepicker-trigger")));
		
		
		driver.findElement(By.cssSelector(".ui-datepicker-trigger")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-state-default.ui-state-highlight")));
		
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		//System.out.println(driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).isSelected());
		
		
		driver.quit();
	}

}

package seleniumLearn;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAutoSugDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chromeDriver", "ChromeDriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		
		Thread.sleep(4000);
		
		List<WebElement>options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option:options) {
			
			if(option.getText().equalsIgnoreCase("India")) {
	
				option.click();
				break;
				
				
		}
	
		}

		}
		}





package miscellaneousExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {

	public static void main(String[] args) {
		

		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in/");
		//here get attribute will print the value in the class
		
		String i=driver.findElement(By.cssSelector(".gLFyf.gsfi")).getAttribute("class");
		
		System.out.println(i);
		driver.close();
		
		
	
	}

}


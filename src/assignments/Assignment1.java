package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("WebDriver.chromeDriver","ChromeDriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		
		
		System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		
		System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		
		
		
		//System.out.println(driver.findElements(By.xpath("//*[@id=\"checkbox-example\"]")).size());
		
		System.out.println(driver.findElements(By.cssSelector("input[value='checkbox']")).size());
		
		
		driver.close();
		
		//driver.findElements(By.id("checkbox-example")).size();
		
		
		
		

	}

}

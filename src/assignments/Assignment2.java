package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.ChromeDriver","ChromeDriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	
		driver.findElement(By.name("name")).sendKeys("Jinto");
		driver.findElement(By.name("email")).sendKeys("tester1895@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("jinto156");
		driver.findElement(By.id("exampleCheck1")).click();
		
		
		WebElement drp=driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select dropdown =new Select(drp);
		
		dropdown.selectByVisibleText("Male");
		
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/form-comp/div/form/div[7]/input")).sendKeys("270-07-1996");
			
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).isDisplayed();
		
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		driver.close();
		
	}

}

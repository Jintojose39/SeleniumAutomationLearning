package seleniumLearn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.netty.util.internal.SystemPropertyUtil;

public class DropDownFlight {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver =new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		
		for(int i=1;i<5;i++) {
			

			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	
		driver.close();
		
		
	}
	/*In case of while
	 * int i=1;
	 * while(i<5){
	 * driver.findElement(By.id("hrefIncAdt")).click();
	 * ++i;
		}
	 * driver.findElement(By.id("btnclosepaxoption")).click();
	 * driver.close();
	 */
	
	
	
	

}

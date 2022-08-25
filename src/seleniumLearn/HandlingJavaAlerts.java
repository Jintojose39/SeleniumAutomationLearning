package seleniumLearn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingJavaAlerts {

	public static void main(String[] args) {

		System.setProperty("WebDriver.chromedriver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys("Jinto");
		driver.findElement(By.id("alertbtn")).click();
		// driver.findElement(By.xpath("//*[@id=\"confirmbtn\"]")).click();

		String exp = "Hello Jinto, share this practice page and share your knowledge";
		String act = driver.switchTo().alert().getText();

		System.out.println(act);

		Assert.assertEquals(exp, act);

		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//*[@id=\"confirmbtn\"]")).click();
		driver.switchTo().alert().dismiss();

		driver.close();

	}

}

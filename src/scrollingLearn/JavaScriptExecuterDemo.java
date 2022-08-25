package scrollingLearn;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecuterDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(3000);

		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000\r\n" + "5000");

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum = 0;
		for (int i = 0; i < values.size(); i++) {

			// to convert string to integer
			sum = sum + Integer.parseInt(values.get(i).getText());

		}
		System.out.println(sum);

		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

		Assert.assertEquals(sum, total);

		System.out.println("Test is passed");

		driver.close();

	}
}

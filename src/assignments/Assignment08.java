package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment08 {

	public static void main(String[] args) {
		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Ind");

		List<WebElement> Options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

		for (WebElement Option : Options) {

			if (Option.getText().equalsIgnoreCase("India")) {

				Option.click();
				break;

			}
			System.out.println(Option.getText());
			driver.close();
		}

	}

}

package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Thread.sleep(2000);

		WebElement table = driver.findElement(By.cssSelector(".table-display"));

		System.out.println("The no of rows are" + " " + ":" + table.findElements(By.tagName("tr")).size());

		System.out.println("The no of coloumns are" + " " + ":" + table.findElements(By.tagName("th")).size());

		List<WebElement> secondrow = driver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		System.out.println(secondrow.get(0).getText());

		System.out.println(secondrow.get(1).getText());

		System.out.println(secondrow.get(2).getText());

		driver.close();

	}

}

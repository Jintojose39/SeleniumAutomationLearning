package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {

		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");

		driver.findElement(
				By.cssSelector("#login-form > div:nth-child(4) > div > label:nth-child(2) > " + "span.checkmark"))
				.click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		// driver.switchTo().alert().accept();
		driver.findElement(By.id("okayBtn")).click();

		WebElement drp = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(drp);

		dropdown.selectByVisibleText("Student");
		driver.findElement(By.id("terms")).click();

		driver.findElement(By.id("signInBtn")).click();

		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='nav-link btn btn-primary']")));

		List<WebElement> products = driver.findElements(By.xpath("//button[@class='btn btn-info']"));

		for (int i = 0; i < products.size(); i++) {
			products.get(i).click();
		}

		driver.findElement(By.partialLinkText("Checkout ")).click();
		
		driver.close();

	}
}

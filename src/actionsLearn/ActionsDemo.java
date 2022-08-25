package actionsLearn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {

	public static void main(String[] args) {

		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));

		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
				.doubleClick().build().perform();

		// here we want to right click that element we use contestClick

		// Actions is an interface not webelement
		Actions act = (Actions) a.moveToElement(move).contextClick().build();

		act.perform();

		a.moveToElement(move).doubleClick().build().perform();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='continue']")));
		a.moveToElement(driver.findElement(By.xpath("//input[@id='continue']"))).click();

		driver.close();

	}

}

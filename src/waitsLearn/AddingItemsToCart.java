package waitsLearn;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddingItemsToCart {

	public static void main(String[] args) {

		System.setProperty("WebDriver.chromeDriver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsNeeded = { "Brocolli", "Beetroot", "Cucumber", "Carrot", "Beans", "Capsicum", "Apple", "Mango",
				"Pears", "Almonds" };

		addItems(driver, itemsNeeded);
		/*
		 * AddingItemsToCart add = new AddingItemsToCart(); add.addItems(driver,
		 * itemsNeeded);
		 */
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		// expicit waits

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));

		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		// Thread.sleep(2000);
		
		// explict waits

		// WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		String act = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		// Assert.assertEquals(exp, act);
		System.out.println(act);

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int J = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");

			// we want to remove all white spaces here we use trim method
			String formattedName = name[0].trim();

			List itemNeededList = Arrays.asList(itemsNeeded);

			if (itemNeededList.contains(formattedName)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				J++;

				if (J == itemsNeeded.length) {
					break;
				}
				// driver.close();

			}
		}
	}
}

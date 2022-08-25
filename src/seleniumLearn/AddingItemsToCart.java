package seleniumLearn;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingItemsToCart {

	public static void main(String[] args) {

		System.setProperty("WebDriver.chromeDriver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String[] itemsNeeded = { "Brocolli", "Beetroot", "Cucumber", "Carrot", "Beans", "Capsicum", "Apple", "Mango",
				"Pears", "Almonds" };
		int J = 0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			/*
			 * here to extract string only Cucumber-1Kg
			 * 
			 * format to get actual vegetable name to avoid 1 kg in the vegetable name
			 * 
			 * here we convert arrays to array list we use asList(Name of the array want to
			 * convert)
			 * 
			 * Brocoli-1Kg We have to convert Brocoli and 1 kg name[0]=Brocoli name[1]=1kg
			 * 
			 * we have to split string we use split() method
			 */

			String[] name = products.get(i).getText().split("-");

			// we want to remove all white spaces here we use trim method
			String formattedName = name[0].trim();

			List itemNeededList = Arrays.asList(itemsNeeded);

			if (itemNeededList.contains(formattedName)) {

				// here we use static xpath instead of using test
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				// boolean check=driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).isSelected();

				// incase of arrayList to find size
				// arraylistName.size()
				// to find arrays size
				// arraysname.length()

				J++;

				if (J == itemsNeeded.length) {
					break;
				}
				driver.close();
				// System.out.println(check);

			}
		}
	}
}

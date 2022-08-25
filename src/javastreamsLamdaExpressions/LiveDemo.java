package javastreamsLamdaExpressions;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {

		System.setProperty("WebDriver.ChromeDriver", "Chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// click on coloumn

		driver.findElement(By.xpath("//tr/th[1]"));
		// capture all webelements into list

		// capture text of all webelements into original list.
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort on the original list of step->3 sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare original list VS Sorted list

		// Assert.assertTrue(originalList.equals(sortedList));

		// scan the coloumn and print the price of the Rice

		List<String> price;

		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			price = rows.stream().filter(s -> s.getText().contains("Orange")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	// System.out.println(price);

	private static String getPriceVeggie(WebElement s) {

		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceValue;

	}
}

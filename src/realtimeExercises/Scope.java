package realtimeExercises;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scope {

	public static void main(String[] args) {

		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://qaclickacademy.com/practice.php");

		// to count th no of link in the given page

		// <a>

		System.out.println(driver.findElements(By.tagName("a")).size());

		// here we want to count the no of links in the footer section
		// here we are specify the footer section.

		WebElement footdriver = driver.findElement(By.id("gf-BIG"));

		System.out.println(footdriver.findElements(By.tagName("a")).size());

		WebElement coloumndriver = footdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		System.out.println(coloumndriver.findElements(By.tagName("a")).size());

		/*
		 * WebElement coloumndriver2 =
		 * footdriver.findElement(By.xpath("//table/tbody/tr/td[2]/ul"));
		 * 
		 * System.out.println(coloumndriver2.findElements(By.tagName("a")).size());
		 * 
		 * WebElement coloumndriver3 =
		 * footdriver.findElement(By.xpath("//table/tbody/tr/td[3]/ul"));
		 * 
		 * System.out.println(coloumndriver3.findElements(By.tagName("a")).size());
		 * 
		 * WebElement coloumndriver4 =
		 * footdriver.findElement(By.xpath("//table/tbody/tr/td[4]/ul"));
		 * 
		 * System.out.println(coloumndriver4.findElements(By.tagName("a")).size());
		 */

		// click on the links of the column check if the pages are open

		for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {

			// to click more than one link at same time
			String clickontab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickontab);
		}
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());

			System.out.println(driver.getTitle());

			//driver.quit();
		}

	}
}

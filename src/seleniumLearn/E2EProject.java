package seleniumLearn;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class E2EProject {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("WebDriver.chromeDriver", "ChromeDriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		String exp = "Chennai (MAA)";
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		String act = driver.findElement(By.xpath("//a[@value='MAA']")).getText();
		System.out.println(act);
		if (exp.equals(act)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Radio button is enabled");
			Assert.assertTrue(true);

		} else {
			System.out.println("its not enabled");
			Assert.assertTrue(false);
		}
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(
				"No of check boxes are: " + driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")));
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		for (int i = 1; i < 5; i++) {

			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(4000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("India")) {

				option.click();

				Thread.sleep(1000);
				WebElement drp1 = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				Select dropdown = new Select(drp1);
				dropdown.selectByVisibleText("USD");
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
				driver.close();

			}
		}
	}

}

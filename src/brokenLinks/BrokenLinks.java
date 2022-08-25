package brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		/*
		 * broken Url Step 1-To get all the urls tied up with the selenium Java methods
		 * will call the url and get status code if status code is greater than 400 the
		 * the url is not working so the selenium is tied with broken link
		 * 
		 * a[href*='soapui']
		 */

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// to get the complete url of the link

		// String url =
		// driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		SoftAssert a = new SoftAssert();

		for (WebElement link : links) {

			String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("HEAD");
			conn.connect();

			int respCode = conn.getResponseCode();

			System.out.println(respCode);

			a.assertTrue(respCode < 400,
					"The link with Text:" + " " + link.getText() + " " + "is broken with code:" + " " + respCode);

		}

		a.assertAll();

	}
}

/*
 * if (respCode > 400) {
 * 
 * System.out.println( "The link with Text:" + " " + link.getText() + " " +
 * "is broken with code:" + " " + respCode);
 * 
 * 
 * //Hard Asserttion so the test will failed after the assertion become false //
 * Soft assertion so the test will not failed even assertion is false
 * Assert.assertTrue(false);
 */

// String url =
// driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

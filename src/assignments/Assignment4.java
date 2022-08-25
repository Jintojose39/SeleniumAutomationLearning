package assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {

	public static void main(String[] args) {

		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Multiple Windows")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(By.linkText("Click Here")));
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

		Set<String> Windows = driver.getWindowHandles();

		Iterator<String> it = Windows.iterator();

		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(parentWindow);

		driver.switchTo().window(childWindow);

		String msg1 = driver.findElement(By.cssSelector("body:nth-child(2) div.example > h3:nth-child(1)")).getText();

		System.out.println(msg1);

		driver.switchTo().window(parentWindow);

		String msg2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();

		System.out.println(msg2);

		driver.quit();

	}

}

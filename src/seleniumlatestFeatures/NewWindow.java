package seleniumlatestFeatures;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NewWindow {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		String parentWindowId = it.next();

		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);

		driver.get("https://rahulshettyacademy.com/");

		Thread.sleep(1000);
		String CourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();

		System.out.println(CourseName);
		driver.switchTo().window(parentWindowId);

		WebElement name = driver.findElement(By.cssSelector("[name='name']"));

		name.sendKeys(CourseName);

		// to get partial screenshot
		File file = name.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("logo.png"));

		System.out.println("Height is:" + name.getRect().getDimension().getHeight());

		System.out.println("Width is:" + name.getRect().getDimension().getWidth());

		// to get height and width of the Webelement box
		int height = name.getRect().getDimension().getHeight();

		int width = name.getRect().getDimension().getWidth();

		Assert.assertEquals(38, height);

		Assert.assertEquals(1110, width);

		driver.quit();

	}

}

package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment6 {

	public static void main(String[] args) {

		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://qaclickacademy.com/practice.php");

		driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label[2]/input")).click();

		String checkmsg = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label[2]")).getText();

		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));

		Select drp = new Select(dropdown);

		drp.selectByVisibleText(checkmsg);

		// System.out.println(dropdown.getText());

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(checkmsg);

		driver.findElement(By.id("alertbtn")).click();

		String text = driver.switchTo().alert().getText();

		if (text.contains(checkmsg)) {
			driver.switchTo().alert().accept();
			System.out.println(checkmsg + " " + "is displayed");
			System.out.println("Alert message is Success");

		} else {
			System.out.println(checkmsg + " " + "is not displayed");
			System.out.println("Alert message is failed");
		}

		driver.quit();

	}

}

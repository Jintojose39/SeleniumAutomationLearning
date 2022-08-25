package seleniumlatestFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;

public class RelativeLocators {

	public static void main(String[] args) {

		System.setProperty("WebDriver.ChromeDriver", "Chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));

		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

		/*
		 * WebElement
		 * birthEditBox=driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		 * 
		 * driver.findElement(with(By.tagName("input")).below(birthEditBox)).click();
		 */

		WebElement IceCreamcheck = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(IceCreamcheck)).click();
		
		WebElement studentButton=driver.findElement(By.xpath("//label[@for='inlineRadio1']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(studentButton)).click();
		
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(studentButton)).getText());

	}

}
